package com.JJ.controller.usermanagement;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.AppUser;
import com.JJ.service.usermanagement.UserManagementService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class UserManagementController {
	
	UserManagementService userManagementService;
	
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
	
	
	
}