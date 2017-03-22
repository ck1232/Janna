package com.JJ.controller.storagelocationmanagement;

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

import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;
import com.JJ.validator.StorageLocationFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/storagelocation")
public class StorageLocationManagementController {
	private static final Logger logger = Logger.getLogger(StorageLocationManagementController.class);
	
	private StorageLocationManagementService storageLocationManagementService;
	private StorageLocationFormValidator storageLocationFormValidator;
	
	@Autowired
	public StorageLocationManagementController(StorageLocationManagementService storageLocationManagementService,
			StorageLocationFormValidator storageLocationFormValidator) {
		this.storageLocationManagementService = storageLocationManagementService;
		this.storageLocationFormValidator = storageLocationFormValidator;
	}
	
	
	@RequestMapping(value = "/listStorageLocation", method = RequestMethod.GET)  
    public String listStorageLocation() {  
    	logger.debug("loading listStorageLocation");
        return "listStorageLocation";  
    }  
	
	@RequestMapping(value = "/getStorageLocationList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getStorageLocationList() {
		logger.debug("getting storage location list");
		List<StorageLocationVO> locationList = storageLocationManagementService.getAllStorageLocations();
		return GeneralUtils.convertListToJSONString(locationList);
	}
	
	@RequestMapping(value = "/createStorageLocation", method = RequestMethod.GET)
    public String showAddStorageLocationForm(Model model) {  
    	logger.debug("loading showAddStorageLocationForm");
    	StorageLocationVO location = new StorageLocationVO();
    	model.addAttribute("storageLocationForm", location);
        return "createStorageLocation";  
    }  
	
	@InitBinder("storageLocationForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(storageLocationFormValidator);
	}
	
	@RequestMapping(value = "/createStorageLocation", method = RequestMethod.POST)
    public String saveStorageLocation(@ModelAttribute("storageLocationForm") @Validated StorageLocationVO location, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveStorageLocation() : " + location.toString());
		if (result.hasErrors()) {
			return "createStorageLocation";
		} else {
			
			storageLocationManagementService.saveStorageLocation(location);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Storage Location added successfully!");
		}
		
		
        return "redirect:listStorageLocation";  
    }  
	
	@RequestMapping(value = "/deleteStorageLocation", method = RequestMethod.POST)
	public String deleteStorageLocation(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listStorageLocation";
		}
		for (String id : ids) {
			storageLocationManagementService.deleteStorageLocation(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Storage location(s) deleted successfully!");
		return "redirect:listStorageLocation";
	}
	
	@RequestMapping(value = "/updateStorageLocation", method = RequestMethod.POST)
	public String getStorageLocationToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		StorageLocationVO location = storageLocationManagementService.findById(new Integer(id));
		logger.debug("Loading update storage location page for " + location.toString());
		
		model.addAttribute("storageLocationForm", location);
		return "updateStorageLocation";
	}
	
	@RequestMapping(value = "/updateStorageLocationToDb", method = RequestMethod.POST)
	public String updateStorageLocation(@ModelAttribute("storageLocationForm") @Validated StorageLocationVO location,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateStorageLocation() : " + location.toString());
		
		if (result.hasErrors()) {
			return "updateStorageLocation";
		} else {
			storageLocationManagementService.updateStorageLocation(location);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Storage Location updated successfully!");
		}
		
		return "redirect:listStorageLocation";
	}
	
	@RequestMapping(value = "/viewStorageLocation", method = RequestMethod.POST)
	public String viewStorageLocation(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		StorageLocationVO location = storageLocationManagementService.findById(new Integer(id));
		if (location == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Storage location not found");
		}
		model.addAttribute("location", location);

		return "viewStorageLocation";

	}
	
}