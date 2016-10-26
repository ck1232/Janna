package com.JJ.controller.rolemanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Role;
import com.JJ.service.rolemanagement.RoleManagementService;
import com.JJ.validator.RoleFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/admin")
public class RoleManagementController {
	private static final Logger logger = Logger.getLogger(RoleManagementController.class);
	
	private RoleManagementService roleManagementService;
	private RoleFormValidator roleFormValidator;
	
	@Autowired
	public RoleManagementController(RoleManagementService roleManagementService, RoleFormValidator roleFormValidator) {
		this.roleManagementService = roleManagementService;
		this.roleFormValidator = roleFormValidator;
	}
	
	
	@RequestMapping("/listRole")  
    public String listRole() {  
    	logger.debug("loading listRole");
        return "listRole";  
    }  
	
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleList() {
		logger.debug("getting role list");
		List<Role> roleList = roleManagementService.getAllRoles();
		return GeneralUtils.convertListToJSONString(roleList);
	}
	
	@RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String showAddRoleForm(Model model) {  
    	logger.debug("loading showAddRoleForm");
    	Role role = new Role();
    	model.addAttribute("roleForm", role);
        return "createRole";  
    }  
	
	@InitBinder("roleForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(roleFormValidator);
	}
	
	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("roleForm") @Validated Role role, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveRole() : " + role.toString());
		if (result.hasErrors()) {
			return "createRole";
		} else {
			List<Role> roleList = roleManagementService.getAllRoles();
			for(Role r: roleList){
				if(role.getName().equals(r.getName())) { //if exist name
					result.rejectValue("name", "error.exist.roleform.name");
					return "createRole";
				}
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Role added successfully!");
		}
		roleManagementService.saveRole(role);
		
        return "redirect:listRole";  
    }  
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public String deleteRole(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listRole";
		}
		for (String id : ids) {
			roleManagementService.deleteRole(new Integer(id));
			logger.debug("deleted "+ id);
			
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Role(s) deleted successfully!");
		return "redirect:listRole";
	}
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public String getRoleToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Role role = roleManagementService.findById(new Integer(id));
		logger.debug("Loading update role page for " + role.toString());
		
		model.addAttribute("roleForm", role);
		
		return "updateRole";
	}
	
	@RequestMapping(value = "/updateRoleToDb", method = RequestMethod.POST)
	public String updateRole(@ModelAttribute("roleForm") @Validated Role role,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateRole() : " + role.toString());
		
		if (result.hasErrors()) {
			return "updateRole";
		} else {
			List<Role> roleList = roleManagementService.getAllRoles();
			Role currentRole = roleManagementService.findById(role.getId());
			for(Role r: roleList){
				if(!currentRole.getName().equals(r.getName()) && role.getName().equals(r.getName())) { //if exist name
					result.rejectValue("name", "error.exist.roleform.name");
					return "updateRole";
				}
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Role updated successfully!");
		}
		roleManagementService.updateRole(role);
		
		return "redirect:listRole";
	}
	
}