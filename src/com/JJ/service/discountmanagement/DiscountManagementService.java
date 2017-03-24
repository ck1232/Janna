package com.JJ.service.discountmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.discountmanagement.vo.DiscountVO;
import com.JJ.dao.DiscountDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.DiscountDbObject;
import com.JJ.model.DiscountDbObjectExample;

@Service
@Transactional
public class DiscountManagementService {
	
	private DiscountDbObjectMapper discountDbObjectMapper;
	
	@Autowired
	public DiscountManagementService(DiscountDbObjectMapper discountDbObjectMapper) {
		this.discountDbObjectMapper = discountDbObjectMapper;
	}
	
	public DiscountVO findById(Integer id) {
		DiscountDbObject discountDbObject = discountDbObjectMapper.selectByPrimaryKey(id);
		if(discountDbObject != null && discountDbObject.getDiscountId() != null){
			return convertToDiscountVOList(Arrays.asList(discountDbObject)).get(0);
		}else{
			return new DiscountVO();
		}
	}

	public List<DiscountVO> getAllDiscounts() {
		DiscountDbObjectExample discountDbObjectExample = new DiscountDbObjectExample();
		discountDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToDiscountVOList(discountDbObjectMapper.selectByExample(discountDbObjectExample));
	}
	
	public List<DiscountVO> getAllDiscountsInPromotion(Integer id) {
		DiscountDbObjectExample discountDbObjectExample = new DiscountDbObjectExample();
		discountDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andPromoIdEqualTo(id);
		return convertToDiscountVOList(discountDbObjectMapper.selectByExample(discountDbObjectExample));
	}
	
	public List<DiscountVO> getAllDiscountsNotInPromotion(Integer id) {
		DiscountDbObjectExample discountDbObjectExample = new DiscountDbObjectExample();
		discountDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andPromoIdIsNull();
		List<DiscountVO> discountVOList = convertToDiscountVOList(discountDbObjectMapper.selectByExample(discountDbObjectExample));
		
		discountDbObjectExample.clear();
		discountDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andPromoIdEqualTo(0);
		discountVOList.addAll(convertToDiscountVOList(discountDbObjectMapper.selectByExample(discountDbObjectExample)));
		return discountVOList;
	}
	
	public void saveDiscount(DiscountVO discountVO) {
		if(discountVO != null){
			DiscountDbObject dbObj = convertToDiscountDbObjectList(Arrays.asList(discountVO)).get(0);
			discountDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deleteDiscount(Integer id) {
		deleteDiscount(Arrays.asList(id));
	}
	
	public void deleteDiscount(List<Integer> idList) {
		DiscountDbObjectExample discountDbObjectExample = new DiscountDbObjectExample();
		discountDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andDiscountIdIn(idList);
		DiscountDbObject dbObj = new DiscountDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		discountDbObjectMapper.updateByExampleSelective(dbObj, discountDbObjectExample);
	}
	
	public void updateDiscount(DiscountVO discountVO) {
		if(discountVO != null && discountVO.getDeleteInd() != null &&
				discountVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			DiscountDbObject dbObj = convertToDiscountDbObjectList(Arrays.asList(discountVO)).get(0);
			discountDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	 
	private List<DiscountVO> convertToDiscountVOList(List<DiscountDbObject> discountDbObjectList) {
		List<DiscountVO> discountVOList = new ArrayList<DiscountVO>();
		if(discountDbObjectList != null && discountDbObjectList.size() > 0) {
			for(DiscountDbObject dbObj : discountDbObjectList) {
				DiscountVO discountVO = new DiscountVO();
				discountVO.setApplyType(dbObj.getApplyType());
				discountVO.setDeleteInd(dbObj.getDeleteInd());
				discountVO.setDiscountId(dbObj.getDiscountId());
				discountVO.setDiscountName(dbObj.getDiscountName());
				discountVO.setDiscountType(dbObj.getDiscountType());
				discountVO.setDiscountValue(dbObj.getDiscountValue());
				discountVO.setPromoId(dbObj.getPromoId());
				discountVO.setVersion(dbObj.getVersion());
				discountVOList.add(discountVO);
			}
		}
		return discountVOList;
	}
	
	private List<DiscountDbObject> convertToDiscountDbObjectList(List<DiscountVO> discountVOList) {
		List<DiscountDbObject> discountDbObjectList = new ArrayList<DiscountDbObject>();
		if(discountVOList != null && discountVOList.size() > 0){
			for(DiscountVO vo : discountVOList){
				DiscountDbObject dbObj = new DiscountDbObject();
				dbObj.setApplyType(vo.getApplyType());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDiscountId(vo.getDiscountId());
				dbObj.setDiscountName(vo.getDiscountName());
				dbObj.setDiscountType(vo.getDiscountType());
				dbObj.setDiscountValue(vo.getDiscountValue());
				dbObj.setPromoId(vo.getPromoId());
				dbObj.setVersion(vo.getVersion());
				discountDbObjectList.add(dbObj);
			}
		}
		return discountDbObjectList;
	}
	
}
