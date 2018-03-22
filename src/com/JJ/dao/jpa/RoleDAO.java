package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.RoleTO;
@Transactional(readOnly = true)
public interface RoleDAO extends BaseDAO<RoleTO> {
	RoleTO findByRoleId(Long roleId);
	List<RoleTO> findByRoleIdIn(List<Long> roleIdList);
}
