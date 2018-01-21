package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductCategoryTO;

@Transactional(readOnly = true)
public interface ProductCategoryDAO extends BaseDAO<ProductCategoryTO>{
	List<ProductCategoryTO> findByDeleteIndAndDisplayInd(String deleteInd, String displayInd);
}