package com.JJ.controller.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
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


@Controller  
@SessionAttributes
@PropertySources({
	@PropertySource(value = "classpath:admin-dev-config.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "classpath:admin-prod-config.properties", ignoreResourceNotFound=true)
})
@RequestMapping(value = "/")
public class CommonController {
	private static final Logger logger = Logger.getLogger(CommonController.class);
	private SubModuleManagementService subModuleManagementService;
	private ModuleManagementService moduleManagementService;
	private RoleAssignmentService roleAssignmentService;
	private UserManagementService userManagementService;
	private PermissionManagementService permissionManagementService;
	private CommonService commonService;
	private BasicDataSource dataSource;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
    private String url;
	
	@Value("${jdbc.query.user}")
    private String user;
	
	@Value("${jdbc.query.password}")
    private String password;
	
	@Autowired
	public CommonController(SubModuleManagementService subModuleManagementService, ModuleManagementService moduleManagementService,
			RoleAssignmentService roleAssignmentService, UserManagementService userManagementService,
			PermissionManagementService permissionManagementService, CommonService commonService, BasicDataSource dataSource){
		this.subModuleManagementService = subModuleManagementService;
		this.moduleManagementService = moduleManagementService;
		this.roleAssignmentService = roleAssignmentService;
		this.userManagementService = userManagementService;
		this.permissionManagementService = permissionManagementService;
		this.commonService = commonService;
		this.dataSource = dataSource;
	}
	
	@RequestMapping(value={"/","/dashboard"})  
    public String loadDashboard(HttpSession session) {  
    	logger.debug("dashboard is executed!");
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(principal instanceof UserDetails){
    		UserDetails userDetails = (UserDetails)principal ;
	    	session.setAttribute("userAccount", principal);
	    	session.setAttribute("menu", this.populateMenu(userDetails));
	    	List<String> roleList = new ArrayList<String>();
	    	for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
	    		roleList.add(authority.getAuthority());
	    	}
	    	List<String> urlList = commonService.getAllowedUrlByRoleName(roleList);
	    	session.setAttribute("allowedUrl", urlList);
    	}else if(principal instanceof String){
    		logger.debug("principal:"+principal.toString());
    	}
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
	
	@RequestMapping(value={"/query","/q"}, method = RequestMethod.GET)
	public String querypage (Model model) {
		return "query";
	}
	
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public String runSqlpage (@RequestParam(value="sqlStatement", required=true) String sqlStatement, final RedirectAttributes redirectAttributes, Model model) {
		Statement statement = null;
		String message = null;
		if(sqlStatement != null && !sqlStatement.trim().isEmpty()){
			try{
				sqlStatement = sqlStatement.trim();
				if(sqlStatement.charAt(sqlStatement.length()-1) != ';'){
					sqlStatement += ';';
				}
				Class.forName(driver);
				Connection connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String sqlType = sqlStatement.substring(0, 6);
				String sqlType2 = sqlStatement.substring(0, 4);
				logger.debug("loading sql :"+ sqlStatement);
				if (sqlType.equalsIgnoreCase("select") || sqlType2.equalsIgnoreCase("desc")){
			         ResultSet resultSet = statement.executeQuery(sqlStatement);
			         message =  GeneralUtils.getHtmlRows(resultSet);
			         statement.close();
			     }else{
			    	 int i = statement.executeUpdate(sqlStatement);
			    	 statement.close();
			    	 message =  "<tr><td>" +
		               "The statement executed successfully.<br>" +
		               i + " row(s) affected." +
		             "</td></tr>";
			     }
			}catch(Exception ex){
				ex.printStackTrace();
				logger.debug(ex.getMessage());
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ex.getMessage().contains("denied ")){
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               "Access denied!"+
				             "</td></tr>";
				}else{
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               ex.getMessage()+
				             "</td></tr>";
				}
			}
		}
		model.addAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:query";
	}
	
	@RequestMapping(value="/query/export", method = RequestMethod.POST)
	public String runSqlExportPage (@RequestParam(value="sqlStatement", required=true) String sqlStatement,
			final RedirectAttributes redirectAttributes, Model model, HttpServletResponse response) {
		Statement statement = null;
		String message = null;
		if(sqlStatement != null && !sqlStatement.trim().isEmpty()){
			try{
				sqlStatement = sqlStatement.trim();
				if(sqlStatement.charAt(sqlStatement.length()-1) != ';'){
					sqlStatement += ';';
				}
				Class.forName(driver);
				Connection connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String sqlType = sqlStatement.substring(0, 6);
				String sqlType2 = sqlStatement.substring(0, 4);
				logger.debug("loading sql :"+ sqlStatement);
				if (sqlType.equalsIgnoreCase("select") || sqlType2.equalsIgnoreCase("desc")){
			         ResultSet resultSet = statement.executeQuery(sqlStatement);
			         Workbook wb =  ExcelFileHelper.writeToFile(resultSet);
			         statement.close();
			         if(wb != null){
			         	response.setContentType("application/vnd.ms-excel");
			             response.addHeader("Content-Disposition", "attachment; filename=data.xls");
			             try{
			             	wb.write(response.getOutputStream());
			                 response.getOutputStream().flush();
			             } 
			             catch (IOException ex) {
			                 ex.printStackTrace();
			             }
			         }
			         return null;
			     }else{
			    	 int i = statement.executeUpdate(sqlStatement);
			    	 statement.close();
			    	 message =  "<tr><td>" +
		               "The statement executed successfully.<br>" +
		               i + " row(s) affected." +
		             "</td></tr>";
			     }
			}catch(Exception ex){
				ex.printStackTrace();
				logger.debug(ex.getMessage());
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ex.getMessage().contains("denied ")){
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               "Access denied!"+
				             "</td></tr>";
				}else{
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               ex.getMessage()+
				             "</td></tr>";
				}
				
			}
		}
		model.addAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:query";
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