package com.JJ.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductSubOptionTO;
@Transactional(readOnly = true)
public interface ProductSubOptionDAO extends BaseDAO<ProductSubOptionTO> {
	ProductSubOptionTO findByproductSuboptionId(Long id);
}
