package com.JJ.service.productcategorymanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductCategoryTO;
import com.JJ.TO.ProductSubCategoryTO;
import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.dao.jpa.ProductCategoryDAO;
import com.JJ.helper.GeneralUtils;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductCategoryMgmtService {
	private ProductCategoryDAO productCategoryDAO;
	
	@Autowired
	public ProductCategoryMgmtService(ProductCategoryDAO productCategoryDAO) {
		this.productCategoryDAO = productCategoryDAO;
	}

	public List<ProductCategoryVO> getAllProductCategoryList() {
		List<ProductCategoryTO> productCategoryTOList = productCategoryDAO.findByDeleteIndAndDisplayInd(GeneralUtils.NOT_DELETED, GeneralUtils.ALLOW_DISPLAY);
		return convertToProductCategoryVOList(productCategoryTOList);
	}

	private List<ProductCategoryVO> convertToProductCategoryVOList(List<ProductCategoryTO> productCategoryTOList) {
		List<ProductCategoryVO> categoryList = new ArrayList<ProductCategoryVO>();
		if(productCategoryTOList != null && !productCategoryTOList.isEmpty()){
			for(ProductCategoryTO to : productCategoryTOList){
				ProductCategoryVO vo = new ProductCategoryVO();
				vo.setCategoryId(to.getCategoryId());
				vo.setCategoryName(to.getCategoryName());
				vo.setDisplayInd(to.getDisplayInd());
				vo.setDisplayIndBoolean(GeneralUtils.ALLOW_DISPLAY.equals(to.getDisplayInd())? Boolean.TRUE : Boolean.FALSE);
				vo.setIsParent(to.getIsParent());
				vo.setIsParentString(to.getIsParent());
				vo.setIsParentBoolean(GeneralUtils.YES_IND.equals(to.getIsParent()) ? Boolean.TRUE : Boolean.FALSE);
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				vo.setSubcategoryList(convertToProductSubCategoryVOList(to.getProductSubCategoryTOList()));
				if(vo.getSubcategoryList().isEmpty()){continue;}
				categoryList.add(vo);
			}
		}
		return categoryList;
	}
	
	private List<ProductSubCategoryVO> convertToProductSubCategoryVOList(List<ProductSubCategoryTO> toList){
		List<ProductSubCategoryVO> subCategoryList = new ArrayList<ProductSubCategoryVO>();
		if(toList != null && !toList.isEmpty()){
			for(ProductSubCategoryTO to : toList){
				ProductSubCategoryVO vo = new ProductSubCategoryVO();
				if(to.getProductCategoryTO() != null){
					vo.setCategoryId(to.getProductCategoryTO().getCategoryId());
				}
				vo.setDisplayInd(to.getDisplayInd());
				vo.setDisplayIndBoolean("Y".equals(to.getDisplayInd()) ? Boolean.TRUE : Boolean.FALSE);
				if(!vo.getDisplayIndBoolean() || "Y".equals(to.getDeleteInd())){
					continue;
				}
				vo.setName(to.getName());
				vo.setSubCategoryId(to.getSubCategoryId());
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				subCategoryList.add(vo);
			}
		}
		return subCategoryList;
	}
}