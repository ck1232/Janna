package com.JJ.service.discountmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.DiscountMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Discount;
import com.JJ.model.DiscountExample;

@Service
@Transactional
public class DiscountManagementService {
	
	private DiscountMapper discountMapper;
	
	@Autowired
	public DiscountManagementService(DiscountMapper discountMapper) {
		this.discountMapper = discountMapper;
	}
	
	public Discount findById(Integer id) {
		return discountMapper.selectByPrimaryKey(id);
	}
	
	public List<Discount> getAllDiscounts() {
		DiscountExample discountExample = new DiscountExample();
		discountExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Discount> discountList = discountMapper.selectByExample(discountExample);
		return discountList;
	}
	
	public List<Discount> getAllDiscountsInPromotion(Integer id) {
		DiscountExample discountExample = new DiscountExample();
		discountExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andPromoidEqualTo(id);
		List<Discount> discountList = discountMapper.selectByExample(discountExample);
		return discountList;
	}
	
	public List<Discount> getAllDiscountsNotInPromotion(Integer id) {
		DiscountExample discountExample = new DiscountExample();
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(null);
		intList.add(0);
		discountExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andPromoidIn(intList);
		List<Discount> discountList = discountMapper.selectByExample(discountExample);
		return discountList;
	}
	
	public void saveDiscount(Discount discount) {
		discountMapper.insert(discount);
	}
	
	public void deleteDiscount(Integer id) {
		Discount discount = findById(id);
		if(discount.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			discount.setDeleteind(GeneralUtils.DELETED);
			discountMapper.updateByPrimaryKey(discount);
		}
	}
	
	public void updateDiscount(Discount discount) {
		if(discount.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			discountMapper.updateByPrimaryKeySelective(discount);
	}
	 
	
	
}
