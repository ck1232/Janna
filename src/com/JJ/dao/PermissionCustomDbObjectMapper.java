package com.JJ.dao;

import java.util.List;
import java.util.Map;

import com.JJ.model.RolesToPermissionCustomDbObject;
import com.JJ.model.SubModulePermissionDbObject;

public interface PermissionCustomDbObjectMapper {
	List<RolesToPermissionCustomDbObject> getRolesToPermission(String moduleId);
	List<SubModulePermissionDbObject> getSubmodulePermissionByRoleIdList (Map<String, List<String>> roleList);
}
