package com.JJ.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.RoleDbObjectMapper;
import com.JJ.dao.SubModulePermissionDbObjectMapper;
import com.JJ.dao.SubModulePermissionTypeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.RoleDbObject;
import com.JJ.model.RoleDbObjectExample;
import com.JJ.model.SubModulePermissionDbObject;
import com.JJ.model.SubModulePermissionDbObjectExample;
import com.JJ.model.SubModulePermissionTypeDbObject;
import com.JJ.model.SubModulePermissionTypeDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class CommonService {
	private RoleDbObjectMapper roleDbObjectMapper;
	private SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper;
	private SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper;
	@Autowired
	public CommonService(RoleDbObjectMapper roleDbObjectMapper, 
			SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper, 
			SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper){
		this.roleDbObjectMapper = roleDbObjectMapper;
		this.subModulePermissionTypeDbObjectMapper = subModulePermissionTypeDbObjectMapper;
		this.subModulePermissionDbObjectMapper = subModulePermissionDbObjectMapper;
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
		RoleDbObjectExample example = new RoleDbObjectExample();
		example.createCriteria().andNameIn(roleNameList);
		List<RoleDbObject> result = roleDbObjectMapper.selectByExample(example);
		List<Integer> roleIdList = new ArrayList<Integer>();
		if(result != null && result.size() > 0){
			for(RoleDbObject role : result){
				roleIdList.add(role.getRoleId());
			}
		}
		return roleIdList;
	}
	
	private List<Integer> getPermissionByRoleId(List<Integer> roleIdList){
		SubModulePermissionDbObjectExample example = new SubModulePermissionDbObjectExample();
		example.createCriteria().andRoleIdIn(roleIdList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModulePermissionDbObject> result= subModulePermissionDbObjectMapper.selectByExample(example);
		List<Integer> permissionIdList = new ArrayList<Integer>();
		if(result != null && result.size() > 0){
			for(SubModulePermissionDbObject submodulepermission : result){
				try{
					permissionIdList.add(submodulepermission.getPermissionTypeId());
				}catch(Exception ex){
					
				}
			}
		}
		return permissionIdList;
	}
	
	private List<String> getAllowedUrlByPermission(List<Integer> permissionId){
		SubModulePermissionTypeDbObjectExample example = new SubModulePermissionTypeDbObjectExample();
		example.createCriteria().andTypeIdIn(permissionId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModulePermissionTypeDbObject> result = subModulePermissionTypeDbObjectMapper.selectByExample(example);
		List<String> urlList = new ArrayList<String>();
		if(result != null && result.size() > 0){
			for(SubModulePermissionTypeDbObject submodulepermissiontype : result){
				urlList.add(submodulepermissiontype.getUrl());
			}
		}
		return urlList;
	}
}
