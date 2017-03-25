package com.JJ.service.productoptionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.dao.ProductOptionDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductOptionDbObject;
import com.JJ.model.ProductOptionDbObjectExample;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional
public class ProductOptionManagementService {
	
	private ProductOptionDbObjectMapper productOptionDbObjectMapper;
	private ProductSubOptionManagementService productSubOptionManagementService;
	@Autowired
	public ProductOptionManagementService(ProductOptionDbObjectMapper productOptionDbObjectMapper,
			ProductSubOptionManagementService productSubOptionManagementService) {
		this.productOptionDbObjectMapper = productOptionDbObjectMapper;
		this.productSubOptionManagementService = productSubOptionManagementService;
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
	 
	public List<ProductOptionVO> getOptionVoList(Integer productId){
		if(productId != null){
			List<ProductOptionVO> optionVoList = new ArrayList<ProductOptionVO>();
			List<ProductOptionVO> productOption = this.getAllProductoptions();
			Map<Integer , ProductOptionVO> optionMap = new HashMap<Integer, ProductOptionVO>();
			Map<Integer, List<ProductSubOptionVO>> suboptionMap = new HashMap<Integer, List<ProductSubOptionVO>>();
			if(productOption != null && productOption.size() > 0){
				for(ProductOptionVO option : productOption){
					optionMap.put(option.getProductOptionId(), option);
				}
			}
			List<ProductSubOptionVO> voList = productSubOptionManagementService.getAllProductsuboptionsByProductId(productId);
			
			if(voList != null && voList.size() > 0){
				for(ProductSubOptionVO vo : voList){
					if(!suboptionMap.containsKey(vo.getProductOptionId())){
						suboptionMap.put(vo.getProductOptionId(), new ArrayList<ProductSubOptionVO>());
					}
					suboptionMap.get(vo.getProductOptionId()).add(vo);
				}
				
				if(!suboptionMap.isEmpty()){
					for(Integer key : suboptionMap.keySet()){
						ProductOptionVO option = optionMap.get(key);
						if(option != null){
							option.setSubOptionList(suboptionMap.get(key));
							optionVoList.add(option);
						}
					}
				}
				return optionVoList;
			}
			
		}
		return new ArrayList<ProductOptionVO>();
	}
	
}
