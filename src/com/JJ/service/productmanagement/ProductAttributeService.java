package com.JJ.service.productmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductAttributeTO;
import com.JJ.TO.ProductSubOptionTO;
import com.JJ.TO.ProductTO;
import com.JJ.controller.productmanagement.vo.ProductAttributeVO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.productoptionmanagement.ProductOptionMgmtService;
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductAttributeService implements Serializable {

	private static final long serialVersionUID = 1L;

	public static List<ProductAttributeVO> convertToProductAttributeVOList(List<ProductAttributeTO> toList){
		List<ProductAttributeVO> voList = new ArrayList<ProductAttributeVO>();
		if(toList != null && !toList.isEmpty()){
			for(ProductAttributeTO to : toList){
				ProductAttributeVO vo = new ProductAttributeVO();
				vo.setProductAttributeId(to.getProductAttributeId());
				vo.setProductId(to.getProductTO().getProductId());
				vo.setOptionId(to.getProductOptionTO().getProductOptionId());
				vo.setSku(to.getSku());
				vo.setSubOptionId(to.getProductSubOptionTO().getProductSuboptionId());
				vo.setDisplayInd(to.getDisplayInd());
				List<ProductOptionVO> optionList = ProductOptionMgmtService.convertToProductOptionVOList(Arrays.asList(to.getProductOptionTO()));
				List<ProductSubOptionVO> subOptionList = ProductOptionMgmtService.convertToProductSubOptionVOList(Arrays.asList(to.getProductSubOptionTO()));
				vo.setSubOptionId(subOptionList.get(0).getProductSuboptionId());
				vo.setOptionId(optionList.get(0).getProductOptionId());
				vo.setSubOptionVO(subOptionList.get(0));
				voList.add(vo);
			}
		}
		return voList;
	}

	public void setProductAttribute(List<ProductAttributeVO> productAttributeVOList, ProductTO newProductTO, Map<ProductSubOptionVO, ProductSubOptionTO> subOptionMap) {
		List<ProductAttributeTO> productAttributeTOList = convertToProductAttributeTOList(productAttributeVOList, newProductTO, subOptionMap);
		newProductTO.setProductAttributeTOList(productAttributeTOList);
	}

	public List<ProductAttributeTO> convertToProductAttributeTOList(List<ProductAttributeVO> productAttributeVOList,ProductTO newProductTO, Map<ProductSubOptionVO, ProductSubOptionTO> subOptionMap) {
		List<ProductAttributeTO> productAttributeTOList = new ArrayList<ProductAttributeTO>();
		Map<String, List<ProductAttributeTO>> attributeMap = GeneralUtils.convertListToStringListMap(newProductTO.getProductAttributeTOList(), "sku");
		Map<String, Map<String, ProductAttributeTO>> attributeNameMap = new HashMap<String, Map<String,ProductAttributeTO>>();
		if(attributeMap != null){
			for(String sku : attributeMap.keySet()){
				List<ProductAttributeTO> list = attributeMap.get(sku);
				if(list != null){
					attributeNameMap.put(sku,GeneralUtils.convertListToStringMap(list, "productSubOptionTO.code"));
				}
			}
		}
		if(productAttributeVOList != null && !productAttributeVOList.isEmpty()){
			for(ProductAttributeVO vo : productAttributeVOList){
				//create attribute
				ProductAttributeTO to = new ProductAttributeTO();
				to.setProductAttributeId(vo.getProductAttributeId());
				to.setSku(vo.getSku());
				to.setDisplayInd(vo.getDisplayInd());
				to.setProductTO(newProductTO);
				ProductSubOptionTO subOptionTO = subOptionMap.get(vo.getSubOptionVO());
				if(subOptionTO != null && subOptionTO.getProductOptionTO() != null){
					to.setProductOptionTO(subOptionTO.getProductOptionTO());
					to.setProductSubOptionTO(subOptionTO);
				}else{
					continue;
				}
				
				//if found, update display ind
				Map<String, ProductAttributeTO> attributeOneMap = attributeNameMap.get(vo.getSku());
				if(attributeOneMap != null){
					ProductAttributeTO oneTO = attributeOneMap.get(vo.getSubOptionVO().getCode());
					if(oneTO != null){
						GeneralUtils.copyFromTO(to, oneTO);
					}
				}
				productAttributeTOList.add(to);
			}
		}
		return productAttributeTOList;
	}
}
