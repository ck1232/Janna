package com.JJ.controller.permissionmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.common.vo.SubModulePermissionTypeVO;
import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.RolesToPermissionCustomDbObject;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.validator.PermissionTypeFormValidator;

@Controller  
@EnableWebMvc
@Scope("request")
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
	
	@RequestMapping("/listPermission")  
    public String listPermission() {  
    	logger.debug("loading listPermission");
        return "listPermission";  
    } 
	
	@RequestMapping(value = "/updateSubmodulePermission", method = RequestMethod.POST)
	public String getRoleToUpdatePermission(@RequestParam("editBtn") String id, Model model) {
		logger.debug("Loading grant role permission page");
		SubModuleVO submodule = subModuleManagementService.findById(Long.parseLong(id));
		List<SubModulePermissionTypeVO> submodulepermissiontypeList = permissionManagementService.getSubmodulepermissiontype(Integer.valueOf(id));
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", submodulepermissiontypeList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/updateSubmodulePermission/{id}", method = RequestMethod.GET)
	public String getRoleToUpdatePermissionForRedirect(@PathVariable String id, Model model) {
		logger.debug("Loading grant role permission page");
		SubModuleVO submodule = subModuleManagementService.findById(Long.parseLong(id));
		List<SubModulePermissionTypeVO> submodulepermissiontypeList = permissionManagementService.getSubmodulepermissiontype(Integer.valueOf(id));
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", submodulepermissiontypeList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/getRoleToPermission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleListToPermission(@RequestParam("editBtn") Integer submoduleid) {
		logger.debug("getting role list");
		List<RolesToPermissionCustomDbObject> rolesToPermissionList = permissionManagementService.getRolesToPermission(submoduleid);

		List<RolesToPermissionCustomDbObject> permissionList = new ArrayList<RolesToPermissionCustomDbObject>();
		Map<Integer, RolesToPermissionCustomDbObject> permissionMap = new HashMap<Integer, RolesToPermissionCustomDbObject>();
		for(RolesToPermissionCustomDbObject obj : rolesToPermissionList){
			RolesToPermissionCustomDbObject roleToPermission = permissionMap.get(obj.getRoleId());
			if(roleToPermission == null){
				permissionMap.put(obj.getRoleId(), obj);
			}else{
				if(roleToPermission.getPermission() != null && !roleToPermission.getPermission().isEmpty()){
					roleToPermission.setPermission(roleToPermission.getPermission()+","+obj.getPermission());
				}else{
					roleToPermission.setPermission(obj.getPermission());
				}
				
				if(roleToPermission.getPermissionId() != null && !roleToPermission.getPermissionId().isEmpty()){
					roleToPermission.setPermissionId(roleToPermission.getPermissionId()+","+obj.getPermissionId());
				}else{
					roleToPermission.setPermissionId(obj.getPermissionId());
				}
			}
		}
		for(RolesToPermissionCustomDbObject obj : permissionMap.values()){
			permissionList.add(obj);
		}
		
		return GeneralUtils.convertListToJSONString(permissionList);
	}
	
	
	
	@RequestMapping(value = "/saveSubmodulePermissionToDb", method = RequestMethod.POST)
	public String savePermissionToDb(@RequestParam("submoduleid") String submoduleid, @RequestParam("roleid") String roleid, @RequestParam(value="submodulePermission", required=false) List<String> submodulePermissionList, final RedirectAttributes redirectAttributes) {
		permissionManagementService.deleteSubmodulepermission(Integer.valueOf(roleid), Integer.valueOf(submoduleid));
		
		if(submodulePermissionList != null && submodulePermissionList.size() > 0){
			for(String submodulePermission: submodulePermissionList){
				SubModulePermissionVO submodulepermission = new SubModulePermissionVO();
				submodulepermission.setRoleId(new Integer(roleid));
				submodulepermission.setSubmoduleId(new Integer(submoduleid));
				submodulepermission.setPermissionTypeId(Integer.valueOf(submodulePermission));
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
		SubModuleVO subModuleVO = subModuleManagementService.findById(Long.parseLong(id));
		model.addAttribute("submodule", subModuleVO);
		return "updatePermissionType";
	}
	
	@RequestMapping(value = "/updatePermissionType/{id}", method = RequestMethod.GET)
	public String loadupdatePermissionTypeFormForRedirect(@PathVariable("id") String id, Model model) {
		logger.debug("Loading update permission type page");
		SubModuleVO subModuleVO = subModuleManagementService.findById(Long.parseLong(id));
		model.addAttribute("submodule", subModuleVO);
		return "updatePermissionType";
	}
	
	
	@RequestMapping(value = "/getPermissionTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getPermissionTypeList(@RequestParam("submoduleid") String submoduleid) {
		logger.debug("getting permission type list");
		List<SubModulePermissionTypeVO> permissionTypeList = permissionManagementService.getSubmodulepermissiontype(Integer.valueOf(submoduleid));
		return GeneralUtils.convertListToJSONString(permissionTypeList);
	}
	
	@RequestMapping(value = "/createPermissionType", method = RequestMethod.POST)
    public String showAddPermissionTypeForm(@RequestParam("submoduleid") String submoduleid, Model model) {  
    	logger.debug("loading add permission type form");
    	SubModulePermissionTypeVO submodulepermissiontype = new SubModulePermissionTypeVO();
    	submodulepermissiontype.setSubmoduleId(Integer.valueOf(submoduleid));
    	SubModuleVO subModuleVO = subModuleManagementService.findById(Long.parseLong(submoduleid));
    	model.addAttribute("submodulepermissiontypeForm", submodulepermissiontype);
    	model.addAttribute("submodule", subModuleVO);
        return "createPermissionType";  
    }
	
	@InitBinder("submodulepermissiontypeForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(permissionTypeFormValidator);
	}
	
	
	@RequestMapping(value = "/savePermissionTypeToDb", method = RequestMethod.POST)
    public String savePermissionTypeToDb(@ModelAttribute("submodulepermissiontypeForm") @Validated SubModulePermissionTypeVO subModulePermissionTypeVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("savePermissionTypeToDb() : " + subModulePermissionTypeVO.getPermissionType());
		
		if (result.hasErrors()) {
			SubModuleVO subModuleVO = subModuleManagementService.findById(subModulePermissionTypeVO.getSubmoduleId().longValue());
			model.addAttribute("submodule", subModuleVO);
			return "createPermissionType";
		} else {
			boolean pass = true;
			List<SubModulePermissionTypeVO> permissiontypeList = permissionManagementService.getSubmodulepermissiontype(subModulePermissionTypeVO.getSubmoduleId());
			for(SubModulePermissionTypeVO smpt: permissiontypeList){
				if(subModulePermissionTypeVO.getPermissionType().equals(smpt.getPermissionType())) { //if exist name
					result.rejectValue("permissiontype", "error.exist.permissiontypeform.permissiontype");;
					pass = false;
					break;
				}
			}
			for(SubModulePermissionTypeVO smpt: permissiontypeList){
				if(subModulePermissionTypeVO.getUrl().equals(smpt.getUrl())) { //if exist url
					result.rejectValue("url", "error.exist.permissiontypeform.url");;
					pass = false;
					break;
				}
			}
			if(!NumberUtils.isNumber(Integer.toString(subModulePermissionTypeVO.getSeqNum()))){
				result.rejectValue("seqno", "error.numeric.permissiontypeform.seqno");;
				pass = false;
			}
			if(!pass){
				SubModuleVO subModuleVO = subModuleManagementService.findById(subModulePermissionTypeVO.getSubmoduleId().longValue());
				model.addAttribute("submodule", subModuleVO);
				return "createPermissionType";
			}
			permissionManagementService.saveSubmodulepermissiontype(subModulePermissionTypeVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Permission type added successfully!");
		}

        return "redirect:updatePermissionType/" + subModulePermissionTypeVO.getSubmoduleId();  
    }  
	
	
	@RequestMapping(value = "/updatePermissionTypeDetail", method = RequestMethod.POST)
	public String getPermissionTypeDetailToUpdate(@RequestParam("editBtn") String id, Model model) {
		logger.debug("id = " + id);
		SubModulePermissionTypeVO subModulePermissionTypeVO = permissionManagementService.findById(new Integer(id));
		if (subModulePermissionTypeVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Permission type not found");
		}
		model.addAttribute("submodulepermissiontypeForm", subModulePermissionTypeVO);
		return "updatePermissionTypeDetail";
	}
	
	@RequestMapping(value = "/updatePermissionTypeDetailToDb", method = RequestMethod.POST)
	public String updateSubmodulepermissiontypeDetail(@ModelAttribute("submodulepermissiontypeForm") @Validated SubModulePermissionTypeVO subModulePermissionTypeVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateSubmodulepermissiontypeDetail() : " + subModulePermissionTypeVO.toString());
		
		if (result.hasErrors()) {
			return "updatePermissionTypeDetail";
		} else {
			permissionManagementService.updateSubmodulepermissiontype(subModulePermissionTypeVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Permission type updated successfully!");
		}
		
		return "redirect:updatePermissionType/" + subModulePermissionTypeVO.getSubmoduleId();
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
		SubModulePermissionTypeVO submodulepermissiontype = permissionManagementService.findById(new Integer(id));
		submodulepermissiontype.setSeqNum(Integer.valueOf(seqno));
		permissionManagementService.updateSubmodulepermissiontype(submodulepermissiontype);
		
		redirectAttributes.addFlashAttribute("css","success");
		redirectAttributes.addFlashAttribute("msg", "Sequence number saved successfully.");
		
		return "redirect:updatePermissionType/" + submodulepermissiontype.getSubmoduleId();
	}
	
}
