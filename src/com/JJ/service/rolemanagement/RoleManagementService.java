package com.JJ.service.rolemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.rolemanagement.vo.RoleVO;
import com.JJ.dao.RoleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.RoleDbObject;
import com.JJ.model.RoleDbObjectExample;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.roleassignment.RoleAssignmentService;

@Service
@Transactional
public class RoleManagementService {
	
	private RoleDbObjectMapper roleDbObjectMapper;
	private RoleAssignmentService roleAssignmentService;
	private PermissionManagementService permissionManagementService;
	
	@Autowired
	public RoleManagementService(RoleDbObjectMapper roleMapper,
			RoleAssignmentService roleAssignmentService,
			PermissionManagementService permissionManagementService) {
		this.roleDbObjectMapper = roleMapper;
		this.roleAssignmentService = roleAssignmentService;
		this.permissionManagementService = permissionManagementService;
	}
	
	public RoleVO findById(Integer id) {
		RoleDbObject roleDbObject = roleDbObjectMapper.selectByPrimaryKey(id);
		if(roleDbObject != null && roleDbObject.getRoleId() != null){
			return convertToRoleVOList(Arrays.asList(roleDbObject)).get(0);
		}else{
			return new RoleVO();
		}
	}

	public List<RoleVO> getAllRoles() {
		RoleDbObjectExample roleDbObjectExample = new RoleDbObjectExample();
		roleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToRoleVOList(roleDbObjectMapper.selectByExample(roleDbObjectExample));
	}
	
	public void saveRole(RoleVO roleVO) {
		if(roleVO != null){
			RoleDbObject dbObj = convertToRoleDbObjectList(Arrays.asList(roleVO)).get(0);
			roleDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deleteRole(Integer id) {
		deleteRole(Arrays.asList(id));
		roleAssignmentService.deleteUserRolebyRoleId(id);
		permissionManagementService.deleteSubmodulepermissionByRoleId(id);
	}
	
	private void deleteRole(List<Integer> idList) {
		RoleDbObjectExample roleDbObjectExample = new RoleDbObjectExample();
		roleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRoleIdIn(idList);
		RoleDbObject dbObj = new RoleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		roleDbObjectMapper.updateByExampleSelective(dbObj, roleDbObjectExample);
	}

	public void updateRole(RoleVO roleVO) {
		if(roleVO != null && roleVO.getRoleId() != null) {
			RoleDbObject dbObj = convertToRoleDbObjectList(Arrays.asList(roleVO)).get(0);
			roleDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	 
	private List<RoleVO> convertToRoleVOList(List<RoleDbObject> objList) {
		List<RoleVO> voList = new ArrayList<RoleVO>();
		if(objList != null && objList.size() > 0){
			for(RoleDbObject obj : objList){
				RoleVO vo = new RoleVO();
				vo.setName(obj.getName());
				vo.setRoleId(obj.getRoleId());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	private List<RoleDbObject> convertToRoleDbObjectList(List<RoleVO> roleVOList) {
		List<RoleDbObject> roleDbObjectList = new ArrayList<RoleDbObject>();
		if(roleVOList != null && !roleVOList.isEmpty()) {
			for(RoleVO vo : roleVOList) {
				RoleDbObject dbObj = new RoleDbObject();
				dbObj.setName(vo.getName());
				dbObj.setRoleId(vo.getRoleId());
				roleDbObjectList.add(dbObj);
			}
		}
		return roleDbObjectList;
	}
}
