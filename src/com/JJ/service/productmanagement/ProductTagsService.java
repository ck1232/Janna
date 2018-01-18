package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ProductTagsTO;
import com.JJ.controller.productmanagement.vo.ProductTagsVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductTagsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductTagsDbObject;
import com.JJ.model.ProductTagsDbObjectExample;
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductTagsService {
	
	private ProductTagsDbObjectMapper productTagsDbObjectMapper;
	
	@Autowired
	public ProductTagsService(ProductTagsDbObjectMapper productTagsDbObjectMapper) {
		this.productTagsDbObjectMapper = productTagsDbObjectMapper;
	}
	
	public void saveProductTags(ProductVO productVo, Integer productid) {
		//delete all tags not in tags list
		ProductTagsDbObjectExample deleteExample = new ProductTagsDbObjectExample();
		ProductTagsDbObjectExample.Criteria criteria = deleteExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productid);
		if(productVo.getTags() != null && !productVo.getTags().isEmpty()){
			criteria.andNameNotIn(GeneralUtils.convertListToStringList(productVo.getTags(), "name", true));
		}
		ProductTagsDbObject tags = new ProductTagsDbObject();
		tags.setDeleteInd(GeneralUtils.DELETED);
		productTagsDbObjectMapper.updateByExampleSelective(tags, deleteExample);
		if(productVo.getTags() != null && !productVo.getTags().isEmpty()){
			//get all active tags
			ProductTagsDbObjectExample selectExample = new ProductTagsDbObjectExample();
			selectExample.createCriteria().andNameIn(GeneralUtils.convertListToStringList(productVo.getTags(), "name", true)).andProductIdEqualTo(productid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			List<ProductTagsDbObject> productTagsList = productTagsDbObjectMapper.selectByExample(selectExample);
			if(productTagsList != null && !productTagsList.isEmpty()){
				//remove exists tags from list
				for(ProductTagsDbObject productTags : productTagsList){
					productVo.getTags().remove(productTags.getName());
				}
			}
			//insert those non exist tags
			List<ProductTagsDbObject> dbList = convertToProductTags(productVo.getTags(), productid);
			for(ProductTagsDbObject dbTags : dbList){
				productTagsDbObjectMapper.insert(dbTags);
			}
		}
		
	}
	
	private List<ProductTagsDbObject> convertToProductTags(List<ProductTagsVO> list, Integer productId){
		List<ProductTagsDbObject> dbList = new ArrayList<ProductTagsDbObject>();
		if(list != null && !list.isEmpty()){
			for(ProductTagsVO tag: list){
				ProductTagsDbObject dbTag = new ProductTagsDbObject();
				dbTag.setName(tag.getName());
				dbTag.setProductId(productId);
				dbTag.setDeleteInd(GeneralUtils.NOT_DELETED);
				dbList.add(dbTag);
			}
		}
		return dbList;
	}
	
	public List<String> getProductTags(Long productid) {
		List<String> tagsList = new ArrayList<String>();
		ProductTagsDbObjectExample example = new ProductTagsDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productid.intValue());
		List<ProductTagsDbObject> dbList = productTagsDbObjectMapper.selectByExample(example);
		if(dbList != null && dbList.size() > 0){
			for(ProductTagsDbObject tags : dbList){
				tagsList.add(tags.getName());
			}
		}
		return tagsList;
	}
	
	public Map<Integer, List<String>> getProductTags(List<Integer> productIdList) {
		Map<Integer, List<String>> tagsMap= new HashMap<Integer, List<String>>();
		ProductTagsDbObjectExample example = new ProductTagsDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdIn(productIdList);
		List<ProductTagsDbObject> dbList = productTagsDbObjectMapper.selectByExample(example);
		if(dbList != null && dbList.size() > 0){
			for(ProductTagsDbObject tags : dbList){
				if(!tagsMap.containsKey(tags.getProductId())){
					tagsMap.put(tags.getProductId(), new ArrayList<String>());
				}
				tagsMap.get(tags.getProductId()).add(tags.getName());
			}
		}
		return tagsMap;
	}

	public List<ProductVO> getProductVOTags(List<ProductVO> voList) {
		if(voList != null && voList.size() > 0){
			List<Integer> productIdList = new ArrayList<Integer>();
			for(ProductVO vo : voList){
				productIdList.add(vo.getProductId().intValue());
			}
			
			if(productIdList.size() > 0){
				Map<Integer, List<String>> map = getProductTags(productIdList);
				if(map != null && map.size() > 0){
					for(ProductVO vo : voList){
						List<String> tagsList = map.get(vo.getProductId());
						if(tagsList != null && tagsList.size() > 0){
//							vo.setTags(tagsList);
						}
					}
				}
			}
		}
		return voList;
	}
	
	public static List<ProductTagsVO> convertToProductTagsVOList(List<ProductTagsTO> toList, Long productId){
		List<ProductTagsVO> voList = new ArrayList<ProductTagsVO>();
		if(toList != null && !toList.isEmpty()){
			for(ProductTagsTO to : toList){
				ProductTagsVO vo = new ProductTagsVO();
				vo.setTagsId(to.getTagsId());
				vo.setName(to.getName());
				vo.setProductId(productId);
				GeneralUtils.copyFromTO(vo, to);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public static List<ProductTagsVO> convertToProductTagsVOList(List<String> tagsList){
		List<ProductTagsVO> productTagsVOList = new ArrayList<ProductTagsVO>();
		if(tagsList != null && !tagsList.isEmpty()){
			//remvoe duplicates
			Set<String> set = new HashSet<String>(tagsList);
			tagsList = new ArrayList<String>(set);
			for(String tagsString : tagsList){
				if(tagsString != null && !tagsString.trim().isEmpty()){
					ProductTagsVO vo = new ProductTagsVO();
					vo.setName(tagsString);
					productTagsVOList.add(vo);
				}
			}
		}
		return productTagsVOList;
	}
}
