package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductOptionTO;
import com.JJ.TO.ProductSubOptionTO;
import com.JJ.TO.ProductTO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.dao.jpa.ProductOptionDAO;
import com.JJ.helper.GeneralUtils;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductSubOptionMgmtService {
	private ProductOptionDAO productOptionDAO;
	
	@Autowired
	public ProductSubOptionMgmtService(ProductOptionDAO productOptionDAO) {
		this.productOptionDAO = productOptionDAO;
	}

	public void setProductSubOption(List<ProductOptionVO> list, ProductTO newProductTO, Map<ProductSubOptionVO, ProductSubOptionTO> subOptionMap){
		List<ProductSubOptionTO> subOptionTOList = convertToProductSubOptionTOList(list, newProductTO, subOptionMap);
		newProductTO.setProductionSubOptionTOList(subOptionTOList);
	}
	
	public List<ProductSubOptionTO> convertToProductSubOptionTOList(List<ProductOptionVO> optionList, ProductTO productTO, Map<ProductSubOptionVO, ProductSubOptionTO> subOptionMap){
		List<ProductSubOptionTO> subOptionList = new ArrayList<ProductSubOptionTO>();
		Map<Long, ProductSubOptionTO> map = GeneralUtils.convertListToLongMap(productTO.getProductionSubOptionTOList(), "productSuboptionId");
		if(optionList != null && !optionList.isEmpty()){
			for(ProductOptionVO optionVO : optionList){
				ProductOptionTO optionTO = new ProductOptionTO();
				optionTO.setProductOptionId(optionVO.getProductOptionId());
				optionTO.setName(optionVO.getName());
				optionTO.setDisplayInd(GeneralUtils.ALLOW_DISPLAY);
				if(optionVO.getName() != null){
					ProductOptionTO to = productOptionDAO.findByNameAndDeleteInd(optionVO.getName(), GeneralUtils.NOT_DELETED);
					if(to != null){
						optionTO = to;
					}
				}
				List<ProductSubOptionVO> subOptionVoList = optionVO.getSubOptionList();
				if(subOptionVoList != null && !subOptionVoList.isEmpty()){
					for(ProductSubOptionVO subOptionVO : subOptionVoList){
						ProductSubOptionTO to = new ProductSubOptionTO();
						to.setProductSuboptionId(subOptionVO.getProductSuboptionId());
						to.setProductTO(productTO);
						to.setProductOptionTO(optionTO);
						to.setCode(subOptionVO.getCode());
						to.setName(subOptionVO.getName());
						to.setDisplayInd(subOptionVO.getDisplayInd());
						if(map != null && to.getProductSuboptionId() != null && map.get(to.getProductSuboptionId()) != null){
							GeneralUtils.copyFromTO(to, map.get(to.getProductSuboptionId()));
							
						}
						subOptionMap.put(subOptionVO, to);
						subOptionList.add(to);
					}
				}
			}
		}
		return subOptionList;
	} 
}
