package com.JJ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.JJ.form.Contact;
import com.JJ.service.TestingService;

@Controller  
@SessionAttributes
@RequestMapping(value = "/")
public class ContactController {  
	private TestingService testingService;
	@Autowired
	public ContactController(TestingService testingService){
		this.testingService = testingService;
	}
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {  
        //write the code here to add contact
    	System.out.println(contact.getOption().intValue()-4);
        return "redirect:contact.html";  
    }  
      
    @RequestMapping("/contact")  
    public ModelAndView showContacts() {  
    	System.out.println("contacts");
        return new ModelAndView("contact", "command", new Contact());  
    }  
}  