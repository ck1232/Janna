package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ImageLinkRsTO;
import com.JJ.TO.ProductTO;
@Transactional(readOnly = true)
public interface ImageLinkRsDAO extends BaseDAO<ImageLinkRsTO> {
	List<ImageLinkRsTO> findByRefTypeAndProductTOInAndDeleteIndOrderBySequenceAsc(String refType, List<ProductTO> productTOList, String deleteInd);
}
