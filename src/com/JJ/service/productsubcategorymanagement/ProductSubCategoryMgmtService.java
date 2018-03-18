package com.JJ.service.productsubcategorymanagement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductSubCategoryTO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.dao.jpa.ProductSubCategoryDAO;
import com.JJ.service.productcategorymanagement.ProductCategoryMgmtService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductSubCategoryMgmtService {
	private ProductSubCategoryDAO productSubCategoryDAO;
	private ProductCategoryMgmtService productCategoryMgmtService;
	@Autowired
	public ProductSubCategoryMgmtService(
			ProductSubCategoryDAO productSubCategoryDAO,
			ProductCategoryMgmtService productCategoryMgmtService) {
		this.productSubCategoryDAO = productSubCategoryDAO;
		this.productCategoryMgmtService = productCategoryMgmtService;
	}
	
	public ProductSubCategoryVO getProductSubCategoryById(Long id, String deleteInd){
		ProductSubCategoryTO to = productSubCategoryDAO.findBySubCategoryIdAndDeleteInd(id, deleteInd);
		if(to != null){
			return productCategoryMgmtService.convertToProductSubCategoryVOList(Arrays.asList(to)).get(0);
		}
		return new ProductSubCategoryVO();
	}
	
}
