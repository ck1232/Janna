package com.JJ2.usermanagement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ2.impl.UserService;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/admin")
public class UserManagementController {
	private static final Logger logger = Logger.getLogger(UserManagementController.class);
	
	@Autowired
	private UserService userService;
	
	
	public UserManagementController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)  
    public String listUser() {  
    	logger.debug("loading listUser222");
    	logger.debug(userService.getUserById(1));
        return "listUser";  
    }  
	
	
	
}