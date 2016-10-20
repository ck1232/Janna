package com.JJ.controller.permissionmanagement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.JJ.model.SubmodulepermissionKey;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.rolemanagement.RoleManagementService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/")
public class PermissionManagementController {
	private static final Logger logger = Logger.getLogger(PermissionManagementController.class);
	
	private PermissionManagementService permissionManagementService;
	private SubModuleManagementService subModuleManagementService;
	private RoleManagementService roleManagementService;
	
	@Autowired
	public PermissionManagementController(PermissionManagementService permissionManagementService, SubModuleManagementService subModuleManagementService,
			RoleManagementService roleManagementService){
		this.permissionManagementService = permissionManagementService;
		this.subModuleManagementService = subModuleManagementService;
		this.roleManagementService = roleManagementService;
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
		List<String> permissionList = new ArrayList<String>();
		for(Submodulepermissiontype type: submodulepermissiontypeList){
			permissionList.add(type.getPermissiontype());
		}
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", permissionList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/updateSubmodulePermission/{id}", method = RequestMethod.GET)
	public String getRoleToUpdatePermissionForRedirect(@PathVariable String id, Model model) {
		logger.debug("Loading grant role permission page");
		Submodule submodule = subModuleManagementService.findById(new Integer(id));
		List<Submodulepermissiontype> submodulepermissiontypeList = permissionManagementService.getSubmodulepermissiontype(id);
		List<String> permissionList = new ArrayList<String>();
		for(Submodulepermissiontype type: submodulepermissiontypeList){
			permissionList.add(type.getPermissiontype());
		}
		model.addAttribute("submodule", submodule);
		model.addAttribute("permissionList", permissionList);
		return "updateSubmodulePermission";
	}
	
	@RequestMapping(value = "/getRoleToPermission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getRoleListToPermission(@RequestParam("editBtn") String submoduleid) {
		logger.debug("getting role list");
		List<RolesToPermission> rolesToPermissionList = permissionManagementService.getRolesToPermission(submoduleid);
		return GeneralUtils.convertListToJSONString(rolesToPermissionList);
	}
	
	
	
	@RequestMapping(value = "/saveSubmodulePermissionToDb", method = RequestMethod.POST)
	public String savePermissionToDb(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		String submoduleid = request.getParameter("submoduleid");
		String roleid = request.getParameter("roleid");
		String permission = request.getParameter("submodulePermission");
		Submodulepermission submodulepermission = new Submodulepermission();
		submodulepermission.setRoleid(new Integer(roleid));
		submodulepermission.setSubmoduleid(new Integer(submoduleid));
		submodulepermission.setPermission(permission);
		SubmodulepermissionKey key = new SubmodulepermissionKey();
		key.setRoleid(new Integer(roleid));
		key.setSubmoduleid(new Integer(submoduleid));
		permissionManagementService.deleteSubmodulepermission(key);
		permissionManagementService.saveSubmodulepermission(submodulepermission);
		
		redirectAttributes.addFlashAttribute("css","success");
		redirectAttributes.addFlashAttribute("msg", "Permission saved to role successfully.");
		
		return "redirect:updateSubmodulePermission/" + submoduleid;
	}
	
	
	
}
