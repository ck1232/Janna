package com.JJ.service.roleassignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.UserRoleMapper;
import com.JJ.model.RolesToAssign;
import com.JJ.model.UserRole;
import com.JJ.model.UserRoleExample;
import com.JJ.model.UserRoleKey;

@Service
@Transactional
public class RoleAssignmentService {
	
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	public RoleAssignmentService(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}
	
	public UserRole findById(UserRoleKey key) {
		return userRoleMapper.selectByPrimaryKey(key);
	}

	public List<UserRole> getAllRoles() {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria();
		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
		return userRoleList;
	}
	
	public List<UserRole> getRoleListByUserId(Integer userId){
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUseridEqualTo(userId);
		return userRoleMapper.selectByExample(userRoleExample);
	}
	
	public List<RolesToAssign> getRolesToAssign(String userid) {
		return userRoleMapper.getRolesToAssign(userid);
	}
	
	
	public void saveUserRole(UserRole userRole) {
		userRoleMapper.insert(userRole);
	}
	
	
	public void deleteUserRole(UserRoleKey key) {
		userRoleMapper.deleteByPrimaryKey(key);
	}
	
	public void deleteRoleListByUserId(Integer userId){
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUseridEqualTo(userId);
		userRoleMapper.deleteByExample(userRoleExample);
	}
	
	public void updateRole(UserRole role) {
		userRoleMapper.updateByPrimaryKeySelective(role);
	}
	 
	
	
}
