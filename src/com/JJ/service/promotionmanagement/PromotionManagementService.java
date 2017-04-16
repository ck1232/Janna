package com.JJ.service.promotionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.promotionmanagement.vo.PromotionVO;
import com.JJ.dao.PromotionDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.PromotionDbObject;
import com.JJ.model.PromotionDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class PromotionManagementService {
	
	private PromotionDbObjectMapper promotionDbObjectMapper;
	
	@Autowired
	public PromotionManagementService(PromotionDbObjectMapper promotionDbObjectMapper) {
		this.promotionDbObjectMapper = promotionDbObjectMapper;
	}
	
	public PromotionVO findById(Integer id) {
		PromotionDbObject promotionDbObject = promotionDbObjectMapper.selectByPrimaryKey(id);
		if(promotionDbObject != null && promotionDbObject.getPromotionId() != null){
			return convertToPromotionVOList(Arrays.asList(promotionDbObject)).get(0);
		}else{
			return new PromotionVO();
		}
	}

	public List<PromotionVO> getAllPromotions() {
		PromotionDbObjectExample promotionDbObjectExample = new PromotionDbObjectExample();
		promotionDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToPromotionVOList(promotionDbObjectMapper.selectByExample(promotionDbObjectExample));
	}
	
	public void savePromotion(PromotionVO promotionVo) {
		if(promotionVo != null) {
			PromotionDbObject dbObj = convertToPromotionDbObjectList(Arrays.asList(promotionVo)).get(0);
			promotionDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deletePromotion(Integer id) {
		deletePromotion(Arrays.asList(id));
	}
	
	public void deletePromotion(List<Integer> idList) {
		PromotionDbObjectExample promotionDbObjectExample = new PromotionDbObjectExample();
		promotionDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andPromotionIdIn(idList);
		PromotionDbObject dbObj = new PromotionDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		promotionDbObjectMapper.updateByExampleSelective(dbObj, promotionDbObjectExample);
	}
	
	public void updatePromotion(PromotionVO promotionVo) {
		if(promotionVo != null && promotionVo.getDeleteInd() != null &&
				promotionVo.getDeleteInd().equals(GeneralUtils.NOT_DELETED)) {
			PromotionDbObject dbObj = convertToPromotionDbObjectList(Arrays.asList(promotionVo)).get(0);
			promotionDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	 
	private List<PromotionVO> convertToPromotionVOList(List<PromotionDbObject> promotionDbObjectList) {
		List<PromotionVO> promotionVOList = new ArrayList<PromotionVO>();
		if(promotionDbObjectList != null && promotionDbObjectList.size() > 0) {
			for(PromotionDbObject dbObj : promotionDbObjectList) {
				PromotionVO promotionVo = new PromotionVO();
				promotionVo.setDeleteInd(dbObj.getDeleteInd());
				promotionVo.setIsActive(dbObj.getIsActive());
				promotionVo.setPromotionEndDate(dbObj.getPromotionEndDate());
				promotionVo.setPromotionId(dbObj.getPromotionId());
				promotionVo.setPromotionMessage(dbObj.getPromotionMessage());
				promotionVo.setPromotionName(dbObj.getPromotionName());
				promotionVo.setPromotionStartDate(dbObj.getPromotionStartDate());
				promotionVo.setVersion(dbObj.getVersion());
				promotionVOList.add(promotionVo);
			}
		}
		return promotionVOList;
	}
	
	private List<PromotionDbObject> convertToPromotionDbObjectList(List<PromotionVO> promotionVOList) {
		List<PromotionDbObject> promotionDbObjectList = new ArrayList<PromotionDbObject>();
		if(promotionVOList != null && promotionVOList.size() > 0){
			for(PromotionVO vo : promotionVOList){
				PromotionDbObject dbObj = new PromotionDbObject();
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setIsActive(vo.getIsActive());
				dbObj.setPromotionEndDate(vo.getPromotionEndDate());
				dbObj.setPromotionId(vo.getPromotionId());
				dbObj.setPromotionMessage(vo.getPromotionMessage());
				dbObj.setPromotionName(vo.getPromotionName());
				dbObj.setPromotionStartDate(vo.getPromotionStartDate());
				dbObj.setVersion(vo.getVersion());
				promotionDbObjectList.add(dbObj);
			}
		}
		return promotionDbObjectList;
	}
	
}
