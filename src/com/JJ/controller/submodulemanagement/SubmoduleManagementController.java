package com.JJ.controller.submodulemanagement;

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

import com.JJ.helper.GeneralUtils;
import com.JJ.model.Module;
import com.JJ.model.Submodule;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.validator.ModuleFormValidator;
import com.JJ.validator.SubmoduleFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class SubmoduleManagementController {
	private static final Logger logger = Logger.getLogger(SubmoduleManagementController.class);
	
	@Autowired
	private ModuleManagementService moduleManagementService;
	
	@Autowired
	private SubModuleManagementService submoduleManagementService;
	
	@Autowired
	SubmoduleFormValidator submoduleFormValidator;
/*	@Autowired
	ModuleFormValidator moduleFormValidator;*/
	
	@Autowired
	public SubmoduleManagementController(ModuleManagementService moduleManagementService, SubModuleManagementService submoduleManagementService){
		this.moduleManagementService = moduleManagementService;
		this.submoduleManagementService = submoduleManagementService;
	}
	
	@RequestMapping(value = "/viewSubmodule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSubmoduleToUpdate(@RequestParam("moduleid") String id, Model model) {
		logger.debug("getting submodules list");
		List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(new Integer(id));
		return GeneralUtils.convertListToJSONString(submoduleList);
	}
	
	@RequestMapping(value = "/createSubmodule", method = RequestMethod.GET)
    public String showAddSubmoduleForm(@RequestParam("moduleid") String id, Model model) {  
    	logger.debug("loading showAddSubmoduleForm");
    	Submodule submodule = new Submodule();
    	submodule.setName("Receipt Management");
    	submodule.setIcon("fa-users");
    	submodule.setUrl("listModule");
    	submodule.setDeleteind(GeneralUtils.NOT_DELETED);
    	submodule.setParentid(new Integer(id));
    	model.addAttribute("submodule", submodule);
        return "createSubmodule";  
    }  
	
/*	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(submoduleFormValidator);
	}*/
	
	@RequestMapping(value = "/createSubmodule", method = RequestMethod.POST)
    public String saveSubmodule(@ModelAttribute("submodule") /*@Validated*/ Submodule submodule, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveSubmodule() : " + submodule.toString());
		if (result.hasErrors()) {
			return "createSubmodule";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Submodule added successfully!");
		}
		submoduleManagementService.saveSubmodule(submodule);
		
        return "redirect:listModule";  
    }  
	
	@RequestMapping(value = "/deleteSubmodule", method = RequestMethod.POST)
	public String deleteSubmodule(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listModule";
		}
		for (String id : ids) {
			submoduleManagementService.deleteSubmodule(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Submodule(s) deleted successfully!");
		return "redirect:listModule";
	}
}
