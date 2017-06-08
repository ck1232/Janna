package com.JJ.service.productcategorymanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.dao.ProductCategoryDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductCategoryDbObject;
import com.JJ.model.ProductCategoryDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductCategoryManagementService {
	private ProductCategoryDbObjectMapper productCategoryDbObjectMapper;
	
	@Autowired
	public ProductCategoryManagementService(ProductCategoryDbObjectMapper productCategoryDbObjectMapper) {
		this.productCategoryDbObjectMapper = productCategoryDbObjectMapper;
		
	}
	
	public ProductCategoryVO findById(Integer id) {
		ProductCategoryDbObject productCategoryDbObject = productCategoryDbObjectMapper.selectByPrimaryKey(id);
		if(productCategoryDbObject != null && productCategoryDbObject.getCategoryId() != null){
			return convertToProductCategoryVOList(Arrays.asList(productCategoryDbObject)).get(0);
		}else{
			return new ProductCategoryVO();
		}
	}
	
	public List<ProductCategoryVO> getAllCategories() {
		ProductCategoryDbObjectExample productCategoryDbObjectExample = new ProductCategoryDbObjectExample();
		productCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToProductCategoryVOList(productCategoryDbObjectMapper.selectByExample(productCategoryDbObjectExample));
	}
	
	public void saveProductCategory(ProductCategoryVO ProductCategoryVO) {
		if(ProductCategoryVO != null){
			ProductCategoryDbObject dbObj = convertToProductCategoryDbObjectList(Arrays.asList(ProductCategoryVO)).get(0);
			productCategoryDbObjectMapper.insert(dbObj);
			ProductCategoryVO.setCategoryId(dbObj.getCategoryId());
		}
	}
	
	public void deleteProductCategory(Integer id) {
		deleteProductCategory(Arrays.asList(id));
	}
	
	public void deleteProductCategory(List<Integer> idList) {
		ProductCategoryDbObjectExample productCategoryDbObjectExample = new ProductCategoryDbObjectExample();
		productCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCategoryIdIn(idList);
		ProductCategoryDbObject dbObj = new ProductCategoryDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		productCategoryDbObjectMapper.updateByExampleSelective(dbObj, productCategoryDbObjectExample);
	}
	
	public void updateProductcategory(ProductCategoryVO productCategoryVO) {
		if(productCategoryVO != null && productCategoryVO.getCategoryId() != null){
			ProductCategoryDbObject dbObj = convertToProductCategoryDbObjectList(Arrays.asList(productCategoryVO)).get(0);
			productCategoryDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	private List<ProductCategoryVO> convertToProductCategoryVOList(List<ProductCategoryDbObject> productCategoryDbObjectList) {
		List<ProductCategoryVO> productCategoryVOList = new ArrayList<ProductCategoryVO>();
		if(productCategoryDbObjectList != null && !productCategoryDbObjectList.isEmpty()) {
			for(ProductCategoryDbObject dbObj : productCategoryDbObjectList) {
				ProductCategoryVO vo = new ProductCategoryVO();
				vo.setCategoryId(dbObj.getCategoryId());
				vo.setCategoryName(dbObj.getCategoryName());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setDisplayIndString(dbObj.getDisplayInd().equals("1") ? "Y" : "N");
				vo.setDisplayIndBoolean(dbObj.getDisplayInd().equals("1")? Boolean.TRUE : Boolean.FALSE);
				vo.setIsParent(dbObj.getIsParent());
				vo.setIsParentString(dbObj.getIsParent().equals("1") ? "Y" : "N");
				vo.setIsParentBoolean(dbObj.getIsParent().equals("1") ? Boolean.TRUE : Boolean.FALSE);
				vo.setVersion(dbObj.getVersion());
				productCategoryVOList.add(vo);
			}
		}
		return productCategoryVOList;
	}
	
	private List<ProductCategoryDbObject> convertToProductCategoryDbObjectList(List<ProductCategoryVO> productCategoryVOList) {
		List<ProductCategoryDbObject> productCategoryDbObjectList = new ArrayList<ProductCategoryDbObject>();
		if(productCategoryVOList != null && !productCategoryVOList.isEmpty()) {
			for(ProductCategoryVO vo : productCategoryVOList) {
				ProductCategoryDbObject dbObj = new ProductCategoryDbObject();
				dbObj.setCategoryId(vo.getCategoryId());
				dbObj.setCategoryName(vo.getCategoryName());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDisplayInd(vo.getDisplayIndBoolean() == Boolean.TRUE ? "1" : "0");
				dbObj.setIsParent(vo.getIsParentBoolean() == Boolean.TRUE ? "1" : "0");
				dbObj.setVersion(vo.getVersion());
				productCategoryDbObjectList.add(dbObj);
			}
		}
		return productCategoryDbObjectList;
	}
}
