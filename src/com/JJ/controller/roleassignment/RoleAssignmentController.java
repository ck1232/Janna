package com.JJ.controller.roleassignment;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Role;
import com.JJ.model.RolesToAssign;
import com.JJ.model.User;
import com.JJ.model.UserRole;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.rolemanagement.RoleManagementService;
import com.JJ.service.usermanagement.UserManagementService;
import com.JJ.validator.UserFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class RoleAssignmentController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@Autowired
	RoleManagementService roleManagementService;
	
	@Autowired
	RoleAssignmentService roleAssignmentService;
	
	@Autowired
	UserFormValidator userFormValidator;
	
	@Autowired
	public RoleAssignmentController(UserManagementService userManagementService, RoleManagementService roleManagementService, RoleAssignmentService roleAssignmentService) {
		this.userManagementService = userManagementService;
		this.roleManagementService = roleManagementService;
		this.roleAssignmentService = roleAssignmentService;
	}
	
	@RequestMapping(value = "/assignRole", method = RequestMethod.POST)
	public String getUserToAssignRole(@RequestParam("assignRoleBtn") String id, Model model) {
		User user = userManagementService.findById(new Integer(id));
		model.addAttribute("user", user);
		return "assignRole";
	}
	
	@RequestMapping(value = "/getRolesToAssignList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleList(@RequestParam("userid") String id) {
		System.out.println("getting roles to assign list");
		List<RolesToAssign> rolesToAssign = roleAssignmentService.getRolesToAssign(id);
		return GeneralUtils.convertListToJSONString(rolesToAssign);
	}
	
	@RequestMapping(value = "/saveRoleToUser", method = RequestMethod.POST)
	public String saveRoleToUser(@ModelAttribute("user") @Validated User user, 
			@RequestParam("checkboxId") List<String> ids,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		System.out.println("saveRoleToUser() : user = " + user.getId());
		
		roleAssignmentService.deleteRoleListByUserId(user.getId());
		for(String roleId: ids){
			System.out.println("saveRoleToUser() : role id = " + roleId);
			UserRole userRole = new UserRole();
			userRole.setUserid(user.getId());
			userRole.setRoleid(new Integer(roleId));
			roleAssignmentService.saveUserRole(userRole);
		}
		if (result.hasErrors()) {
			return "assignRole";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Role saved to user successfully!");
		}		
		
		return "redirect:listUser";
	}
	
	
	
}