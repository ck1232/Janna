package com.JJ.service.productsuboptionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.dao.ProductSubOptionDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductSubOptionDbObject;
import com.JJ.model.ProductSubOptionDbObjectExample;

@Service
@Transactional
public class ProductSubOptionManagementService {
	
	private ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper;
	
	@Autowired
	public ProductSubOptionManagementService(ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper) {
		this.productSubOptionDbObjectMapper = productSubOptionDbObjectMapper;
	}
	
	public ProductSubOptionVO findById(Integer id) {
		ProductSubOptionDbObject dbObj = productSubOptionDbObjectMapper.selectByPrimaryKey(id);
		if(dbObj != null){
			List<ProductSubOptionVO> voList = convertToProductSubOptionVOList(Arrays.asList(dbObj));
			return voList.get(0);
		}
		return new ProductSubOptionVO();
	}

	public List<ProductSubOptionVO> getAllProductsuboptions() {
		ProductSubOptionDbObjectExample productsuboptionExample = new ProductSubOptionDbObjectExample();
		productsuboptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductSubOptionDbObject> productsuboptionList = productSubOptionDbObjectMapper.selectByExample(productsuboptionExample);
		return convertToProductSubOptionVOList(productsuboptionList);
	}
	
	
	
	private List<ProductSubOptionVO> convertToProductSubOptionVOList(List<ProductSubOptionDbObject> dbObjList) {
		List<ProductSubOptionVO> voList = new ArrayList<ProductSubOptionVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(ProductSubOptionDbObject dbObj : dbObjList){
				ProductSubOptionVO vo = new ProductSubOptionVO();
				vo.setCode(dbObj.getCode());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setName(dbObj.getName());
				vo.setProductId(dbObj.getProductId());
				vo.setProductOptionId(dbObj.getProductOptionId());
				vo.setProductSuboptionId(dbObj.getProductSuboptionId());
				vo.setVersion(dbObj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}

	public List<ProductSubOptionVO> getAllProductsuboptionsByProductId(Integer productid) {
		ProductSubOptionDbObjectExample productsuboptionExample = new ProductSubOptionDbObjectExample();
		productsuboptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
												.andDisplayIndEqualTo(GeneralUtils.ALLOW_DISPLAY)
												.andProductIdEqualTo(productid);
		List<ProductSubOptionDbObject> productsuboptionList = productSubOptionDbObjectMapper.selectByExample(productsuboptionExample);
		return convertToProductSubOptionVOList(productsuboptionList);
	}
	
	public List<ProductSubOptionVO> getAllProductsuboptionsByProductIdList(List<Integer> productid) {
		if(productid != null && productid.size() > 0){
			
		
		ProductSubOptionDbObjectExample productsuboptionExample = new ProductSubOptionDbObjectExample();
		productsuboptionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
												.andDisplayIndEqualTo(GeneralUtils.ALLOW_DISPLAY)
												.andProductIdIn(productid);
		List<ProductSubOptionDbObject> productsuboptionList = productSubOptionDbObjectMapper.selectByExample(productsuboptionExample);
		return convertToProductSubOptionVOList(productsuboptionList);
		}
		return new ArrayList<ProductSubOptionVO>();
	}
	
	public void saveProductsuboption(ProductSubOptionVO vo) {
		List<ProductSubOptionDbObject> dbObjList = convertToProductSubOptionDbObject(Arrays.asList(vo));
		if(dbObjList != null && dbObjList.size() > 0){
			productSubOptionDbObjectMapper.insert(dbObjList.get(0));
		}
	}
	
	public void deleteProductsuboption(Integer id) {
		ProductSubOptionVO vo = findById(id);
		if(vo != null && vo.getDeleteInd() != null && vo.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductSubOptionDbObject dbObj = new ProductSubOptionDbObject();
			dbObj.setProductSuboptionId(id);
			dbObj.setDeleteInd(GeneralUtils.DELETED);
			productSubOptionDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void deleteProductsuboption(ProductSubOptionVO vo) {
		if(vo != null && vo.getDeleteInd() != null && vo.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ProductSubOptionDbObject dbObj = new ProductSubOptionDbObject();
			dbObj.setProductSuboptionId(vo.getProductSuboptionId());
			dbObj.setDeleteInd(GeneralUtils.DELETED);
			productSubOptionDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void updateProductoption(ProductSubOptionVO vo) {
		if(vo != null && vo.getDeleteInd() != null && vo.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			List<ProductSubOptionDbObject> dbObjList = convertToProductSubOptionDbObject(Arrays.asList(vo));
			if(dbObjList != null && dbObjList.size() > 0){
				productSubOptionDbObjectMapper.updateByPrimaryKeySelective(dbObjList.get(0));
			}
			
		}
			
	}

	private List<ProductSubOptionDbObject> convertToProductSubOptionDbObject(
			List<ProductSubOptionVO> voList) {
		List<ProductSubOptionDbObject> dbObjList = new ArrayList<ProductSubOptionDbObject>();
		if(voList != null && voList.size() > 0){
			for(ProductSubOptionVO vo : voList){
				ProductSubOptionDbObject dbObj = new ProductSubOptionDbObject();
				dbObj.setCode(vo.getCode());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDisplayInd(vo.getDisplayInd());
				dbObj.setName(vo.getName());
				dbObj.setProductId(vo.getProductId());
				dbObj.setProductOptionId(vo.getProductSuboptionId());
				dbObj.setProductSuboptionId(vo.getProductSuboptionId());
				dbObj.setVersion(vo.getVersion());
				dbObjList.add(dbObj);
			}
		}
		return dbObjList;
	}
	
	
	
	/*public SubOptionVO convertSubOptionToVo(Productsuboption suboption){
		SubOptionVO vo = new SubOptionVO();
		vo.setSubOptionId(suboption.getProductsuboptionid());
		vo.setSubOptionName(suboption.getName());
		return vo;
	}*/
	
}
