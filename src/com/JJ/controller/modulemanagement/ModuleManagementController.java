package com.JJ.controller.modulemanagement;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.validator.ModuleFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class ModuleManagementController {
	private static final Logger logger = Logger.getLogger(ModuleManagementController.class);
	
	private ModuleManagementService moduleManagementService;
	
	@Autowired
	private ModuleFormValidator moduleFormValidator;
	
	@Autowired
	public ModuleManagementController(ModuleManagementService moduleManagementService, ModuleFormValidator moduleFormValidator){
		this.moduleManagementService = moduleManagementService;
		this.moduleFormValidator = moduleFormValidator;
	}
	
	@RequestMapping("/listModule")  
    public String listModule(HttpSession session) {  
    	logger.debug("loading listModule");
        return "listModule";  
    } 
	
	@RequestMapping(value = "/getModuleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getModuleList() {
		logger.debug("getting Module list");
		List<Module> moduleList = moduleManagementService.getAllModules();
		return GeneralUtils.convertListToJSONString(moduleList);
	}
	
	@RequestMapping(value = "/createModule", method = RequestMethod.GET)
    public String showAddModuleForm(Model model) {  
    	logger.debug("loading showAddModuleForm");
    	Module module = new Module();
    	module.setName("Project Management");
    	module.setIcon("fa-users");
    	module.setDeleteind(GeneralUtils.NOT_DELETED);
    	
    	model.addAttribute("module", module);
        return "createModule";  
    }  
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(moduleFormValidator);
	}
	
	@RequestMapping(value = "/createModule", method = RequestMethod.POST)
    public String saveModule(@ModelAttribute("module") @Validated Module module, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveModule() : " + module.toString());
		if (result.hasErrors()) {
			return "createModule";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Module added successfully!");
		}
		moduleManagementService.saveModule(module);
		
        return "redirect:listModule";  
    }  
	
	@RequestMapping(value = "/deleteModule", method = RequestMethod.POST)
	public String deleteModule(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listModule";
		}
		for (String id : ids) {
			moduleManagementService.deleteModule(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Module(s) deleted successfully!");
		return "redirect:listModule";
	}
	
	@RequestMapping(value = "/updateModuleToDb", method = RequestMethod.POST)
	public String updateModule(@ModelAttribute("moduleForm") @Validated Module module,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateModule() : " + module.toString());
		
		if (result.hasErrors()) {
			return "updateModule";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Module updated successfully!");
		}
		moduleManagementService.updateModule(module);
		
		return "redirect:listModule";
	}
	
	@RequestMapping(value = "/updateModule", method = RequestMethod.POST)
	public String getModuleToUpdate(@RequestParam("editBtn") String id, Model model) {
		logger.debug("id = " + id);
		Module module = moduleManagementService.findById(new Integer(id));
		if (module == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Module not found");
		}
		model.addAttribute("module", module);

		return "updateModule";

	}
}
