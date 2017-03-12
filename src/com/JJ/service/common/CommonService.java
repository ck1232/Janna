package com.JJ.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.RoleMapper;
import com.JJ.dao.SubmodulepermissionMapper;
import com.JJ.dao.SubmodulepermissiontypeMapper;
import com.JJ.model.Role;
import com.JJ.model.RoleExample;
import com.JJ.model.Submodulepermission;
import com.JJ.model.SubmodulepermissionExample;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.model.SubmodulepermissiontypeExample;

@Service
@Transactional
public class CommonService {
	private RoleMapper roleMapper;
	private SubmodulepermissiontypeMapper submodulepermissiontypeMapper;
	private SubmodulepermissionMapper submodulepermissionMapper;
	@Autowired
	public CommonService(RoleMapper roleMapper, 
			SubmodulepermissiontypeMapper submodulepermissiontypeMapper, 
			SubmodulepermissionMapper submodulepermissionMapper){
		this.roleMapper = roleMapper;
		this.submodulepermissionMapper = submodulepermissionMapper;
		this.submodulepermissiontypeMapper = submodulepermissiontypeMapper;
	}
	
	public List<String> getAllowedUrlByRoleName(List<String> roleNameList){
		List<Integer> roleIdList = getRoleIdByRoleName(roleNameList);
		List<String> urlList = new ArrayList<String>();
		if(roleIdList != null && roleIdList.size() > 0){
			List<Integer> permissionList = getPermissionByRoleId(roleIdList); 
			if(permissionList != null && permissionList.size() > 0){
				urlList = getAllowedUrlByPermission(permissionList);
			}
		}
		return urlList;
	}
	
	private List<Integer> getRoleIdByRoleName(List<String> roleNameList){
		RoleExample example = new RoleExample();
		example.createCriteria().andNameIn(roleNameList);
		List<Role> result = roleMapper.selectByExample(example);
		List<Integer> roleIdList = new ArrayList<Integer>();
		if(result != null && result.size() > 0){
			for(Role role : result){
				roleIdList.add(role.getId());
			}
		}
		return roleIdList;
	}
	
	private List<Integer> getPermissionByRoleId(List<Integer> roleIdList){
		SubmodulepermissionExample example = new SubmodulepermissionExample();
		example.createCriteria().andRoleidIn(roleIdList);
		List<Submodulepermission> result= submodulepermissionMapper.selectByExample(example);
		List<Integer> permissionIdList = new ArrayList<Integer>();
		if(result != null && result.size() > 0){
			for(Submodulepermission submodulepermission : result){
				try{
					Integer permission = Integer.parseInt(submodulepermission.getPermission());
					permissionIdList.add(permission);
				}catch(Exception ex){
					
				}
			}
		}
		return permissionIdList;
	}
	
	private List<String> getAllowedUrlByPermission(List<Integer> permissionId){
		SubmodulepermissiontypeExample example = new SubmodulepermissiontypeExample();
		example.createCriteria().andIdIn(permissionId);
		List<Submodulepermissiontype> result = submodulepermissiontypeMapper.selectByExample(example);
		List<String> urlList = new ArrayList<String>();
		if(result != null && result.size() > 0){
			for(Submodulepermissiontype submodulepermissiontype : result){
				try{
					urlList.add(submodulepermissiontype.getUrl());
				}catch(Exception ex){
					
				}
			}
		}
		return urlList;
	}
}
