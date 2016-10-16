package com.JJ.controller.usermanagement;

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

import com.JJ.controller.roleassignment.RoleAssignmentController;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.User;
import com.JJ.service.rolemanagement.RoleManagementService;
import com.JJ.service.usermanagement.UserManagementService;
import com.JJ.validator.UserFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class UserManagementController {
	private static final Logger logger = Logger.getLogger(UserManagementController.class);
	
	private UserManagementService userManagementService;
	private RoleManagementService roleManagementService;
	private UserFormValidator userFormValidator;
	
	@Autowired
	public UserManagementController(UserManagementService userManagementService, RoleManagementService roleManagementService,
			UserFormValidator userFormValidator) {
		this.userManagementService = userManagementService;
		this.roleManagementService = roleManagementService;
		this.userFormValidator = userFormValidator;
	}
	
	
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)  
    public String listUser() {  
    	logger.debug("loading listUser");
        return "listUser";  
    }  
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserList() {
		logger.debug("getting user list");
		List<User> userList = userManagementService.getAllUsers();
		return GeneralUtils.convertListToJSONString(userList);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {  
    	logger.debug("loading showAddUserForm");
    	User user = new User();
    	
    	user.setUserid("jj");
    	user.setPassword("12345");
    	user.setName("Janice Lee");
    	user.setEmailaddress("jj@hotmail.com");
    	user.setEnabled(true);
    	model.addAttribute("userForm", user);
        return "createUser";  
    }  
	
	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userForm") @Validated User user, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveUser() : " + user.toString());
		if (result.hasErrors()) {
			return "createUser";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		userManagementService.saveUser(user);
		
        return "redirect:listUser";  
    }  
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listUser";
		}
		for (String id : ids) {
			userManagementService.deleteUser(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User(s) deleted successfully!");
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String getUserToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		User user = userManagementService.findById(new Integer(id));
		logger.debug("Loading update user page for " + user.toString());
		
		model.addAttribute("userForm", user);
		
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUserToDb", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateUser() : " + user.toString());
		
		if (result.hasErrors()) {
			return "updateUser";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		}
		userManagementService.updateUser(user);
		
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/viewUser", method = RequestMethod.POST)
	public String viewUser(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		User user = userManagementService.findById(new Integer(id));
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "viewUser";

	}
	
}