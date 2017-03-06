package com.JJ.controller.inventorymanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.batchintakemanagement.BatchIntakeProduct;
import com.JJ.controller.batchintakemanagement.BatchProductVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.JsonResponse;
import com.JJ.model.Product;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.mysql.jdbc.StringUtils;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/inventory")
public class InventoryManagementController {
	private static final Logger logger = Logger.getLogger(InventoryManagementController.class);
	
	private InventoryProductManagementService inventoryProductManagementService;
	private ProductService productService;
	
	private List<BatchIntakeProduct> inventoryProductList; 
	private InventoryVO inventoryVO;
	private ProductVo productVo;
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
	
	@RequestMapping(value = "/createInventoryProduct", method = RequestMethod.GET)
	public String createInventoryProduct(Model model) {
		logger.debug("loading createInventoryProduct");
    	inventoryVO = new InventoryVO();
    	inventoryVO.setDate(new Date());
    	model.addAttribute("inventoryProductForm", inventoryVO);
        return "createInventoryProduct"; 
	}
	
	@RequestMapping(value = "/getAddInventoryProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchProductList() {
		if(inventoryVO.getProductItems() != null){
			for(BatchIntakeProduct batchIntakeProduct : inventoryVO.getProductItems() ){
				batchIntakeProduct.setHashCode(batchIntakeProduct.hashCode());
			}
			return GeneralUtils.convertListToJSONString(inventoryVO.getProductItems());
		}
		return GeneralUtils.convertListToJSONString(new ArrayList<BatchProductVo>());
	}
	
	@RequestMapping(value = "/getBatchProductVo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductVo getBatchProductVo(@RequestBody Product product) {
		logger.debug(product.getProductid());
		
		List<ProductVo> productVoList = productService.getAllProductVo(product.getProductid());
		if(productVoList != null && productVoList.size() > 0){
			productVo = productVoList.get(0);
			if(productVo != null){
				return productVo;
			}
		}
		return new ProductVo();
	}
	
	@RequestMapping(value = "/saveAddProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveAddProduct(@RequestBody BatchIntakeProduct product) {
		logger.debug("save add product");
		boolean pass = true;
		if(StringUtils.isNullOrEmpty(product.getProduct().getProductname()) ||
				product.getSubOptionList() == null ||
				product.getSubOptionList().size() == 0 ||
				product.getUnitcost() == null ||
				product.getQty() == null){
			pass = false;
		}else if(product.getSubOptionList().size() > 0){
			for(SubOptionVo vo : product.getSubOptionList()){
				if(vo.getSubOptionId() == null){
					pass = false;
					break;
				}
			}
		}
		if(!pass){
			return new JsonResponse("error", "Please fill in all the details!");
		}
		
		if(inventoryVO.getProductItems() == null) { 
			inventoryVO.setProductItems(new ArrayList<BatchIntakeProduct>());
		}
		/*
		BigDecimal totalcostNum = product.getBatchtotalcost();
		if(totalcostNum != null){
			if(batchIntakeProductList.size() > 0) { 
				for(BatchIntakeProduct p: batchIntakeProductList) {
					BigDecimal d = p.getUnitcost().multiply(BigDecimal.valueOf((double)p.getQty()));
					totalcostNum = totalcostNum.subtract(d);
				}
			}
			BigDecimal d = product.getUnitcost().multiply(BigDecimal.valueOf((double)product.getQty()));
				totalcostNum = totalcostNum.subtract(d);
				if(totalcostNum.signum() == -1) {
					return new JsonResponse("error", "Please either lower the price of products or add the total cost!");
				
			}
		}
		*/
		//for generating suboption
		Iterator<SubOptionVo> i = product.getSubOptionList().iterator();
		while(i.hasNext()){
			SubOptionVo subOptionVo = i.next();
			SubOptionVo generatedSubOptionVo = productService.getSubOptionVo(subOptionVo.getSubOptionId());
			subOptionVo.setSeq(generatedSubOptionVo.getSeq());
			subOptionVo.setSubOptionName(generatedSubOptionVo.getSubOptionName());
		}
		for(BatchIntakeProduct p : inventoryVO.getProductItems()){
			if(p.hashCode() == product.hashCode()) {
				return new JsonResponse("error", "Product already exists!");
			}
		}
		inventoryVO.getProductItems().add(product);
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/deleteInventoryProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse deleteBatchIntakeProduct(@RequestBody BatchIntakeProduct product) {
		logger.debug("delete inventory product");
		if(inventoryVO.getProductItems() != null) {
			Iterator<BatchIntakeProduct> iterator = inventoryVO.getProductItems().iterator();
			while(iterator.hasNext()){
				BatchIntakeProduct inventoryProduct = iterator.next();
				if(inventoryProduct.hashCode() == product.getHashCode()){
					iterator.remove();
					break;
				}
			}
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value="/editBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BatchIntakeProduct editBatchIntakeProduct(@RequestBody BatchIntakeProduct product) {
		if(inventoryVO.getProductItems() != null && inventoryVO.getProductItems().size() > 0){
			for(BatchIntakeProduct batchIntakeProduct : inventoryVO.getProductItems()){
				if(batchIntakeProduct.getHashCode() == product.getHashCode()){
					return batchIntakeProduct;
				}
			}
		}
		return new BatchIntakeProduct();
	}
	
	@RequestMapping(value = "/saveEditProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveEditProduct(@RequestBody BatchIntakeProduct product) {
		logger.debug("save edit product");
		if(inventoryVO.getProductItems() != null) {
			for(BatchIntakeProduct batchproduct: inventoryVO.getProductItems()){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					batchproduct.setUnitcost(product.getUnitcost());
					batchproduct.setQty(product.getQty());
					break;
				}
			}
		}
		return new JsonResponse("success");
	}
	@RequestMapping(value = "/createInventoryProduct", method = RequestMethod.POST)
	public String saveInventoryProduct(@RequestParam("date") String date, @RequestParam("locationTo") String locationTo,
			@RequestParam("locationFrom") String locationFrom,@RequestParam("remarks") String remarks) {
		return "";
	}
	
}