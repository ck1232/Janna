package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductTagsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductTagsDbObject;
import com.JJ.model.ProductTagsDbObjectExample;
@Service
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
			criteria.andNameNotIn(productVo.getTags());
		}
		ProductTagsDbObject tags = new ProductTagsDbObject();
		tags.setDeleteInd(GeneralUtils.DELETED);
		productTagsDbObjectMapper.updateByExampleSelective(tags, deleteExample);
		if(productVo.getTags() != null && !productVo.getTags().isEmpty()){
			//get all active tags
			ProductTagsDbObjectExample selectExample = new ProductTagsDbObjectExample();
			selectExample.createCriteria().andNameIn(productVo.getTags()).andProductIdEqualTo(productid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
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
	
	private List<ProductTagsDbObject> convertToProductTags(List<String> tagsList, Integer productId){
		List<ProductTagsDbObject> dbList = new ArrayList<ProductTagsDbObject>();
		if(tagsList != null && !tagsList.isEmpty()){
			for(String tag: tagsList){
				ProductTagsDbObject dbTag = new ProductTagsDbObject();
				dbTag.setName(tag);
				dbTag.setProductId(productId);
				dbTag.setDeleteInd(GeneralUtils.NOT_DELETED);
				dbList.add(dbTag);
			}
		}
		return dbList;
	}
	
	public List<String> getProductTags(Integer productid) {
		List<String> tagsList = new ArrayList<String>();
		ProductTagsDbObjectExample example = new ProductTagsDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productid);
		List<ProductTagsDbObject> dbList = productTagsDbObjectMapper.selectByExample(example);
		if(dbList != null && dbList.size() > 0){
			for(ProductTagsDbObject tags : dbList){
				tagsList.add(tags.getName());
			}
		}
		return tagsList;
	}
}
