package com.JJ.service.productcategorymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductcategoryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productcategory;
import com.JJ.model.ProductcategoryExample;

@Service
@Transactional
public class ProductCategoryManagementService {
	private ProductcategoryMapper productCategoryMapper;
	
	@Autowired
	public ProductCategoryManagementService(ProductcategoryMapper productCategoryMapper) {
		this.productCategoryMapper = productCategoryMapper;
		
	}
	
	public Productcategory findById(Integer id) {
		return productCategoryMapper.selectByPrimaryKey(id);
	}
	
	public List<Productcategory> getAllCategories() {
		ProductcategoryExample categoryExample = new ProductcategoryExample();
		categoryExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productcategory> categoryList = productCategoryMapper.selectByExample(categoryExample);
		return categoryList;
	}
	
	public void saveProductCategory(Productcategory productcategory) {
		productCategoryMapper.insert(productcategory);
	}
	
	public void deleteProductCategory(Integer id) {
		Productcategory productcategory = findById(id);
		if(productcategory.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			productcategory.setDeleteInd(GeneralUtils.DELETED);
			productCategoryMapper.updateByPrimaryKey(productcategory);
		}
	}
	
	public void updateProductcategory(Productcategory productCategory) {
		if(productCategory.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			productCategoryMapper.updateByPrimaryKeySelective(productCategory);
	}
}
