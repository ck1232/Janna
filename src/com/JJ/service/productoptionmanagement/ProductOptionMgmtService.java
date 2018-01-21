package com.JJ.service.productoptionmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductOptionTO;
import com.JJ.TO.ProductSubOptionTO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.dao.jpa.ProductOptionDAO;
import com.JJ.helper.GeneralUtils;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductOptionMgmtService {
	private ProductOptionDAO productOptionDAO;
	
	@Autowired
	public ProductOptionMgmtService(ProductOptionDAO productOptionDAO) {
		this.productOptionDAO = productOptionDAO;
	}

	public List<ProductOptionVO> getAllProductOptions() {
		List<ProductOptionTO> productOptionTOList = productOptionDAO.findByDeleteIndAndDisplayInd(GeneralUtils.NOT_DELETED, GeneralUtils.ALLOW_DISPLAY);
		List<ProductOptionVO> productOptionVOList = convertToProductOptionVOList(productOptionTOList);
		return productOptionVOList;
	}

	public static List<ProductOptionVO> convertToProductOptionVOList(List<ProductOptionTO> productOptionTOList) {
		List<ProductOptionVO> productOptionVOList = new ArrayList<ProductOptionVO>();
		if(productOptionTOList != null && !productOptionTOList.isEmpty()){
			for(ProductOptionTO to : productOptionTOList){
				ProductOptionVO vo = new ProductOptionVO();
				vo.setDisplayInd(to.getDisplayInd());
				vo.setName(to.getName());
				vo.setProductOptionId(to.getProductOptionId());
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				vo.setSubOptionList(new ArrayList<ProductSubOptionVO>());
				productOptionVOList.add(vo);
			}
		}
		return productOptionVOList;
	}
	
	public static List<ProductSubOptionVO> convertToProductSubOptionVOList(List<ProductSubOptionTO> productSubOptionTOList) {
		List<ProductSubOptionVO> productSubOptionVOList = new ArrayList<ProductSubOptionVO>();
		if(productSubOptionTOList != null && !productSubOptionTOList.isEmpty()){
			for(ProductSubOptionTO to : productSubOptionTOList){
				ProductSubOptionVO vo = new ProductSubOptionVO();
				vo.setProductSuboptionId(to.getProductSuboptionId());
				vo.setDisplayInd(to.getDisplayInd());
				vo.setName(to.getName());
				vo.setProductOptionId(to.getProductOptionTO()==null? null:to.getProductOptionTO().getProductOptionId());
				vo.setCode(to.getCode());
				vo.setProductId(to.getProductTO()==null? null : to.getProductTO().getProductId());
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				productSubOptionVOList.add(vo);
			}
		}
		return productSubOptionVOList;
	}
	
	
}