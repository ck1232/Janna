package com.JJ.controller.rolemanagement;

import java.util.List;

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
@RequestMapping(value = "/")
public class RoleManagementController {
	
	@Autowired
	RoleManagementService roleManagementService;
	
	@Autowired
	RoleFormValidator roleFormValidator;
	
	@Autowired
	public RoleManagementController(RoleManagementService roleManagementService) {
		this.roleManagementService = roleManagementService;
	}
	
	
	@RequestMapping("/listRole")  
    public String listRole() {  
    	System.out.println("loading listRole");
        return "listRole";  
    }  
	
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleList() {
		System.out.println("getting role list");
		List<Role> roleList = roleManagementService.getAllRoles();
		return GeneralUtils.convertListToJSONString(roleList);
	}
	
	@RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String showAddRoleForm(Model model) {  
    	System.out.println("loading showAddRoleForm");
    	Role role = new Role();
    	
    	role.setName("Product Manager");
    	model.addAttribute("roleForm", role);
        return "createRole";  
    }  
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(roleFormValidator);
	}
	
	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("roleForm") @Validated Role role, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		System.out.println("saveRole() : " + role.toString());
		if (result.hasErrors()) {
			return "createRole";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Role added successfully!");
		}
		roleManagementService.saveRole(role);
		
        return "redirect:listRole";  
    }  
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public String deleteRole(@RequestParam("checkboxId") List<String> ids) {
		
		for (String id : ids) {
			roleManagementService.deleteRole(new Integer(id));
			System.out.println("deleted "+ id);
			
		}
		return "redirect:listRole";
	}
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public String getRoleToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Role role = roleManagementService.findById(new Integer(id));
		System.out.println("Loading update role page for " + role.toString());
		
		model.addAttribute("roleForm", role);
		
		return "updateRole";
	}
	
	@RequestMapping(value = "/updateRoleToDb", method = RequestMethod.POST)
	public String updateRole(@ModelAttribute("roleForm") @Validated Role role,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		System.out.println("updateRole() : " + role.toString());
		
		if (result.hasErrors()) {
			return "updateRole";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Role updated successfully!");
		}
		roleManagementService.updateRole(role);
		
		return "redirect:listRole";
	}
	
}