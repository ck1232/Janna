package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductAttributeTO;
import com.JJ.TO.ProductTO;
@Transactional(readOnly = true)
public interface ProductAttributeDAO extends BaseDAO<ProductAttributeTO> {
	List<ProductAttributeTO> findByProductTOAndDeleteInd(ProductTO productTO, String deleteInd);
}
