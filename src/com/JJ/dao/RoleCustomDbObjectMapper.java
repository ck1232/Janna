package com.JJ.dao;

import java.util.List;

import com.JJ.controller.roleassignment.vo.RolesToAssignVO;

public interface RoleCustomDbObjectMapper {
	List<RolesToAssignVO> getRolesToAssign(String userName);
}
