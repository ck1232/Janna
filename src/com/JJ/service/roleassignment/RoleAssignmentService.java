package com.JJ.service.roleassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.UserRoleVO;
import com.JJ.controller.roleassignment.vo.RolesToAssignVO;
import com.JJ.dao.RoleCustomDbObjectMapper;
import com.JJ.dao.UserRoleDbObjectMapper;
import com.JJ.model.UserRoleDbObject;
import com.JJ.model.UserRoleDbObjectExample;

@Service
@Transactional
public class RoleAssignmentService {
	
	private UserRoleDbObjectMapper userRoleDbObjectMapper;
	private RoleCustomDbObjectMapper roleCustomDbObjectMapper;
	@Autowired
	public RoleAssignmentService(UserRoleDbObjectMapper userRoleDbObjectMapper,
			RoleCustomDbObjectMapper roleCustomDbObjectMapper) {
		this.userRoleDbObjectMapper = userRoleDbObjectMapper;
		this.roleCustomDbObjectMapper = roleCustomDbObjectMapper;
	}
	
	public UserRoleVO findById(int key) {
		UserRoleDbObject obj = userRoleDbObjectMapper.selectByPrimaryKey(key);
		List<UserRoleVO> voList = convertToUserRoleVOList(Arrays.asList(obj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new UserRoleVO();
	}

	private List<UserRoleVO> convertToUserRoleVOList(
			List<UserRoleDbObject> objList) {
		List<UserRoleVO> voList = new ArrayList<UserRoleVO>();
		if(objList != null && objList.size() > 0){
			for(UserRoleDbObject obj : objList){
				UserRoleVO vo = new UserRoleVO();
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setRoleId(vo.getRoleId());
				vo.setUserId(vo.getUserId());
				vo.setUserRoleId(vo.getUserRoleId());
				vo.setVersion(vo.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}

	public List<UserRoleVO> getAllRoles() {
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria();
		List<UserRoleDbObject> userRoleList = userRoleDbObjectMapper.selectByExample(userRoleExample);
		return convertToUserRoleVOList(userRoleList);
	}
	
	public List<UserRoleVO> getRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		return convertToUserRoleVOList(userRoleDbObjectMapper.selectByExample(userRoleExample));
	}
	
	public List<RolesToAssignVO> getRolesToAssign(String userName) {
		return roleCustomDbObjectMapper.getRolesToAssign(userName);
	}
	
	
	public void saveUserRole(UserRoleVO userRole) {
		UserRoleDbObject obj = convertToUserRoleDbObject(userRole);
		userRoleDbObjectMapper.insert(obj);
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

	public void deleteUserRole(int key) {
		userRoleDbObjectMapper.deleteByPrimaryKey(key);
	}
	
	public void deleteRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		userRoleDbObjectMapper.deleteByExample(userRoleExample);
	}
	
	public void updateRole(UserRoleVO role) {
		userRoleDbObjectMapper.updateByPrimaryKeySelective(convertToUserRoleDbObject(role));
	}
	 
	
	
}
