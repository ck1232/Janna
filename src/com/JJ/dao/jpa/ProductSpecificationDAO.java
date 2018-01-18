package com.JJ.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductSpecificationTO;
import com.JJ.TO.ProductTO;
@Transactional(readOnly = true)
public interface ProductSpecificationDAO extends BaseDAO<ProductSpecificationTO> {
	ProductSpecificationTO findByProductTOAndDeleteInd(ProductTO productTO, String deleteInd );
}
