package com.JJ.service.permissionmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.SubmodulepermissionMapper;
import com.JJ.dao.SubmodulepermissiontypeMapper;
import com.JJ.model.RolesToPermission;
import com.JJ.model.Submodulepermission;
import com.JJ.model.SubmodulepermissionExample;
import com.JJ.model.SubmodulepermissionKey;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.model.SubmodulepermissiontypeExample;

@Service
@Transactional
public class PermissionManagementService {
	
	private SubmodulepermissionMapper submodulepermissionMapper;
	private SubmodulepermissiontypeMapper submodulepermissiontypeMapper;
	
	@Autowired
	public PermissionManagementService(SubmodulepermissionMapper submodulepermissionMapper,
			SubmodulepermissiontypeMapper submodulepermissiontypeMapper) {
		this.submodulepermissionMapper = submodulepermissionMapper;
		this.submodulepermissiontypeMapper = submodulepermissiontypeMapper;
	}
	
	//Submodulepermission functions START
	public Submodulepermission findById(SubmodulepermissionKey key) {
		return submodulepermissionMapper.selectByPrimaryKey(key);
	}

	public List<Submodulepermission> getAllSubmodulepermission() {
		SubmodulepermissionExample submodulepermissionExample = new SubmodulepermissionExample();
		submodulepermissionExample.createCriteria();
		List<Submodulepermission> submodulepermissionList = submodulepermissionMapper.selectByExample(submodulepermissionExample);
		return submodulepermissionList;
	}
	
	public List<RolesToPermission> getRolesToPermission(String submoduleid) {
		return submodulepermissionMapper.getRolesToPermission(submoduleid);
	}
	
	
	public void saveSubmodulepermission(Submodulepermission submodulepermission) {
		submodulepermissionMapper.insert(submodulepermission);
	}
	
	
	public void deleteSubmodulepermission(SubmodulepermissionKey key) {
		submodulepermissionMapper.deleteByPrimaryKey(key);
	}
	
	public void updateSubmodulepermission(Submodulepermission submodulepermission) {
		submodulepermissionMapper.updateByPrimaryKeySelective(submodulepermission);
	}
	//Submodulepermission functions END
	
	
	
	//Submodulepermissiontype functions START
	public List<Submodulepermissiontype> getSubmodulepermissiontype(String submoduleid) {
		SubmodulepermissiontypeExample submodulepermissiontypeExample = new SubmodulepermissiontypeExample();
		submodulepermissiontypeExample.createCriteria().andSubmoduleidEqualTo(submoduleid);
		submodulepermissiontypeExample.setOrderByClause("seqno");
		List<Submodulepermissiontype> submodulepermissiontypeList = submodulepermissiontypeMapper.selectByExample(submodulepermissiontypeExample);
		return submodulepermissiontypeList;
	}
	//Submodulepermissiontype functions END
	
}
