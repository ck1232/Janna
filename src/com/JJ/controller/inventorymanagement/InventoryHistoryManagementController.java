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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.productmanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.Productinventory;
import com.JJ.model.Storagelocation;
import com.JJ.model.ViewItemCode;
import com.JJ.model.ViewProductInventory;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;
import com.JJ.validator.InventoryHistorySearchValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/inventoryhistory")
public class InventoryHistoryManagementController {
	private static final Logger logger = Logger.getLogger(InventoryHistoryManagementController.class);
	
	private InventoryProductManagementService inventoryProductManagementService;
	private ProductService productService;
	private StorageLocationManagementService storageLocationManagementService;
	private InventoryHistorySearchValidator inventoryHistorySearchValidator;
	
	boolean searchBefore;
	List<Productinventory> productInventoryList;
	Map<String,String> modeList;
	Map<String,String> locationList;
	InventoryHistorySearchCriteria searchCriteria;
	
	@Autowired
	public InventoryHistoryManagementController(InventoryProductManagementService inventoryProductManagementService,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService,
			InventoryHistorySearchValidator inventoryHistorySearchValidator) {
		this.inventoryProductManagementService = inventoryProductManagementService;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
		this.inventoryHistorySearchValidator = inventoryHistorySearchValidator;
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
    	List<Storagelocation> storageLocationList = storageLocationManagementService.getAllStorageLocations();
    	for(Storagelocation storageLocation : storageLocationList) {
    		locationList.put(String.valueOf(storageLocation.getLocationid()), storageLocation.getLocationname());
    	}
	}
	
	@RequestMapping(value = "/getInventoryHistoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory history list");
		if(productInventoryList.isEmpty() && !searchBefore) {
			productInventoryList = inventoryProductManagementService.getAllProductInventory();
		}
		return GeneralUtils.convertListToJSONString(productInventoryList);
	}
	
	@InitBinder("inventoryHistoryForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(inventoryHistorySearchValidator);
	}
	
	@RequestMapping(value = "/searchInventoryHistoryList", method = RequestMethod.POST)
	public String searchInventoryHistoryList(@ModelAttribute("inventoryHistoryForm") @Validated InventoryHistorySearchCriteria searchCriteria, 
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("searching inventory history list");
		if (!result.hasErrors()) {
			//search from db
			productInventoryList = inventoryProductManagementService.searchProductInventory(searchCriteria);
			searchBefore = true;
		}
		model.addAttribute("inventoryHistoryForm", searchCriteria);
    	model.addAttribute("modeList", modeList);
    	model.addAttribute("locationList", locationList);
    	return "listInventoryHistory";
	}

	
}