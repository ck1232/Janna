package com.JJ.dao.jpa;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductTagsTO;
@Transactional(readOnly = true)
public interface ProductTagsDAO extends BaseDAO<ProductTagsTO> {
}
