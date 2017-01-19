package com.JJ.controller.inventorymanagement;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;
import com.JJ.service.productmanagement.ProductService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/inventory")
public class InventoryManagementController {
	private static final Logger logger = Logger.getLogger(InventoryManagementController.class);
	
	private InventoryProductManagementService inventoryProductManagementService;
	private ProductService productService;
	
	@Autowired
	public InventoryManagementController(InventoryProductManagementService inventoryProductManagementService,
			ProductService productService) {
		this.inventoryProductManagementService = inventoryProductManagementService;
		this.productService = productService;
	}
	
	
	@RequestMapping(value = "/listInventoryProduct", method = RequestMethod.GET)  
    public String listInventoryProduct() {  
    	logger.debug("loading listInventoryProduct");
        return "listInventoryProduct";  
    }  
	
	@RequestMapping(value = "/getInventoryProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory product list");
		List<ViewProductInventory> productList = inventoryProductManagementService.getAllInventoryProducts();
		return GeneralUtils.convertListToJSONString(productList);
	}
	
	@RequestMapping(value = "/viewInventoryProduct", method = RequestMethod.POST)
	public String viewInventoryProduct(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		ProductVo product = productService.getProductVoById(Integer.parseInt(id));
		if (product == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Inventory Product not found");
		}
		model.addAttribute("product", product);

		return "viewInventoryProduct";

	}
	
	@RequestMapping(value = "/getInventoryProductLocationList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductLocationList(@RequestParam("suboptionids") String ids) {
		logger.debug("getting inventory product location list");
		String[] suboptionIds = ids.split("_");
		int suboption1Id  = Integer.parseInt(suboptionIds[0]);
		int suboption2Id  = Integer.parseInt(suboptionIds[1]);
		int suboption3Id  = Integer.parseInt(suboptionIds[2]);
		List<ViewProductInventoryLocation> productLocationList = inventoryProductManagementService.getAllInventoryProductLocations(suboption1Id, suboption2Id,suboption3Id);
		return GeneralUtils.convertListToJSONString(productLocationList);
	}
	
	
	@RequestMapping(value = "/getInventoryProductQuantityList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductQuantityList(@RequestParam("productid") String id) {
		logger.debug("getting inventory product quantity list");
		List<ViewProductSuboptionInventory> productQuantityList = inventoryProductManagementService.getInventoryProductAllQuantity(Integer.parseInt(id));
		return GeneralUtils.convertListToJSONString(productQuantityList);
	}
	
	
	
}