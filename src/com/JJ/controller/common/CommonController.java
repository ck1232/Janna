package com.JJ.controller.common;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;


@Controller  
@SessionAttributes
@RequestMapping(value = "/")
public class CommonController {
	private static final Logger logger = Logger.getLogger(CommonController.class);
	private SubModuleManagementService subModuleManagementService;
	private ModuleManagementService moduleManagementService;
	
	@Autowired
	public CommonController(SubModuleManagementService subModuleManagementService, ModuleManagementService moduleManagementService){
		this.subModuleManagementService = subModuleManagementService;
		this.moduleManagementService = moduleManagementService;
	}
	
	@RequestMapping(value={"/","/dashboard"})  
    public String loadDashboard(HttpSession session) {  
    	logger.debug("dashboard is executed!");
    	UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	session.setAttribute("user", principal);
    	session.setAttribute("menu", this.populateMenu(principal));
        return "dashboard";  
    }
	public Menu populateMenu(UserDetails user){
		Menu menu = new Menu();
		List<Module> moduleList = moduleManagementService.getAllModules();
		List<Submodule> submoduleList = subModuleManagementService.getAllSubmodules();
		Map<Integer, List<Submodule>> subModuleMap = new HashMap<Integer, List<Submodule>>();
		for(Submodule subModule : submoduleList){
			if(subModuleMap.get(subModule.getParentid()) == null){
				subModuleMap.put(subModule.getParentid(), new ArrayList<Submodule>());
			}
			subModuleMap.get(subModule.getParentid()).add(subModule);
		}
		for(Module module : moduleList){
			module.setSubModuleList(subModuleMap.get(module.getId()));
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