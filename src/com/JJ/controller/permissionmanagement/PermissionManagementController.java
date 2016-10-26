package com.JJ.controller.permissionmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.RolesToPermission;
import com.JJ.model.Submodule;
import com.JJ.model.Submodulepermission;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.validator.PermissionTypeFormValidator;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/admin")
public class PermissionManagementController {
	private static final Logger logger = Logger.getLogger(PermissionManagementController.class);
	
	private PermissionManagementService permissionManagementService;
	private SubModuleManagementService subModuleManagementService;
	private PermissionTypeFormValidator permissionTypeFormValidator;
	
	@Autowired
	public PermissionManagementController(PermissionManagementService permissionManagementService, SubModuleManagementService subModuleManagementService,
			PermissionTypeFormValidator permissionTypeFormValidator){
		this.permissionManagementService = permissionManagementService;
		this.subModuleManagementService = subModuleManagementService;
		this.permissionTypeFormValidator = permissionTypeFormValidator;
	}
	
	@RequestMapping("/listPermissionModule")  
    public String listPermissionModule() {  
    	logger.debug("loading listPermissionModule");
        return "listPermissionModule";  
    } 
	
	@RequestMapping(value = "/updateSubmodulePermission", method = RequestMethod.POST)
	public String getRoleToUpdatePermission(@RequestParam("editBtn") String id, Model model) {
		logger.debug("Loading grant role permission page");
		Submodule submodule = subModuleManagementService.findById(new Integer(id));
		List<Submodulepermissiontype> submodulepermissiontypeList = permissionManagementService.getSubmodulepermissiontype(id);
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", submodulepermissiontypeList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/updateSubmodulePermission/{id}", method = RequestMethod.GET)
	public String getRoleToUpdatePermissionForRedirect(@PathVariable String id, Model model) {
		logger.debug("Loading grant role permission page");
		Submodule submodule = subModuleManagementService.findById(new Integer(id));
		List<Submodulepermissiontype> submodulepermissiontypeList = permissionManagementService.getSubmodulepermissiontype(id);
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", submodulepermissiontypeList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/getRoleToPermission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleListToPermission(@RequestParam("editBtn") String submoduleid) {
		logger.debug("getting role list");
		List<RolesToPermission> rolesToPermissionList = permissionManagementService.getRolesToPermission(submoduleid);

		List<RolesToPermission> permissionList = new ArrayList<RolesToPermission>();
		Map<String, RolesToPermission> permissionMap = new HashMap<String, RolesToPermission>();
		for(RolesToPermission obj : rolesToPermissionList){
			RolesToPermission roleToPermission = permissionMap.get(obj.getRoleid());
			if(roleToPermission == null){
				permissionMap.put(obj.getRoleid(), obj);
			}else{
				roleToPermission.setPermission(roleToPermission.getPermission()+","+obj.getPermission());
				roleToPermission.setPermissionId(roleToPermission.getPermissionId()+","+obj.getPermissionId());
			}
		}
		for(RolesToPermission obj : permissionMap.values()){
			permissionList.add(obj);
		}
		
		return GeneralUtils.convertListToJSONString(permissionList);
	}
	
	
	
	@RequestMapping(value = "/saveSubmodulePermissionToDb", method = RequestMethod.POST)
	public String savePermissionToDb(@RequestParam("submoduleid") String submoduleid, @RequestParam("roleid") String roleid, @RequestParam(value="submodulePermission", required=false) List<String> submodulePermissionList, final RedirectAttributes redirectAttributes) {
		permissionManagementService.deleteSubmodulepermission(roleid, submoduleid);
		
		if(submodulePermissionList != null && submodulePermissionList.size() > 0){
			for(String submodulePermission: submodulePermissionList){

				Submodulepermission submodulepermission = new Submodulepermission();
				submodulepermission.setRoleid(new Integer(roleid));
				submodulepermission.setSubmoduleid(new Integer(submoduleid));
				submodulepermission.setPermission(submodulePermission);
				
				permissionManagementService.saveSubmodulepermission(submodulepermission);
			}
		}
		
		redirectAttributes.addFlashAttribute("css","success");
		redirectAttributes.addFlashAttribute("msg", "Permission saved to role successfully.");
		
		return "redirect:updateSubmodulePermission/" + submoduleid;
	}
	
	@RequestMapping(value = "/updatePermissionType", method = RequestMethod.POST)
	public String loadupdatePermissionTypeForm(@RequestParam("loadEditPermissionTypeBtn") String id, Model model) {
		logger.debug("Loading update permission type page");
		Submodule submodule = subModuleManagementService.findById(new Integer(id));
		model.addAttribute("submodule", submodule);
		return "updatePermissionType";
	}
	
	@RequestMapping(value = "/updatePermissionType/{id}", method = RequestMethod.GET)
	public String loadupdatePermissionTypeFormForRedirect(@PathVariable("id") String id, Model model) {
		logger.debug("Loading update permission type page");
		Submodule submodule = subModuleManagementService.findById(new Integer(id));
		model.addAttribute("submodule", submodule);
		return "updatePermissionType";
	}
	
	
	@RequestMapping(value = "/getPermissionTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getPermissionTypeList(@RequestParam("submoduleid") String submoduleid) {
		logger.debug("getting permission type list");
		List<Submodulepermissiontype> permissionTypeList = permissionManagementService.getSubmodulepermissiontype(submoduleid);
		return GeneralUtils.convertListToJSONString(permissionTypeList);
	}
	
	@RequestMapping(value = "/createPermissionType", method = RequestMethod.POST)
    public String showAddPermissionTypeForm(@RequestParam("submoduleid") String submoduleid, Model model) {  
    	logger.debug("loading add permission type form");
    	Submodulepermissiontype submodulepermissiontype = new Submodulepermissiontype();
    	submodulepermissiontype.setSubmoduleid(submoduleid);
    	Submodule submodule = subModuleManagementService.findById(new Integer(submoduleid));
    	model.addAttribute("submodulepermissiontypeForm", submodulepermissiontype);
    	model.addAttribute("submodule", submodule);
        return "createPermissionType";  
    }
	
	@InitBinder("submodulepermissiontypeForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(permissionTypeFormValidator);
	}
	
	
	@RequestMapping(value = "/savePermissionTypeToDb", method = RequestMethod.POST)
    public String savePermissionTypeToDb(@ModelAttribute("submodulepermissiontypeForm") @Validated Submodulepermissiontype permissionType, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("savePermissionTypeToDb() : " + permissionType.getPermissiontype());
		
		if (result.hasErrors()) {
			Submodule submodule = subModuleManagementService.findById(new Integer(permissionType.getSubmoduleid()));
			model.addAttribute("submodule", submodule);
			return "createPermissionType";
		} else {
			boolean pass = true;
			List<Submodulepermissiontype> permissiontypeList = permissionManagementService.getSubmodulepermissiontype(permissionType.getSubmoduleid());
			for(Submodulepermissiontype smpt: permissiontypeList){
				if(permissionType.getPermissiontype().equals(smpt.getPermissiontype())) { //if exist name
					result.rejectValue("permissiontype", "error.exist.permissiontypeform.permissiontype");;
					pass = false;
					break;
				}
			}
			for(Submodulepermissiontype smpt: permissiontypeList){
				if(permissionType.getUrl().equals(smpt.getUrl())) { //if exist url
					result.rejectValue("url", "error.exist.permissiontypeform.url");;
					pass = false;
					break;
				}
			}
			if(!NumberUtils.isNumber(permissionType.getSeqno())){
				result.rejectValue("seqno", "error.numeric.permissiontypeform.seqno");;
				pass = false;
			}
			if(!pass){
				Submodule submodule = subModuleManagementService.findById(new Integer(permissionType.getSubmoduleid()));
				model.addAttribute("submodule", submodule);
				return "createPermissionType";
			}
			permissionManagementService.saveSubmodulepermissiontype(permissionType);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Permission type added successfully!");
		}

        return "redirect:updatePermissionType/" + permissionType.getSubmoduleid();  
    }  
	
	@RequestMapping(value = "/deletePermissionType", method = RequestMethod.POST)
	public String deletePermissionType(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			@RequestParam("submoduleid") String submoduleid,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:updatePermissionType/" + submoduleid;
		}
		for (String id : ids) {
			permissionManagementService.deleteSubmodulepermissiontype(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Permission type(s) deleted successfully!");
		return "redirect:updatePermissionType/" + submoduleid;
	}
	
	@RequestMapping(value = "/savePermissionTypeSeqToDb", method = RequestMethod.POST)
	public String savePermissionTypeSeqToDb(@RequestParam("permissionTypeid") String id, 
			@RequestParam("seqno") String seqno,
			final RedirectAttributes redirectAttributes) {
		Submodulepermissiontype submodulepermissiontype = permissionManagementService.findById(new Integer(id));
		submodulepermissiontype.setSeqno(seqno);
		permissionManagementService.updateSubmodulepermissiontype(submodulepermissiontype);
		
		redirectAttributes.addFlashAttribute("css","success");
		redirectAttributes.addFlashAttribute("msg", "Sequence number saved successfully.");
		
		return "redirect:updatePermissionType/" + submodulepermissiontype.getSubmoduleid();
	}
	
}
