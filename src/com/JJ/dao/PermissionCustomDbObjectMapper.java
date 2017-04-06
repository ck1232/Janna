package com.JJ.dao;

import java.util.List;
import java.util.Map;

import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.model.RolesToPermissionCustomDbObject;

public interface PermissionCustomDbObjectMapper {
	List<RolesToPermissionCustomDbObject> getRolesToPermission(String moduleId);
	List<SubModulePermissionVO> getSubmodulePermissionByRoleIdList (Map<String, List<Integer>> roleList);
}
