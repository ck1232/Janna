package com.JJ.controller.inventorymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	boolean searchBefore;
	List<Productinventory> productInventoryList;
	Map<String,String> modeList;
	Map<String,String> locationList;
	InventoryHistorySearchCriteria searchCriteria;
	
	@Autowired
	public InventoryHistoryManagementController(InventoryProductManagementService inventoryProductManagementService,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService) {
		this.inventoryProductManagementService = inventoryProductManagementService;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
	}
	
	
	@RequestMapping(value = "/listInventoryHistory", method = RequestMethod.GET)  
    public String listInventoryHistory(Model model) {  
    	logger.debug("loading listInventoryHistory");
    	initSearchData();
    	model.addAttribute("inventoryHistoryForm", searchCriteria);
    	model.addAttribute("modeList", modeList);
    	model.addAttribute("locationList", locationList);
        return "listInventoryHistory";  
    }
	
	private void initSearchData(){
		productInventoryList = new ArrayList<Productinventory>();
    	if(null == searchCriteria) {
    		searchCriteria = new InventoryHistorySearchCriteria();
    	}
		searchBefore = false;
    	modeList = new LinkedHashMap<String,String>();
    	modeList.put("BATCH", "Batch Intake");
    	modeList.put("ADHOC", "Adhoc Creation");
    	
    	locationList = new LinkedHashMap<String,String>();
    	List<Storagelocation> storageLocationList = storageLocationManagementService.getAllStoragelocations();
    	for(Storagelocation storageLocation : storageLocationList) {
    		locationList.put(String.valueOf(storageLocation.getLocationid()), storageLocation.getLocationname());
    	}
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
		if(productInventoryList.isEmpty() && !searchBefore) {
			productInventoryList = inventoryProductManagementService.getAllProductInventory();
		}
		
		List<Product> productList = productService.getAllProducts();
		List<ProductSubOptionRsVo> productSuboptionList = productService.getAllProductSubOptionVo();
		List<Storagelocation> storageLocationList = storageLocationManagementService.getAllStoragelocations();
		
		productInventoryList = combineProductInventoryInfo(productInventoryList, productList, productSuboptionList, storageLocationList);
		
		return GeneralUtils.convertListToJSONString(productInventoryList);
	}
	
	@RequestMapping(value = "/searchInventoryHistoryList", method = RequestMethod.POST)
	public String searchInventoryHistoryList(@ModelAttribute("inventoryHistoryForm") InventoryHistorySearchCriteria searchCriteria, 
			Model model) {
		logger.debug("searching inventory history list");
		//search from db
		productInventoryList = inventoryProductManagementService.searchProductInventory(searchCriteria);
		searchBefore = true;
		model.addAttribute("inventoryHistoryForm", searchCriteria);
    	model.addAttribute("modeList", modeList);
    	model.addAttribute("locationList", locationList);
		return "listInventoryHistory";
	}

	
}