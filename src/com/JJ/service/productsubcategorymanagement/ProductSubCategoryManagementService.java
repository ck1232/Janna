package com.JJ.service.productsubcategorymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductsubcategoryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productsubcategory;
import com.JJ.model.ProductsubcategoryExample;

@Service
@Transactional
public class ProductSubCategoryManagementService {
	private ProductsubcategoryMapper productSubCategoryMapper;
	
	@Autowired
	public ProductSubCategoryManagementService(ProductsubcategoryMapper productSubCategoryMapper) {
		this.productSubCategoryMapper = productSubCategoryMapper;
	}
	
	public Productsubcategory findById(Integer id) {
		return productSubCategoryMapper.selectByPrimaryKey(id);
	}
	
	public List<Productsubcategory> getAllCategories() {
		ProductsubcategoryExample subcategoryExample = new ProductsubcategoryExample();
		subcategoryExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productsubcategory> subcategoryList = productSubCategoryMapper.selectByExample(subcategoryExample);
		return subcategoryList;
	}
	
	public List<Productsubcategory> getAllProductSubCategoryByCategory(Integer productcategoryid) {
		ProductsubcategoryExample subcategoryExample = new ProductsubcategoryExample();
		subcategoryExample.createCriteria().andProductcategoryidEqualTo(productcategoryid)
										.andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productsubcategory> subcategoryList = productSubCategoryMapper.selectByExample(subcategoryExample);
		return subcategoryList;
	}
	
	public void saveProductSubCategory(Productsubcategory productsubcategory) {
		productSubCategoryMapper.insert(productsubcategory);
	}
	
	public void deleteProductSubCategory(Integer id) {
		Productsubcategory productsubcategory = findById(id);
		if(productsubcategory.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			productsubcategory.setDeleteind(GeneralUtils.DELETED);
			productSubCategoryMapper.updateByPrimaryKey(productsubcategory);
		}
	}
	
	public void deleteProductSubCategoryByCategory(Integer id) {
		List<Productsubcategory> subcategoryList = getAllProductSubCategoryByCategory(id);
		for(Productsubcategory psc: subcategoryList){
			if(psc.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
				psc.setDeleteind(GeneralUtils.DELETED);
				productSubCategoryMapper.updateByPrimaryKey(psc);
			}
		}
	}
	
	
	
	public void updateProductsubcategory(Productsubcategory productSubCategory) {
		if(productSubCategory.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			productSubCategoryMapper.updateByPrimaryKeySelective(productSubCategory);
	}

}
