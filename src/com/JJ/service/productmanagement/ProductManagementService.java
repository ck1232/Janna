package com.JJ.service.productmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;

@Service
@Transactional
public class ProductManagementService {
	
	private ProductMapper productMapper;
	
	@Autowired
	public ProductManagementService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public Product findById(Integer id) {
		Product product = productMapper.selectByPrimaryKey(id);
		return product;
	}
	

	public List<Product> getAllProducts() {
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Product> productList = productMapper.selectByExample(productExample);
		return productList;
	}
	
	public List<Product> getAllProductsBySubCategory(Integer id) {
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andSubcategoryidEqualTo(id);
		List<Product> productList = productMapper.selectByExample(productExample);
		return productList;
	}
	
	public void saveProduct(Product product) {
		productMapper.insert(product);
	}
	
	public void deleteProduct(Integer id) {
		Product product = findById(id);
		if(product.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			product.setDeleteind(GeneralUtils.DELETED);
			productMapper.updateByPrimaryKey(product);
		}
	}
	
	public void updateProduct(Product product) {
		if(product.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			productMapper.updateByPrimaryKeySelective(product);
	}
	
}
