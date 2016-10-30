package com.JJ.service.promotionmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.PromotionMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Module;
import com.JJ.model.Promotion;
import com.JJ.model.PromotionExample;

@Service
@Transactional
public class PromotionManagementService {
	
	private PromotionMapper promotionMapper;
	
	@Autowired
	public PromotionManagementService(PromotionMapper promotionMapper) {
		this.promotionMapper = promotionMapper;
	}
	
	public Promotion findById(Integer id) {
		return promotionMapper.selectByPrimaryKey(id);
	}

	public List<Promotion> getAllPromotions() {
		PromotionExample promotionExample = new PromotionExample();
		promotionExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Promotion> promotionList = promotionMapper.selectByExample(promotionExample);
		return promotionList;
	}
	
	public void savePromotion(Promotion promotion) {
		promotionMapper.insert(promotion);
	}
	
	public void deletePromotion(Integer id) {
		Promotion promotion = findById(id);
		if(promotion.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			promotion.setDeleteind(GeneralUtils.DELETED);
			promotionMapper.updateByPrimaryKey(promotion);
		}
	}
	
	public void updatePromotion(Promotion promotion) {
		if(promotion.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			promotionMapper.updateByPrimaryKeySelective(promotion);
	}
	 
	
	
}
