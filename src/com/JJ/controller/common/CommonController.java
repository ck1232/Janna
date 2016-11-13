package com.JJ.controller.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.JJ.model.LoginForm;
import com.JJ.model.Menu;
import com.JJ.model.Module;
import com.JJ.model.Submodule;
import com.JJ.model.Submodulepermission;
import com.JJ.model.User;
import com.JJ.model.UserRole;
import com.JJ.service.common.CommonService;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.service.usermanagement.UserManagementService;
import com.mysql.jdbc.util.Base64Decoder;


@Controller  
@SessionAttributes
@RequestMapping(value = "/")
public class CommonController {
	private static final Logger logger = Logger.getLogger(CommonController.class);
	private SubModuleManagementService subModuleManagementService;
	private ModuleManagementService moduleManagementService;
	private RoleAssignmentService roleAssignmentService;
	private UserManagementService userManagementService;
	private PermissionManagementService permissionManagementService;
	private CommonService commonService;
	@Autowired
	public CommonController(SubModuleManagementService subModuleManagementService, ModuleManagementService moduleManagementService,
			RoleAssignmentService roleAssignmentService, UserManagementService userManagementService,
			PermissionManagementService permissionManagementService, CommonService commonService){
		this.subModuleManagementService = subModuleManagementService;
		this.moduleManagementService = moduleManagementService;
		this.roleAssignmentService = roleAssignmentService;
		this.userManagementService = userManagementService;
		this.permissionManagementService = permissionManagementService;
		this.commonService = commonService;
	}
	
	@RequestMapping(value={"/","/dashboard"})  
    public String loadDashboard(HttpSession session) {  
    	logger.debug("dashboard is executed!");
    	LoginForm loginform = (LoginForm) session.getAttribute("LOGGEDIN_USER");
    	//UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Menu menu = this.populateMenu(loginform.getUsername());
    	session.setAttribute("userAccount", loginform);
    	session.setAttribute("menu", menu);
    	List<String> roleList = new ArrayList<String>();
    	for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
    		roleList.add(authority.getAuthority());
    	}
    	List<String> urlList = commonService.getAllowedUrlByRoleName(roleList);
    	session.setAttribute("allowedUrl", urlList);
        return "dashboard";  
    }
	
	private List<Submodule> getAllSubModuleByUserId(String userId){
		List<Integer> roleIdList = new ArrayList<Integer>();
		List<Integer> subModuleIdList = new ArrayList<Integer>();
		User dbUser = userManagementService.findByUserId(userId);
		if(dbUser == null){
			return null;
		}
		List<UserRole> roleList = roleAssignmentService.getRoleListByUserId(dbUser.getId());
		for(UserRole userRole: roleList){
			roleIdList.add(userRole.getRoleid());
		}
		if(roleIdList.size() == 0){
			return null;
		}
		List<Submodulepermission> submodulepermissionList = permissionManagementService.getSubmoduleByRole(roleIdList);
		for(Submodulepermission obj : submodulepermissionList){
			subModuleIdList.add(obj.getSubmoduleid());
		}
		if(subModuleIdList.size() == 0){
			return null;
		}
		return subModuleManagementService.getSubmodulesById(subModuleIdList);
	}
	public Menu populateMenu(String username){
		Menu menu = new Menu();
		
		List<Submodule> subModuleList = getAllSubModuleByUserId(username);
		List<Module> moduleList = moduleManagementService.getAllModules();
//		List<Submodule> submoduleList = subModuleManagementService.getAllSubmodules();
		
		if(subModuleList != null && subModuleList.size() > 0){
			Map<Integer, List<Submodule>> subModuleMap = new HashMap<Integer, List<Submodule>>();
			for(Submodule subModule : subModuleList){
				if(subModuleMap.get(subModule.getParentid()) == null){
					subModuleMap.put(subModule.getParentid(), new ArrayList<Submodule>());
				}
				subModuleMap.get(subModule.getParentid()).add(subModule);
			}
			for(Module module : moduleList){
				module.setSubModuleList(subModuleMap.get(module.getId()));
			}
			
		}
		menu.setModuleList(moduleList);
		menu.setDteUpdated(new Date());
		return menu;
	}
	@RequestMapping(value={"/login"},method = RequestMethod.GET)  
    public String login() {  
        return "login";  
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, LoginForm loginform, HttpServletRequest request) throws Exception {
		
		String username = loginform.getUsername();
		String password = getPassword(loginform.getPassword());
		// A simple authentication manager
		if(username != null && password != null){
			List<User> uList = userManagementService.getAllUsers();
			for(User u: uList) {
				if(u.getUserid().equals(username) && BCrypt.checkpw(password, u.getPassword())) {
					request.getSession().setAttribute("LOGGEDIN_USER", loginform);
					return loadDashboard(request.getSession());
				}
			}
			return "redirect:/login";
		}else{
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/home",method = RequestMethod.POST)
	public String userAuthenticated(){
		logger.debug("dashboard is executed!");
		return "dashboard";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
		logger.debug("access denied!");
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       request.getSession().setAttribute("user", null);
       request.getSession().setAttribute("menu", null);
       return "redirect:/login?logout";
    }
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
	
	private String getPassword(String ePassword) {
		String data[] = ePassword.split(":");
        String salt_hex = data[0];
        String iv_hex = data[1];
        String msg64 = data[2];
        String jskey_hex = data[3];
        byte[] jskey = hexStringToByteArray(jskey_hex);
        byte[] iv = hexStringToByteArray(iv_hex);
        byte[] salt = hexStringToByteArray(salt_hex);
        Base64Decoder decoder = new Base64Decoder();
        byte[] msg = decoder.decode(msg64.getBytes(), 0, msg64.length());
        String plaintext = "";
        try {
            SecretKey key = new SecretKeySpec(jskey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            plaintext = new String(cipher.doFinal(msg), "UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return plaintext;
	}
	
	//Converting a string of hex character to bytes
	  public static byte[] hexStringToByteArray(String s) {
		  int len = s.length();
		  byte[] data = new byte[len / 2];
		  for (int i = 0; i < len; i += 2){
		  data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
		  + Character.digit(s.charAt(i+1), 16));
		  }
		  return data;
	  }
}