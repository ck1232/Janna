package com.JJ.service.productmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.Productsubcategory;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Service
@Transactional
public class ProductService {
	private ProductMapper productMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	@Autowired
	public ProductService(ProductMapper productMapper, ProductSubCategoryManagementService productSubCategoryManagementService){
		this.productMapper = productMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
	}
	
	public List<Product> getAllProducts() {
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Product> productList = productMapper.selectByExample(productExample);
		Map<Integer, Productsubcategory> subcategoryMap =  getProductsubcategoryMap();
		if(productList != null && productList.size() > 0){
			for(Product product : productList){
				if(product.getSubcategoryid() != null && product.getSubcategoryid().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubcategoryid()));
				}
			}
		}
		return productList;
	}
	
	private Map<Integer, Productsubcategory> getProductsubcategoryMap(){
		List<Productsubcategory> subcatergoryList = productSubCategoryManagementService.getAllSubCategories();
		Map<Integer, Productsubcategory> map = new HashMap<Integer, Productsubcategory>();
		if(subcatergoryList != null && subcatergoryList.size() > 0){
			for(Productsubcategory subcategory : subcatergoryList){
				map.put(subcategory.getId(), subcategory);
			}
		}
		return map;
	}

}
