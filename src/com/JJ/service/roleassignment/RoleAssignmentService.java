package com.JJ.service.roleassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.UserRoleVO;
import com.JJ.controller.roleassignment.vo.RolesToAssignVO;
import com.JJ.dao.RoleDbObjectMapper;
import com.JJ.dao.UserRoleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.RoleDbObject;
import com.JJ.model.RoleDbObjectExample;
import com.JJ.model.UserRoleDbObject;
import com.JJ.model.UserRoleDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class RoleAssignmentService {
	
	private UserRoleDbObjectMapper userRoleDbObjectMapper;
	private RoleDbObjectMapper roleDbObjectMapper;
	@Autowired
	public RoleAssignmentService(UserRoleDbObjectMapper userRoleDbObjectMapper,
			RoleDbObjectMapper roleDbObjectMapper) {
		this.userRoleDbObjectMapper = userRoleDbObjectMapper;
		this.roleDbObjectMapper = roleDbObjectMapper;
	}
	
	public List<RoleDbObject> getAllRolesDbObject() {
		RoleDbObjectExample roleDbObjectExample = new RoleDbObjectExample();
		roleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return roleDbObjectMapper.selectByExample(roleDbObjectExample);
	}
	
	public UserRoleVO findById(int key) {
		UserRoleDbObject obj = userRoleDbObjectMapper.selectByPrimaryKey(key);
		List<UserRoleVO> voList = convertToUserRoleVOList(Arrays.asList(obj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new UserRoleVO();
	}

	public List<UserRoleVO> getAllRoles() {
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria();
		List<UserRoleDbObject> userRoleList = userRoleDbObjectMapper.selectByExample(userRoleExample);
		return convertToUserRoleVOList(userRoleList);
	}
	
	public List<UserRoleVO> getRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToUserRoleVOList(userRoleDbObjectMapper.selectByExample(userRoleExample));
	}
	
	public List<RolesToAssignVO> getRolesToAssign(Integer userId) {
		List<RolesToAssignVO> roleAssignList = new ArrayList<RolesToAssignVO>();
		List<RoleDbObject> roleList = getAllRolesDbObject();
		List<UserRoleVO> userRoleVOList = getRoleListByUserId(userId);
		Map<Integer, UserRoleVO> map = new HashMap<Integer, UserRoleVO>();
		if(userRoleVOList != null && userRoleVOList.size() > 0){
			for(UserRoleVO vo : userRoleVOList){
				map.put(vo.getRoleId(), vo);
			}
		}
		if(roleList != null && roleList.size() > 0){
			for(RoleDbObject role : roleList){
				RolesToAssignVO vo = new RolesToAssignVO();
				vo.setRoleId(role.getRoleId());
				vo.setName(role.getName());
				vo.setChecked(GeneralUtils.NO_IND);
				if(map.get(role.getRoleId()) != null){
					vo.setChecked(GeneralUtils.YES_IND);
				}
				roleAssignList.add(vo);
			}
		}
		return roleAssignList;
	}
	
	
	public void saveUserRole(UserRoleVO userRole) {
		UserRoleDbObject obj = convertToUserRoleDbObject(userRole);
		userRoleDbObjectMapper.insert(obj);
	}
	
	public void deleteRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andUserIdEqualTo(userId);
		UserRoleDbObject dbObj = new UserRoleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		userRoleDbObjectMapper.updateByExampleSelective(dbObj, userRoleExample);
	}
	
	public void deleteUserRolebyRoleId(Integer roleId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRoleIdEqualTo(roleId);
		UserRoleDbObject dbObj = new UserRoleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		userRoleDbObjectMapper.updateByExampleSelective(dbObj, userRoleExample);
	}
	
	public void updateRole(UserRoleVO role) {
		userRoleDbObjectMapper.updateByPrimaryKeySelective(convertToUserRoleDbObject(role));
	}
	 
	private List<UserRoleVO> convertToUserRoleVOList(List<UserRoleDbObject> objList) {
		List<UserRoleVO> voList = new ArrayList<UserRoleVO>();
		if(objList != null && objList.size() > 0){
			for(UserRoleDbObject obj : objList){
				UserRoleVO vo = new UserRoleVO();
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setRoleId(obj.getRoleId());
				vo.setUserId(obj.getUserId());
				vo.setUserRoleId(obj.getUserRoleId());
				vo.setVersion(obj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	private UserRoleDbObject convertToUserRoleDbObject(UserRoleVO vo) {
		UserRoleDbObject obj = new UserRoleDbObject();
		obj.setDeleteInd(vo.getDeleteInd());
		obj.setRoleId(vo.getRoleId());
		obj.setUserId(vo.getUserId());
		obj.setUserRoleId(vo.getUserRoleId());
		obj.setVersion(obj.getVersion());
		return obj;
	}

}
