package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.SubModuleTO;
@Transactional(readOnly = true)
public interface SubModuleDAO extends BaseDAO<SubModuleTO> {
	SubModuleTO findBySubmoduleId(Long submoduleId);
	List<SubModuleTO> findBySubmoduleIdIn(List<Long> submoduleIdList);
}
