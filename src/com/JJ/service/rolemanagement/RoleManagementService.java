package com.JJ.service.rolemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.RoleMapper;
import com.JJ.model.Role;
import com.JJ.model.RoleExample;

@Service
@Transactional
public class RoleManagementService {
	
	private RoleMapper roleMapper;
	
	@Autowired
	public RoleManagementService(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	public Role findById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public List<Role> getAllRoles() {
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria();
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		return roleList;
	}
	
	public void saveRole(Role role) {
		roleMapper.insert(role);
	}
	
	public void deleteRole(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
	}
	
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}
	 
	
	
}
