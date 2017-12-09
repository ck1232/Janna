package com.JJ.service.productcategorymanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.controller.productcategorymanagement.ImageLinkRefTypeEnum;
import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.dao.ProductCategoryDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductCategoryDbObject;
import com.JJ.model.ProductCategoryDbObjectExample;
import com.JJ.service.filelinkmanagement.ImageService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductCategoryManagementService {
	private ProductCategoryDbObjectMapper productCategoryDbObjectMapper;
	private ImageService imageService;
	private ProductSubCategoryManagementService subCategoryService;
	
	@Autowired
	public ProductCategoryManagementService(ProductCategoryDbObjectMapper productCategoryDbObjectMapper,
			ImageService imageService,
			ProductSubCategoryManagementService subCategoryService) {
		this.productCategoryDbObjectMapper = productCategoryDbObjectMapper;
		this.imageService = imageService;
		this.subCategoryService = subCategoryService;
		
	}
	
	public ProductCategoryVO findById(Integer id) {
		ProductCategoryDbObject productCategoryDbObject = productCategoryDbObjectMapper.selectByPrimaryKey(id);
		if(productCategoryDbObject != null && productCategoryDbObject.getCategoryId() != null){
			ProductCategoryVO vo = convertToProductCategoryVOList(Arrays.asList(productCategoryDbObject)).get(0);
			if(vo != null) {
				List<ProductCategoryVO> voList = getImageForCategory(Arrays.asList(vo));
				if(voList!=null &&!voList.isEmpty())
					return voList.get(0);
			}
		}
		return new ProductCategoryVO();
	}
	
	private List<ProductCategoryVO> getImageForCategory(List<ProductCategoryVO> categoryList) {
		if(!categoryList.isEmpty()){
			List<Integer> refIdList = GeneralUtils.convertListToIntegerList(categoryList, "categoryId");
			Map<Integer, List<ImageLinkVO>> imageLinkMap = imageService.getAllImageLinkByRefTypeAndIdList(ImageLinkRefTypeEnum.PRODUCT_CATEGORY.getType(), refIdList);
			for(ProductCategoryVO vo : categoryList) {
				List<ImageLinkVO> imageList = imageLinkMap.get(vo.getCategoryId());
				vo.setImageList(new ArrayList<ImageLinkVO>());
				if(imageList != null && !imageList.isEmpty()) {
					for(ImageLinkVO imageLinkVO : imageList) {
						if(imageLinkVO.getSequence() == 1) {
							vo.setFirstImageLink(imageLinkVO);
						}
						vo.getImageList().add(imageLinkVO);
					}
				}else{
					ImageLinkVO imageLink = new ImageLinkVO();
					imageLink.setDisplayPath(imageLink.getDisplayPath());
					vo.setFirstImageLink(imageLink);
				}
			}
		}
		return categoryList;
	}
	
	public List<ProductCategoryVO> getAllCategories() {
		ProductCategoryDbObjectExample productCategoryDbObjectExample = new ProductCategoryDbObjectExample();
		productCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductCategoryVO> categoryList = convertToProductCategoryVOList(productCategoryDbObjectMapper.selectByExample(productCategoryDbObjectExample));
		return getImageForCategory(categoryList);
	}
	
	public void saveProductCategory(ProductCategoryVO ProductCategoryVO) {
		if(ProductCategoryVO != null){
			ProductCategoryDbObject dbObj = convertToProductCategoryDbObjectList(Arrays.asList(ProductCategoryVO)).get(0);
			productCategoryDbObjectMapper.insert(dbObj);
			ProductCategoryVO.setCategoryId(dbObj.getCategoryId());
		}
	}
	
	public void deleteProductCategory(Integer id) {
		deleteProductCategory(Arrays.asList(id));
	}
	
	public void deleteProductCategory(List<Integer> idList) {
		ProductCategoryDbObjectExample productCategoryDbObjectExample = new ProductCategoryDbObjectExample();
		productCategoryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCategoryIdIn(idList);
		ProductCategoryDbObject dbObj = new ProductCategoryDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		productCategoryDbObjectMapper.updateByExampleSelective(dbObj, productCategoryDbObjectExample);
	}
	
	public void initUpdateProductCategory(ProductCategoryVO productCategoryVO, List<ImageLinkVO> imageList, List<ImageLinkVO> deletedImageList) {
		updateProductcategory(productCategoryVO);
		//if category is parent, auto add in sub-category
		if(productCategoryVO.getIsParentBoolean()) {
			subCategoryService.deleteProductSubCategoryByCategory(productCategoryVO.getCategoryId());
			ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
			productSubCategoryVO.setName(productCategoryVO.getCategoryName());
	    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
	    	productSubCategoryVO.setCategoryId(new Integer(productCategoryVO.getCategoryId()));
	    	productSubCategoryVO.setDisplayIndBoolean(productCategoryVO.getDisplayIndBoolean());
	    	subCategoryService.saveProductSubCategory(productSubCategoryVO);
		}
		for(ImageLinkVO imageLink : imageList) {
			if(!imageLink.isRemoveInd())
				imageService.saveImageLink(imageLink);
			else{
				imageService.deleteImageLink(imageLink);
			}
		}
	}
	
	public void updateProductcategory(ProductCategoryVO productCategoryVO) {
		if(productCategoryVO != null && productCategoryVO.getCategoryId() != null){
			ProductCategoryDbObject dbObj = convertToProductCategoryDbObjectList(Arrays.asList(productCategoryVO)).get(0);
			productCategoryDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	private List<ProductCategoryVO> convertToProductCategoryVOList(List<ProductCategoryDbObject> productCategoryDbObjectList) {
		List<ProductCategoryVO> productCategoryVOList = new ArrayList<ProductCategoryVO>();
		if(productCategoryDbObjectList != null && !productCategoryDbObjectList.isEmpty()) {
			for(ProductCategoryDbObject dbObj : productCategoryDbObjectList) {
				ProductCategoryVO vo = new ProductCategoryVO();
				vo.setCategoryId(dbObj.getCategoryId());
				vo.setCategoryName(dbObj.getCategoryName());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setDisplayIndString(dbObj.getDisplayInd());
				vo.setDisplayIndBoolean(GeneralUtils.ALLOW_DISPLAY.equals(dbObj.getDisplayInd())? Boolean.TRUE : Boolean.FALSE);
				vo.setIsParent(dbObj.getIsParent());
				vo.setIsParentString(dbObj.getIsParent());
				vo.setIsParentBoolean(GeneralUtils.YES_IND.equals(dbObj.getIsParent()) ? Boolean.TRUE : Boolean.FALSE);
				vo.setVersion(dbObj.getVersion());
				productCategoryVOList.add(vo);
			}
		}
		return productCategoryVOList;
	}
	
	private List<ProductCategoryDbObject> convertToProductCategoryDbObjectList(List<ProductCategoryVO> productCategoryVOList) {
		List<ProductCategoryDbObject> productCategoryDbObjectList = new ArrayList<ProductCategoryDbObject>();
		if(productCategoryVOList != null && !productCategoryVOList.isEmpty()) {
			for(ProductCategoryVO vo : productCategoryVOList) {
				ProductCategoryDbObject dbObj = new ProductCategoryDbObject();
				dbObj.setCategoryId(vo.getCategoryId());
				dbObj.setCategoryName(vo.getCategoryName());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDisplayInd(vo.getDisplayIndBoolean() == Boolean.TRUE ? "1" : "0");
				dbObj.setIsParent(vo.getIsParentBoolean() == Boolean.TRUE ? "1" : "0");
				dbObj.setVersion(vo.getVersion());
				productCategoryDbObjectList.add(dbObj);
			}
		}
		return productCategoryDbObjectList;
	}
}
