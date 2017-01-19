package com.JJ.controller.batchintakemanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchproductRs;
import com.JJ.model.Batchstockintake;
import com.JJ.model.JsonResponse;
import com.JJ.model.Product;
import com.JJ.model.Productinventory;
import com.JJ.model.ProductsuboptionRs;
import com.JJ.model.Storagelocation;
import com.JJ.service.batchintakemanagement.BatchIntakeManagementService;
import com.JJ.service.batchproductrsmanagement.BatchProductRSManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;
import com.JJ.validator.BatchIntakeFormValidator;
import com.mysql.jdbc.StringUtils;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/batchintake")
public class BatchIntakeManagementController {
	private static final Logger logger = Logger.getLogger(BatchIntakeManagementController.class);
	
	private BatchIntakeManagementService batchIntakeManagementService;
	private ProductService productService;
	private BatchProductRSManagementService batchProductRSManagementService;
	private StorageLocationManagementService storageLocationManagementService;
	private BatchIntakeFormValidator batchIntakeFormValidator;
	
	private List<BatchProductVo> productList;
	private ProductVo productVo;
	private List<BatchIntakeProduct> batchIntakeProductList; 
	
	@Autowired
	public BatchIntakeManagementController(BatchIntakeManagementService batchIntakeManagementService,
			ProductService productService,
			BatchProductRSManagementService batchProductRSManagementService,
			StorageLocationManagementService storageLocationManagementService,
			BatchIntakeFormValidator batchIntakeFormValidator) {
		this.batchIntakeManagementService = batchIntakeManagementService;
		this.productService = productService;
		this.batchProductRSManagementService = batchProductRSManagementService;
		this.storageLocationManagementService = storageLocationManagementService;
		this.batchIntakeFormValidator = batchIntakeFormValidator;
	}
	
	
	@RequestMapping("/listBatchIntake")  
    public String listBatchIntake() {  
    	logger.debug("loading listBatchIntake");
        return "listBatchIntake";  
    }  
	
	@RequestMapping(value = "/getBatchIntakeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchIntakeList() {
		logger.debug("getting batch intake list");
		List<Batchstockintake> batchIntakeList = batchIntakeManagementService.getAllBatchstockintakes();
		for(Batchstockintake batch: batchIntakeList) {
			Storagelocation loc = storageLocationManagementService.findById(batch.getStoragelocation());
			batch.setStoragelocationname(loc.getLocationname());
		}
		return GeneralUtils.convertListToJSONString(batchIntakeList);
	}
	
	@RequestMapping(value = "/createBatchIntake", method = RequestMethod.GET)
    public String showAddBatchIntakeForm(Model model) {  
    	logger.debug("loading showAddBatchIntakeForm");
    	Batchstockintake batchIntake = new Batchstockintake();
    	batchIntake.setDate(new Date());
    	batchIntakeProductList = new ArrayList<BatchIntakeProduct>();
    	model.addAttribute("batchIntakeForm", batchIntake);
        return "createBatchIntake";  
    }
	
	@InitBinder("batchIntakeForm")
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
		binder.setValidator(batchIntakeFormValidator);
	}
	
	@RequestMapping(value = "/createBatchIntake", method = RequestMethod.POST)
    public String saveBatchIntake(@ModelAttribute("batchIntakeForm") @Validated Batchstockintake batchIntake, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveBatchIntake() : " + batchIntake.toString());
		if (result.hasErrors()) {
			return "createBatchIntake";
		} else {
			BigDecimal totalProductCost = BigDecimal.ZERO;
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList){
					BigDecimal i = product.getUnitcost().multiply(BigDecimal.valueOf(product.getQty()));
					totalProductCost = totalProductCost.add(i);
				}
			}
			BigDecimal addcost = batchIntake.getTotalcost().subtract(totalProductCost);
			if(addcost.signum() == -1) {
				result.rejectValue("totalcost", "error.lessthan.batchintakeform.totalcost");
				return "createBatchIntake";
			}
			batchIntake.setAdditionalcost(addcost);
			batchIntake.setDeleteind(GeneralUtils.NOT_DELETED);
			List<BatchproductRs> batchProductList = new ArrayList<BatchproductRs>();
			List<Productinventory> inventoryList = new ArrayList<Productinventory>();
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList){
					//find if exist in db
					List<Integer> suboptionIdList = new ArrayList<Integer>();
					for(SubOptionVo suboption: product.getSubOptionList()) {
						suboptionIdList.add(suboption.getSubOptionId());
					}
					ProductsuboptionRs rs = productService.findProductSubOptionRs(product.getProduct().getProductid(), suboptionIdList);
					//if exist, get id
					if(rs.getProductid() != null) {
						BatchproductRs batchProductRs = new BatchproductRs();
						batchProductRs.setBatchid(batchIntake.getBatchid());
						batchProductRs.setProductsuboptionid(rs.getProductsuboptionid());
						batchProductRs.setUnitcost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteind(GeneralUtils.NOT_DELETED);
						batchProductList.add(batchProductRs);
						
						Productinventory inventory = new Productinventory(rs.getProductsuboptionid(), null, 
								batchIntake.getStoragelocation(), true,
								product.getQty(), null);
						inventoryList.add(inventory);
					//else invalid
					}else{
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Invalid Product(s)!");
						return "redirect:createBatchIntake";
					}
				}
			}
			batchIntakeManagementService.createBatchstockintake(batchIntake, inventoryList, batchProductList);
			batchIntakeProductList = new ArrayList<BatchIntakeProduct>();
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Batch intake added successfully!");
		}
		
		
        return "redirect:listBatchIntake";  
    }  
	
	@RequestMapping(value = "/deleteBatchIntake", method = RequestMethod.POST)
	public String deleteBatchIntake(@RequestParam(value = "checkboxId", required=false) List<Integer> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listBatchIntake";
		}
		batchIntakeManagementService.deleteBatch(ids);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Batch Intake(s) deleted successfully!");
		return "redirect:listBatchIntake";
	}
	
	@RequestMapping(value = "/getBatchProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchProductList() {
		if(batchIntakeProductList != null){
			for(BatchIntakeProduct batchIntakeProduct : batchIntakeProductList){
				batchIntakeProduct.setHashCode(batchIntakeProduct.hashCode());
			}
			return GeneralUtils.convertListToJSONString(batchIntakeProductList);
		}
		return GeneralUtils.convertListToJSONString(new ArrayList<BatchIntakeProduct>());
	}
	
	@RequestMapping(value = "/getLocationList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Storagelocation> getLocationNameList() {
		logger.debug("getting product list");
		List<Storagelocation> locationList = storageLocationManagementService.getAllStoragelocations();	
		return locationList;
	}
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getProductNameList() {
		logger.debug("getting product list");
		List<Product> productList = productService.getAllProducts();		
		return productList;
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
	/*
	@RequestMapping(value = "/calculateAdditionalCost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse calculateAdditionalCost(@RequestBody Batchstockintake batch) {
		logger.debug(batch.getTotalcost());
		BigDecimal totalcostNum = batch.getTotalcost();
		if(batchIntakeProductList != null) {
			for(BatchIntakeProduct product: batchIntakeProductList) {
				BigDecimal d = product.getUnitcost().multiply(BigDecimal.valueOf((double)product.getQty()));
				totalcostNum = totalcostNum.subtract(d);
				if(totalcostNum.signum() == -1) {
					return new JsonResponse("error", "Total cost entered is less than the total cost of input batch product list.");
				}
			}
		}
		return new JsonResponse("success", totalcostNum.toString());
	}
	*/
	
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
		
		if(batchIntakeProductList == null) { 
			batchIntakeProductList = new ArrayList<BatchIntakeProduct>();
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
		for(BatchIntakeProduct p : batchIntakeProductList){
			if(p.hashCode() == product.hashCode()) {
				return new JsonResponse("error", "Product already exists!");
			}
		}
		batchIntakeProductList.add(product);
		return new JsonResponse("success");
	}
	
	@RequestMapping(value="/editBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BatchIntakeProduct editBatchIntakeProduct(@RequestBody BatchIntakeProduct product) {
		if(batchIntakeProductList != null && batchIntakeProductList.size() > 0){
			for(BatchIntakeProduct batchIntakeProduct : batchIntakeProductList){
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
		if(batchIntakeProductList != null) {
			for(BatchIntakeProduct batchproduct: batchIntakeProductList){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					batchproduct.setUnitcost(product.getUnitcost());
					batchproduct.setQty(product.getQty());
					break;
				}
			}
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/deleteBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse deleteBatchIntakeProduct(@RequestBody BatchIntakeProduct product) {
		logger.debug("delete product");
		int index = -1;
		if(batchIntakeProductList != null) {
			for(BatchIntakeProduct batchproduct: batchIntakeProductList){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					index = batchIntakeProductList.indexOf(batchproduct);
					break;
				}
			}
		}
		if(index > -1){
			batchIntakeProductList.remove(index);
		}
		return new JsonResponse("success");
	}
	
	/*----------------------Update batch intake ------------------------------*/
	
	@RequestMapping(value = "/updateBatchIntake", method = RequestMethod.POST)
	public String getBatchIntakeToUpdate(@RequestParam("editBtn") String id, Model model) {
		Batchstockintake batchIntake = batchIntakeManagementService.findById(Integer.parseInt(id));
		Storagelocation loc = storageLocationManagementService.findById(batchIntake.getStoragelocation());
		batchIntake.setStoragelocationname(loc.getLocationname());
		batchIntakeProductList = batchProductRSManagementService.getAllBatchProductVoByBatchId(batchIntake.getBatchid());
		logger.debug("Loading update Batch Intake page for " + batchIntake.toString());
		model.addAttribute("batchIntakeForm", batchIntake);
        return "updateBatchIntake";  
	}
	
	
	private List<Productinventory> compareBatchProductsQtyDifference(Integer locationId, List<BatchproductRs> originalList, List<BatchproductRs> newList){
		List<Productinventory> productInventoryList = new ArrayList<Productinventory>();
		if(newList != null && originalList != null) {
			Map<Integer, BatchproductRs> newProductRsMap = new HashMap<Integer, BatchproductRs>();
			Map<Integer, BatchproductRs> oldProductRsMap = new HashMap<Integer, BatchproductRs>();
			for(BatchproductRs rs : newList){
				newProductRsMap.put(rs.getProductsuboptionid(), rs);
			}
			for(BatchproductRs rs : originalList){
				oldProductRsMap.put(rs.getProductsuboptionid(), rs);
			}
			for(BatchproductRs originalProduct : originalList){
				BatchproductRs newProductRs = newProductRsMap.get(originalProduct.getProductsuboptionid());
				if(newProductRs == null){
					//old product kena deleted
					Productinventory inventory = new Productinventory(originalProduct.getProductsuboptionid(), locationId, 
							null, false,
							originalProduct.getQty(), null);
					productInventoryList.add(inventory);
				}else{
					//check qty difference
					String remark = "old: " + originalProduct.getQty() + ", new: " + newProductRs.getQty();
					if(originalProduct.getQty().compareTo(newProductRs.getQty()) > 0) {
						Productinventory inventory = new Productinventory(newProductRs.getProductsuboptionid(), null, 
								locationId, false,
								originalProduct.getQty() - newProductRs.getQty(), remark);
						productInventoryList.add(inventory);
					}else if(originalProduct.getQty().compareTo(newProductRs.getQty()) < 0){
						Productinventory inventory = new Productinventory(newProductRs.getProductsuboptionid(), null, 
								locationId, true,
								newProductRs.getQty() - originalProduct.getQty(), remark);
						productInventoryList.add(inventory);
					}
				}
			}
			
			for(Integer prdSuboptionId : newProductRsMap.keySet()){
				BatchproductRs oldProductRs = oldProductRsMap.get(prdSuboptionId);
				if(oldProductRs == null){
					//new product added
					Productinventory inventory = new Productinventory(prdSuboptionId, null, 
							locationId, true,
							newProductRsMap.get(prdSuboptionId).getQty(), null);
					productInventoryList.add(inventory);
				}
			}
		}
		return productInventoryList;
	}
	
	@RequestMapping(value = "/editBatchIntake", method = RequestMethod.POST)
    public String saveEditBatchIntake(@ModelAttribute("batchIntakeForm") @Validated Batchstockintake batchIntake, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveEditBatchIntake() : " + batchIntake.toString());
		if (result.hasErrors()) {
			return "updateBatchIntake";
		} else {
			BigDecimal totalProductCost = BigDecimal.ZERO;
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList){
					BigDecimal i = product.getUnitcost().multiply(BigDecimal.valueOf(product.getQty()));
					totalProductCost = totalProductCost.add(i);
				}
			}
			
			BigDecimal addcost = batchIntake.getTotalcost().subtract(totalProductCost);
			if(addcost.signum() == -1) {
				result.rejectValue("totalcost", "error.lessthan.batchintakeform.totalcost");
				return "updateBatchIntake";
			}
			batchIntake.setAdditionalcost(addcost);
			batchIntake.setDeleteind(GeneralUtils.NOT_DELETED);
//			batchIntakeManagementService.updateBatchstockintake(batchIntake);
			List<Integer> idList = new ArrayList<Integer>();
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList) {
					if(product.getBatchProductId() != null) {
						idList.add(product.getBatchProductId());
					}
				}
			}
			List<BatchproductRs> originalList = batchProductRSManagementService.getBatchproductByBatchId(batchIntake.getBatchid());
//			batchProductRSManagementService.deleteBatchproductNotInBatchProductidList(batchIntake.getBatchid(), idList);
			List<BatchproductRs> batchProductList = new ArrayList<BatchproductRs>();
			List<BatchproductRs> batchProductRsList = new ArrayList<BatchproductRs>();
			List<Productinventory> inventoryList = new ArrayList<Productinventory>();
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList){
					BatchproductRs batchProductRs = batchProductRSManagementService.findById(product.getBatchProductId());
					if(batchProductRs == null){
						List<Integer> suboptionIdList = new ArrayList<Integer>();
						for(SubOptionVo suboption: product.getSubOptionList()) {
							suboptionIdList.add(suboption.getSubOptionId());
						}
						ProductsuboptionRs rs = productService.findProductSubOptionRs(product.getProduct().getProductid(), suboptionIdList);
						if(rs.getProductsuboptionid() == null){
							redirectAttributes.addFlashAttribute("css", "danger");
							redirectAttributes.addFlashAttribute("msg", "Invalid Product(s)!");
							return "redirect:updateBatchIntake";
						}
						batchProductRs = new BatchproductRs();
						batchProductRs.setBatchid(batchIntake.getBatchid());
						batchProductRs.setProductsuboptionid(rs.getProductsuboptionid());
						batchProductRs.setUnitcost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteind(GeneralUtils.NOT_DELETED);
						batchProductList.add(batchProductRs);
						batchProductRsList.add(batchProductRs);
//						batchProductRSManagementService.saveBatchproduct(batchProductRs);
					}else{
						batchProductRs.setUnitcost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteind(GeneralUtils.NOT_DELETED);
						batchProductRSManagementService.updateBatchproductRS(batchProductRs);
						batchProductRsList.add(batchProductRs);
					}
				}
			}
			
			List<Productinventory> productInventoryList = compareBatchProductsQtyDifference(batchIntake.getStoragelocation(), originalList, batchProductRsList);
			batchIntakeManagementService.editBatchstockintake(batchIntake, idList, batchProductList, productInventoryList);
			batchIntakeProductList = new ArrayList<BatchIntakeProduct>();
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Batch intake updated successfully!");
		}
		
		
        return "redirect:listBatchIntake";  
    }  
	
}