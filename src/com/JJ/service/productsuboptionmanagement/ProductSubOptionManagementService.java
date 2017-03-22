package com.JJ.service.productsuboptionmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.SubOptionVO;
import com.JJ.dao.ProductMapper;
import com.JJ.dao.ProductsuboptionMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;

@Service
@Transactional
public class ProductSubOptionManagementService {
	
	private ProductsuboptionMapper productsuboptionMapper;
	private ProductMapper productMapper;
	
	@Autowired
	public ProductSubOptionManagementService(ProductsuboptionMapper productsuboptionMapper,
		 ProductMapper productMapper) {
		this.productsuboptionMapper = productsuboptionMapper;
		this.productMapper = productMapper;
	}
	
	public Productsuboption findById(Integer id) {
		return productsuboptionMapper.selectByPrimaryKey(id);
	}

	public List<Productsuboption> getAllProductsuboptions() {
		ProductsuboptionExample productsuboptionExample = new ProductsuboptionExample();
		productsuboptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productsuboption> productsuboptionList = productsuboptionMapper.selectByExample(productsuboptionExample);
		return productsuboptionList;
	}
	
	public List<Productsuboption> getAllProductsuboptionsByProductId(Integer productid) {
		ProductsuboptionExample productsuboptionExample = new ProductsuboptionExample();
		productsuboptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED)
												.andDisplayindEqualTo(true)
												.andProductidEqualTo(productid);
		List<Productsuboption> productsuboptionList = productsuboptionMapper.selectByExample(productsuboptionExample);
		return productsuboptionList;
	}
	
	public List<Productsuboption> getAllProductsuboptionsByProductIdList(List<Integer> productid) {
		ProductsuboptionExample productsuboptionExample = new ProductsuboptionExample();
		productsuboptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED)
												.andDisplayindEqualTo(true)
												.andProductidIn(productid);
		List<Productsuboption> productsuboptionList = productsuboptionMapper.selectByExample(productsuboptionExample);
		return productsuboptionList;
	}
	
	public void saveProductsuboption(Productsuboption productsuboption) {
		productsuboptionMapper.insert(productsuboption);
	}
	
	public void deleteProductsuboption(Integer id) {
		Productsuboption productsuboption = findById(id);
		if(productsuboption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			productsuboption.setDeleteInd(GeneralUtils.DELETED);
			productsuboptionMapper.updateByPrimaryKey(productsuboption);
		}
	}
	
	public void deleteProductsuboption(Productsuboption productsuboption) {
		if(productsuboption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			productsuboption.setDeleteInd(GeneralUtils.DELETED);
			productsuboptionMapper.updateByPrimaryKey(productsuboption);
		}
	}
	
	public void updateProductoption(Productsuboption productsuboption) {
		if(productsuboption.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			productsuboptionMapper.updateByPrimaryKeySelective(productsuboption);
	}
	
	public SubOptionVO convertSubOptionToVo(Productsuboption suboption){
		SubOptionVO vo = new SubOptionVO();
		vo.setSubOptionId(suboption.getProductsuboptionid());
		vo.setSubOptionName(suboption.getName());
		return vo;
	}
	
}
