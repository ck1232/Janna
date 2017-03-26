package com.JJ.controller.inventorymanagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.batchintakemanagement.vo.BatchIntakeProductVO;
import com.JJ.controller.batchintakemanagement.vo.ProductInventoryVO;
import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;
import com.JJ.controller.common.vo.JsonResponseVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductInventoryLocationVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductInventoryVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductSubOptionInventoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;
import com.mysql.jdbc.StringUtils;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/inventory")
public class InventoryManagementController {
	private static final Logger logger = Logger.getLogger(InventoryManagementController.class);
	
	private InventoryProductManagementService inventoryProductManagementService;
	private ProductService productService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private ProductInventoryVO inventoryVO;
	private ProductVO productVo;
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	@Autowired
	public InventoryManagementController(InventoryProductManagementService inventoryProductManagementService,
			ProductService productService, ProductSubOptionManagementService productSubOptionManagementService) {
		this.inventoryProductManagementService = inventoryProductManagementService;
		this.productService = productService;
		this.productSubOptionManagementService = productSubOptionManagementService;
	}
	
	
	@RequestMapping(value = "/listInventoryProduct", method = RequestMethod.GET)  
    public String listInventoryProduct() {  
    	logger.debug("loading listInventoryProduct");
        return "listInventoryProduct";  
    }  
	
	@RequestMapping(value = "/getInventoryProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory product list");
		List<ViewProductInventoryVO> productList = inventoryProductManagementService.getAllInventoryProducts();
		return GeneralUtils.convertListToJSONString(productList);
	}
	
	@RequestMapping(value = "/viewInventoryProduct", method = RequestMethod.POST)
	public String viewInventoryProduct(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		ProductVO product = productService.getProductVoById(Integer.parseInt(id));
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
		List<ViewProductInventoryLocationVO> productLocationList = inventoryProductManagementService.getAllInventoryProductLocations(suboption1Id, suboption2Id,suboption3Id);
		return GeneralUtils.convertListToJSONString(productLocationList);
	}
	
	
	@RequestMapping(value = "/getInventoryProductQuantityList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductQuantityList(@RequestParam("productid") String id) {
		logger.debug("getting inventory product quantity list");
		List<ViewProductSubOptionInventoryVO> productQuantityList = inventoryProductManagementService.getInventoryProductAllQuantity(Integer.parseInt(id));
		return GeneralUtils.convertListToJSONString(productQuantityList);
	}
	
	@RequestMapping(value = "/createInventoryProduct", method = RequestMethod.GET)
	public String createInventoryProduct(Model model) {
		logger.debug("loading createInventoryProduct");
    	inventoryVO = new ProductInventoryVO();
    	inventoryVO.setDate(new Date());
    	model.addAttribute("inventoryProductForm", inventoryVO);
        return "createInventoryProduct"; 
	}
	
	@RequestMapping(value = "/getAddInventoryProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchProductList() {
		if(inventoryVO.getProductItems() != null){
			for(BatchIntakeProductVO batchIntakeProduct : inventoryVO.getProductItems() ){
				batchIntakeProduct.setHashCode(batchIntakeProduct.hashCode());
			}
			return GeneralUtils.convertListToJSONString(inventoryVO.getProductItems());
		}
		return GeneralUtils.convertListToJSONString(new ArrayList<BatchIntakeProductVO>());
	}
	
	@RequestMapping(value = "/getBatchProductVo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductVO getBatchProductVo(@RequestBody ProductVO product) {
		logger.debug(product.getProductId());
		
		List<ProductVO> productVoList = productService.getAllProductVo(product.getProductId());
		if(productVoList != null && productVoList.size() > 0){
			productVo = productVoList.get(0);
			if(productVo != null){
				return productVo;
			}
		}
		return new ProductVO();
	}
	
	@RequestMapping(value = "/saveAddProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveAddProduct(@RequestBody BatchIntakeProductVO product) {
		logger.debug("save add product");
		boolean pass = true;
		if(StringUtils.isNullOrEmpty(product.getProduct().getProductName()) ||
				product.getSubOptionList() == null ||
				product.getSubOptionList().size() == 0 ||
				product.getUnitcost() == null ||
				product.getQty() == null){
			pass = false;
		}else if(product.getSubOptionList().size() > 0){
			for(ProductSubOptionVO vo : product.getSubOptionList()){
				if(vo.getProductSuboptionId() == null){
					pass = false;
					break;
				}
			}
		}
		if(!pass){
			return new JsonResponseVO("error", "Please fill in all the details!");
		}
		
		if(inventoryVO.getProductItems() == null) { 
			inventoryVO.setProductItems(new ArrayList<BatchIntakeProductVO>());
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
		Iterator<ProductSubOptionVO> i = product.getSubOptionList().iterator();
		while(i.hasNext()){
			ProductSubOptionVO subOptionVo = i.next();
			ProductSubOptionVO generatedSubOptionVo = productSubOptionManagementService.getSubOptionVo(subOptionVo.getProductSuboptionId());
			subOptionVo.setSeq(generatedSubOptionVo.getSeq());
			subOptionVo.setName(generatedSubOptionVo.getName());
		}
		for(BatchIntakeProductVO p : inventoryVO.getProductItems()){
			if(p.hashCode() == product.hashCode()) {
				return new JsonResponseVO("error", "Product already exists!");
			}
		}
		inventoryVO.getProductItems().add(product);
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/deleteInventoryProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO deleteBatchIntakeProduct(@RequestBody BatchIntakeProductVO product) {
		logger.debug("delete inventory product");
		if(inventoryVO.getProductItems() != null) {
			Iterator<BatchIntakeProductVO> iterator = inventoryVO.getProductItems().iterator();
			while(iterator.hasNext()){
				BatchIntakeProductVO inventoryProduct = iterator.next();
				if(inventoryProduct.hashCode() == product.getHashCode()){
					iterator.remove();
					break;
				}
			}
		}
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value="/editBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BatchIntakeProductVO editBatchIntakeProduct(@RequestBody BatchIntakeProductVO product) {
		if(inventoryVO.getProductItems() != null && inventoryVO.getProductItems().size() > 0){
			for(BatchIntakeProductVO batchIntakeProduct : inventoryVO.getProductItems()){
				if(batchIntakeProduct.getHashCode() == product.getHashCode()){
					return batchIntakeProduct;
				}
			}
		}
		return new BatchIntakeProductVO();
	}
	
	@RequestMapping(value = "/saveEditProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveEditProduct(@RequestBody BatchIntakeProductVO product) {
		logger.debug("save edit product");
		if(inventoryVO.getProductItems() != null) {
			for(BatchIntakeProductVO batchproduct: inventoryVO.getProductItems()){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					batchproduct.setUnitcost(product.getUnitcost());
					batchproduct.setQty(product.getQty());
					break;
				}
			}
		}
		return new JsonResponseVO("success");
	}
	@RequestMapping(value = "/createInventoryProduct", method = RequestMethod.POST)
	public String saveInventoryProduct(@ModelAttribute("inventoryProductForm") ProductInventoryVO inventoryVO, 
			final RedirectAttributes redirectAttributes) {
		inventoryVO.setProductItems(this.inventoryVO.getProductItems());
		try{
			List<StorageLocationVO> locationList = inventoryProductManagementService.getAllStorageLocation();
			Map<String, StorageLocationVO> locationMap = new HashMap<String, StorageLocationVO>();
			if(locationList != null && locationList.size() > 0){
				for(StorageLocationVO location:locationList){
					locationMap.put(location.getName(), location);
				}
			}
			Date date = df.parse(inventoryVO.getDateString());
			inventoryVO.setDate(date);
			StorageLocationVO locationTo = locationMap.get(inventoryVO.getTransferFromName());
			StorageLocationVO locationFrom = locationMap.get(inventoryVO.getTransferToName());
			if(locationTo != null){
				inventoryVO.setTransferTo(locationTo.getLocationId());
			}
			
			if(locationFrom != null){
				inventoryVO.setTransferFrom(locationFrom.getLocationId());
			}
			
			
			inventoryProductManagementService.saveInventoryRecord(inventoryVO);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Batch intake added successfully!");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Invalid date input.");
		}
		return "redirect:listInventoryProduct";
	}
	
}