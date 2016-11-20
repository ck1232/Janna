package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.OptionVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.ProductMapper;
import com.JJ.dao.ProductimageMapper;
import com.JJ.dao.ProductoptionMapper;
import com.JJ.dao.ProductspecificationMapper;
import com.JJ.dao.ProductsuboptionMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.FileMeta;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.ProductimageWithBLOBs;
import com.JJ.model.Productoption;
import com.JJ.model.ProductoptionExample;
import com.JJ.model.Productspecification;
import com.JJ.model.ProductspecificationExample;
import com.JJ.model.Productsubcategory;
import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ProductService {
	private ProductMapper productMapper;
	private ProductoptionMapper productOptionMapper;
	private ProductsuboptionMapper productSubOptionMapper;
	private ProductimageMapper productImageMapper;
	private ProductspecificationMapper productSpecificationMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	@Autowired
	public ProductService(ProductMapper productMapper, ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductoptionMapper productOptionMapper,ProductsuboptionMapper productSubOptionMapper,
			ProductimageMapper productImageMapper,ProductspecificationMapper productSpecificationMapper){
		this.productMapper = productMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productImageMapper = productImageMapper;
		this.productOptionMapper = productOptionMapper;
		this.productSubOptionMapper = productSubOptionMapper;
		this.productSpecificationMapper = productSpecificationMapper;
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
		//find product option
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			//get all name
			List<String> optionNameList = new ArrayList<String>();
			Map<String, OptionVo> optionMap = new HashMap<String, OptionVo>();
			for(OptionVo optionVo : productVo.getOptionList()){
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
					if(optionVo != null){
						optionVo.setOptionId(productOption.getProductoptionid());
					}
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
		example.createCriteria().andProductidEqualTo(product.getProductid());
		Productsuboption subOption = new Productsuboption();
		subOption.setDeleteind(GeneralUtils.DELETED);
		productSubOptionMapper.updateByExampleSelective(subOption, example);
		
		
		//get all subOption
		if(productVo.getOptionList() != null && productVo.getOptionList().size() > 0){
			List<Productsuboption> productSubOptionList = new ArrayList<Productsuboption>();
			for(OptionVo optionVo : productVo.getOptionList()){
				if(optionVo.getSubOptionList() != null && optionVo.getSubOptionList().size() > 0){
					productSubOptionList.addAll(convertToProductsuboption(product.getProductid(), optionVo.getOptionId(), optionVo.getSubOptionList()));
				}
			}
			//delete if empty productsuboption exsits
			ProductsuboptionExample deleteExample = new ProductsuboptionExample();
			deleteExample.createCriteria().andProductidEqualTo(product.getProductid()).andProductoptionidEqualTo(0).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
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
				}
			}
		}else{
			//insert empty suboption
			//select if empty productsuboption exsits
			ProductsuboptionExample selectExample = new ProductsuboptionExample();
			selectExample.createCriteria().andProductidEqualTo(product.getProductid()).andProductoptionidEqualTo(0);
			List<Productsuboption> productSubOptionList = productSubOptionMapper.selectByExample(selectExample);
			//insert empty suboption if dont exists
			if(productSubOptionList == null || productSubOptionList.size() == 0){
				Productsuboption productSubOption = new Productsuboption();
				productSubOption.setDeleteind(GeneralUtils.NOT_DELETED);
				productSubOption.setProductid(product.getProductid());
				productSubOption.setProductoptionid(0);
				productSubOptionMapper.insert(productSubOption);
			}
		}
		//productinfo
		ProductspecificationExample selectSpecExample = new ProductspecificationExample();
		selectSpecExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andProductidEqualTo(product.getProductid());
		List<Productspecification> specList = productSpecificationMapper.selectByExample(selectSpecExample);
		//if already exisit, then  update
		Productspecification spec = new Productspecification();
		if(specList != null && specList.size() > 0){
			spec.setContent(productVo.getProductInfo());
			productSpecificationMapper.updateByExampleSelective(spec, selectSpecExample);
		}else{
			//insert
			spec.setProductid(product.getProductid());
			spec.setDeleteind(GeneralUtils.NOT_DELETED);
			productSpecificationMapper.insertSelective(spec);
		}
		//table image
		LinkedList<FileMeta> images = productVo.getImages();
		List<ProductimageWithBLOBs> productImages = convertToProductImage(productVo.getId(),images);
		for(ProductimageWithBLOBs productImage : productImages){
			if(productImage.getImageid() != null){
				productImageMapper.updateByPrimaryKeySelective(productImage);
			}else{
				productImageMapper.insertSelective(productImage);
			}
		}
	}
	
	private Product convertToProduct(ProductVo productVo){
		Product product = new Product();
		product.setProductid(productVo.getId());
		product.setProductname(productVo.getProductName());
		product.setUnitprice(productVo.getUnitPrice());
		product.setSubcategoryid(productVo.getSubcategoryId());
		product.setDeleteind(GeneralUtils.NOT_DELETED);
		return product;
	}
	
	private List<Productoption> convertToProductOption(List<OptionVo> optionList){
		List<Productoption> productOptionList = new ArrayList<Productoption>();
		if(optionList != null  && optionList.size() != 0){
			for(OptionVo optionVo : optionList){
				Productoption productOption = new Productoption();
				productOption.setName(optionVo.getOptionName());
				productOption.setDeleteind(GeneralUtils.NOT_DELETED);
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
				productSubOption.setProductoptionid(optionId);
				productSubOption.setName(subOption.getSubOptionName());
				productSubOption.setDeleteind(GeneralUtils.NOT_DELETED);
				productSubOption.setDisplayind(subOption.isDisplay());
				productSubOption.setSequence(subOption.getSeq());
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
				productImage.setSequence(image.getSequence());
				if(image.getImageId() != null && image.getImageId().intValue() > 0){
					
				}else{
					productImage.setImage(image.getBytes());
				}
			}
		}
		return productImages;
	}
}
