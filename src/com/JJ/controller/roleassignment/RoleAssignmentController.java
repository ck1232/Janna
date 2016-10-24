package com.JJ.controller.roleassignment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.RolesToAssign;
import com.JJ.model.User;
import com.JJ.model.UserRole;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.usermanagement.UserManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/admin")
public class RoleAssignmentController {
	private static final Logger logger = Logger.getLogger(RoleAssignmentController.class);
	
	private UserManagementService userManagementService;
	private RoleAssignmentService roleAssignmentService;
	
	@Autowired
	public RoleAssignmentController(UserManagementService userManagementService, RoleAssignmentService roleAssignmentService) {
		this.userManagementService = userManagementService;
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
		logger.debug("getting roles to assign list");
		List<RolesToAssign> rolesToAssign = roleAssignmentService.getRolesToAssign(id);
		return GeneralUtils.convertListToJSONString(rolesToAssign);
	}
	
	@RequestMapping(value = "/saveRoleToUser", method = RequestMethod.POST)
	public String saveRoleToUser(@ModelAttribute("user") User user, 
			@RequestParam(value="checkboxId", required=false) List<String> ids,
			Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("saveRoleToUser() : user = " + user.getId());
		
		roleAssignmentService.deleteRoleListByUserId(user.getId());
		if(ids != null && ids.size() > 0){
			for(String roleId: ids){
				logger.debug("saveRoleToUser() : role id = " + roleId);
				UserRole userRole = new UserRole();
				userRole.setUserid(user.getId());
				userRole.setRoleid(new Integer(roleId));
				roleAssignmentService.saveUserRole(userRole);
			}
		}
	
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Role saved to user successfully!");
		
		return "redirect:listUser";
	}
	
	
	
}