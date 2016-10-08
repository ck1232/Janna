package com.JJ.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.JJ.form.Contact;


@Controller  
@SessionAttributes
@RequestMapping(value = "/")
public class CommonController {
	
	/*@RequestMapping("/**")
	public ModelAndView index(){
		return new ModelAndView("contact", "command", new Contact());
	}*/
	
	@RequestMapping("/dashboard")  
    public String loadDashboard() {  
    	System.out.println("loading dashboard");
        return "dashboard";  
    }  
	
}