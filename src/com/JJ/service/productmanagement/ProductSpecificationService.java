package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JJ.controller.productmanagement.vo.ProductSpecificationVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductSpecificationDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductSpecificationDbObject;
import com.JJ.model.ProductSpecificationDbObjectExample;
@Service
public class ProductSpecificationService {
	
	private ProductSpecificationDbObjectMapper productSpecificationDbObjectMapper;
	
	@Autowired
	public ProductSpecificationService(ProductSpecificationDbObjectMapper productSpecificationDbObjectMapper) {
		this.productSpecificationDbObjectMapper = productSpecificationDbObjectMapper;
	}
	
	public ProductSpecificationVO getProductSpecification(Integer productId){
		if(productId != null && productId.intValue() > 0){
			ProductSpecificationDbObjectExample example = new ProductSpecificationDbObjectExample();
			example.createCriteria().andProductIdEqualTo(productId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			List<ProductSpecificationDbObject> productSpecificationList = productSpecificationDbObjectMapper.selectByExampleWithBLOBs(example);
			List<ProductSpecificationVO> voList = convertToProductSpecification(productSpecificationList);
			if(voList != null && voList.size() > 0){
				return voList.get(0);
			}
		}
		return new ProductSpecificationVO();
	}
	
	public List<ProductVO> getProductSpecification(List<ProductVO> voList){
		List<Integer> idList = ProductService.getProductIdList(voList);
		if(idList != null && idList.size() > 0){
			ProductSpecificationDbObjectExample example = new ProductSpecificationDbObjectExample();
			example.createCriteria().andProductIdIn(idList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			List<ProductSpecificationDbObject> productSpecificationList = productSpecificationDbObjectMapper.selectByExampleWithBLOBs(example);
			List<ProductSpecificationVO> specsVOList = convertToProductSpecification(productSpecificationList);
			if(specsVOList != null && specsVOList.size() > 0){
				Map<Integer, ProductVO> map = ProductService.getProductVOMap(voList);
				for(ProductSpecificationVO specs : specsVOList){
					ProductVO productVO = map.get(specs.getProductId());
					if(productVO != null){
						productVO.setProductInfo(specs.getContent());
					}
				}
			}
		}
		return voList;
	}
	private List<ProductSpecificationVO> convertToProductSpecification(List<ProductSpecificationDbObject> objList) {
		List<ProductSpecificationVO> voList = new ArrayList<ProductSpecificationVO>();
		if(objList != null && objList.size() > 0){
			for(ProductSpecificationDbObject obj : objList){
				ProductSpecificationVO vo = new ProductSpecificationVO();
				vo.setContent(obj.getContent());
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setProductId(obj.getProductId());
				vo.setProductSpecificationId(obj.getProductSpecificationId());
				vo.setVersion(obj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public void saveProductInfo(ProductVO productVo, Integer productId){
		ProductSpecificationDbObjectExample selectSpecExample = new ProductSpecificationDbObjectExample();
		selectSpecExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productId);
		List<ProductSpecificationDbObject> specList = productSpecificationDbObjectMapper.selectByExample(selectSpecExample);
		//if already exisit, then  update
		ProductSpecificationDbObject spec = new ProductSpecificationDbObject();
		spec.setContent(productVo.getProductInfo());
		if(specList != null && specList.size() > 0){
			productSpecificationDbObjectMapper.updateByExampleSelective(spec, selectSpecExample);
		}else{
			//insert
			spec.setProductId(productId);
			spec.setDeleteInd(GeneralUtils.NOT_DELETED);
			productSpecificationDbObjectMapper.insertSelective(spec);
		}
	}
}
