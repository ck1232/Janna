package com.JJ.service.roleassignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.UserRoleVO;
import com.JJ.dao.UserRoleDbObjectMapper;
import com.JJ.dao.UserRoleMapper;
import com.JJ.model.RolesToAssign;
import com.JJ.model.UserDbObjectExample;
import com.JJ.model.UserRole;
import com.JJ.model.UserRoleDbObject;
import com.JJ.model.UserRoleDbObjectExample;
import com.JJ.model.UserRoleExample;

@Service
@Transactional
public class RoleAssignmentService {
	
	private UserRoleDbObjectMapper userRoleDbObjectMapper;
	
	@Autowired
	public RoleAssignmentService(UserRoleDbObjectMapper userRoleDbObjectMapper) {
		this.userRoleDbObjectMapper = userRoleDbObjectMapper;
	}
	
	public UserRoleVO findById(UserRoleVO key) {
		return userRoleDbObjectMapper.selectByPrimaryKey(key);
	}

	public List<UserRoleVO> getAllRoles() {
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria();
		List<UserRoleDbObject> userRoleList = userRoleDbObjectMapper.selectByExample(userRoleExample);
		return userRoleList;
	}
	
	public List<UserRoleVO> getRoleListByUserId(Integer userId){
		UserDbObjectExample userRoleExample = new UserDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		return userRoleDbObjectMapper.selectByExample(userRoleExample);
	}
	
	public List<RolesToAssign> getRolesToAssign(String userid) {
		return userRoleDbObjectMapper.getRolesToAssign(userid);
	}
	
	
	public void saveUserRole(UserRoleVO userRole) {
		userRoleDbObjectMapper.insert(userRole);
	}
	
	
	public void deleteUserRole(UserRoleVO key) {
		userRoleDbObjectMapper.deleteByPrimaryKey(key);
	}
	
	public void deleteRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		userRoleDbObjectMapper.deleteByExample(userRoleExample);
	}
	
	public void updateRole(UserRole role) {
		userRoleDbObjectMapper.updateByPrimaryKeySelective(role);
	}
	 
	
	
}
