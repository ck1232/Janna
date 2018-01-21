package com.JJ.service.productmanagement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductSpecificationTO;
import com.JJ.TO.ProductTO;
import com.JJ.helper.GeneralUtils;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductSpecificationMgmtService {

	public void setProductSpecification(String content, ProductTO newProductTO ){
		ProductSpecificationTO to = convertToProductSpecificationTO(content);
		to = setExistingProductSpecificationTO(to, newProductTO);
		newProductTO.setProductSpecificationTO(to);
	}

	private ProductSpecificationTO convertToProductSpecificationTO(String content) {
		ProductSpecificationTO to = new ProductSpecificationTO();
		to.setContent(content);
		return to;
	}
	
	private ProductSpecificationTO setExistingProductSpecificationTO(ProductSpecificationTO specTO, ProductTO newProductTO) {
		specTO.setProductTO(newProductTO);
		if(newProductTO != null && newProductTO.getProductId() != null && newProductTO.getProductSpecificationTO() != null){
			ProductSpecificationTO dbTO = newProductTO.getProductSpecificationTO();
			if(dbTO != null){
				specTO.setProductSpecificationId(dbTO.getProductSpecificationId());
				GeneralUtils.copyFromTO(specTO, dbTO);
			}
		}
		return specTO;
	}
}