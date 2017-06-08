package com.JJ.service.productsubcategorymanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.dao.ProductSubCategoryDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductSubCategoryDbObject;
import com.JJ.model.ProductSubCategoryDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductSubCategoryManagementService {
	private ProductSubCategoryDbObjectMapper productSubCategoryDbObjectMapper;
	
	@Autowired
	public ProductSubCategoryManagementService(ProductSubCategoryDbObjectMapper ProductSubCategoryDbObjectMapper) {
		this.productSubCategoryDbObjectMapper = ProductSubCategoryDbObjectMapper;
	}
	
	public ProductSubCategoryVO findById(Integer id) {
		ProductSubCategoryDbObject productSubCategoryDbObject = productSubCategoryDbObjectMapper.selectByPrimaryKey(id);
		if(productSubCategoryDbObject != null && productSubCategoryDbObject.getSubCategoryId() != null){
			return convertToProductSubCategoryVOList(Arrays.asList(productSubCategoryDbObject)).get(0);
		}else{
			return new ProductSubCategoryVO();
		}
	}
	
	public List<ProductSubCategoryVO> getAllSubCategories() {
		ProductSubCategoryDbObjectExample productSubCategoryDbObjectExample = new ProductSubCategoryDbObjectExample();
		productSubCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToProductSubCategoryVOList(productSubCategoryDbObjectMapper.selectByExample(productSubCategoryDbObjectExample));
	}
	
	public Map<Integer, ProductSubCategoryVO> getProductsubcategoryMap(){
		List<ProductSubCategoryVO> subcatergoryList = this.getAllSubCategories();
		Map<Integer, ProductSubCategoryVO> map = new HashMap<Integer, ProductSubCategoryVO>();
		if(subcatergoryList != null && subcatergoryList.size() > 0){
			for(ProductSubCategoryVO subcategory : subcatergoryList){
				map.put(subcategory.getSubCategoryId(), subcategory);
			}
		}
		return map;
	}
	
	public List<ProductSubCategoryVO> getAllProductSubCategoryByCategory(Integer productcategoryid) {
		ProductSubCategoryDbObjectExample subcategoryExample = new ProductSubCategoryDbObjectExample();
		subcategoryExample.createCriteria().andCategoryIdEqualTo(productcategoryid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToProductSubCategoryVOList(productSubCategoryDbObjectMapper.selectByExample(subcategoryExample));
	}
	
	public void saveProductSubCategory(ProductSubCategoryVO productSubCategoryVO) {
		if(productSubCategoryVO != null){
			ProductSubCategoryDbObject dbObj = convertToProductSubCategoryDbObjectList(Arrays.asList(productSubCategoryVO)).get(0);
			productSubCategoryDbObjectMapper.insert(dbObj);
			productSubCategoryVO.setSubCategoryId(dbObj.getSubCategoryId());
		}
	}
	
	public void deleteProductSubCategory(Integer id) {
		deleteProductSubCategory(Arrays.asList(id));
	}
	
	public void deleteProductSubCategory(List<Integer> idList) {
		ProductSubCategoryDbObjectExample productSubCategoryDbObjectExample = new ProductSubCategoryDbObjectExample();
		productSubCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubCategoryIdIn(idList);
		ProductSubCategoryDbObject dbObj = new ProductSubCategoryDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		productSubCategoryDbObjectMapper.updateByExampleSelective(dbObj, productSubCategoryDbObjectExample);
	}
	
	public void deleteProductSubCategoryByCategory(Integer id) {
		if(id != null) {
			ProductSubCategoryDbObjectExample productSubCategoryDbObjectExample = new ProductSubCategoryDbObjectExample();
			productSubCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCategoryIdEqualTo(id);
			ProductSubCategoryDbObject dbObj = new ProductSubCategoryDbObject();
			dbObj.setDeleteInd(GeneralUtils.DELETED);
			productSubCategoryDbObjectMapper.updateByExampleSelective(dbObj, productSubCategoryDbObjectExample);
		}
	}
	
	
	public void updateProductsubcategory(ProductSubCategoryVO productSubCategoryVO) {
		if(productSubCategoryVO != null && productSubCategoryVO.getDeleteInd() != null &&
				productSubCategoryVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductSubCategoryDbObject dbObj = convertToProductSubCategoryDbObjectList(Arrays.asList(productSubCategoryVO)).get(0);
			productSubCategoryDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	private List<ProductSubCategoryVO> convertToProductSubCategoryVOList(List<ProductSubCategoryDbObject> productSubCategoryDbObjectList) {
		List<ProductSubCategoryVO> productSubCategoryVOList = new ArrayList<ProductSubCategoryVO>();
		if(productSubCategoryDbObjectList != null && !productSubCategoryDbObjectList.isEmpty()) {
			for(ProductSubCategoryDbObject dbObj : productSubCategoryDbObjectList) {
				ProductSubCategoryVO vo = new ProductSubCategoryVO();
				vo.setCategoryId(dbObj.getCategoryId());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setDisplayIndString(dbObj.getDisplayInd().equals("1") ? "Y" : "N");
				vo.setDisplayIndBoolean(dbObj.getDisplayInd().equals("1") ? Boolean.TRUE : Boolean.FALSE);
				vo.setName(dbObj.getName());
				vo.setSubCategoryId(dbObj.getSubCategoryId());
				vo.setVersion(dbObj.getVersion());
				productSubCategoryVOList.add(vo);
			}
		}
		return productSubCategoryVOList;
	}
	
	private List<ProductSubCategoryDbObject> convertToProductSubCategoryDbObjectList(List<ProductSubCategoryVO> productSubCategoryVOList) {
		List<ProductSubCategoryDbObject> productSubCategoryDbObjectList = new ArrayList<ProductSubCategoryDbObject>();
		if(productSubCategoryVOList != null && !productSubCategoryVOList.isEmpty()) {
			for(ProductSubCategoryVO vo : productSubCategoryVOList) {
				ProductSubCategoryDbObject dbObj = new ProductSubCategoryDbObject();
				dbObj.setCategoryId(vo.getCategoryId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDisplayInd(vo.getDisplayIndBoolean() == Boolean.TRUE ? "1" : "0");
				dbObj.setName(vo.getName());
				dbObj.setSubCategoryId(vo.getSubCategoryId());
				dbObj.setVersion(vo.getVersion());
				productSubCategoryDbObjectList.add(dbObj);
			}
		}
		return productSubCategoryDbObjectList;
	}

}
