package com.JJ.controller.inventorymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.productmanagement.vo.ProductSubOptionRsVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.Productinventory;
import com.JJ.model.Storagelocation;
import com.JJ.model.ViewProductInventory;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/inventoryhistory")
public class InventoryHistoryManagementController {
	private static final Logger logger = Logger.getLogger(InventoryHistoryManagementController.class);
	
	private InventoryProductManagementService inventoryProductManagementService;
	private ProductService productService;
	private StorageLocationManagementService storageLocationManagementService;
	
	@Autowired
	public InventoryHistoryManagementController(InventoryProductManagementService inventoryProductManagementService,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService) {
		this.inventoryProductManagementService = inventoryProductManagementService;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
	}
	
	
	@RequestMapping(value = "/listInventoryHistory", method = RequestMethod.GET)  
    public String listInventoryHistory() {  
    	logger.debug("loading listInventoryHistory");
        return "listInventoryHistory";  
    }  
	
	private HashMap<Integer, Product> convertToHashMapForProduct(List<Product> productList) {
		HashMap<Integer, Product> productHash = new HashMap<Integer, Product>();
		for(Product product : productList) {
			productHash.put(product.getProductid(), product);
		}
		return productHash;
	}
	
	private HashMap<Integer, ProductSubOptionRsVo> convertToHashMapForProductSubOption(List<ProductSubOptionRsVo> voList) {
		HashMap<Integer, ProductSubOptionRsVo> voHash = new HashMap<Integer, ProductSubOptionRsVo>();
		for(ProductSubOptionRsVo vo : voList) {
			voHash.put(vo.getProductsuboptionid(), vo);
		}
		return voHash;
	}
	
	private HashMap<Integer, Storagelocation> convertToHashMapForStoragelocation(List<Storagelocation> locationList) {
		HashMap<Integer, Storagelocation> locationHash = new HashMap<Integer, Storagelocation>();
		for(Storagelocation location : locationList) {
			locationHash.put(location.getLocationid(), location);
		}
		return locationHash;
	}
	
	private List<Productinventory> combineProductInventoryInfo(List<Productinventory> productInventoryList, 
			List<Product> productList,
			List<ProductSubOptionRsVo> productSuboptionList,
			List<Storagelocation> storageLocationList){
		
		HashMap<Integer, Product> productHash = convertToHashMapForProduct(productList);
		HashMap<Integer, ProductSubOptionRsVo> productSuboptionHash = convertToHashMapForProductSubOption(productSuboptionList);
		HashMap<Integer, Storagelocation> locationHash = convertToHashMapForStoragelocation(storageLocationList);
		for(Productinventory productInventory : productInventoryList) {
			productInventory.setProductSuboption(productSuboptionHash.get(productInventory.getProductsuboptionid()));
			Product product = productHash.get(productInventory.getProductSuboption().getProductid());
			ProductVo productvo = new ProductVo();
			productvo.setProductName(product.getProductname());
			productInventory.getProductSuboption().setProduct(productvo);
			productInventory.setFromLocation(locationHash.get(productInventory.getTransferfrom()));
			productInventory.setToLocation(locationHash.get(productInventory.getTransferto()));
			productInventory.setLocation();
			productInventory.setProduct();
		}
		
		return productInventoryList;
	}
	
	@RequestMapping(value = "/getInventoryHistoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory history list");
		List<Productinventory> productInventoryList = inventoryProductManagementService.getAllProductInventory();
		
		List<Product> productList = productService.getAllProducts();
		List<ProductSubOptionRsVo> productSuboptionList = productService.getAllProductSubOptionVo();
		List<Storagelocation> storageLocationList = storageLocationManagementService.getAllStoragelocations();
		
		productInventoryList = combineProductInventoryInfo(productInventoryList, productList, productSuboptionList, storageLocationList);
		
		return GeneralUtils.convertListToJSONString(productInventoryList);
	}

	
}