package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductTO;
import com.JJ.TO.ProductTagsTO;
import com.JJ.controller.productmanagement.vo.ProductTagsVO;
import com.JJ.dao.jpa.ProductTagsDAO;
import com.JJ.helper.GeneralUtils;
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductTagsMgmtService {
	private static final Logger logger = Logger.getLogger(ProductTagsMgmtService.class);
	private ProductTagsDAO productTagsDAO;
	
	@Autowired
	public ProductTagsMgmtService(ProductTagsDAO productTagsDAO) {
		this.productTagsDAO = productTagsDAO;
	}
	
	public void setProductTagsTO(List<ProductTagsVO> productTagsVOList, ProductTO newProductTO){
		List<ProductTagsTO> toList = convertToProductTagsTO(productTagsVOList);
		toList = setExisitingProductTags(toList);
		newProductTO.setProductTagsTOList(toList);
	}
	
	private List<ProductTagsTO> setExisitingProductTags(List<ProductTagsTO> toList){
		//chek if product tags exists
		List<ProductTagsTO> newList = new ArrayList<ProductTagsTO>();
		if(toList != null && !toList.isEmpty()){
			//get all active tags
			List<ProductTagsTO> existTOList = productTagsDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
			Map<String, ProductTagsTO> toMap = GeneralUtils.convertListToStringMap(existTOList, "name");
			
			for(ProductTagsTO to : toList){
				ProductTagsTO dbTO = toMap.get(to.getName());
				ProductTagsTO productTagsTO = to;
				if(dbTO != null){
					productTagsTO = dbTO;
				}
				newList.add(productTagsTO);
			}
		}
		return newList;
	}

	private static List<ProductTagsTO> convertToProductTagsTO(List<ProductTagsVO> newTagsList) {
		List<ProductTagsTO> toList = new ArrayList<ProductTagsTO>();
		if(newTagsList != null && !newTagsList.isEmpty()){
			for(ProductTagsVO vo : newTagsList){
				ProductTagsTO to = new ProductTagsTO();
				to.setName(vo.getName());
				to.setTagsId(vo.getTagsId());
				to.setDeleteInd(GeneralUtils.NOT_DELETED);
				toList.add(to);
			}
		}
		return toList;
	}
}
