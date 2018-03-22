package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ModuleTO;
@Transactional(readOnly = true)
public interface ModuleDAO extends BaseDAO<ModuleTO> {
	ModuleTO findByModuleId(Long moduleId);
	List<ModuleTO> findByModuleIdIn(List<Long> moduleIdList);
}
