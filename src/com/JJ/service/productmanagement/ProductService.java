package com.JJ.service.productmanagement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.inventorymanagement.vo.ViewItemCodeVO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSpecificationVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductDbObjectMapper;
import com.JJ.dao.ProductImageDbObjectMapper;
import com.JJ.dao.ProductOptionDbObjectMapper;
import com.JJ.dao.ProductSpecificationDbObjectMapper;
import com.JJ.dao.ProductSubOptionDbObjectMapper;
import com.JJ.dao.ProductSubOptionRsDbObjectMapper;
import com.JJ.dao.ProductTagsDbObjectMapper;
import com.JJ.dao.ViewItemCodeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductDbObject;
import com.JJ.model.ProductDbObjectExample;
import com.JJ.model.ProductImageDbObjectExample;
import com.JJ.model.ProductImageDbObjectWithBLOBs;
import com.JJ.model.ProductOptionDbObject;
import com.JJ.model.ProductOptionDbObjectExample;
import com.JJ.model.ProductSpecificationDbObject;
import com.JJ.model.ProductSpecificationDbObjectExample;
import com.JJ.model.ProductSubOptionDbObject;
import com.JJ.model.ProductSubOptionDbObjectExample;
import com.JJ.model.ProductSubOptionRsDbObject;
import com.JJ.model.ProductSubOptionRsDbObjectExample;
import com.JJ.model.ProductTagsDbObject;
import com.JJ.model.ProductTagsDbObjectExample;
import com.JJ.model.ViewItemCodeDbObject;
import com.JJ.model.ViewItemCodeDbObjectExample;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductService {
	private ProductDbObjectMapper productDbObjectMapper;
	private ProductOptionDbObjectMapper productOptionDbObjectMapper;
	private ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper;
	private ProductImageDbObjectMapper productImageDbObjectMapper;
	private ProductSpecificationDbObjectMapper productSpecificationDbObjectMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductOptionManagementService productOptionManagementService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper;
	private ViewItemCodeDbObjectMapper viewItemCodeDbObjectMapper;
	private ProductTagsDbObjectMapper productTagsDbObjectMapper;
	private final static int thumbnail_width = 200;
	private final static int thumbnail_height = 200;
	@Autowired
	public ProductService(ProductDbObjectMapper productDbObjectMapper, 
			ProductOptionDbObjectMapper productOptionDbObjectMapper,ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper,
			ProductImageDbObjectMapper productImageDbObjectMapper,ProductSpecificationDbObjectMapper productSpecificationDbObjectMapper, 
			ProductOptionManagementService productOptionManagementService, ProductTagsDbObjectMapper productTagsDbObjectMapper,
			ProductSubOptionManagementService productSubOptionManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper,
			ViewItemCodeDbObjectMapper viewItemCodeDbObjectMapper){
		this.productDbObjectMapper = productDbObjectMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productImageDbObjectMapper = productImageDbObjectMapper;
		this.productOptionDbObjectMapper = productOptionDbObjectMapper;
		this.productSubOptionDbObjectMapper = productSubOptionDbObjectMapper;
		this.productSpecificationDbObjectMapper = productSpecificationDbObjectMapper;
		this.productOptionManagementService = productOptionManagementService;
		this.productTagsDbObjectMapper = productTagsDbObjectMapper;
		this.productSubOptionManagementService = productSubOptionManagementService;
		this.productSubOptionRsDbObjectMapper = productSubOptionRsDbObjectMapper;
		this.viewItemCodeDbObjectMapper = viewItemCodeDbObjectMapper;
	}
	
	public List<ProductVO> getAllProducts() {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		List<ProductVO> productVOList = convertToProductVOList(productList);
		Map<Integer, ProductSubCategoryVO> subcategoryMap =  getProductsubcategoryMap();
		if(productVOList != null && productVOList.size() > 0){
			for(ProductVO product : productVOList){
				if(product.getSubCategoryId() != null && product.getSubCategoryId().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubCategoryId()));
				}
			}
		}
		return productVOList;
	}
	
	public List<ProductVO> getProductsByName(String productName) {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = ProductDbObjectExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		if(productName != null){
			criteria.andProductNameLike(productName);
			List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
			if(productList != null && productList.size() > 0){
				return convertToProductVOList(productList);
			}
		}
		return new ArrayList<ProductVO>();
	}
	
	public ProductVO getProductsById(Integer productId) {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = ProductDbObjectExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		if(productId != null){
			criteria.andProductIdEqualTo(productId);
			List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
			List<ProductVO> voList = convertToProductVOList(productList);
			if(voList != null && voList.size() > 0){
				return voList.get(0);
			}
		}
		return new ProductVO();
	}
	//-------------- START
	public List<ProductVO> getAllProductsByName(String name) {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductNameEqualTo(name);
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		List<ProductVO> productVoList = convertToProductVOList(productList);
		//get suboptions
		if(productList.size() > 0) {
			for(ProductVO vo: productVoList) {
				List<ProductSubOptionVO> suboptionList = productSubOptionManagementService.getAllProductsuboptionsByProductId(vo.getProductId());
				if(suboptionList.size() > 0){
					Map<Integer, List<ProductSubOptionVO>> suboptionMap = new HashMap<Integer, List<ProductSubOptionVO>>();
					for(ProductSubOptionVO suboption: suboptionList) {
						Integer optionid = suboption.getProductOptionId();
						if(null == suboptionMap.get(optionid)) {
							List<ProductSubOptionVO> psoList = new ArrayList<ProductSubOptionVO>();
							psoList.add(suboption);
							suboptionMap.put(optionid, psoList);
						}else if(suboptionMap.get(optionid).size() > 0) {
							suboptionMap.get(optionid).add(suboption);
						}
					}
					
					List<ProductOptionVO> optionvoList = new ArrayList<ProductOptionVO>();
					for(Integer optionid: suboptionMap.keySet()){
						ProductOptionVO option = new ProductOptionVO();
						ProductOptionVO po = productOptionManagementService.findById(optionid);
						option.setProductOptionId(optionid);
						option.setName(po.getName());
						List<ProductSubOptionVO> suboptionvoList = new ArrayList<ProductSubOptionVO>();
						option.setSubOptionList(suboptionMap.get(optionid));
						optionvoList.add(option);
					}
					vo.setOptionList(optionvoList);
				}
				productVoList.add(vo);
			}
			
			/*Map<Integer, Productsubcategory> subcategoryMap =  getProductsubcategoryMap();
			if(productList != null && productList.size() > 0){
				for(Product product : productList){
					if(product.getSubcategoryid() != null && product.getSubcategoryid().intValue() > 0){
						product.setSubCategory(subcategoryMap.get(product.getSubcategoryid()));
					}
				}
			}*/
		}
		return productVoList;
	}
	//-------------- END
	
	public List<ProductVO> getAllProduct(Integer id) {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = ProductDbObjectExample.createCriteria();
		if(id != null){
			criteria.andProductIdEqualTo(id);
		}
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		return convertToProductVOList(productList);
	}

	public ProductVO getProductVoById(Integer id) {
		ProductVO product = new ProductVO();
		List<ProductVO> productList = getAllProductVo(id);
		if(productList != null && productList.size() > 0){
			product = productList.get(0);  
		}
		return product;
	}
		
	public List<ProductVO> getAllProductVo(Integer id) {
		List<ProductVO> productList = getAllProduct(id);
		List<ProductVO> productVoList = new ArrayList<ProductVO>();
		
		Map<Integer, ProductSubCategoryVO> subcategoryMap =  getProductsubcategoryMap();
		if(productList != null && productList.size() > 0){
			for(ProductVO product : productList){
				//set category
				if(product.getSubCategoryId() != null && product.getSubCategoryId().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubCategoryId()));
				}
				//getProductImage
				List<ProductImageDbObjectWithBLOBs> productImage = getProductImage(Arrays.asList(product.getProductId()));
				
				//get Product spec
				ProductSpecificationVO productInfo =  getProductSpecification(product.getProductId());
				
				//get Product Option
				List<ProductOptionVO> optionVoList = getOptionVoList(product.getProductId());
				Collections.sort(optionVoList,new OptionVoCompare());
				//get ProductTags
				List<String> tagsList = getProductTags(product.getProductId());
				//convert To productVo
				productVoList.add(convertToProductVo(product, productImage, productInfo, optionVoList, tagsList));
			}
		}
		return productVoList;
	}
	
	private List<String> getProductTags(Integer productid) {
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

	public ProductSubOptionVO getSubOptionVo(Integer suboptionId){
		ProductSubOptionDbObjectExample example = new ProductSubOptionDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductSuboptionIdEqualTo(suboptionId);
		List<ProductSubOptionDbObject> productSubOptionList = productSubOptionDbObjectMapper.selectByExample(example);
		List<ProductSubOptionVO> voList = convertToSubOptionVo(productSubOptionList);
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new ProductSubOptionVO();
	}
	private List<ProductOptionVO> getOptionVoList(Integer productId){
		if(productId != null){
			List<ProductOptionVO> optionVoList = new ArrayList<ProductOptionVO>();
			List<ProductOptionVO> productOption = productOptionManagementService.getAllProductoptions();
			Map<Integer , ProductOptionVO> optionMap = new HashMap<Integer, ProductOptionVO>();
			Map<Integer, List<ProductSubOptionVO>> suboptionMap = new HashMap<Integer, List<ProductSubOptionVO>>();
			if(productOption != null && productOption.size() > 0){
				for(ProductOptionVO option : productOption){
					optionMap.put(option.getProductOptionId(), option);
				}
			}
			ProductSubOptionDbObjectExample example = new ProductSubOptionDbObjectExample();
			example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productId);
			List<ProductSubOptionDbObject> productSubOptionList = productSubOptionDbObjectMapper.selectByExample(example);
			if(productSubOptionList != null && productSubOptionList.size() > 0){
				List<ProductSubOptionVO> voList = convertToSubOptionVo(productSubOptionList);
				for(ProductSubOptionVO vo : voList){
					if(!suboptionMap.containsKey(vo.getProductOptionId())){
						suboptionMap.put(vo.getProductOptionId(), new ArrayList<ProductSubOptionVO>());
					}
					suboptionMap.get(vo.getProductOptionId()).add(vo);
				}
				
				if(!suboptionMap.isEmpty()){
					for(Integer key : suboptionMap.keySet()){
						ProductOptionVO option = optionMap.get(key);
						if(option != null){
							option.setSubOptionList(suboptionMap.get(key));
							optionVoList.add(option);
						}
					}
				}
				return optionVoList;
			}
			
		}
		return new ArrayList<ProductOptionVO>();
	}
	
	/*private List<ProductSubOptionVO> convertToOptionVo(List<ProductOptionDbObject> dbObjList){
		List<ProductOptionVO> voList = new ArrayList<ProductOptionVO>();
		if(option != null){
			optionVo.setProductOptionId(option.getProductOptionId());
			optionVo.setName(option.getName());
			//optionVo.setSequence(option.getSequence());
		}
		return voList;
	}*/
	private List<ProductSubOptionVO> convertToSubOptionVo(List<ProductSubOptionDbObject> dbObjList){
		List<ProductSubOptionVO> voList = new ArrayList<ProductSubOptionVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(ProductSubOptionDbObject dbObj : dbObjList){
				ProductSubOptionVO vo = new ProductSubOptionVO();
				vo.setCode(dbObj.getCode());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDisplayInd(dbObj.getDisplayInd());
				vo.setName(dbObj.getName());
				vo.setProductId(dbObj.getProductId());
				vo.setProductOptionId(dbObj.getProductOptionId());
				vo.setProductSuboptionId(dbObj.getProductSuboptionId());
				voList.add(vo);
			}
		}
		return voList;
	}
	private ProductSpecificationVO getProductSpecification(Integer productId){
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
	private List<ProductSpecificationVO> convertToProductSpecification(
			List<ProductSpecificationDbObject> productSpecificationList) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<ProductImageDbObjectWithBLOBs> getProductImage(List<Integer> productIdList){
		List<ProductImageDbObjectWithBLOBs> productImageList = new ArrayList<ProductImageDbObjectWithBLOBs>();
		if(productIdList != null && productIdList.size() > 0){
			ProductImageDbObjectExample example = new ProductImageDbObjectExample();
			example.createCriteria().andProductIdIn(productIdList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			productImageList = productImageDbObjectMapper.selectByExampleWithBLOBs(example);
		}
		return productImageList;
	}
	private ProductVO convertToProductVo(ProductVO productVo, List<ProductImageDbObjectWithBLOBs> productImageList, ProductSpecificationVO productInfo, List<ProductOptionVO> optionVoList, List<String> productTagsList){
		if(productVo != null){
			productVo.setProductInfo(productInfo.getContent());
			productVo.setImages(convertToFileMetaList(productImageList));
			productVo.setOptionList(optionVoList);
			productVo.setTags(productTagsList);
		}
		return productVo;
	}
	
	private LinkedList<FileMetaVO> convertToFileMetaList(List<ProductImageDbObjectWithBLOBs> productImageList){
		LinkedList<FileMetaVO> fileMetaList = new LinkedList<FileMetaVO>();
		if(productImageList != null && productImageList.size() > 0){
			for(ProductImageDbObjectWithBLOBs image : productImageList){
				FileMetaVO fileMeta = new FileMetaVO();
				fileMeta.setBytes(image.getImage());
				fileMeta.setFileSize(image.getImage().length+"");
				fileMeta.setFileName(image.getImageName());
				fileMeta.setImageId(image.getProductImageId());
				fileMeta.setSequence(image.getSequence());
				fileMeta.setFileType(image.getFileType());
				fileMeta.setThumbnail(image.getThumbNailImage());
				fileMetaList.add(fileMeta);
			}
		}
		return fileMetaList;
	}
	
	
	public List<ProductVO> getAllProductsBySubCategory(Integer id) {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubCategoryIdEqualTo(id);
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		return convertToProductVOList(productList);
	}
	
	private List<ProductVO> convertToProductVOList(List<ProductDbObject> productList) {
		List<ProductVO> voList = new ArrayList<ProductVO>();
		if(productList != null && productList.size() > 0){
			for(ProductDbObject dbObj : productList){
				ProductVO vo = new ProductVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDescription(dbObj.getDescription());
				vo.setPaypayId(dbObj.getPaypayId());
				vo.setProductCode(dbObj.getProductCode());
				vo.setProductId(dbObj.getProductId());
				vo.setProductName(dbObj.getProductName());
				vo.setSubCategoryId(dbObj.getSubCategoryId());
				vo.setUnitAmt(dbObj.getUnitAmt());
				vo.setVersion(dbObj.getVersion());
				vo.setWeight(dbObj.getWeight());
				voList.add(vo);
			}
		}
		return voList;
	}

	private Map<Integer, ProductSubCategoryVO> getProductsubcategoryMap(){
		List<ProductSubCategoryVO> subcatergoryList = productSubCategoryManagementService.getAllSubCategories();
		Map<Integer, ProductSubCategoryVO> map = new HashMap<Integer, ProductSubCategoryVO>();
		if(subcatergoryList != null && subcatergoryList.size() > 0){
			for(ProductSubCategoryVO subcategory : subcatergoryList){
				map.put(subcategory.getSubCategoryId(), subcategory);
			}
		}
		return map;
	}
	
	public Integer insertImageStaging(byte[] image, String imageName, String username){
//		return imageStagingService.insertImageStaging(image, imageName, username);
		return null;
	}
	
	public void deleteImageStaging(Integer stagingId){
//		imageStagingService.deleteImageStaging(stagingId);
	}
	
	public void saveProduct(ProductVO productVo){
		List<ProductDbObject> productList = convertToProductDbObjectList(Arrays.asList(productVo));
		ProductDbObject product = productList.get(0);
		//insert into product table
		if(product.getProductId() != null){
			productDbObjectMapper.updateByPrimaryKeySelective(product);
		}else{
			productDbObjectMapper.insertSelective(product);
		}
		//option
		saveOption(productVo, product.getProductId());
		//productinfo
		saveProductInfo(productVo, product.getProductId());
		//image
		saveProductImage(productVo, product.getProductId());
		//tags
		saveProductTags(productVo, product.getProductId());
	}
	
	private List<ProductDbObject> convertToProductDbObjectList(
			List<ProductVO> asList) {
		// TODO Auto-generated method stub
		return null;
	}

	private void saveProductTags(ProductVO productVo, Integer productid) {
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

	private void saveProductImage(ProductVO productVo, Integer productId){
		//delete all images
		ProductImageDbObjectExample deleteExample = new ProductImageDbObjectExample();
		deleteExample.createCriteria().andProductIdEqualTo(productId);
		ProductImageDbObjectWithBLOBs obj = new ProductImageDbObjectWithBLOBs();
		obj.setDeleteInd(GeneralUtils.DELETED);
		productImageDbObjectMapper.updateByExampleSelective(obj, deleteExample);
		//table image
		LinkedList<FileMetaVO> images = productVo.getImages();
		List<ProductImageDbObjectWithBLOBs> productImages = convertToProductImage(productId,images);
		for(ProductImageDbObjectWithBLOBs productImage : productImages){
			productImage.setDeleteInd(GeneralUtils.NOT_DELETED);
			if(productImage.getProductImageId() != null){
				productImageDbObjectMapper.updateByPrimaryKeySelective(productImage);
			}else{
				productImageDbObjectMapper.insertSelective(productImage);
			}
		}
	}
	
	private void saveProductInfo(ProductVO productVo, Integer productId){
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
	private void saveOption(ProductVO productVo, Integer productId){
		
		//find product option
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			//get all name
			List<String> optionNameList = new ArrayList<String>();
			Map<String, ProductOptionVO> optionMap = new HashMap<String, ProductOptionVO>();
			for(ProductOptionVO optionVo : productVo.getOptionList()){
				optionVo.setProductOptionId(null);
				optionMap.put(optionVo.getName(), optionVo);
			}
			optionNameList.addAll(optionMap.keySet());
			//search exists productoption
			ProductOptionDbObjectExample example = new ProductOptionDbObjectExample();
			example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andNameIn(optionNameList);
			List<ProductOptionDbObject> productOptionList = productOptionDbObjectMapper.selectByExample(example);
			
			//set id for existing optionVo
			if(productOptionList != null && productOptionList.size() > 0){
				for(ProductOptionDbObject productOption : productOptionList){
					ProductOptionVO optionVo = optionMap.get(productOption.getName());
					//reset all optionId
//					optionVo.setProductOptionId(null);
					if(optionVo != null){
						optionVo.setProductOptionId(productOption.getProductOptionId());
					}
				}
			}
			//find non exist productoption
			List<ProductOptionDbObject> newOptionDbObjectList = new ArrayList<ProductOptionDbObject>();
			List<ProductOptionDbObject> productOptionDbObjctList = productOptionManagementService.convertToProductOptionDbObjectList(productVo.getOptionList());
			for(ProductOptionDbObject optionVo : productOptionDbObjctList){
				if(optionVo.getProductOptionId() == null){
					newOptionDbObjectList.add(optionVo);
				}
			}
			
			//insert into productOption
			for(ProductOptionDbObject productOption : newOptionDbObjectList){
				productOptionDbObjectMapper.insert(productOption);
				ProductOptionVO optionVo = optionMap.get(productOption.getName());
				//set id for newly created optionVo
				if(optionVo != null){
					optionVo.setProductOptionId(productOption.getProductOptionId());
				}
			}
		}
		//product suboption
		//set all deleteInd to true
		ProductSubOptionDbObjectExample example = new ProductSubOptionDbObjectExample();
		example.createCriteria().andProductIdEqualTo(productId);
		ProductSubOptionDbObject subOption = new ProductSubOptionDbObject();
		subOption.setDeleteInd(GeneralUtils.DELETED);
		productSubOptionDbObjectMapper.updateByExampleSelective(subOption, example);
		
		
		//get all subOption
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			List<Productsuboption> productSubOptionList = new ArrayList<Productsuboption>();
			for(ProductOptionVO optionVo : productVo.getOptionList()){
				if(optionVo.getSubOptionList() != null && optionVo.getSubOptionList().size() > 0){
					productSubOptionList.addAll(convertToProductsuboption(productId, optionVo.getProductOptionId(), optionVo.getSubOptionList()));
				}
			}
			//delete if empty productsuboption exsits
			ProductSubOptionDbObjectExample deleteExample = new ProductSubOptionDbObjectExample();
			deleteExample.createCriteria().andProductIdEqualTo(productId).andProductoptionidEqualTo(0).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			Productsuboption updateProductSubOption = new Productsuboption();
			updateProductSubOption.setDeleteInd(GeneralUtils.DELETED);
			productSubOptionDbObjectMapper.updateByExample(updateProductSubOption, deleteExample);
			
			//insert into productsuboption
			
			for(Productsuboption productSubOption : productSubOptionList){
				//update
				if(productSubOption.getProductsuboptionid() != null){
					productSubOptionDbObjectMapper.updateByPrimaryKeySelective(productSubOption);
				}else{
					//insert
					productSubOptionDbObjectMapper.insert(productSubOption);
					//set id back to suboptionVo
					A:
					for(ProductOptionVO optionVo : productVo.getOptionList()){
						if(optionVo.getProductOptionId() != null && productSubOption.getProductOptionId() != null &&
								optionVo.getProductOptionId().compareTo(productSubOption.getProductOptionId()) == 0){
							for(ProductSubOptionVO suboptionVO : optionVo.getSubOptionList()){
								if(suboptionVO.getProductSuboptionId() == null 
										&& suboptionVO.getSubOptionName().equals(productSubOption.getName())){
									suboptionVO.setSubOptionId(productSubOption.getProductsuboptionid());
									break A;
								}
							}
						}
					}
				}
			}
		}else{
			//insert empty suboption
			//select if empty productsuboption exsits
			ProductSubOptionDbObjectExample selectExample = new ProductSubOptionDbObjectExample();
			selectExample.createCriteria().andProductIdEqualTo(productId).andProductoptionidEqualTo(0);
			List<Productsuboption> productSubOptionList = productSubOptionDbObjectMapper.selectByExample(selectExample);
			//insert empty suboption if dont exists
			if(productSubOptionList == null || productSubOptionList.size() == 0){
				Productsuboption productSubOption = new Productsuboption();
				productSubOption.setDeleteInd(GeneralUtils.NOT_DELETED);
				productSubOption.setCode(" ");
				productSubOption.setProductId(productId);
				productSubOption.setProductoptionid(0);
				productSubOptionDbObjectMapper.insert(productSubOption);
			}
		}
		
		//maintain productsuboption_rs
		productVo.setId(productId);
		saveProductSubOptionRs(productVo);
	}
	
	private List<ProductOptionDbObject> convertToProductOptionDbObjectList(
			List<ProductOptionVO> optionList) {
		// TODO Auto-generated method stub
		return null;
	}

	private void saveProductSubOptionRs(ProductVO productVo) {
		
		//find if product suboption rs exists
		//set delete ind to true for all suboption
		ProductSubOptionRsDbObjectExample deleteExample = new ProductSubOptionRsDbObjectExample();
		deleteExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productVo.getId());
		ProductSubOptionRsVO obj = new ProductSubOptionRsVO();
		obj.setDeleteInd(GeneralUtils.DELETED);
		productSubOptionRsDbObjectMapper.updateByExampleSelective(obj, deleteExample);
		
		//if suboption exists
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			//sort optionVO
			Collections.sort(productVo.getOptionList(),new OptionVoCompare());
			//todo generate matrix
			List<ProductSubOptionRsVO> productSuboptionRsList = new ArrayList<ProductSubOptionRsVO>();
			int size = productVo.getOptionList().size();
			if(productVo.getOptionList() != null && size >= 1){
				productSuboptionRsList =  generateLevelOne(productVo.getOptionList().get(0));
				if(size >= 2){
					productSuboptionRsList = generateLevelTwo(productVo.getOptionList().get(1), productSuboptionRsList);
					if(size >= 3){
						productSuboptionRsList = generateLevelThree(productVo.getOptionList().get(2), productSuboptionRsList);
					}
				}
			}
			for(ProductSubOptionRsVO dbObj : productSuboptionRsList){
				insertOrUpdateProductSuboptionRs(productVo.getId(), dbObj.getSuboption1Id(), dbObj.getSuboption2Id(),dbObj.getSuboption3Id());
			}
			
		}else{
			insertOrUpdateProductSuboptionRs(productVo.getId(), null, null, null);
		}
		
		//delete non used records
		ProductSubOptionRsDbObjectExample deleteRsExample = new ProductSubOptionRsDbObjectExample();
		ProductSubOptionRsDbObjectExample.Criteria criteria = deleteRsExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.DELETED);
		//TODO delete those not used id
		productSubOptionRsDbObjectMapper.deleteByExample(deleteRsExample);
	}
	
	private List<ProductSubOptionRsVO> generateLevelOne(ProductOptionVO option){
		List<ProductSubOptionRsVO> list = new ArrayList<ProductSubOptionRsVO>();
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(ProductSubOptionVO suboptionVo : option.getSubOptionList()){
				ProductSubOptionRsVO suboption = new ProductSubOptionRsVO();
				suboption.setSuboption1Id(suboptionVo.getProductSuboptionId());
				list.add(suboption);
			}
		}
		return list;
	}
	
	private List<ProductSubOptionRsVO> generateLevelTwo(ProductOptionVO option, List<ProductSubOptionRsVO> list){
		List<ProductSubOptionRsVO> list2 = new ArrayList<ProductSubOptionRsVO>();
		
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(ProductSubOptionVO suboptionVo : option.getSubOptionList()){
				if(list != null && list.size() > 0){
					for(ProductSubOptionRsVO suboption1 : list){
						ProductSubOptionRsVO suboption = new ProductSubOptionRsVO();
						suboption.setSuboption1Id(suboption1.getSuboption1Id());
						suboption.setSuboption2Id(suboptionVo.getProductSuboptionId());
						list2.add(suboption);
					}
				}
			}
		}
		return list2;
	}
	private List<ProductSubOptionRsVO> generateLevelThree(ProductOptionVO option, List<ProductSubOptionRsVO> list){
		List<ProductSubOptionRsVO> list2 = new ArrayList<ProductSubOptionRsVO>();
		
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(ProductSubOptionVO suboptionVo : option.getSubOptionList()){
				if(list != null && list.size() > 0){
					for(ProductSubOptionRsVO suboption1 : list){
						ProductSubOptionRsVO suboption = new ProductSubOptionRsVO();
						suboption.setSuboption1Id(suboption1.getSuboption1Id());
						suboption.setSuboption2Id(suboption1.getSuboption2Id());
						suboption.setSuboption3Id(suboptionVo.getProductSuboptionId());
						list2.add(suboption);
					}
				}
			}
		}
		return list2;
	}
	
	private void insertOrUpdateProductSuboptionRs(Integer productId, Integer suboption1, Integer suboption2, Integer suboption3){
		ProductSubOptionRsDbObjectExample updateExample = new ProductSubOptionRsDbObjectExample();
		ProductSubOptionRsDbObjectExample.Criteria criteria = updateExample.createCriteria();
		criteria.andProductIdEqualTo(productId);
		if(suboption1 != null){
			criteria.andSuboption1idEqualTo(suboption1);
		}
		if(suboption2 != null){
			criteria.andSuboption2idEqualTo(suboption2);
		}
		if(suboption3 != null){
			criteria.andSuboption3idEqualTo(suboption3);
		}
		ProductSubOptionRsVO deleteObj = new ProductSubOptionRsVO();
		deleteObj.setDeleteInd(GeneralUtils.NOT_DELETED);
		int rowsUpdated = productSubOptionRsDbObjectMapper.updateByExampleSelective(deleteObj, updateExample);
		
		//record dont exist, insert record
		if(rowsUpdated == 0){
			ProductSubOptionRsVO obj = new ProductSubOptionRsVO();
			obj.setProductId(productId);
			obj.setSuboption1Id(suboption1);
			obj.setSuboption2Id(suboption2);
			obj.setSuboption3Id(suboption3);
			obj.setDeleteInd(GeneralUtils.NOT_DELETED);
			productSubOptionRsDbObjectMapper.insertSelective(obj);
		}
	}

	private Product convertToProduct(ProductVO productVo){
		Product product = new Product();
		product.setProductId(productVo.getId());
		product.setProductcode(productVo.getProductCode());
		product.setUnitprice(productVo.getUnitPrice());
		product.setWeight(productVo.getWeight());
		product.setProductname(productVo.getProductName());
		product.setUnitprice(productVo.getUnitPrice());
		product.setSubcategoryid(productVo.getSubcategoryId());
		product.setDeleteInd(GeneralUtils.NOT_DELETED);
		return product;
	}
	
	private List<Productoption> convertToProductOption(List<ProductOptionVO> optionList){
		List<Productoption> productOptionList = new ArrayList<Productoption>();
		if(optionList != null  && optionList.size() > 0){
			for(ProductOptionVO optionVo : optionList){
				Productoption productOption = new Productoption();
				productOption.setProductoptionid(optionVo.getProductOptionId());
//				productOption.setSequence(optionVo.getSequence());
				productOption.setName(optionVo.getName());
				productOption.setDeleteInd(GeneralUtils.NOT_DELETED);
				productOption.setDisplayind(true);
				productOptionList.add(productOption);
			}
		}
		return productOptionList;
	}
	
	private List<Productsuboption> convertToProductsuboption(Integer productId, Integer optionId, List<ProductSubOptionVO> subOptionList){
		List<Productsuboption> productOptionList = new ArrayList<Productsuboption>();
		if(subOptionList != null && subOptionList.size() > 0){
			for(ProductSubOptionVO subOption : subOptionList){
				Productsuboption productSubOption = new Productsuboption();
				productSubOption.setProductsuboptionid(subOption.getProductSuboptionId());
				productSubOption.setProductId(productId);
				productSubOption.setCode(subOption.getCode());
				productSubOption.setProductoptionid(optionId);
				productSubOption.setName(subOption.getSubOptionName());
				productSubOption.setDeleteInd(GeneralUtils.NOT_DELETED);
				productSubOption.setDisplayind(subOption.isDisplay());
				productOptionList.add(productSubOption);
			}
		}
		return productOptionList;
	}
	
	private List<ProductImageDbObjectWithBLOBs> convertToProductImage(Integer productId,List<FileMetaVO> images){
		List<ProductImageDbObjectWithBLOBs> productImages = new ArrayList<ProductImageDbObjectWithBLOBs>();
		if(images != null && images.size() > 0 && productId != null){
			for(FileMetaVO image : images){
				ProductImageDbObjectWithBLOBs productImage = new ProductImageDbObjectWithBLOBs();
				productImage.setProductImageId(image.getImageId());
				productImage.setProductId(productId);
				productImage.setImageName(image.getFileName());
				productImage.setSequence(image.getSequence());
				productImage.setFileType(image.getFileType());
				if(image.getImageId() != null && image.getImageId().intValue() > 0){
					
				}else{
					productImage.setImage(image.getBytes());
					productImage.setThumbNailImage(getThumbnail(image.getBytes(), thumbnail_width, thumbnail_height));
				}
				productImages.add(productImage);
			}
		}
		return productImages;
	}
	
	public void deleteProduct(List<Integer> idList) {
		ProductDbObjectExample example = new ProductDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdIn(idList);
		ProductDbObject product = new ProductDbObject();
		product.setDeleteInd(GeneralUtils.DELETED);
		productDbObjectMapper.updateByExampleSelective(product, example);
	}
	
	public ProductimageWithBLOBs getCoverImageByProductId(Integer productId){
		ProductimageExample selectExample = new ProductimageExample();
		selectExample.createCriteria().andProductIdEqualTo(productId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		selectExample.setOrderByClause("sequence");
		List<ProductimageWithBLOBs> productImageList = productImageDbObjectMapper.selectByExampleWithBLOBs(selectExample);
		if(productImageList != null && productImageList.size() > 0){
			return productImageList.get(0);
		}else{
			return null;
		}
	}
	
	public class OptionVoCompare implements Comparator<ProductOptionVO>{
		@Override
		public int compare(ProductOptionVO o1, ProductOptionVO o2) {
			if(o1.getSequence() != null && o2.getSequence() != null){
				return o1.getSequence().compareTo(o2.getSequence());
			}else if(o1.getSequence() != null){
				return 1;
			}else if(o2.getSequence() != null){
				return -1;
			}
			return 0;
		}
	}
	
	
	private byte[] getThumbnail(byte[] source,int w, int h){
		try {
			InputStream in = new ByteArrayInputStream(source);
			BufferedImage buf = ImageIO.read(in);
			
			BufferedImage thumb = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics2D = thumb.createGraphics();
		    graphics2D.setBackground(Color.WHITE);
		    graphics2D.setPaint(Color.WHITE); 
		    graphics2D.fillRect(0, 0, w, h);
		    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    graphics2D.drawImage(buf, 0, 0, w, h, null);
		    
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  
			ImageIO.write( thumb, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public ProductSubOptionRsVO findProductSubOptionRs(Integer productId, List<Integer> suboptionIdList){
		//check suboption belong to product, reorder by option
		List<Integer> list = checkValidProductSubOption(productId, suboptionIdList);
		if(list == null){
			return new ProductSubOptionRsVO();
		}
		
		//check against productSuboption
		ProductSubOptionRsDbObjectExample selectExample = new ProductSubOptionRsDbObjectExample();
		ProductSubOptionRsDbObjectExample.Criteria criteria = selectExample.createCriteria();
		criteria.andProductIdEqualTo(productId);
		int size = list.size();
		switch(size){
			case 3:criteria.andSuboption3idEqualTo(list.get(2));
			case 2:criteria.andSuboption2idEqualTo(list.get(1));
			case 1:criteria.andSuboption1idEqualTo(list.get(0));
			case 0:;
		}
		List<ProductSubOptionRsVO> result = productSubOptionRsDbObjectMapper.selectByExample(selectExample);
		//if not exist, add and return
		if(result == null || result.size() == 0){
			ProductSubOptionRsVO rs = new ProductSubOptionRsVO();
			rs.setDeleteInd(GeneralUtils.NOT_DELETED);
			rs.setVersion(1);
			rs.setProductId(productId);
			switch(size){
				case 3:rs.setSuboption3Id(list.get(2));
				case 2:rs.setSuboption2Id(list.get(1));
				case 1:rs.setSuboption1Id(list.get(0));
				case 0:;
			}
			productSubOptionRsDbObjectMapper.insert(rs);
			return rs;
		}
		return result.get(0);
	}
	
	private List<Integer> checkValidProductSubOption(Integer productId,List<Integer> suboptionIdList){
		Set<Integer> duplicateSet = new HashSet<Integer>();
		if(suboptionIdList != null && suboptionIdList.size() > 0){
			for(Integer id : suboptionIdList){
				duplicateSet.add(id);
			}
		}else{
			return new ArrayList<Integer>();
		}
		List<Integer> distinctSuboptionIdList = new ArrayList<Integer>();
		distinctSuboptionIdList.addAll(duplicateSet);
		ProductSubOptionDbObjectExample selectExample = new ProductSubOptionDbObjectExample();
		selectExample.createCriteria().andProductIdEqualTo(productId).andProductSuboptionIdIn(distinctSuboptionIdList);
		List<ProductSubOptionDbObject> productSuboption = productSubOptionDbObjectMapper.selectByExample(selectExample);
		if(productSuboption != null && productSuboption.size() == distinctSuboptionIdList.size()){
			List<Integer> optionIdList = new ArrayList<Integer>();
			for(Productsuboption suboption:productSuboption){
				optionIdList.add(suboption.getProductOptionId());
			}
			ProductOptionDbObjectExample selectOptionExample = new ProductOptionDbObjectExample();
			selectOptionExample.createCriteria().andProductOptionIdIn(optionIdList);
			selectOptionExample.setOrderByClause("name");
			List<ProductOptionDbObject> productOptionList = productOptionDbObjectMapper.selectByExample(selectOptionExample);
			List<Integer> suboptionOrderedList = new ArrayList<Integer>();
			for(Productoption option: productOptionList){
				for(Productsuboption suboption:productSuboption){
					if(option.getProductOptionId().equals(suboption.getProductOptionId())){
						suboptionOrderedList.add(suboption.getProductsuboptionid());
					}
				}
			}
			return suboptionOrderedList;
		}
		return null;
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
			List<ProductOptionVO> allOptionVo = getOptionVoList(obj.getProductId());
			if(vo.getSuboption1Id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(ProductOptionVO option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(ProductSubOptionVO suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getProductSuboptionId().equals(vo.getSuboption1Id())){
								ProductOptionVO option1 = new ProductOptionVO();
								option1.setProductOptionId(option.getProductOptionId());
								option1.setName(option.getName());
								option1.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSuboption1(option1);
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
	
	public List<ProductSubOptionRsVO> getAllProductSubOptionVo(){
		ProductSubOptionRsDbObjectExample selectExample = new ProductSubOptionRsDbObjectExample();
		selectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductSubOptionRsDbObject> result = productSubOptionRsDbObjectMapper.selectByExample(selectExample);
		
		List<ProductSubOptionRsVO> voList = new ArrayList<ProductSubOptionRsVO>();
		
		
		if(result != null && result.size() > 0){
			for(ProductSubOptionRsDbObject obj : result) {
				ProductSubOptionRsVO vo = new ProductSubOptionRsVO();
				
				vo.setProductSuboptionRsId(obj.getProductSuboptionRsId());
				vo.setProductId(obj.getProductId());
				vo.setSuboption1Id(obj.getSuboption1Id());
				vo.setSuboption2Id(obj.getSuboption2Id());
				vo.setSuboption3Id(obj.getSuboption3Id());
				List<ProductOptionVO> allOptionVo = getOptionVoList(obj.getProductId());
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
									vo.setSubOption3(option3);
									break;
								}
							}
						}
					}
				}
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public ProductSubOptionRsVO getProductSubOptionRsById(Integer productsuboptionid) {
		ProductSubOptionRsDbObject dbObj = productSubOptionRsDbObjectMapper.selectByPrimaryKey(productsuboptionid);
		return convertToProductSubOptionRsVO(Arrays.asList(dbObj)).get(0);
	}
	
	private List<ProductSubOptionRsVO> convertToProductSubOptionRsVO(
			List<ProductSubOptionRsDbObject> asList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getExisitingProductCode(Integer excludeProductId){
		List<String> productCodeList = new ArrayList<String>();
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = ProductDbObjectExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		if(excludeProductId != null){
			criteria.andProductIdNotEqualTo(excludeProductId);
		}
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		if(productList != null && productList.size() > 0){
			for(ProductDbObject product : productList){
				productCodeList.add(product.getProductCode());
			}
		}
		return productCodeList;
	}
	
	public List<ViewItemCodeVO> getAllItemCode() {
		ViewItemCodeDbObjectExample viewItemCodeExample = new ViewItemCodeDbObjectExample();
		List<ViewItemCodeDbObject> itemCodeList = viewItemCodeDbObjectMapper.selectByExample(viewItemCodeExample);
		return convertToViewItemCodeVOList(itemCodeList);
	}

	private List<ViewItemCodeVO> convertToViewItemCodeVOList(
			List<ViewItemCodeDbObject> itemCodeList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
