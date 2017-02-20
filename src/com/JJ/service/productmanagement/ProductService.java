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

import com.JJ.controller.productmanagement.vo.OptionVo;
import com.JJ.controller.productmanagement.vo.ProductSubOptionRsVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.ProductMapper;
import com.JJ.dao.ProductimageMapper;
import com.JJ.dao.ProductoptionMapper;
import com.JJ.dao.ProductspecificationMapper;
import com.JJ.dao.ProductsuboptionMapper;
import com.JJ.dao.ProductsuboptionRsMapper;
import com.JJ.dao.ProducttagsMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.FileMeta;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.ProductimageExample;
import com.JJ.model.ProductimageWithBLOBs;
import com.JJ.model.Productoption;
import com.JJ.model.ProductoptionExample;
import com.JJ.model.Productspecification;
import com.JJ.model.ProductspecificationExample;
import com.JJ.model.Productsubcategory;
import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;
import com.JJ.model.ProductsuboptionRs;
import com.JJ.model.ProductsuboptionRsExample;
import com.JJ.model.Producttags;
import com.JJ.model.ProducttagsExample;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductService {
	private ProductMapper productMapper;
	private ProductoptionMapper productOptionMapper;
	private ProductsuboptionMapper productSubOptionMapper;
	private ProductimageMapper productImageMapper;
	private ProductspecificationMapper productSpecificationMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductOptionManagementService productOptionManagementService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private ProductsuboptionRsMapper productSuboptionRsMapper;
	private ProducttagsMapper productTagsMapper;
	private final static int thumbnail_width = 200;
	private final static int thumbnail_height = 200;
	@Autowired
	public ProductService(ProductMapper productMapper, 
			ProductoptionMapper productOptionMapper,ProductsuboptionMapper productSubOptionMapper,
			ProductimageMapper productImageMapper,ProductspecificationMapper productSpecificationMapper, 
			ProductOptionManagementService productOptionManagementService, ProducttagsMapper productTagsMapper,
			ProductSubOptionManagementService productSubOptionManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductsuboptionRsMapper productSuboptionRsMapper){
		this.productMapper = productMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productImageMapper = productImageMapper;
		this.productOptionMapper = productOptionMapper;
		this.productSubOptionMapper = productSubOptionMapper;
		this.productSpecificationMapper = productSpecificationMapper;
		this.productOptionManagementService = productOptionManagementService;
		this.productTagsMapper = productTagsMapper;
		this.productSubOptionManagementService = productSubOptionManagementService;
		this.productSuboptionRsMapper = productSuboptionRsMapper;
	}
	
	public List<Product> getAllProducts() {
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Product> productList = productMapper.selectByExample(productExample);
		Map<Integer, Productsubcategory> subcategoryMap =  getProductsubcategoryMap();
		if(productList != null && productList.size() > 0){
			for(Product product : productList){
				if(product.getSubcategoryid() != null && product.getSubcategoryid().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubcategoryid()));
				}
			}
		}
		return productList;
	}
	
	public Product getProductsById(Integer productId) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		if(productId != null){
			criteria.andProductidEqualTo(productId);
		}
		List<Product> productList = productMapper.selectByExample(productExample);
		if(productList != null && productList.size() > 0){
			return productList.get(0);
		}
		return new Product();
	}
	//-------------- START
	public List<ProductVo> getAllProductsByName(String name) {
		List<ProductVo> productVoList = new ArrayList<ProductVo>();
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductnameEqualTo(name);
		List<Product> productList = productMapper.selectByExample(productExample);
		//get suboptions
		if(productList.size() > 0) {
			for(Product product: productList) {
				ProductVo vo = new ProductVo();
				List<Productsuboption> suboptionList = productSubOptionManagementService.getAllProductsuboptionsByProductId(product.getProductid());
				if(suboptionList.size() > 0){
					Map<Integer, List<Productsuboption>> suboptionMap = new HashMap<Integer, List<Productsuboption>>();
					for(Productsuboption suboption: suboptionList) {
						Integer optionid = suboption.getProductoptionid();
						if(null == suboptionMap.get(optionid)) {
							List<Productsuboption> psoList = new ArrayList<Productsuboption>();
							psoList.add(suboption);
							suboptionMap.put(optionid, psoList);
						}else if(suboptionMap.get(optionid).size() > 0) {
							suboptionMap.get(optionid).add(suboption);
						}
					}
					
					List<OptionVo> optionvoList = new ArrayList<OptionVo>();
					for(Integer optionid: suboptionMap.keySet()){
						OptionVo option = new OptionVo();
						Productoption po = productOptionManagementService.findById(optionid);
						option.setOptionId(optionid);
						option.setOptionName(po.getName());
						//option.setSequence(po.getSequence());
						List<SubOptionVo> suboptionvoList = new ArrayList<SubOptionVo>();
						for(Productsuboption suboption: suboptionMap.get(optionid)){
							suboptionvoList.add(productSubOptionManagementService.convertSubOptionToVo(suboption));
						}
						option.setSubOptionList(suboptionvoList);
						optionvoList.add(option);
					}
					vo.setOptionList(optionvoList);
				}
				vo.setId(product.getProductid());
				vo.setProductName(product.getProductname());
				vo.setProductInfo(product.getDesciption());
				vo.setUnitPrice(product.getUnitprice());
				
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
	
	public ProductVo getProductVoById(Integer id) {
		ProductVo product = new ProductVo();
		List<ProductVo> productList = getAllProductVo(id);
		if(productList != null && productList.size() > 0){
			product = productList.get(0); 
		}
		return product;
	}
		
	public List<ProductVo> getAllProductVo(Integer id) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		if(id != null){
			criteria.andProductidEqualTo(id);
		}
		criteria.andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Product> productList = productMapper.selectByExample(productExample);
		List<ProductVo> productVoList = new ArrayList<ProductVo>();
		
		Map<Integer, Productsubcategory> subcategoryMap =  getProductsubcategoryMap();
		if(productList != null && productList.size() > 0){
			for(Product product : productList){
				//set category
				if(product.getSubcategoryid() != null && product.getSubcategoryid().intValue() > 0){
					product.setSubCategory(subcategoryMap.get(product.getSubcategoryid()));
				}
				//getProductImage
				List<ProductimageWithBLOBs> productImage = getProductImage(Arrays.asList(product.getProductid()));
				
				//get Product spec
				Productspecification productInfo =  getProductSpecification(product.getProductid());
				
				//get Product Option
				List<OptionVo> optionVoList = getOptionVoList(product.getProductid());
				Collections.sort(optionVoList,new OptionVoCompare());
				//get ProductTags
				List<String> tagsList = getProductTags(product.getProductid());
				//convert To productVo
				productVoList.add(convertToProductVo(product, productImage, productInfo, optionVoList, tagsList));
			}
		}
		return productVoList;
	}
	
	private List<String> getProductTags(Integer productid) {
		List<String> tagsList = new ArrayList<String>();
		ProducttagsExample example = new ProducttagsExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(productid);
		List<Producttags> dbList = productTagsMapper.selectByExample(example);
		if(dbList != null && dbList.size() > 0){
			for(Producttags tags : dbList){
				tagsList.add(tags.getName());
			}
		}
		return tagsList;
	}

	public SubOptionVo getSubOptionVo(Integer suboptionId){
		ProductsuboptionExample example = new ProductsuboptionExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductsuboptionidEqualTo(suboptionId);
		List<Productsuboption> productSubOptionList = productSubOptionMapper.selectByExample(example);
		if(productSubOptionList != null && productSubOptionList.size() > 0){
			return convertToSubOptionVo(productSubOptionList.get(0));
		}
		return new SubOptionVo();
	}
	private List<OptionVo> getOptionVoList(Integer productId){
		if(productId != null){
			List<OptionVo> optionVoList = new ArrayList<OptionVo>();
			List<Productoption> productOption = productOptionManagementService.getAllProductoptions();
			Map<Integer , Productoption> optionMap = new HashMap<Integer, Productoption>();
			Map<Integer, List<SubOptionVo>> suboptionMap = new HashMap<Integer, List<SubOptionVo>>();
			if(productOption != null && productOption.size() > 0){
				for(Productoption option : productOption){
					optionMap.put(option.getProductoptionid(), option);
				}
			}
			ProductsuboptionExample example = new ProductsuboptionExample();
			example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(productId);
			List<Productsuboption> productSubOptionList = productSubOptionMapper.selectByExample(example);
			if(productSubOptionList != null && productSubOptionList.size() > 0){
				for(Productsuboption suboption : productSubOptionList){
					if(!suboptionMap.containsKey(suboption.getProductoptionid())){
						suboptionMap.put(suboption.getProductoptionid(), new ArrayList<SubOptionVo>());
					}
					suboptionMap.get(suboption.getProductoptionid()).add(convertToSubOptionVo(suboption));
				}
				
				if(!suboptionMap.isEmpty()){
					for(Integer key : suboptionMap.keySet()){
						Productoption option = optionMap.get(key);
						if(option != null){
							OptionVo optionVo = convertToOptionVo(option);
							optionVo.setSubOptionList(suboptionMap.get(key));
							optionVoList.add(optionVo);
						}
					}
				}
				return optionVoList;
			}
			
		}
		return new ArrayList<OptionVo>();
	}
	
	private OptionVo convertToOptionVo(Productoption option){
		OptionVo optionVo = new OptionVo();
		if(option != null){
			optionVo.setOptionId(option.getProductoptionid());
			optionVo.setOptionName(option.getName());
			//optionVo.setSequence(option.getSequence());
		}
		return optionVo;
	}
	private SubOptionVo convertToSubOptionVo(Productsuboption suboption){
		SubOptionVo subOptionVo = new SubOptionVo();
		if(suboption != null){
			subOptionVo.setDisplay(suboption.getDisplayind()== null ? false: suboption.getDisplayind().booleanValue());
			subOptionVo.setSubOptionId(suboption.getProductsuboptionid());
			subOptionVo.setSubOptionName(suboption.getName());
		}
		return subOptionVo;
	}
	private Productspecification getProductSpecification(Integer productId){
		if(productId != null && productId.intValue() > 0){
			ProductspecificationExample example = new ProductspecificationExample();
			example.createCriteria().andProductidEqualTo(productId).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
			List<Productspecification> productSpecificationList = productSpecificationMapper.selectByExampleWithBLOBs(example);
			if(productSpecificationList != null && productSpecificationList.size() > 0){
				return productSpecificationList.get(0);
			}
		}
		return new Productspecification();
	}
	private List<ProductimageWithBLOBs> getProductImage(List<Integer> productIdList){
		List<ProductimageWithBLOBs> productImageList = new ArrayList<ProductimageWithBLOBs>();
		if(productIdList != null && productIdList.size() > 0){
			ProductimageExample example = new ProductimageExample();
			example.createCriteria().andProductidIn(productIdList).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
			productImageList = productImageMapper.selectByExampleWithBLOBs(example);
		}
		return productImageList;
	}
	private ProductVo convertToProductVo(Product product, List<ProductimageWithBLOBs> productImageList, Productspecification productInfo, List<OptionVo> optionVoList, List<String> productTagsList){
		ProductVo productVo = new ProductVo();
		if(product != null){
			productVo.setId(product.getProductid());
			productVo.setProductName(product.getProductname());
			productVo.setUnitPrice(product.getUnitprice());
			productVo.setWeight(product.getWeight());
			productVo.setSubcategoryId(product.getSubcategoryid());
			productVo.setProductInfo(productInfo.getContent());
			productVo.setImages(convertToFileMetaList(productImageList));
			productVo.setOptionList(optionVoList);
			productVo.setTags(productTagsList);
			productVo.setProductCode(product.getProductcode());
		}
		return productVo;
	}
	
	private LinkedList<FileMeta> convertToFileMetaList(List<ProductimageWithBLOBs> productImageList){
		LinkedList<FileMeta> fileMetaList = new LinkedList<FileMeta>();
		if(productImageList != null && productImageList.size() > 0){
			for(ProductimageWithBLOBs image : productImageList){
				FileMeta fileMeta = new FileMeta();
				fileMeta.setBytes(image.getImage());
				fileMeta.setFileSize(image.getImage().length+"");
				fileMeta.setFileName(image.getImagename());
				fileMeta.setImageId(image.getImageid());
				fileMeta.setSequence(image.getSequence());
				fileMeta.setFileType(image.getFiletype());
				fileMeta.setThumbnail(image.getThumbnailimage());
				fileMetaList.add(fileMeta);
			}
		}
		return fileMetaList;
	}
	
	
	public List<Product> getAllProductsBySubCategory(Integer id) {
		ProductExample productExample = new ProductExample();
		productExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andSubcategoryidEqualTo(id);
		List<Product> productList = productMapper.selectByExample(productExample);
		return productList;
	}
	
	private Map<Integer, Productsubcategory> getProductsubcategoryMap(){
		List<Productsubcategory> subcatergoryList = productSubCategoryManagementService.getAllSubCategories();
		Map<Integer, Productsubcategory> map = new HashMap<Integer, Productsubcategory>();
		if(subcatergoryList != null && subcatergoryList.size() > 0){
			for(Productsubcategory subcategory : subcatergoryList){
				map.put(subcategory.getId(), subcategory);
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
	
	public void saveProduct(ProductVo productVo){
		Product product = convertToProduct(productVo);
		//insert into product table
		if(product.getProductid() != null){
			productMapper.updateByPrimaryKeySelective(product);
		}else{
			productMapper.insertSelective(product);
		}
		//option
		saveOption(productVo, product.getProductid());
		//productinfo
		saveProductInfo(productVo, product.getProductid());
		//image
		saveProductImage(productVo, product.getProductid());
		//tags
		saveProductTags(productVo, product.getProductid());
	}
	
	private void saveProductTags(ProductVo productVo, Integer productid) {
		//delete all tags not in tags list
		ProducttagsExample deleteExample = new ProducttagsExample();
		ProducttagsExample.Criteria criteria = deleteExample.createCriteria();
		criteria.andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(productid);
		if(productVo.getTags() != null && !productVo.getTags().isEmpty()){
			criteria.andNameNotIn(productVo.getTags());
		}
		Producttags tags = new Producttags();
		tags.setDeleteind(GeneralUtils.DELETED);
		productTagsMapper.updateByExampleSelective(tags, deleteExample);
		if(productVo.getTags() != null && !productVo.getTags().isEmpty()){
			//get all active tags
			ProducttagsExample selectExample = new ProducttagsExample();
			selectExample.createCriteria().andNameIn(productVo.getTags()).andProductidEqualTo(productid).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
			List<Producttags> productTagsList = productTagsMapper.selectByExample(selectExample);
			if(productTagsList != null && !productTagsList.isEmpty()){
				//remove exists tags from list
				for(Producttags productTags : productTagsList){
					productVo.getTags().remove(productTags.getName());
				}
			}
			//insert those non exist tags
			List<Producttags> dbList = convertToProductTags(productVo.getTags(), productid);
			for(Producttags dbTags : dbList){
				productTagsMapper.insert(dbTags);
			}
		}
		
	}
	
	private List<Producttags> convertToProductTags(List<String> tagsList, Integer productId){
		List<Producttags> dbList = new ArrayList<Producttags>();
		if(tagsList != null && !tagsList.isEmpty()){
			for(String tag: tagsList){
				Producttags dbTag = new Producttags();
				dbTag.setName(tag);
				dbTag.setProductid(productId);
				dbTag.setDeleteind(GeneralUtils.NOT_DELETED);
				dbList.add(dbTag);
			}
		}
		return dbList;
	}

	private void saveProductImage(ProductVo productVo, Integer productId){
		//delete all images
		ProductimageExample deleteExample = new ProductimageExample();
		deleteExample.createCriteria().andProductidEqualTo(productId);
		ProductimageWithBLOBs obj = new ProductimageWithBLOBs();
		obj.setDeleteind(GeneralUtils.DELETED);
		productImageMapper.updateByExampleSelective(obj, deleteExample);
		//table image
		LinkedList<FileMeta> images = productVo.getImages();
		List<ProductimageWithBLOBs> productImages = convertToProductImage(productId,images);
		for(ProductimageWithBLOBs productImage : productImages){
			productImage.setDeleteind(GeneralUtils.NOT_DELETED);
			if(productImage.getImageid() != null){
				productImageMapper.updateByPrimaryKeySelective(productImage);
			}else{
				productImageMapper.insertSelective(productImage);
			}
		}
	}
	
	private void saveProductInfo(ProductVo productVo, Integer productId){
		ProductspecificationExample selectSpecExample = new ProductspecificationExample();
		selectSpecExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(productId);
		List<Productspecification> specList = productSpecificationMapper.selectByExample(selectSpecExample);
		//if already exisit, then  update
		Productspecification spec = new Productspecification();
		spec.setContent(productVo.getProductInfo());
		if(specList != null && specList.size() > 0){
			productSpecificationMapper.updateByExampleSelective(spec, selectSpecExample);
		}else{
			//insert
			spec.setProductid(productId);
			spec.setDeleteind(GeneralUtils.NOT_DELETED);
			productSpecificationMapper.insertSelective(spec);
		}
	}
	private void saveOption(ProductVo productVo, Integer productId){
		
		//find product option
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			//get all name
			List<String> optionNameList = new ArrayList<String>();
			Map<String, OptionVo> optionMap = new HashMap<String, OptionVo>();
			for(OptionVo optionVo : productVo.getOptionList()){
				optionVo.setOptionId(null);
				optionMap.put(optionVo.getOptionName(), optionVo);
			}
			optionNameList.addAll(optionMap.keySet());
			//search exists productoption
			ProductoptionExample example = new ProductoptionExample();
			example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andNameIn(optionNameList);
			List<Productoption> productOptionList = productOptionMapper.selectByExample(example);
			
			//set id for existing optionVo
			if(productOptionList != null && productOptionList.size() > 0){
				for(Productoption productOption : productOptionList){
					OptionVo optionVo = optionMap.get(productOption.getName());
					//reset all optionId
					optionVo.setOptionId(null);
					/*if(optionVo != null && productOption.getSequence().compareTo(optionVo.getSequence())== 0){
						optionVo.setOptionId(productOption.getProductoptionid());
					}*/
				}
			}
			//find non exist productoption
			List<OptionVo> newOptionVo = new ArrayList<OptionVo>();
			for(OptionVo optionVo : productVo.getOptionList()){
				if(optionVo.getOptionId() == null){
					newOptionVo.add(optionVo);
				}
			}
			
			//insert into productOption
			List<Productoption> newProductOptionList = convertToProductOption(newOptionVo);
			for(Productoption productOption : newProductOptionList){
				productOptionMapper.insert(productOption);
				OptionVo optionVo = optionMap.get(productOption.getName());
				//set id for newly created optionVo
				if(optionVo != null){
					optionVo.setOptionId(productOption.getProductoptionid());
				}
			}
		}
		//product suboption
		//set all deleteInd to true
		ProductsuboptionExample example = new ProductsuboptionExample();
		example.createCriteria().andProductidEqualTo(productId);
		Productsuboption subOption = new Productsuboption();
		subOption.setDeleteind(GeneralUtils.DELETED);
		productSubOptionMapper.updateByExampleSelective(subOption, example);
		
		
		//get all subOption
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			List<Productsuboption> productSubOptionList = new ArrayList<Productsuboption>();
			for(OptionVo optionVo : productVo.getOptionList()){
				if(optionVo.getSubOptionList() != null && optionVo.getSubOptionList().size() > 0){
					productSubOptionList.addAll(convertToProductsuboption(productId, optionVo.getOptionId(), optionVo.getSubOptionList()));
				}
			}
			//delete if empty productsuboption exsits
			ProductsuboptionExample deleteExample = new ProductsuboptionExample();
			deleteExample.createCriteria().andProductidEqualTo(productId).andProductoptionidEqualTo(0).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
			Productsuboption updateProductSubOption = new Productsuboption();
			updateProductSubOption.setDeleteind(GeneralUtils.DELETED);
			productSubOptionMapper.updateByExample(updateProductSubOption, deleteExample);
			
			//insert into productsuboption
			
			for(Productsuboption productSubOption : productSubOptionList){
				//update
				if(productSubOption.getProductsuboptionid() != null){
					productSubOptionMapper.updateByPrimaryKeySelective(productSubOption);
				}else{
					//insert
					productSubOptionMapper.insert(productSubOption);
					//set id back to suboptionVo
					A:
					for(OptionVo optionVo : productVo.getOptionList()){
						if(optionVo.getOptionId() != null && productSubOption.getProductoptionid() != null &&
								optionVo.getOptionId().compareTo(productSubOption.getProductoptionid()) == 0){
							for(SubOptionVo suboptionVO : optionVo.getSubOptionList()){
								if(suboptionVO.getSubOptionId() == null 
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
			ProductsuboptionExample selectExample = new ProductsuboptionExample();
			selectExample.createCriteria().andProductidEqualTo(productId).andProductoptionidEqualTo(0);
			List<Productsuboption> productSubOptionList = productSubOptionMapper.selectByExample(selectExample);
			//insert empty suboption if dont exists
			if(productSubOptionList == null || productSubOptionList.size() == 0){
				Productsuboption productSubOption = new Productsuboption();
				productSubOption.setDeleteind(GeneralUtils.NOT_DELETED);
				productSubOption.setCode(" ");
				productSubOption.setProductid(productId);
				productSubOption.setProductoptionid(0);
				productSubOptionMapper.insert(productSubOption);
			}
		}
		
		//maintain productsuboption_rs
		/*productVo.setId(productId);
		saveProductSubOptionRs(productVo);*/
	}
	
	/*private void saveProductSubOptionRs(ProductVo productVo) {
		
		//find if product suboption rs exists
		//set delete ind to true for all suboption
		ProductsuboptionRsExample deleteExample = new ProductsuboptionRsExample();
		deleteExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(productVo.getId());
		ProductsuboptionRs obj = new ProductsuboptionRs();
		obj.setDeleteind(GeneralUtils.DELETED);
		productSuboptionRsMapper.updateByExampleSelective(obj, deleteExample);
		
		//if suboption exists
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			//sort optionVO
			Collections.sort(productVo.getOptionList(),new OptionVoCompare());
			//todo generate matrix
			List<ProductsuboptionRs> productSuboptionRsList = new ArrayList<ProductsuboptionRs>();
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
			for(ProductsuboptionRs dbObj : productSuboptionRsList){
				insertOrUpdateProductSuboptionRs(productVo.getId(), dbObj.getSuboption1id(), dbObj.getSuboption2id(),dbObj.getSuboption3id());
			}
			
		}else{
			insertOrUpdateProductSuboptionRs(productVo.getId(), null, null, null);
		}
		
		//delete non used records
		ProductsuboptionRsExample deleteRsExample = new ProductsuboptionRsExample();
		ProductsuboptionRsExample.Criteria criteria = deleteRsExample.createCriteria();
		criteria.andDeleteindEqualTo(GeneralUtils.DELETED);
		//TODO delete those not used id
		productSuboptionRsMapper.deleteByExample(deleteRsExample);
	}
	
	private List<ProductsuboptionRs> generateLevelOne(OptionVo option){
		List<ProductsuboptionRs> list = new ArrayList<ProductsuboptionRs>();
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(SubOptionVo suboptionVo : option.getSubOptionList()){
				ProductsuboptionRs suboption = new ProductsuboptionRs();
				suboption.setSuboption1id(suboptionVo.getSubOptionId());
				list.add(suboption);
			}
		}
		return list;
	}
	
	private List<ProductsuboptionRs> generateLevelTwo(OptionVo option, List<ProductsuboptionRs> list){
		List<ProductsuboptionRs> list2 = new ArrayList<ProductsuboptionRs>();
		
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(SubOptionVo suboptionVo : option.getSubOptionList()){
				if(list != null && list.size() > 0){
					for(ProductsuboptionRs suboption1 : list){
						ProductsuboptionRs suboption = new ProductsuboptionRs();
						suboption.setSuboption1id(suboption1.getSuboption1id());
						suboption.setSuboption2id(suboptionVo.getSubOptionId());
						list2.add(suboption);
					}
				}
			}
		}
		return list2;
	}
	private List<ProductsuboptionRs> generateLevelThree(OptionVo option, List<ProductsuboptionRs> list){
		List<ProductsuboptionRs> list2 = new ArrayList<ProductsuboptionRs>();
		
		if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(SubOptionVo suboptionVo : option.getSubOptionList()){
				if(list != null && list.size() > 0){
					for(ProductsuboptionRs suboption1 : list){
						ProductsuboptionRs suboption = new ProductsuboptionRs();
						suboption.setSuboption1id(suboption1.getSuboption1id());
						suboption.setSuboption2id(suboption1.getSuboption2id());
						suboption.setSuboption3id(suboptionVo.getSubOptionId());
						list2.add(suboption);
					}
				}
			}
		}
		return list2;
	}
	
	private void insertOrUpdateProductSuboptionRs(Integer productId, Integer suboption1, Integer suboption2, Integer suboption3){
		ProductsuboptionRsExample updateExample = new ProductsuboptionRsExample();
		ProductsuboptionRsExample.Criteria criteria = updateExample.createCriteria();
		criteria.andProductidEqualTo(productId);
		if(suboption1 != null){
			criteria.andSuboption1idEqualTo(suboption1);
		}
		if(suboption2 != null){
			criteria.andSuboption2idEqualTo(suboption2);
		}
		if(suboption3 != null){
			criteria.andSuboption3idEqualTo(suboption3);
		}
		ProductsuboptionRs deleteObj = new ProductsuboptionRs();
		deleteObj.setDeleteind(GeneralUtils.NOT_DELETED);
		int rowsUpdated = productSuboptionRsMapper.updateByExampleSelective(deleteObj, updateExample);
		
		//record dont exist, insert record
		if(rowsUpdated == 0){
			ProductsuboptionRs obj = new ProductsuboptionRs();
			obj.setProductid(productId);
			obj.setSuboption1id(suboption1);
			obj.setSuboption2id(suboption2);
			obj.setSuboption3id(suboption3);
			obj.setDeleteind(GeneralUtils.NOT_DELETED);
			productSuboptionRsMapper.insertSelective(obj);
		}
	}*/

	private Product convertToProduct(ProductVo productVo){
		Product product = new Product();
		product.setProductid(productVo.getId());
		product.setProductcode(productVo.getProductCode());
		product.setUnitprice(productVo.getUnitPrice());
		product.setWeight(productVo.getWeight());
		product.setProductname(productVo.getProductName());
		product.setUnitprice(productVo.getUnitPrice());
		product.setSubcategoryid(productVo.getSubcategoryId());
		product.setDeleteind(GeneralUtils.NOT_DELETED);
		return product;
	}
	
	private List<Productoption> convertToProductOption(List<OptionVo> optionList){
		List<Productoption> productOptionList = new ArrayList<Productoption>();
		if(optionList != null  && optionList.size() > 0){
			for(OptionVo optionVo : optionList){
				Productoption productOption = new Productoption();
				productOption.setProductoptionid(optionVo.getOptionId());
//				productOption.setSequence(optionVo.getSequence());
				productOption.setName(optionVo.getOptionName());
				productOption.setDeleteind(GeneralUtils.NOT_DELETED);
				productOption.setDisplayind(true);
				productOptionList.add(productOption);
			}
		}
		return productOptionList;
	}
	
	private List<Productsuboption> convertToProductsuboption(Integer productId, Integer optionId, List<SubOptionVo> subOptionList){
		List<Productsuboption> productOptionList = new ArrayList<Productsuboption>();
		if(subOptionList != null && subOptionList.size() > 0){
			for(SubOptionVo subOption : subOptionList){
				Productsuboption productSubOption = new Productsuboption();
				productSubOption.setProductsuboptionid(subOption.getSubOptionId());
				productSubOption.setProductid(productId);
				productSubOption.setCode(subOption.getCode());
				productSubOption.setProductoptionid(optionId);
				productSubOption.setName(subOption.getSubOptionName());
				productSubOption.setDeleteind(GeneralUtils.NOT_DELETED);
				productSubOption.setDisplayind(subOption.isDisplay());
				productOptionList.add(productSubOption);
			}
		}
		return productOptionList;
	}
	
	private List<ProductimageWithBLOBs> convertToProductImage(Integer productId,List<FileMeta> images){
		List<ProductimageWithBLOBs> productImages = new ArrayList<ProductimageWithBLOBs>();
		if(images != null && images.size() > 0 && productId != null){
			for(FileMeta image : images){
				ProductimageWithBLOBs productImage = new ProductimageWithBLOBs();
				productImage.setImageid(image.getImageId());
				productImage.setProductid(productId);
				productImage.setImagename(image.getFileName());
				productImage.setSequence(image.getSequence());
				productImage.setFiletype(image.getFileType());
				if(image.getImageId() != null && image.getImageId().intValue() > 0){
					
				}else{
					productImage.setImage(image.getBytes());
					productImage.setThumbnailimage(getThumbnail(image.getBytes(), thumbnail_width, thumbnail_height));
				}
				productImages.add(productImage);
			}
		}
		return productImages;
	}
	
	public void deleteProduct(List<Integer> idList) {
		ProductExample example = new ProductExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidIn(idList);
		Product product = new Product();
		product.setDeleteind(GeneralUtils.DELETED);
		productMapper.updateByExampleSelective(product, example);
	}
	
	public ProductimageWithBLOBs getCoverImageByProductId(Integer productId){
		ProductimageExample selectExample = new ProductimageExample();
		selectExample.createCriteria().andProductidEqualTo(productId).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		selectExample.setOrderByClause("sequence");
		List<ProductimageWithBLOBs> productImageList = productImageMapper.selectByExampleWithBLOBs(selectExample);
		if(productImageList != null && productImageList.size() > 0){
			return productImageList.get(0);
		}else{
			return null;
		}
	}
	
	public class OptionVoCompare implements Comparator<OptionVo>{
		@Override
		public int compare(OptionVo o1, OptionVo o2) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public ProductsuboptionRs findProductSubOptionRs(Integer productId, List<Integer> suboptionIdList){
		//check suboption belong to product, reorder by option
		List<Integer> list = checkValidProductSubOption(productId, suboptionIdList);
		if(list == null){
			return new ProductsuboptionRs();
		}
		
		//check against productSuboption
		ProductsuboptionRsExample selectExample = new ProductsuboptionRsExample();
		ProductsuboptionRsExample.Criteria criteria = selectExample.createCriteria();
		criteria.andProductidEqualTo(productId);
		int size = list.size();
		switch(size){
			case 3:criteria.andSuboption3idEqualTo(list.get(2));
			case 2:criteria.andSuboption2idEqualTo(list.get(1));
			case 1:criteria.andSuboption1idEqualTo(list.get(0));
			case 0:;
		}
		List<ProductsuboptionRs> result = productSuboptionRsMapper.selectByExample(selectExample);
		//if not exist, add and return
		if(result == null || result.size() == 0){
			ProductsuboptionRs rs = new ProductsuboptionRs();
			rs.setDeleteind(GeneralUtils.NOT_DELETED);
			rs.setVersion(1);
			rs.setProductid(productId);
			switch(size){
				case 3:rs.setSuboption3id(list.get(2));
				case 2:rs.setSuboption2id(list.get(1));
				case 1:rs.setSuboption1id(list.get(0));
				case 0:;
			}
			productSuboptionRsMapper.insert(rs);
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
		ProductsuboptionExample selectExample = new ProductsuboptionExample();
		selectExample.createCriteria().andProductidEqualTo(productId).andProductsuboptionidIn(distinctSuboptionIdList);
		List<Productsuboption> productSuboption = productSubOptionMapper.selectByExample(selectExample);
		if(productSuboption != null && productSuboption.size() == distinctSuboptionIdList.size()){
			List<Integer> optionIdList = new ArrayList<Integer>();
			for(Productsuboption suboption:productSuboption){
				optionIdList.add(suboption.getProductoptionid());
			}
			ProductoptionExample selectOptionExample = new ProductoptionExample();
			selectOptionExample.createCriteria().andProductoptionidIn(optionIdList);
			selectOptionExample.setOrderByClause("name");
			List<Productoption> productOptionList = productOptionMapper.selectByExample(selectOptionExample);
			List<Integer> suboptionOrderedList = new ArrayList<Integer>();
			for(Productoption option: productOptionList){
				for(Productsuboption suboption:productSuboption){
					if(option.getProductoptionid().equals(suboption.getProductoptionid())){
						suboptionOrderedList.add(suboption.getProductsuboptionid());
					}
				}
			}
			return suboptionOrderedList;
		}
		return null;
	}
	
	public ProductSubOptionRsVo getProductSubOptionVo(Integer productSubOptionId){
		ProductsuboptionRsExample selectExample = new ProductsuboptionRsExample();
		selectExample.createCriteria().andProductidEqualTo(productSubOptionId).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductsuboptionRs> result = productSuboptionRsMapper.selectByExample(selectExample);
		
		if(result != null && result.size() > 0){
			ProductsuboptionRs obj = result.get(0);
			ProductSubOptionRsVo vo = new ProductSubOptionRsVo();
			vo.setProductsuboptionid(obj.getProductsuboptionid());
			vo.setProductid(obj.getProductid());
			vo.setSuboption1id(obj.getSuboption1id());
			vo.setSuboption2id(obj.getSuboption2id());
			vo.setSuboption3id(obj.getSuboption3id());
			List<OptionVo> allOptionVo = getOptionVoList(obj.getProductid());
			if(vo.getSuboption1id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(OptionVo option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(SubOptionVo suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getSubOptionId().equals(vo.getSuboption1id())){
								OptionVo option1 = new OptionVo();
								option1.setOptionId(option.getOptionId());
								option1.setOptionName(option.getOptionName());
								option1.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSubOption1(option1);
								break;
							}
						}
					}
				}
			}
			
			if(vo.getSuboption2id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(OptionVo option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(SubOptionVo suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getSubOptionId().equals(vo.getSuboption2id())){
								OptionVo option2 = new OptionVo();
								option2.setOptionId(option.getOptionId());
								option2.setOptionName(option.getOptionName());
								option2.setSubOptionList(Arrays.asList(suboptionVo));
								vo.setSubOption2(option2);
								break;
							}
						}
					}
				}
			}
			
			if(vo.getSuboption3id() != null && allOptionVo != null && allOptionVo.size() > 0){
				for(OptionVo option: allOptionVo){
					if(option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
						for(SubOptionVo suboptionVo :option.getSubOptionList()){
							if(suboptionVo.getSubOptionId().equals(vo.getSuboption3id())){
								OptionVo option3 = new OptionVo();
								option3.setOptionId(option.getOptionId());
								option3.setOptionName(option.getOptionName());
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
		return new ProductSubOptionRsVo();
	}
	
	public ProductsuboptionRs getProductsuboptionRsById(Integer productsuboptionid) {
		return productSuboptionRsMapper.selectByPrimaryKey(productsuboptionid);
	}
}
