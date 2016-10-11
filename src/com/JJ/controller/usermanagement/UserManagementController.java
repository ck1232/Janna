package com.JJ.controller.usermanagement;

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
import com.JJ.model.User;
import com.JJ.service.usermanagement.UserManagementService;
import com.JJ.validator.UserFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@Autowired
	UserFormValidator userFormValidator;
	
	@Autowired
	public UserManagementController(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}
	
	
	@RequestMapping("/listUser")  
    public String listUser() {  
    	System.out.println("loading listUser");
        return "listUser";  
    }  
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserList() {
		System.out.println("getting user list");
		List<User> userList = userManagementService.getAllUsers();
		return GeneralUtils.convertListToJSONString(userList);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {  
    	System.out.println("loading showAddUserForm");
    	User user = new User();
    	
    	user.setUserid("jj");
    	user.setPassword("12345");
    	user.setName("Janice Lee");
    	user.setEmailaddress("jj@hotmail.com");
    	user.setEnabled(true);
    	model.addAttribute("userForm", user);
        return "createUser";  
    }  
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userForm") @Validated User User, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
		System.out.println("saveUser() : " + User.toString());
		if (result.hasErrors()) {
			return "createUser";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		userManagementService.saveUser(User);
		
        return "redirect:listUser";  
    }  
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("id") List<String> ids) {
		
		for (String id : ids) {
			userManagementService.deleteUser(new Integer(id));
			System.out.println("deleted "+ id);
			
		}
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String getUserToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		User user = userManagementService.findById(new Integer(id));
		System.out.println("Loading update user page for " + user.toString());
		
		model.addAttribute("userForm", user);
		
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUserToDb", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		System.out.println("updateUser() : " + user.toString());
		
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
	
}