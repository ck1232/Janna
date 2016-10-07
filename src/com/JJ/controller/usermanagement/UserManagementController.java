package com.JJ.controller.usermanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller  
@SessionAttributes
@RequestMapping(value = "/")
public class UserManagementController {
	
	@RequestMapping("/listUser")  
    public String listUser() {  
    	System.out.println("loading listUser");
        return "listUser";  
    }  
	
}