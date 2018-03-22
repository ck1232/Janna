package com.JJ.service.rolemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.RoleTO;
import com.JJ.controller.rolemanagement.vo.RoleVO;
import com.JJ.dao.RoleDbObjectMapper;
import com.JJ.dao.jpa.RoleDAO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.roleassignment.RoleAssignmentService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class RoleManagementService {
	
	private RoleDbObjectMapper roleDbObjectMapper;
	private RoleDAO roleDAO;
	private RoleAssignmentService roleAssignmentService;
	private PermissionManagementService permissionManagementService;
	
	@Autowired
	public RoleManagementService(RoleDbObjectMapper roleMapper,
			RoleDAO roleDAO,
			RoleAssignmentService roleAssignmentService,
			PermissionManagementService permissionManagementService) {
		this.roleDbObjectMapper = roleMapper;
		this.roleDAO = roleDAO;
		this.roleAssignmentService = roleAssignmentService;
		this.permissionManagementService = permissionManagementService;
	}
	
	public RoleVO findById(Long id) {
		/*RoleDbObject roleDbObject = roleDbObjectMapper.selectByPrimaryKey(id);
		if(roleDbObject != null && roleDbObject.getRoleId() != null){
			return convertToRoleVOList(Arrays.asList(roleDbObject)).get(0);
		}else{
			return new RoleVO();
		}*/
		RoleTO roleTO = roleDAO.findByRoleId(id); 
		List<RoleVO> roleVOList = convertToRoleVOList(Arrays.asList(roleTO));
		if(roleVOList != null && !roleVOList.isEmpty()){
			return roleVOList.get(0);
		}
		return new RoleVO();
	}

	public List<RoleVO> getAllRoles() {
		/*RoleDbObjectExample roleDbObjectExample = new RoleDbObjectExample();
		roleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToRoleVOList(roleDbObjectMapper.selectByExample(roleDbObjectExample));*/
		List<RoleTO> roleTOList = roleDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
		return convertToRoleVOList(roleTOList);
	}
	
	public void saveRole(RoleVO roleVO) {
		/*if(roleVO != null){
			RoleDbObject dbObj = convertToRoleDbObjectList(Arrays.asList(roleVO)).get(0);
			roleDbObjectMapper.insert(dbObj);
		}*/
		List<RoleTO> roleTOList = convertToRoleTOList(Arrays.asList(roleVO));
		roleDAO.save(roleTOList);
	}
	
	public void deleteRole(Long id) {
		deleteRole(Arrays.asList(id));
		roleAssignmentService.deleteUserRolebyRoleId(id.intValue());
		permissionManagementService.deleteSubmodulepermissionByRoleId(id.intValue());
	}
	
	private void deleteRole(List<Long> idList) {
		/*RoleDbObjectExample roleDbObjectExample = new RoleDbObjectExample();
		roleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRoleIdIn(idList);
		RoleDbObject dbObj = new RoleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		roleDbObjectMapper.updateByExampleSelective(dbObj, roleDbObjectExample);*/
		List<RoleTO> roleTOList = roleDAO.findByRoleIdIn(idList);
		if(roleTOList != null && !roleTOList.isEmpty()){
			for(RoleTO roleTO : roleTOList){
				roleTO.setDeleteInd(GeneralUtils.DELETED);
			}
			roleDAO.save(roleTOList);
		}
		
	}

	public void updateRole(RoleVO vo) {
		/*if(roleVO != null && roleVO.getRoleId() != null) {
			RoleDbObject dbObj = convertToRoleDbObjectList(Arrays.asList(roleVO)).get(0);
			roleDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}*/
		if(vo != null && vo.getRoleId() != null){
			RoleTO roleTO = roleDAO.findByRoleId(vo.getRoleId().longValue());
			roleTO.setName(vo.getName());
			roleDAO.save(roleTO);
		}
	}
	 
	/*private List<RoleVO> convertToRoleVOList(List<RoleDbObject> objList) {
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
	}*/
	
	private List<RoleVO> convertToRoleVOList(List<RoleTO> toList) {
		List<RoleVO> voList = new ArrayList<RoleVO>();
		if(toList != null && !toList.isEmpty()){
			for(RoleTO obj : toList){
				RoleVO vo = new RoleVO();
				vo.setName(obj.getName());
				vo.setRoleId(obj.getRoleId().intValue());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	/*private List<RoleDbObject> convertToRoleDbObjectList(List<RoleVO> roleVOList) {
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
	}*/
	
	private List<RoleTO> convertToRoleTOList(List<RoleVO> voList) {
		List<RoleTO> roleTOList = new ArrayList<RoleTO>();
		if(voList != null && !voList.isEmpty()) {
			for(RoleVO vo : voList) {
				RoleTO to = new RoleTO();
				to.setName(vo.getName());
				to.setRoleId(vo.getRoleId().longValue());
				roleTOList.add(to);
			}
		}
		return roleTOList;
	}
}
