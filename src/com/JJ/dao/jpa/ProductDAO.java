package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductTO;
@Transactional(readOnly = true)
public interface ProductDAO extends BaseDAO<ProductTO> {
	List<ProductTO> findByDeleteInd(String deleteInd);
	List<ProductTO> findByProductIdNotAndDeleteInd(Long productId, String deleteInd);
	List<ProductTO> findByProductIdInAndDeleteInd(List<Long> productIdList, String deleteInd);
	ProductTO findByProductCodeAndDeleteInd(String productCode, String deleteInd);
}
