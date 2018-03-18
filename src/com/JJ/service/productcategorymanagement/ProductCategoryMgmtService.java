package com.JJ.service.productcategorymanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.CategoryImageLinkRsTO;
import com.JJ.TO.FileLinkTO;
import com.JJ.TO.ProductCategoryTO;
import com.JJ.TO.ProductSubCategoryTO;
import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.dao.jpa.ProductCategoryDAO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.filelinkmanagement.NewImageService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductCategoryMgmtService {
	private ProductCategoryDAO productCategoryDAO;
	private NewImageService imageService;
	
	@Autowired
	public ProductCategoryMgmtService(ProductCategoryDAO productCategoryDAO,
			NewImageService imageService) {
		this.productCategoryDAO = productCategoryDAO;
		this.imageService = imageService;
	}

	public List<ProductCategoryVO> getAllProductCategoryList() {
		List<ProductCategoryTO> productCategoryTOList = productCategoryDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
		return convertToProductCategoryVOList(productCategoryTOList);
	}
	
	public ProductCategoryVO getProductCategoryVOById(Long categoryId){
		ProductCategoryTO productCategoryTO = productCategoryDAO.findByCategoryIdAndDeleteInd(categoryId, GeneralUtils.NOT_DELETED);
		if(productCategoryTO != null){
			return convertToProductCategoryVOList(Arrays.asList(productCategoryTO)).get(0);
		}
		return null;
	}
	
	public ImageLinkVO getCoverImageByCategoryId(Long categoryId) {
		ProductCategoryTO productCategoryTO = productCategoryDAO.findByCategoryIdAndDeleteInd(categoryId, GeneralUtils.NOT_DELETED);
		if(productCategoryTO != null){
			LinkedList<ImageLinkVO> list = NewImageService.convertToNewImageLinkVOMapOrdered(productCategoryTO.getCategoryImageLinkRsTOList());
			if(list != null && !list.isEmpty()){
				ImageLinkVO imageLinkVO = list.get(0);
				imageLinkVO = imageService.readImageFromURL(imageLinkVO);
				return imageLinkVO;
			}
		}
		return null;
	}

	private List<ProductCategoryVO> convertToProductCategoryVOList(List<ProductCategoryTO> productCategoryTOList) {
		List<ProductCategoryVO> categoryList = new ArrayList<ProductCategoryVO>();
		if(productCategoryTOList != null && !productCategoryTOList.isEmpty()){
			for(ProductCategoryTO to : productCategoryTOList){
				ProductCategoryVO vo = new ProductCategoryVO();
				vo.setCategoryId(to.getCategoryId());
				vo.setCategoryName(to.getCategoryName());
				vo.setDisplayInd(to.getDisplayInd());
				vo.setDisplayIndBoolean(GeneralUtils.ALLOW_DISPLAY.equals(to.getDisplayInd())? Boolean.TRUE : Boolean.FALSE);
				vo.setIsParent(to.getIsParent());
				vo.setIsParentString(to.getIsParent());
				vo.setIsParentBoolean(GeneralUtils.YES_IND.equals(to.getIsParent()) ? Boolean.TRUE : Boolean.FALSE);
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				vo.setSubcategoryList(convertToProductSubCategoryVOList(to.getProductSubCategoryTOList()));
				LinkedList<ImageLinkVO> imageList = NewImageService.convertToNewImageLinkVOMapOrdered(to.getCategoryImageLinkRsTOList());
				vo.setImageList(imageList);
				if(!imageList.isEmpty())
					vo.setFirstImageLink(imageList.getFirst());
				else{
					ImageLinkVO imageLink = new ImageLinkVO();
					vo.setFirstImageLink(imageLink);
				}
				if(vo.getSubcategoryList().isEmpty()){continue;}
				categoryList.add(vo);
			}
		}
		return categoryList;
	}
	
	public List<ProductSubCategoryVO> convertToProductSubCategoryVOList(List<ProductSubCategoryTO> toList){
		List<ProductSubCategoryVO> subCategoryList = new ArrayList<ProductSubCategoryVO>();
		if(toList != null && !toList.isEmpty()){
			for(ProductSubCategoryTO to : toList){
				ProductSubCategoryVO vo = new ProductSubCategoryVO();
				if(to.getProductCategoryTO() != null){
					vo.setCategoryId(to.getProductCategoryTO().getCategoryId());
				}
				vo.setDisplayInd(to.getDisplayInd());
				vo.setDisplayIndBoolean("Y".equals(to.getDisplayInd()) ? Boolean.TRUE : Boolean.FALSE);
				if("Y".equals(to.getDeleteInd())){
					continue;
				}
				vo.setName(to.getName());
				vo.setSubCategoryId(to.getSubCategoryId());
				vo.setCreatedBy(to.getCreatedBy());
				vo.setCreatedOn(to.getCreatedOn());
				vo.setUpdatedBy(to.getUpdatedBy());
				vo.setUpdatedOn(to.getUpdatedOn());
				vo.setDeleteInd(to.getDeleteInd());
				vo.setVersion(to.getVersion());
				subCategoryList.add(vo);
			}
		}
		return subCategoryList;
	}
	
	private List<ProductCategoryTO> convertToProductCategoryTOList(List<ProductCategoryVO> productCategoryVOList) {
		List<ProductCategoryTO> categoryList = new ArrayList<ProductCategoryTO>();
		if(productCategoryVOList != null && !productCategoryVOList.isEmpty()){
			for(ProductCategoryVO vo : productCategoryVOList){
				ProductCategoryTO to = new ProductCategoryTO();
				to.setCategoryId(vo.getCategoryId());
				to.setCategoryName(vo.getCategoryName());
				to.setDisplayInd(vo.getDisplayIndBoolean() ? GeneralUtils.ALLOW_DISPLAY : GeneralUtils.NOT_ALLOW_DISPLAY);
				to.setIsParent(vo.getIsParentBoolean() ? GeneralUtils.IS_PARENT : GeneralUtils.IS_NOT_PARENT);
				to.setCreatedBy(vo.getCreatedBy());
				to.setCreatedOn(vo.getCreatedOn());
				to.setUpdatedBy(vo.getUpdatedBy());
				to.setUpdatedOn(vo.getUpdatedOn());
				to.setDeleteInd(vo.getDeleteInd());
				to.setVersion(vo.getVersion());
				to.setProductSubCategoryTOList(convertToProductSubCategoryTOList(to, vo.getSubcategoryList()));
				to.setCategoryImageLinkRsTOList(convertToProductCategoryImageTOList(to, vo.getImageList()));
				categoryList.add(to);
			}
		}
		return categoryList;
	}
	
	private List<CategoryImageLinkRsTO> convertToProductCategoryImageTOList(ProductCategoryTO categoryTO, List<ImageLinkVO> imageList) {
		List<CategoryImageLinkRsTO> list = new ArrayList<CategoryImageLinkRsTO>();
		if(imageList != null){
			for(ImageLinkVO vo : imageList){
				CategoryImageLinkRsTO to = new CategoryImageLinkRsTO();
				to.setProductCategoryTO(categoryTO);
				to.setRefType(GeneralUtils.TYPE_PRODUCT_CATEGORY);
				FileLinkTO fileLinkTO = new FileLinkTO();
				fileLinkTO.setContentType(vo.getContentType());
				fileLinkTO.setFileLinkId(vo.getImageLinkId());
				fileLinkTO.setFilePath(vo.getImagePath());
				to.setFileLinkTO(fileLinkTO);
				to.setSequence(vo.getSequence());
				to.setImageLinkRsId(vo.getImageLinkRsId());
				GeneralUtils.copyFromVO(vo, to);
				list.add(to);
			}
		}
		return list;
	}

	private List<ProductSubCategoryTO> convertToProductSubCategoryTOList(ProductCategoryTO categoryTO, List<ProductSubCategoryVO> productCategoryVOList) {
		List<ProductSubCategoryTO> categoryList = new ArrayList<ProductSubCategoryTO>();
		if(productCategoryVOList != null && !productCategoryVOList.isEmpty()){
			for(ProductSubCategoryVO vo : productCategoryVOList){
				ProductSubCategoryTO to = new ProductSubCategoryTO();
				to.setSubCategoryId(vo.getSubCategoryId());
				to.setName(vo.getName());
				to.setDisplayInd(vo.getDisplayIndBoolean() ? GeneralUtils.ALLOW_DISPLAY : GeneralUtils.NOT_ALLOW_DISPLAY);
				to.setCreatedBy(vo.getCreatedBy());
				to.setCreatedOn(vo.getCreatedOn());
				to.setUpdatedBy(vo.getUpdatedBy());
				to.setUpdatedOn(vo.getUpdatedOn());
				to.setDeleteInd(vo.getDeleteInd());
				to.setProductCategoryTO(categoryTO);
				to.setVersion(vo.getVersion());
				categoryList.add(to);
			}
		}
		return categoryList;
	}
	
	public void saveProductCategory(ProductCategoryVO productCategoryVO) {
		List<ProductCategoryTO> productCategoryTOList = convertToProductCategoryTOList(Arrays.asList(productCategoryVO));
		ProductCategoryTO to = productCategoryTOList.get(0);
		if(to.getCategoryId() != null){
			ProductCategoryTO existingTO = productCategoryDAO.findOne(to.getCategoryId());
			GeneralUtils.copyFromTO(to, existingTO);
			if(GeneralUtils.DELETED.compareTo(productCategoryVO.getDeleteInd()) == 0){
				to.setDeleteInd(GeneralUtils.DELETED);
			}
		}
		productCategoryDAO.save(to);
	}
}
