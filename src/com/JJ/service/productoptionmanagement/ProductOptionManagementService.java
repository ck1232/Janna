package com.JJ.service.productoptionmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.dao.ProductOptionDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductOptionDbObject;
import com.JJ.model.ProductOptionDbObjectExample;

@Service
@Transactional
public class ProductOptionManagementService {
	
	private ProductOptionDbObjectMapper productOptionDbObjectMapper;
	
	@Autowired
	public ProductOptionManagementService(ProductOptionDbObjectMapper productOptionDbObjectMapper) {
		this.productOptionDbObjectMapper = productOptionDbObjectMapper;
	}
	
	public ProductOptionVO findById(Integer id) {
		return productOptionDbObjectMapper.selectByPrimaryKey(id);
	}

	public List<ProductOptionVO> getAllProductoptions() {
		ProductOptionDbObjectExample productoptionExample = new ProductOptionDbObjectExample();
		productoptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductOptionDbObject> productoptionList = productOptionDbObjectMapper.selectByExample(productoptionExample);
		return productoptionList;
	}

	public List<ProductOptionVO> getAllProductoptionsByName(String name) {
		ProductOptionDbObjectExample productoptionExample = new ProductOptionDbObjectExample();
		productoptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andNameEqualTo(name);
		List<ProductOptionDbObject> productoptionList = productOptionDbObjectMapper.selectByExample(productoptionExample);
		return productoptionList;
	}
	
	public void saveProductoption(ProductOptionVO productoption) {
		productOptionDbObjectMapper.insert(productoption);
	}
	
	public void deleteProductoption(Integer id) {
		ProductOptionVO productoption = findById(id);
		if(productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			productoption.setDeleteInd(GeneralUtils.DELETED);
			productOptionDbObjectMapper.updateByPrimaryKey(productoption);
		}
	}
	
	public void deleteProductoption(ProductOptionVO productoption) {
		if(productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			productoption.setDeleteInd(GeneralUtils.DELETED);
			productOptionDbObjectMapper.updateByPrimaryKey(productoption);
		}
	}
	
	public void updateProductoption(ProductOptionVO productoption) {
		if(productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			productOptionDbObjectMapper.updateByPrimaryKeySelective(productoption);
	}
	 
	
	
}
