package com.JJ.service.permissionmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.SubmodulepermissionMapper;
import com.JJ.dao.SubmodulepermissiontypeMapper;
import com.JJ.model.RolesToPermission;
import com.JJ.model.Submodulepermission;
import com.JJ.model.SubmodulepermissionExample;
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
	
	public List<Submodulepermission> getSubmoduleByRole(List<Integer> roleIdList){
		if(roleIdList == null || roleIdList.size() == 0){
			return new ArrayList<Submodulepermission>();
		}
		SubmodulepermissionExample example = new SubmodulepermissionExample();
		example.createCriteria().andRoleidIn(roleIdList);
		return submodulepermissionMapper.selectByExample(example);
	}
	
	public List<Submodulepermission> getSubmodulePermissionByRoleIdList(Map roleList){
		return submodulepermissionMapper.getSubmodulePermissionByRoleIdList(roleList);
	}
	
	
	public void deleteSubmodulepermission(String roleid, String submoduleid) {
		SubmodulepermissionExample submodulepermissionExample = new SubmodulepermissionExample();
		submodulepermissionExample.createCriteria().andSubmoduleidEqualTo(new Integer(submoduleid)).andRoleidEqualTo(new Integer(roleid));
		submodulepermissionMapper.deleteByExample(submodulepermissionExample);
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
	
	public Submodulepermissiontype getSubmodulepermissiontypeByUrl(String url){
		SubmodulepermissiontypeExample example = new SubmodulepermissiontypeExample();
		example.createCriteria().andUrlEqualTo(url);
		List<Submodulepermissiontype> resultList = submodulepermissiontypeMapper.selectByExample(example);
		if(resultList != null && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return null;
		}
	}
	
	public List<Submodulepermissiontype> getSubmodulepermissiontypeByUrl(){
		SubmodulepermissiontypeExample example = new SubmodulepermissiontypeExample();
		example.createCriteria();
		List<Submodulepermissiontype> resultList = submodulepermissiontypeMapper.selectByExample(example);
		if(resultList != null && resultList.size() > 0){
			return resultList;
		}else{
			return new ArrayList<Submodulepermissiontype>();
		}
	}
	
	public Submodulepermissiontype findById(Integer id) {
		return submodulepermissiontypeMapper.selectByPrimaryKey(id);
	}
	
	public void saveSubmodulepermissiontype(Submodulepermissiontype submodulepermissiontype) {
		submodulepermissiontypeMapper.insert(submodulepermissiontype);
	}
	
	public void deleteSubmodulepermissiontype(Integer id){
		submodulepermissiontypeMapper.deleteByPrimaryKey(id);
	}
	
	public void updateSubmodulepermissiontype(Submodulepermissiontype submodulepermissiontype) {
		submodulepermissiontypeMapper.updateByPrimaryKeySelective(submodulepermissiontype);
	}

	//Submodulepermissiontype functions END
	
}
