package com.JJ.service.productmanagement;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.ImageLinkVO;
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
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductDbObject;
import com.JJ.model.ProductDbObjectExample;
import com.JJ.model.ProductImageDbObjectWithBLOBs;
import com.JJ.model.ProductOptionDbObject;
import com.JJ.model.ProductOptionDbObjectExample;
import com.JJ.model.ProductSubOptionDbObject;
import com.JJ.model.ProductSubOptionDbObjectExample;
import com.JJ.model.ProductSubOptionRsDbObject;
import com.JJ.model.ProductSubOptionRsDbObjectExample;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductService {
	private ProductDbObjectMapper productDbObjectMapper;
	private ProductOptionDbObjectMapper productOptionDbObjectMapper;
	private ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductOptionManagementService productOptionManagementService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper;
	private ProductImageService productImageService;
	private ProductTagsService productTagsService;
	private ProductSubOptionRsService productSubOptionRsService;
	private ProductSpecificationService productSpecificationService;
	
	@Autowired
	public ProductService(ProductDbObjectMapper productDbObjectMapper, 
			ProductOptionDbObjectMapper productOptionDbObjectMapper,ProductSubOptionDbObjectMapper productSubOptionDbObjectMapper,
			ProductImageDbObjectMapper productImageDbObjectMapper,ProductSpecificationDbObjectMapper productSpecificationDbObjectMapper, 
			ProductOptionManagementService productOptionManagementService,
			ProductSubOptionManagementService productSubOptionManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductSpecificationService productSpecificationService,
			ProductSubOptionRsDbObjectMapper productSubOptionRsDbObjectMapper,
			ProductImageService productImageService, ProductTagsService productTagsService,
			ProductSubOptionRsService productSubOptionRsService){
		this.productDbObjectMapper = productDbObjectMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productOptionDbObjectMapper = productOptionDbObjectMapper;
		this.productSubOptionDbObjectMapper = productSubOptionDbObjectMapper;
		this.productOptionManagementService = productOptionManagementService;
		this.productSubOptionManagementService = productSubOptionManagementService;
		this.productSubOptionRsDbObjectMapper = productSubOptionRsDbObjectMapper;
		this.productSpecificationService = productSpecificationService;
		this.productImageService = productImageService;
		this.productTagsService = productTagsService;
		this.productSubOptionRsService = productSubOptionRsService;
	}
	
	public List<ProductVO> getProductVOById(List<Integer> productIdList, List<AdditionalInfo> additionalInfoList){
		ProductDbObjectExample productDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = productDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		if(productIdList != null && productIdList.size() > 0){
			criteria.andProductIdIn(productIdList);
		}
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(productDbObjectExample);
		List<ProductVO> productVOList = convertToProductVOList(productList);
		productVOList = getProductAdditionalInfo(productVOList, additionalInfoList);
		return productVOList;
	}
	
	public List<ProductVO> getProductVOByName(List<String> productNameList, List<AdditionalInfo> additionalInfoList){
		ProductDbObjectExample productDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.Criteria criteria = productDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		if(productNameList != null && productNameList.size() > 0){
			criteria.andProductNameIn(productNameList);
		}
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(productDbObjectExample);
		List<ProductVO> productVOList = convertToProductVOList(productList);
		productVOList = getProductAdditionalInfo(productVOList, additionalInfoList);
		return productVOList;
	}
	
	private List<ProductVO> getProductAdditionalInfo(List<ProductVO> voList, List<AdditionalInfo> additionalInfoList){
		if(voList != null && voList.size() > 0){
			if(additionalInfoList != null && !additionalInfoList.contains(AdditionalInfo.NONE)){
				if(additionalInfoList.contains(AdditionalInfo.ALL)){
					voList = getProductSubCategory(voList);
					voList = productSpecificationService.getProductSpecification(voList);
				}else{
					for(AdditionalInfo info : additionalInfoList){
						switch(info){
						case CATEGORY : voList = getProductSubCategory(voList); break;
						case IMAGE : voList = productImageService.getProductVOImage(voList);break;
						case OPTION : voList = productOptionManagementService.getProductOption(voList);break;
						case SPECIFICATION : voList = productSpecificationService.getProductSpecification(voList); break;
						case TAGS : voList = productTagsService.getProductVOTags(voList);break;
						default :;
						}
					}
				}
			}
			return voList;
		}
		return new ArrayList<ProductVO>();
	}

	public static List<Integer> getProductIdList(List<ProductVO> voList){
		List<Integer> productIdList = new ArrayList<Integer>();
		if(voList != null && voList.size() > 0){
			Set<Integer> productIdSet = new HashSet<Integer>();
			for(ProductVO productVO : voList){
				if(productVO.getProductId() != null && productVO.getProductId() > 0){
					productIdSet.add(productVO.getProductId().intValue());
				}
			}
			productIdList.addAll(productIdSet);
		}
		return productIdList;
	}
	
	public static Map<Integer, ProductVO> getProductVOMap(List<ProductVO> voList){
		Map<Integer, ProductVO> map = new HashMap<Integer, ProductVO>();
		if(voList != null && voList.size() > 0){
			for(ProductVO vo : voList){
				if(vo.getProductId() != null && vo.getProductId() > 0){
					map.put(vo.getProductId().intValue(), vo);
				}
			}
		}
		return map;
	}
	
	private List<ProductVO> getProductSubCategory(List<ProductVO> voList){
		Map<Integer, ProductSubCategoryVO> subcategoryMap =  productSubCategoryManagementService.getProductsubcategoryMap();
		if(voList != null && voList.size() > 0){
			for(ProductVO product : voList){
				if(product.getSubCategoryId() != null && product.getSubCategoryId().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubCategoryId()));
				}
			}
		}
		return voList;
	}
	
	public enum AdditionalInfo{
		NONE,
		SPECIFICATION,
		TAGS,
		IMAGE,
		OPTION,
		CATEGORY,
		ALL
	}
	
	public List<ProductVO> getAllProducts() {
		ProductDbObjectExample ProductDbObjectExample = new ProductDbObjectExample();
		ProductDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductDbObject> productList = productDbObjectMapper.selectByExample(ProductDbObjectExample);
		List<ProductVO> productVOList = convertToProductVOList(productList);
		Map<Integer, ProductSubCategoryVO> subcategoryMap =  productSubCategoryManagementService.getProductsubcategoryMap();
		if(productVOList != null && productVOList.size() > 0){
			for(ProductVO product : productVOList){
				if(product.getSubCategoryId() != null && product.getSubCategoryId().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubCategoryId()));
				}
				LinkedList<ImageLinkVO> imageLinkVOList = productImageService.getProductImage(product.getProductId().intValue());
				if(imageLinkVOList != null){
					product.setImagesLink(imageLinkVOList);
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
				List<ProductSubOptionVO> suboptionList = productSubOptionManagementService.getAllProductsuboptionsByProductId(vo.getProductId().intValue());
				if(suboptionList.size() > 0){
					Map<Integer, List<ProductSubOptionVO>> suboptionMap = new HashMap<Integer, List<ProductSubOptionVO>>();
					for(ProductSubOptionVO suboption: suboptionList) {
						Integer optionid = suboption.getProductOptionId().intValue();
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
						option.setProductOptionId(optionid.longValue());
						option.setName(po.getName());
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
	
	private List<ProductVO> getAllProduct(Integer id) {
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
		
		Map<Integer, ProductSubCategoryVO> subcategoryMap =  productSubCategoryManagementService.getProductsubcategoryMap();
		if(productList != null && productList.size() > 0){
			for(ProductVO product : productList){
				//set category
				if(product.getSubCategoryId() != null && product.getSubCategoryId().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubCategoryId()));
				}
				//getProductImage
				LinkedList<ImageLinkVO> productImage = productImageService.getProductImage(product.getProductId().intValue());
				
				//get Product spec
				ProductSpecificationVO productInfo =  productSpecificationService.getProductSpecification(product.getProductId().intValue());
				
				//get Product Option
				List<ProductOptionVO> optionVoList = productOptionManagementService.getOptionVoList(product.getProductId().intValue());
				Collections.sort(optionVoList,new OptionVoCompare());
				//get ProductTags
				List<String> tagsList = productTagsService.getProductTags(product.getProductId());
				//convert To productVo
				productVoList.add(convertToProductVo(product, productImage, productInfo, optionVoList, tagsList));
			}
		}
		return productVoList;
	}

	private ProductVO convertToProductVo(ProductVO productVo, LinkedList<ImageLinkVO> productImage, ProductSpecificationVO productInfo, List<ProductOptionVO> optionVoList, List<String> productTagsList){
		if(productVo != null){
			productVo.setProductInfo(productInfo.getContent());
			productVo.setImagesLink(productImage);
			productVo.setOptionList(optionVoList);
//			productVo.setTags(productTagsList);
		}
		return productVo;
	}
	@SuppressWarnings("unused")
	@Deprecated
	private LinkedList<FileMetaVO> convertToFileMetaList(List<ProductImageDbObjectWithBLOBs> productImageList){
		LinkedList<FileMetaVO> fileMetaList = new LinkedList<FileMetaVO>();
		if(productImageList != null && productImageList.size() > 0){
			for(ProductImageDbObjectWithBLOBs image : productImageList){
				FileMetaVO fileMeta = new FileMetaVO();
				fileMeta.setBytes(image.getImage());
				fileMeta.setFileSize(image.getImage().length+"");
				fileMeta.setFileName(image.getImageName());
				fileMeta.setImageId(image.getProductImageId().longValue());
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
				vo.setPaypalId(dbObj.getPaypayId());
				vo.setProductCode(dbObj.getProductCode());
				vo.setProductId(dbObj.getProductId().longValue());
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
	
	public void saveProduct(ProductVO productVo){
		List<ProductDbObject> productList = convertToProductDbObjectList(Arrays.asList(productVo));
		ProductDbObject product = productList.get(0);
		//insert into product table
		if(product.getProductId() != null){
			productDbObjectMapper.updateByPrimaryKeySelective(product);
		}else{
			productDbObjectMapper.insertSelective(product);
			productVo.setProductId(product.getProductId().longValue());
		}
		//option
		saveOption(productVo);
		//productinfo
		productSpecificationService.saveProductInfo(productVo, product.getProductId());
		//image
		productImageService.saveProductImage(productVo, product.getProductId());
		//tags
		productTagsService.saveProductTags(productVo, product.getProductId());
	}
	
	private List<ProductDbObject> convertToProductDbObjectList(List<ProductVO> productVOList) {
		List<ProductDbObject> ProductDbObjectList = new ArrayList<ProductDbObject>();
		if(productVOList != null && !productVOList.isEmpty()) {
			for(ProductVO vo : productVOList) {
				ProductDbObject dbObj = new ProductDbObject();
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDescription(vo.getDescription());
				dbObj.setPaypayId(vo.getPaypalId());
				dbObj.setProductCode(vo.getProductCode());
				dbObj.setProductId(vo.getProductId().intValue());
				dbObj.setProductName(vo.getProductName());
				dbObj.setSubCategoryId(vo.getSubCategoryId());
				dbObj.setUnitAmt(vo.getUnitAmt());
				dbObj.setVersion(vo.getVersion());
				dbObj.setWeight(vo.getWeight());
				ProductDbObjectList.add(dbObj);
			}
		}
		return ProductDbObjectList;
	}

	

	
	
	
	private void saveOption(ProductVO productVo){
		
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
						optionVo.setProductOptionId(productOption.getProductOptionId().longValue());
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
				productOption.setDisplayInd(GeneralUtils.YES_IND);
				productOptionDbObjectMapper.insert(productOption);
				ProductOptionVO optionVo = optionMap.get(productOption.getName());
				//set id for newly created optionVo
				if(optionVo != null){
					optionVo.setProductOptionId(productOption.getProductOptionId().longValue());
				}
			}
		}
		//product suboption
		//set all deleteInd to true
		ProductSubOptionDbObjectExample example = new ProductSubOptionDbObjectExample();
		example.createCriteria().andProductIdEqualTo(productVo.getProductId().intValue());
		ProductSubOptionDbObject subOption = new ProductSubOptionDbObject();
		subOption.setDeleteInd(GeneralUtils.DELETED);
		productSubOptionDbObjectMapper.updateByExampleSelective(subOption, example);
		
		
		//get all subOption
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			List<ProductSubOptionDbObject> productSubOptionList = new ArrayList<ProductSubOptionDbObject>();
			for(ProductOptionVO optionVo : productVo.getOptionList()){
				if(optionVo.getSubOptionList() != null && optionVo.getSubOptionList().size() > 0){
					productSubOptionList.addAll(productSubOptionManagementService.convertToProductSubOptionDbObjectList(optionVo.getSubOptionList(),productVo.getProductId().intValue(), optionVo.getProductOptionId().intValue()));
				}
			}
			//delete if empty productsuboption exsits
			ProductSubOptionDbObjectExample deleteExample = new ProductSubOptionDbObjectExample();
			deleteExample.createCriteria().andProductIdEqualTo(productVo.getProductId().intValue()).andProductOptionIdEqualTo(0).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			ProductSubOptionDbObject updateProductSubOption = new ProductSubOptionDbObject();
			updateProductSubOption.setDeleteInd(GeneralUtils.DELETED);
			productSubOptionDbObjectMapper.updateByExampleSelective(updateProductSubOption, deleteExample);
			
			//insert into productsuboption
			
			for(ProductSubOptionDbObject productSubOption : productSubOptionList){
				//update
				if(productSubOption.getProductSuboptionId() != null){
					productSubOptionDbObjectMapper.updateByPrimaryKeySelective(productSubOption);
				}else{
					//insert
					productSubOptionDbObjectMapper.insert(productSubOption);
					//set id back to suboptionVo
					A:
					for(ProductOptionVO optionVo : productVo.getOptionList()){
						if(optionVo.getProductOptionId() != null && productSubOption.getProductOptionId() != null &&
								optionVo.getProductOptionId().compareTo(productSubOption.getProductOptionId().longValue()) == 0){
							for(ProductSubOptionVO suboptionVO : optionVo.getSubOptionList()){
								if(suboptionVO.getProductSuboptionId() == null 
										&& suboptionVO.getName().equals(productSubOption.getName())){
									suboptionVO.setProductSuboptionId(productSubOption.getProductSuboptionId().longValue());
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
			selectExample.createCriteria().andProductIdEqualTo(productVo.getProductId().intValue()).andProductOptionIdEqualTo(0);
			List<ProductSubOptionDbObject> productSubOptionList = productSubOptionDbObjectMapper.selectByExample(selectExample);
			//insert empty suboption if dont exists
			if(productSubOptionList == null || productSubOptionList.size() == 0){
				ProductSubOptionDbObject productSubOption = new ProductSubOptionDbObject();
				productSubOption.setDeleteInd(GeneralUtils.NOT_DELETED);
				productSubOption.setCode(" ");
				productSubOption.setProductId(productVo.getProductId().intValue());
				productSubOption.setProductOptionId(0);
				productSubOptionDbObjectMapper.insert(productSubOption);
			}
		}
		
		//maintain productsuboption_rs
//		productVo.setProductId(productId);
		saveProductSubOptionRs(productVo);
	}
	
	private void saveProductSubOptionRs(ProductVO productVo) {
		
		//find if product suboption rs exists
		//set delete ind to true for all suboption
		ProductSubOptionRsDbObjectExample deleteExample = new ProductSubOptionRsDbObjectExample();
		deleteExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdEqualTo(productVo.getProductId().intValue());
		ProductSubOptionRsDbObject obj = new ProductSubOptionRsDbObject();
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
				insertOrUpdateProductSuboptionRs(productVo.getProductId().intValue(), dbObj.getSuboption1Id(), dbObj.getSuboption2Id(),dbObj.getSuboption3Id());
			}
			
		}else{
			insertOrUpdateProductSuboptionRs(productVo.getProductId().intValue(), null, null, null);
		}
		
		//delete non used records
		ProductSubOptionRsDbObjectExample deleteRsExample = new ProductSubOptionRsDbObjectExample();
		ProductSubOptionRsDbObjectExample.Criteria criteria = deleteRsExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.DELETED);
		//delete those not used id
		productSubOptionRsDbObjectMapper.deleteByExample(deleteRsExample);
	}
	
	private List<ProductSubOptionRsVO> generateLevelOne(ProductOptionVO option){
		List<ProductSubOptionRsVO> list = new ArrayList<ProductSubOptionRsVO>();
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(ProductSubOptionVO suboptionVo : option.getSubOptionList()){
				ProductSubOptionRsVO suboption = new ProductSubOptionRsVO();
				suboption.setSuboption1Id(suboptionVo.getProductSuboptionId().intValue());
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
						suboption.setSuboption2Id(suboptionVo.getProductSuboptionId().intValue());
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
						suboption.setSuboption3Id(suboptionVo.getProductSuboptionId().intValue());
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
			criteria.andSuboption1IdEqualTo(suboption1);
		}
		if(suboption2 != null){
			criteria.andSuboption2IdEqualTo(suboption2);
		}
		if(suboption3 != null){
			criteria.andSuboption3IdEqualTo(suboption3);
		}
		ProductSubOptionRsDbObject deleteObj = new ProductSubOptionRsDbObject();
		deleteObj.setDeleteInd(GeneralUtils.NOT_DELETED);
		int rowsUpdated = productSubOptionRsDbObjectMapper.updateByExampleSelective(deleteObj, updateExample);
		
		//record dont exist, insert record
		if(rowsUpdated == 0){
			ProductSubOptionRsDbObject obj = new ProductSubOptionRsDbObject();
			obj.setProductId(productId);
			obj.setSuboption1Id(suboption1);
			obj.setSuboption2Id(suboption2);
			obj.setSuboption3Id(suboption3);
			obj.setDeleteInd(GeneralUtils.NOT_DELETED);
			productSubOptionRsDbObjectMapper.insertSelective(obj);
		}
	}
	
	public void deleteProduct(List<Integer> idList) {
		ProductDbObjectExample example = new ProductDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andProductIdIn(idList);
		ProductDbObject product = new ProductDbObject();
		product.setDeleteInd(GeneralUtils.DELETED);
		productDbObjectMapper.updateByExampleSelective(product, example);
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
			case 3:criteria.andSuboption3IdEqualTo(list.get(2));
			case 2:criteria.andSuboption2IdEqualTo(list.get(1));
			case 1:criteria.andSuboption1IdEqualTo(list.get(0));
			case 0:;
		}
		List<ProductSubOptionRsDbObject> result = productSubOptionRsDbObjectMapper.selectByExample(selectExample);
		//if not exist, add and return
		if(result == null || result.size() == 0){
			ProductSubOptionRsDbObject rs = new ProductSubOptionRsDbObject();
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
			return productSubOptionRsService.convertToProductSubOptionRsVO(Arrays.asList(rs)).get(0);
		}
		return productSubOptionRsService.convertToProductSubOptionRsVO(Arrays.asList(result.get(0))).get(0);
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
		distinctSuboptionIdList.addAll(duplicateSet); //remove duplicates from pass in list
		ProductSubOptionDbObjectExample selectExample = new ProductSubOptionDbObjectExample();
		selectExample.createCriteria().andProductIdEqualTo(productId).andProductSuboptionIdIn(distinctSuboptionIdList);
		List<ProductSubOptionDbObject> productSuboption = productSubOptionDbObjectMapper.selectByExample(selectExample);
		//if all id found in db
		if(productSuboption != null && productSuboption.size() == distinctSuboptionIdList.size()){
			List<Integer> optionIdList = new ArrayList<Integer>();
			for(ProductSubOptionDbObject suboption:productSuboption){
				optionIdList.add(suboption.getProductOptionId());
			}
			ProductOptionDbObjectExample selectOptionExample = new ProductOptionDbObjectExample();
			selectOptionExample.createCriteria().andProductOptionIdIn(optionIdList);
			selectOptionExample.setOrderByClause("name");
			List<ProductOptionDbObject> productOptionList = productOptionDbObjectMapper.selectByExample(selectOptionExample);
			List<Integer> suboptionOrderedList = new ArrayList<Integer>();
			for(ProductOptionDbObject option: productOptionList){
				for(ProductSubOptionDbObject suboption:productSuboption){
					if(option.getProductOptionId().equals(suboption.getProductOptionId())){
						suboptionOrderedList.add(suboption.getProductSuboptionId());
					}
				}
			}
			return suboptionOrderedList;
		}
		return null;
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
	
}
