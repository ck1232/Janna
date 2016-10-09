package com.JJ.controller.usermanagement;

import java.util.ArrayList;
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
import com.JJ.model.AppUser;
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
		List<AppUser> userList = userManagementService.getAllUsers();
		return GeneralUtils.convertListToJSONString(userList);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {  
    	System.out.println("loading showAddUserForm");
    	AppUser user = new AppUser();
    	user.setFirstname("");
    	user.setLastname("Lee");
    	user.setName("jj");
    	user.setEmail("jj@hotmail.com");
    	user.setPassword("12345");
    	user.setEnabled(true);
    	model.addAttribute("userForm", user);
        return "createUser";  
    }  
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated AppUser appUser, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		System.out.println("saveOrUpdateUser() : " + appUser.toString());
		if (result.hasErrors()) {
			return "createUser";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		userManagementService.saveOrUpdate(appUser);
		
        return "redirect:listUser";  
    }  
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String delete(@RequestParam("id") List<String> ids) {
		List<Long> idList = new ArrayList<>();

		for (String id : ids) {
			idList.add(new Long(id));
			System.out.println(id);
		}
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String delete(@RequestParam("editBtn") String id) {
		List<Long> idList = new ArrayList<>();
		System.out.println(id);
		
		return "redirect:listUser";
	}
	
}