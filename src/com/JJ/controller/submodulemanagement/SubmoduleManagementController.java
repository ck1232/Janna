package com.JJ.controller.submodulemanagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import com.JJ.validator.SubmoduleFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/admin")
public class SubmoduleManagementController {
	private static final Logger logger = Logger.getLogger(SubmoduleManagementController.class);
	
	private ModuleManagementService moduleManagementService;
	private SubModuleManagementService submoduleManagementService;
	private SubmoduleFormValidator submoduleFormValidator;
	
	@Autowired
	public SubmoduleManagementController(ModuleManagementService moduleManagementService, SubModuleManagementService submoduleManagementService,
			SubmoduleFormValidator submoduleFormValidator){
		this.moduleManagementService = moduleManagementService;
		this.submoduleManagementService = submoduleManagementService;
		this.submoduleFormValidator = submoduleFormValidator;
	}
	
	@RequestMapping(value = "/getSubmoduleListByModule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSubmoduleListByModule(@RequestParam("moduleid") String id, Model model) {
		logger.debug("getting submodules list by module");
		List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(new Integer(id));
		return GeneralUtils.convertListToJSONString(submoduleList);
	}
	
	@RequestMapping(value = "/getSubmoduleListOrderByModule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSubmoduleListOrderByParentId() {
		logger.debug("getting all submodules list order by module");
		List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesOrderByClause("parentId, name");
		Iterator<Submodule> i = submoduleList.iterator();
		List<Module> allModuleList = moduleManagementService.getAllModules();
		Map<Integer, Module> moduleMap = new HashMap<Integer, Module>();
		for(Module module : allModuleList){
			moduleMap.put(module.getId(), module);
		}
//		moduleMap = GeneralUtils.convertListToIntegerMap(allModuleList, "id");
		
		while (i.hasNext()){
			Submodule submodule = i.next();
			Module module = moduleMap.get(submodule.getParentid());
			if(module == null){
				i.remove();
			}
			else{
				submodule.setParentModuleName(module.getName());
			}
		}
//		for(Submodule submodule: submoduleList){
//			Module module = moduleManagementService.findById(submodule.getParentid());
//			submodule.setParentModuleName(module.getName());
//		}
		return GeneralUtils.convertListToJSONString(submoduleList);
	}
	
	@RequestMapping(value = "/createSubmodule", method = RequestMethod.POST)
    public String showAddSubmoduleForm(@RequestParam("moduleid") String id, Model model, final RedirectAttributes redirectAttributes) {  
    	logger.debug("loading showAddSubmoduleForm");
    	
    	List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(new Integer(id));
    	if(submoduleList.size() >= 10){
    		redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Only 10 submodules are allowed in each module!");
			return "redirect:updateModule/"+id;
    	}
    	Submodule submodule = new Submodule();
    	submodule.setDeleteind(GeneralUtils.NOT_DELETED);
    	submodule.setParentid(new Integer(id));
    	model.addAttribute("submodule", submodule);
        return "createSubmodule";  
    }  
	
	@InitBinder("submodule")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(submoduleFormValidator);
	}

	@RequestMapping(value = "/createSubmoduleToDb", method = RequestMethod.POST)
    public String saveSubmodule(@ModelAttribute("submodule") @Validated Submodule submodule, 
    		BindingResult result, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveSubmodule() : " + submodule.toString());
		if (result.hasErrors()) {
			return "createSubmodule";
		} else {
			boolean pass = true;
			List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(submodule.getParentid());
			for(Submodule sm: submoduleList){
				if(submodule.getName().equals(sm.getName())) { //if exist name
					result.rejectValue("name", "error.exist.submoduleform.name");;
					pass = false;
					break;
				}
			}
			for(Submodule sm: submoduleList){
				if(submodule.getUrl().equals(sm.getUrl())) { //if exist url
					result.rejectValue("url", "error.exist.submoduleform.url");;
					pass = false;
					break;
				}
			}
			if(!pass){
				return "createSubmodule";
			}
			submoduleManagementService.saveSubmodule(submodule);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Submodule added successfully!");
			
		}
		return "redirect:updateModule/"+submodule.getParentid();
    }  
	
	@RequestMapping(value = "/deleteSubmodule", method = RequestMethod.POST)
	public String deleteSubmodule(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			@RequestParam("moduleid") String moduleid, 
			Model model, final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:updateModule/"+moduleid;
		}
		
		for (String id : ids) {
			submoduleManagementService.deleteSubmodule(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Submodule(s) deleted successfully!");
		return "redirect:updateModule/"+moduleid;
	}
	
	@RequestMapping(value = "/updateSubmodule", method = RequestMethod.POST)
	public String getSubmoduleToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		Submodule submodule = submoduleManagementService.findById(new Integer(id));
		logger.debug("Loading update submodule page for " + submodule.toString());
		
		model.addAttribute("submodule", submodule);
		
		return "updateSubmodule";
	}
	
	@RequestMapping(value = "/updateSubmoduleToDb", method = RequestMethod.POST)
	public String updateSubmodule(@ModelAttribute("submodule") @Validated Submodule submodule,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateSubmodule() : " + submodule.toString());
		
		if (result.hasErrors()) {
			return "updateSubmodule";
		} else {
			boolean pass = true;
			List<Submodule> submoduleList = submoduleManagementService.getAllSubmodulesByModule(submodule.getParentid());
			Submodule currentSm = submoduleManagementService.findById(submodule.getId());
			for(Submodule sm: submoduleList){
				if(!currentSm.getName().equals(sm.getName()) && submodule.getName().equals(sm.getName())) { //if exist name
					result.rejectValue("name", "error.exist.submoduleform.name");;
					pass = false;
					break;
				}
			}
			for(Submodule sm: submoduleList){
				if(!currentSm.getUrl().equals(sm.getUrl()) && submodule.getUrl().equals(sm.getUrl())) { //if exist url
					result.rejectValue("url", "error.exist.submoduleform.url");;
					pass = false;
					break;
				}
			}
			if(!pass){
				return "updateSubmodule";
			}
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Submodule updated successfully!");
		}
		submoduleManagementService.updateSubmodule(submodule);
		return "redirect:updateModule/"+submodule.getParentid();
	}
	
	@RequestMapping(value = "/viewSubmodule", method = RequestMethod.POST)
	public String viewSubmodule(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Submodule submodule = submoduleManagementService.findById(new Integer(id));
		if (submodule == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Submodule not found");
		}
		
		Module module = moduleManagementService.findById(submodule.getParentid());
		submodule.setParentModuleName(module.getName());
		model.addAttribute("submodule", submodule);

		return "viewSubmodule";

	}
}
