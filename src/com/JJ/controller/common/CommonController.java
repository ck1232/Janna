package com.JJ.controller.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.JJ.model.Menu;
import com.JJ.model.Module;
import com.JJ.model.Submodule;
import com.JJ.model.SubmodulepermissionKey;
import com.JJ.model.User;
import com.JJ.model.UserRole;
import com.JJ.service.common.CommonService;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.service.usermanagement.UserManagementService;


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
    	UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	session.setAttribute("userAccount", principal);
    	session.setAttribute("menu", this.populateMenu(principal));
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
		List<SubmodulepermissionKey> submodulepermissionKeyList = permissionManagementService.getSubmoduleByRole(roleIdList);
		for(SubmodulepermissionKey obj : submodulepermissionKeyList){
			subModuleIdList.add(obj.getSubmoduleid());
		}
		if(subModuleIdList.size() == 0){
			return null;
		}
		return subModuleManagementService.getSubmodulesById(subModuleIdList);
	}
	public Menu populateMenu(UserDetails user){
		Menu menu = new Menu();
		
		List<Submodule> subModuleList = getAllSubModuleByUserId(user.getUsername());
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
}