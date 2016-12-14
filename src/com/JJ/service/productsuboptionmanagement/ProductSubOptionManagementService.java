package com.JJ.service.productsuboptionmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.ProductsuboptionMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;

@Service
@Transactional
public class ProductSubOptionManagementService {
	
	private ProductsuboptionMapper productsuboptionMapper;
	
	@Autowired
	public ProductSubOptionManagementService(ProductsuboptionMapper productsuboptionMapper) {
		this.productsuboptionMapper = productsuboptionMapper;
	}
	
	public Productsuboption findById(Integer id) {
		return productsuboptionMapper.selectByPrimaryKey(id);
	}

	public List<Productsuboption> getAllProductsuboptions() {
		ProductsuboptionExample productsuboptionExample = new ProductsuboptionExample();
		productsuboptionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andSequenceEqualTo(1);
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
	
	public void saveProductsuboption(Productsuboption productsuboption) {
		productsuboptionMapper.insert(productsuboption);
	}
	
	public void deleteProductsuboption(Integer id) {
		Productsuboption productsuboption = findById(id);
		if(productsuboption.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			productsuboption.setDeleteind(GeneralUtils.DELETED);
			productsuboptionMapper.updateByPrimaryKey(productsuboption);
		}
	}
	
	public void deleteProductsuboption(Productsuboption productsuboption) {
		if(productsuboption.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			productsuboption.setDeleteind(GeneralUtils.DELETED);
			productsuboptionMapper.updateByPrimaryKey(productsuboption);
		}
	}
	
	public void updateProductoption(Productsuboption productsuboption) {
		if(productsuboption.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			productsuboptionMapper.updateByPrimaryKeySelective(productsuboption);
	}
	
	public SubOptionVo convertSubOptionToVo(Productsuboption suboption){
		SubOptionVo vo = new SubOptionVo();
		vo.setSubOptionId(suboption.getProductsuboptionid());
		vo.setSubOptionName(suboption.getName());
		vo.setSeq(suboption.getSequence());
		return vo;
	}
	 
	
	
}