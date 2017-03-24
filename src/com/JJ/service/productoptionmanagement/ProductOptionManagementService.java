package com.JJ.service.productoptionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
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
		ProductOptionDbObject obj = productOptionDbObjectMapper.selectByPrimaryKey(id);
		List<ProductOptionVO> voList= convertToProductOptionVOList(Arrays.asList(obj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new ProductOptionVO();
	}

	public List<ProductOptionVO> convertToProductOptionVOList(
			List<ProductOptionDbObject> objList) {
		List<ProductOptionVO> list = new ArrayList<ProductOptionVO>();
		if(objList != null && objList.size() > 0){
			for(ProductOptionDbObject dbObj : objList){
				ProductOptionVO vo = new ProductOptionVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setName(dbObj.getDisplayInd());
				vo.setProductOptionId(dbObj.getProductOptionId());
				vo.setVersion(dbObj.getVersion());
				list.add(vo);
			}
		}
		return list;
	}

	public List<ProductOptionVO> getAllProductoptions() {
		ProductOptionDbObjectExample productoptionExample = new ProductOptionDbObjectExample();
		productoptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductOptionDbObject> productoptionList = productOptionDbObjectMapper.selectByExample(productoptionExample);
		return convertToProductOptionVOList(productoptionList);
	}

	public List<ProductOptionVO> getAllProductoptionsByName(String name) {
		ProductOptionDbObjectExample productoptionExample = new ProductOptionDbObjectExample();
		productoptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andNameEqualTo(name);
		List<ProductOptionDbObject> productoptionList = productOptionDbObjectMapper.selectByExample(productoptionExample);
		return convertToProductOptionVOList(productoptionList);
	}
	
	public void saveProductoption(ProductOptionVO productoption) {
		if(productoption != null){
			ProductOptionDbObject dbObj = convertToProductOptionDbObjectList(Arrays.asList(productoption)).get(0);
			productOptionDbObjectMapper.insert(dbObj);
		}
		
	}
	
	public List<ProductOptionDbObject> convertToProductOptionDbObjectList(
			List<ProductOptionVO> voList) {
		List<ProductOptionDbObject> objList = new ArrayList<ProductOptionDbObject>();
		if(voList != null && voList.size() > 0){
			for(ProductOptionVO vo : voList){
				ProductOptionDbObject obj = new ProductOptionDbObject();
				obj.setDeleteInd(vo.getDeleteInd());
				obj.setDisplayInd(vo.getDisplayInd());
				obj.setName(vo.getDisplayInd());
				obj.setProductOptionId(vo.getProductOptionId());
				obj.setVersion(vo.getVersion());
				objList.add(obj);
			}
		}
		return objList;
	}

	public void deleteProductoption(Integer id) {
		ProductOptionVO productoption = findById(id);
		if(productoption != null && productoption.getDeleteInd() != null 
				&& productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductOptionDbObject obj = new ProductOptionDbObject();
			obj.setProductOptionId(id);
			obj.setDeleteInd(GeneralUtils.DELETED);
			productOptionDbObjectMapper.updateByPrimaryKeySelective(obj);
		}
	}
	
	public void deleteProductoption(ProductOptionVO productoption) {
		if(productoption != null && productoption.getDeleteInd() != null 
				&& productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductOptionDbObject obj = new ProductOptionDbObject();
			obj.setProductOptionId(productoption.getProductOptionId());
			obj.setDeleteInd(GeneralUtils.DELETED);
			productOptionDbObjectMapper.updateByPrimaryKeySelective(obj);
		}
	}
	
	public void updateProductoption(ProductOptionVO productoption) {
		if(productoption != null && productoption.getDeleteInd() != null 
				&& productoption.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductOptionDbObject obj = convertToProductOptionDbObjectList(Arrays.asList(productoption)).get(0);
			productOptionDbObjectMapper.updateByPrimaryKeySelective(obj);
		}
	}
	 
	
	
}
