package com.JJ.service.rolemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.rolemanagement.vo.RoleVO;
import com.JJ.dao.RoleDbObjectMapper;
import com.JJ.model.RoleDbObject;
import com.JJ.model.RoleDbObjectExample;

@Service
@Transactional
public class RoleManagementService {
	
	private RoleDbObjectMapper roleMapper;
	
	@Autowired
	public RoleManagementService(RoleDbObjectMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	public RoleVO findById(Integer id) {
		RoleDbObject obj = roleMapper.selectByPrimaryKey(id);
		return convertToRoleVO(Arrays.asList(obj)).get(0);
	}

	public List<RoleVO> getAllRoles() {
		RoleDbObjectExample roleExample = new RoleDbObjectExample();
		roleExample.createCriteria();
		List<RoleDbObject> roleList = roleMapper.selectByExample(roleExample);
		return convertToRoleVO(roleList);
	}
	
	private List<RoleVO> convertToRoleVO(List<RoleDbObject> objList) {
		List<RoleVO> voList = new ArrayList<RoleVO>();
		if(objList != null && objList.size() > 0){
			for(RoleDbObject obj : objList){
				RoleVO vo = new RoleVO();
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setName(obj.getName());
				vo.setRoleId(obj.getRoleId());
				vo.setVersion(obj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}

	public void saveRole(RoleVO role) {
		RoleDbObject obj = convertToRoleDbObject(role);
		roleMapper.insert(obj);
	}
	
	private RoleDbObject convertToRoleDbObject(RoleVO role) {
		RoleDbObject obj = new RoleDbObject();
		obj.setDeleteInd(role.getDeleteInd());
		obj.setName(role.getName());
		obj.setRoleId(role.getRoleId());
		obj.setVersion(role.getVersion());
		return obj;
	}

	public void deleteRole(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
	}
	
	public void updateRole(RoleVO role) {
		roleMapper.updateByPrimaryKeySelective(convertToRoleDbObject(role));
	}
	 
	
	
}
