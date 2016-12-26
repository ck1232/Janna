package com.JJ.service.productoptionmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductoptionMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productoption;
import com.JJ.model.ProductoptionExample;

@Service
@Transactional
public class ProductOptionManagementService {
	
	private ProductoptionMapper productoptionMapper;
	
	@Autowired
	public ProductOptionManagementService(ProductoptionMapper productoptionMapper) {
		this.productoptionMapper = productoptionMapper;
	}
	
	public Productoption findById(Integer id) {
		return productoptionMapper.selectByPrimaryKey(id);
	}

	public List<Productoption> getAllProductoptions() {
		ProductoptionExample productoptionExample = new ProductoptionExample();
		productoptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productoption> productoptionList = productoptionMapper.selectByExample(productoptionExample);
		return productoptionList;
	}
	
	public List<Productoption> getDistinctProductoptions() {
		ProductoptionExample productoptionExample = new ProductoptionExample();
		productoptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productoption> productoptionList = productoptionMapper.selectByExample(productoptionExample);
		return productoptionList;
	}
	
	public List<Productoption> getAllProductoptionsByName(String name) {
		ProductoptionExample productoptionExample = new ProductoptionExample();
		productoptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andNameEqualTo(name);
		List<Productoption> productoptionList = productoptionMapper.selectByExample(productoptionExample);
		return productoptionList;
	}
	
	public void saveProductoption(Productoption productoption) {
		productoptionMapper.insert(productoption);
	}
	
	public void deleteProductoption(Integer id) {
		Productoption productoption = findById(id);
		if(productoption.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			productoption.setDeleteind(GeneralUtils.DELETED);
			productoptionMapper.updateByPrimaryKey(productoption);
		}
	}
	
	public void deleteProductoption(Productoption productoption) {
		if(productoption.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			productoption.setDeleteind(GeneralUtils.DELETED);
			productoptionMapper.updateByPrimaryKey(productoption);
		}
	}
	
	public void updateProductoption(Productoption productoption) {
		if(productoption.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			productoptionMapper.updateByPrimaryKeySelective(productoption);
	}
	 
	
	
}
