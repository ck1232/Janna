package com.JJ.service.productmanagement;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.OptionVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.dao.ProductMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.FileMeta;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.Productoption;

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
	
	public void deleteProduct(Integer id) {
		Product product = findById(id);
		if(product.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			product.setDeleteind(GeneralUtils.DELETED);
			productMapper.updateByPrimaryKey(product);
		}
	}
	
	public void saveProduct(ProductVo productVo){
		Product product = convertToProduct(productVo);
		//insert into product table
		if(product.getProductid() != null){
			productMapper.updateByPrimaryKeySelective(product);
		}else{
			productMapper.insertSelective(product);
		}
		
		//table image
		LinkedList<FileMeta> images = productVo.getImages();
		
	}
	
	private Product convertToProduct(ProductVo productVo){
		Product product = new Product();
		product.setProductid(productVo.getId());
		product.setProductname(productVo.getProductName());
		product.setUnitprice(productVo.getUnitPrice());
		product.setSubcategoryid(productVo.getSubcategoryId());
		product.setDeleteind(GeneralUtils.NOT_DELETED);
		return product;
	}
	
	private Productoption convertToProductsuboption(List<OptionVo> subOptionList){
		return null;
	}
}
