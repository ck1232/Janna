package com.JJ.dao.jpa;

import java.util.List;

import com.JJ.TO.ProductOptionTO;

public interface ProductOptionDAO extends BaseDAO<ProductOptionTO>{
	List<ProductOptionTO> findByDeleteIndAndDisplayInd(String deleteInd, String displayInd);
	ProductOptionTO findByProductOptionId(Long productOptionId);
	ProductOptionTO findByNameAndDeleteInd(String name, String deleteInd);
}
