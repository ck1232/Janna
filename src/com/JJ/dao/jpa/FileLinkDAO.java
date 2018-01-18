package com.JJ.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.FileLinkTO;
@Transactional(readOnly = true)
public interface FileLinkDAO extends BaseDAO<FileLinkTO>{
	
}
