package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.dao.ProductSubOptionRsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductSubOptionRsDbObject;
import com.JJ.model.ProductSubOptionRsDbObjectExample;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductSubOptionRsService {
	
	private ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper;
	private ProductOptionManagementService productOptionManagementService;
	@Autowired
	public ProductSubOptionRsService(ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper,
			ProductOptionManagementService productOptionManagementService) {
		this.productSubOptionRsDbObjectMapper = productSubOptionRsDbObjectMapper;
		this.productOptionManagementService = productOptionManagementService;
	}
	
	public ProductSubOptionRsVO getProductSubOptionRsById(Integer productsuboptionid) {
		ProductSubOptionRsDbObject dbObj = productSubOptionRsDbObjectMapper.selectByPrimaryKey(productsuboptionid);
		return convertToProductSubOptionRsVO(Arrays.asList(dbObj)).get(0);
	}
	
	public ProductSubOptionRsVO getProductSubOptionVo(Integer productSubOptionId){
		ProductSubOptionRsDbObjectExample selectExample = new ProductSubOptionRsDbObjectExample();
		selectExample.createCriteria().andProductIdEqualTo(productSubOptionId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductSubOptionRsDbObject> result = productSubOptionRsDbObjectMapper.selectByExample(selectExample);
		
		if(result != null && result.size() > 0){
			ProductSubOptionRsDbObject obj = result.get(0);
			ProductSubOptionRsVO vo = new ProductSubOptionRsVO();
			vo.setProductSuboptionRsId(obj.getProductSuboptionRsId());
			vo.setProductId(obj.getProductId());
			vo.setSuboption1Id(obj.getSuboption1Id());
			vo.setSuboption2Id(obj.getSuboption2Id());
			vo.setSuboption3Id(obj.getSuboption3Id());
			List<ProductOptionVO> allOptionVo = productOptionManagementService.getOptionVoList(obj.getProductId());
			if(vo.getSuboption1Id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(ProductOptionVO option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(ProductSubOptionVO suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getProductSuboptionId().equals(vo.getSuboption1Id())){
								ProductOptionVO option1 = new ProductOptionVO();
								option1.setProductOptionId(option.getProductOptionId());
								option1.setName(option.getName());
								option1.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSubOption1(option1);
								break;
							}
						}
					}
				}
			}
			
			if(vo.getSuboption2Id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(ProductOptionVO option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(ProductSubOptionVO suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getProductSuboptionId().equals(vo.getSuboption2Id())){
								ProductOptionVO option2 = new ProductOptionVO();
								option2.setProductOptionId(option.getProductOptionId());
								option2.setName(option.getName());
								option2.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSubOption2(option2);
								break;
							}
						}
					}
				}
			}
			
			if(vo.getSuboption3Id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(ProductOptionVO option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(ProductSubOptionVO suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getProductSuboptionId().equals(vo.getSuboption3Id())){
								ProductOptionVO option3 = new ProductOptionVO();
								option3.setProductOptionId(option.getProductOptionId());
								option3.setName(option.getName());
								option3.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSubOption1(option3);
								break;
							}
						}
					}
				}
			}
			return vo;
		}
		return new ProductSubOptionRsVO();
	}
	
	public List<ProductSubOptionRsVO> convertToProductSubOptionRsVO(List<ProductSubOptionRsDbObject> productSubOptionRsDbObjectList) {
		List<ProductSubOptionRsVO> productSubOptionRsVOList = new ArrayList<ProductSubOptionRsVO>();
		if(productSubOptionRsDbObjectList != null && !productSubOptionRsDbObjectList.isEmpty()) {
			for(ProductSubOptionRsDbObject dbObj : productSubOptionRsDbObjectList) {
				ProductSubOptionRsVO vo = new ProductSubOptionRsVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setProductId(dbObj.getProductId());
				vo.setProductSuboptionRsId(dbObj.getProductSuboptionRsId());
				vo.setSuboption1Id(dbObj.getSuboption1Id());
				vo.setSuboption2Id(dbObj.getSuboption2Id());
				vo.setSuboption3Id(dbObj.getSuboption3Id());
				vo.setVersion(dbObj.getVersion());
				productSubOptionRsVOList.add(vo);
			}
		}
		return productSubOptionRsVOList;
	}
	
	
}
