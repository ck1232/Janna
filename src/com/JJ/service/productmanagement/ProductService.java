package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.productmanagement.vo.OptionVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.ProductMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.ProductExample;
import com.JJ.model.Productoption;
import com.JJ.model.Productsubcategory;
import com.JJ.model.Productsuboption;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional
public class ProductService {
	private ProductMapper productMapper;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductOptionManagementService productOptionManagementService;
	private ProductSubOptionManagementService productSubOptionManagementService;
//	private ImageStagingService imageStagingService;
	@Autowired
	public ProductService(ProductMapper productMapper, 
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductOptionManagementService productOptionManagementService,
			ProductSubOptionManagementService productSubOptionManagementService
//			,ImageStagingService imageStagingService
			){
		this.productMapper = productMapper;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productOptionManagementService = productOptionManagementService;
		this.productSubOptionManagementService = productSubOptionManagementService;
//		this.imageStagingService = imageStagingService;
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
						option.setSequence(po.getSequence());
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
}
