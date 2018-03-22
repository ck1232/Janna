package com.JJ.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductSubCategoryTO;

@Transactional(readOnly = true)
public interface ProductSubCategoryDAO extends BaseDAO<ProductSubCategoryTO>{
	ProductSubCategoryTO findBySubCategoryIdAndDeleteInd(Long id , String deleteInd);
}
