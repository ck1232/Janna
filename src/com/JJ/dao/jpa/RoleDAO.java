package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.RoleTO;
@Transactional(readOnly = true)
public interface RoleDAO extends BaseDAO<RoleTO> {
	RoleTO findByRoleId(Integer roleId);
	List<RoleTO> findByRoleIdIn(List<Integer> roleIdList);
}
