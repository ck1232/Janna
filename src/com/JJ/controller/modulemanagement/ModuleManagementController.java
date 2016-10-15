package com.JJ.controller.modulemanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.JJ.model.User;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class ModuleManagementController {
	private static final Logger logger = Logger.getLogger(ModuleManagementController.class);
	private ModuleManagementService moduleManagementService;
	private SubModuleManagementService submoduleManagementService;
	
	@Autowired
	public ModuleManagementController(ModuleManagementService moduleManagementService, SubModuleManagementService submoduleManagementService){
		this.moduleManagementService = moduleManagementService;
		this.submoduleManagementService = submoduleManagementService;
	}
	
	@RequestMapping("/listModule")  
    public String listModule() {  
    	logger.debug("loading listModule");
        return "listModule";  
    } 
	
	@RequestMapping(value = "/getModuleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getModuleList() {
		logger.debug("getting Module list");
		List<Module> moduleList = moduleManagementService.getAllModules();
		return GeneralUtils.convertListToJSONString(moduleList);
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
	
	@RequestMapping(value = "/updateModule", method = RequestMethod.POST)
	public String getModuleToUpdate(@RequestParam("editBtn") String id, Model model) {
		Module module = moduleManagementService.findById(new Integer(id));
		model.addAttribute("module", module);
		return "updateModule";
	}
	
	@RequestMapping(value = "/viewSubmodule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSubmoduleToUpdate(@RequestParam("moduleid") String id, Model model) {
		logger.debug("getting submodules list");
		List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(new Integer(id));
		return GeneralUtils.convertListToJSONString(submoduleList);
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
	
	@RequestMapping(value = "/viewModule", method = RequestMethod.POST)
	public String viewModule(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Module module = moduleManagementService.findById(new Integer(id));
		if (module == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Module not found");
		}
		model.addAttribute("module", module);

		return "viewModule";

	}
}
