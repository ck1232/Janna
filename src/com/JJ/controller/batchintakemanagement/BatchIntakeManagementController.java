package com.JJ.controller.batchintakemanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.batchintakemanagement.vo.BatchIntakeProductVO;
import com.JJ.controller.batchintakemanagement.vo.BatchProductRsVO;
import com.JJ.controller.batchintakemanagement.vo.BatchStockIntakeVO;
import com.JJ.controller.batchintakemanagement.vo.ProductInventoryVO;
import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;
import com.JJ.controller.common.vo.JsonResponseVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.batchintakemanagement.BatchIntakeManagementService;
import com.JJ.service.batchproductrsmanagement.BatchProductRSManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;
import com.JJ.validator.BatchIntakeFormValidator;
import com.mysql.jdbc.StringUtils;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/batchintake")
public class BatchIntakeManagementController {
	private static final Logger logger = Logger.getLogger(BatchIntakeManagementController.class);
	
	private BatchIntakeManagementService batchIntakeManagementService;
	private ProductService productService;
	private BatchProductRSManagementService batchProductRSManagementService;
	private StorageLocationManagementService storageLocationManagementService;
	private BatchIntakeFormValidator batchIntakeFormValidator;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private ProductVO productVo;
	private List<BatchIntakeProductVO> batchIntakeProductList; 
	
	@Autowired
	public BatchIntakeManagementController(BatchIntakeManagementService batchIntakeManagementService,
			ProductService productService,
			BatchProductRSManagementService batchProductRSManagementService,
			StorageLocationManagementService storageLocationManagementService,
			BatchIntakeFormValidator batchIntakeFormValidator,
			ProductSubOptionManagementService productSubOptionManagementService) {
		this.batchIntakeManagementService = batchIntakeManagementService;
		this.productService = productService;
		this.batchProductRSManagementService = batchProductRSManagementService;
		this.storageLocationManagementService = storageLocationManagementService;
		this.batchIntakeFormValidator = batchIntakeFormValidator;
		this.productSubOptionManagementService = productSubOptionManagementService;
	}
	
	
	@RequestMapping("/listBatchIntake")  
    public String listBatchIntake() {  
    	logger.debug("loading listBatchIntake");
        return "listBatchIntake";  
    }  
	
	@RequestMapping(value = "/getBatchIntakeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchIntakeList() {
		logger.debug("getting batch intake list");
		List<BatchStockIntakeVO> batchIntakeList = batchIntakeManagementService.getAllBatchStockIntakes();
		for(BatchStockIntakeVO batch: batchIntakeList) {
			StorageLocationVO loc = storageLocationManagementService.findById(batch.getStorageLocation());
			if(loc != null){
				batch.setStorageLocationName(loc.getName());
			}
		}
		return GeneralUtils.convertListToJSONString(batchIntakeList);
	}
	
	@RequestMapping(value = "/createBatchIntake", method = RequestMethod.GET)
    public String showAddBatchIntakeForm(HttpSession session, Model model) {  
    	logger.debug("loading showAddBatchIntakeForm");
    	BatchStockIntakeVO batchIntake = new BatchStockIntakeVO();
    	batchIntake.setDate(new Date());
    	batchIntakeProductList = new ArrayList<BatchIntakeProductVO>();
    	model.addAttribute("batchIntakeForm", batchIntake);
    	session.setAttribute("productList", batchIntakeProductList);
        return "createBatchIntake";  
    }
	
	@InitBinder("batchIntakeForm")
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));
		binder.setValidator(batchIntakeFormValidator);
	}
	
	@RequestMapping(value = "/createBatchIntake", method = RequestMethod.POST)
    public String saveBatchIntake(@ModelAttribute("batchIntakeForm") @Validated BatchStockIntakeVO batchIntakeVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpSession session) {  
    	
		logger.debug("saveBatchIntake() : " + batchIntakeVO.toString());
		if (result.hasErrors()) {
			return "createBatchIntake";
		} else {
			batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
			BigDecimal totalProductCost = calculateTotalProductCost(batchIntakeProductList);
			BigDecimal addcost = this.calculateAdditionalCost(batchIntakeVO.getTotalCost(), totalProductCost);
			if(addcost.signum() == -1) {
				result.rejectValue("totalCost", "error.lessthan.batchintakeform.totalcost");
				return "createBatchIntake";
			}
			batchIntakeVO.setAdditionalCost(addcost);
			batchIntakeVO.setDeleteInd(GeneralUtils.NOT_DELETED);
			List<BatchProductRsVO> batchProductList = new ArrayList<BatchProductRsVO>();
			List<ProductInventoryVO> inventoryList = new ArrayList<ProductInventoryVO>();
			if(batchIntakeProductList != null) {
				for(BatchIntakeProductVO product: batchIntakeProductList){
					//find if exist in db
					List<Integer> suboptionIdList = this.getSubOptionIdsFromProduct(product.getSubOptionList());
					ProductSubOptionRsVO rs = productService.findProductSubOptionRs(product.getProduct().getProductId(), suboptionIdList);
					//if exist, get id
					if(rs.getProductId() != null) {
						BatchProductRsVO batchProductRs = new BatchProductRsVO();
						batchProductRs.setBatchId(batchIntakeVO.getBatchId());
						batchProductRs.setProductSubOptionId(rs.getProductSuboptionRsId());
						batchProductRs.setUnitCost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteInd(GeneralUtils.NOT_DELETED);
						batchProductList.add(batchProductRs);
						
						ProductInventoryVO inventory = new ProductInventoryVO(rs.getProductSuboptionRsId(), null, 
								batchIntakeVO.getStorageLocation(), true,
								product.getQty(), null, batchIntakeVO.getDate());
						inventoryList.add(inventory);
					//else invalid
					}else{
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Invalid Product(s)!");
						return "redirect:createBatchIntake";
					}
				}
			}
			batchIntakeManagementService.createBatchstockintake(batchIntakeVO, inventoryList, batchProductList);
			batchIntakeProductList = new ArrayList<BatchIntakeProductVO>();
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
		List<ProductInventoryVO> inventoryList = new ArrayList<ProductInventoryVO>();
		List<BatchStockIntakeVO> batchList = batchIntakeManagementService.findByIdList(ids);
		for(BatchStockIntakeVO batch : batchList) {
			List<BatchProductRsVO> originalList = batchProductRSManagementService.getBatchproductByBatchId(batch.getBatchId());
			inventoryList.addAll(this.compareBatchProductsQtyDifference(batch, originalList, new ArrayList<BatchProductRsVO>()));
		}
		
		batchIntakeManagementService.deleteBatch(ids, inventoryList);
		
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Batch Intake(s) deleted successfully!");
		return "redirect:listBatchIntake";
	}
	
	@RequestMapping(value = "/getBatchProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchProductList(HttpSession session) {
		batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
		if(batchIntakeProductList != null){
			for(BatchIntakeProductVO batchIntakeProduct : batchIntakeProductList){
				batchIntakeProduct.setHashCode(batchIntakeProduct.hashCode());
			}
			return GeneralUtils.convertListToJSONString(batchIntakeProductList);
		}
		return GeneralUtils.convertListToJSONString(new ArrayList<BatchIntakeProductVO>());
	}
	
	@RequestMapping(value = "/getLocationList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<StorageLocationVO> getLocationNameList() {
		logger.debug("getting product list");
		List<StorageLocationVO> locationList = storageLocationManagementService.getAllStorageLocations();	
		return locationList;
	}
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductVO> getProductNameList() {
		logger.debug("getting product list");
		List<ProductVO> productList = productService.getAllProducts();		
		return productList;
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
	public @ResponseBody JsonResponseVO saveAddProduct(@RequestBody BatchIntakeProductVO product, HttpSession session) {
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
		
		batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
		if(batchIntakeProductList == null) { 
			batchIntakeProductList = new ArrayList<BatchIntakeProductVO>();
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
		for(BatchIntakeProductVO p : batchIntakeProductList){
			if(p.hashCode() == product.hashCode()) {
				return new JsonResponseVO("error", "Product already exists!");
			}
		}
		batchIntakeProductList.add(product);
		session.setAttribute("productList", batchIntakeProductList);
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value="/editBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BatchIntakeProductVO editBatchIntakeProduct(@RequestBody BatchIntakeProductVO product, HttpSession session) {
		batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
		if(batchIntakeProductList != null && batchIntakeProductList.size() > 0){
			for(BatchIntakeProductVO batchIntakeProduct : batchIntakeProductList){
				if(batchIntakeProduct.getHashCode() == product.getHashCode()){
					return batchIntakeProduct;
				}
			}
		}
		return new BatchIntakeProductVO();
	}
	
	@RequestMapping(value = "/saveEditProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveEditProduct(@RequestBody BatchIntakeProductVO product, HttpSession session) {
		logger.debug("save edit product");
		batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
		if(batchIntakeProductList != null) {
			for(BatchIntakeProductVO batchproduct: batchIntakeProductList){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					batchproduct.setUnitcost(product.getUnitcost());
					batchproduct.setQty(product.getQty());
					break;
				}
			}
		}
		session.setAttribute("productList", batchIntakeProductList);
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/deleteBatchIntakeProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO deleteBatchIntakeProduct(@RequestBody BatchIntakeProductVO product, HttpSession session) {
		logger.debug("delete product");
		int index = -1;
		batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
		if(batchIntakeProductList != null) {
			for(BatchIntakeProductVO batchproduct: batchIntakeProductList){
				if((batchproduct.getHashCode()) == product.getHashCode()) {
					index = batchIntakeProductList.indexOf(batchproduct);
					break;
				}
			}
		}
		if(index > -1){
			batchIntakeProductList.remove(index);
		}
		session.setAttribute("productList", batchIntakeProductList);
		return new JsonResponseVO("success");
	}
	
	/*----------------------Update batch intake ------------------------------*/
	
	@RequestMapping(value = "/updateBatchIntake", method = RequestMethod.POST)
	public String getBatchIntakeToUpdate(@RequestParam("editBtn") String id, Model model, HttpSession session, 
			final RedirectAttributes redirectAttributes) {
		BatchStockIntakeVO batchIntake = batchIntakeManagementService.findById(Integer.parseInt(id));
		if(batchIntake != null){
			StorageLocationVO loc = storageLocationManagementService.findById(batchIntake.getStorageLocation());
			batchIntake.setStorageLocationName(loc.getName());
			batchIntakeProductList = batchProductRSManagementService.getAllBatchProductVoByBatchId(batchIntake.getBatchId());
//			if(originalList != null && !originalList.isEmpty()) {
//				List<Integer> originalIdList = getIdsFromBatchProductRsList(originalList);
//				List<ProductSubOptionVO> productsuboptionList = productSubOptionManagementService.getAllProductsuboptionsByProductIdList(originalIdList);
//				List<Integer> retrievedIdList = getSubOptionIdsFromProduct(productsuboptionList);
//				for(Iterator<BatchProductRsVO> i = originalList.iterator() ; i.hasNext();) {
//					if(!retrievedIdList.contains(i.next().getProductSubOptionId()))
//						i.remove();
//				}
//			}
			if(batchIntakeProductList == null) {
				redirectAttributes.addFlashAttribute("css", "danger");
				redirectAttributes.addFlashAttribute("msg", "Invalid Product(s) in Batch Intake!");
				return "redirect:listBatchIntake";
			}
			session.setAttribute("productList", batchIntakeProductList);
			logger.debug("Loading update Batch Intake page for " + batchIntake.toString());
			model.addAttribute("batchIntakeForm", batchIntake);
		}
		
        return "updateBatchIntake";  
	}
	
	
	private List<ProductInventoryVO> compareBatchProductsQtyDifference(BatchStockIntakeVO batch, List<BatchProductRsVO> originalList, List<BatchProductRsVO> newList){
		List<ProductInventoryVO> productInventoryList = new ArrayList<ProductInventoryVO>();
		if(newList != null && originalList != null) {
			Map<Integer, BatchProductRsVO> newProductRsMap = new HashMap<Integer, BatchProductRsVO>();
			Map<Integer, BatchProductRsVO> oldProductRsMap = new HashMap<Integer, BatchProductRsVO>();
			for(BatchProductRsVO rs : newList){
				newProductRsMap.put(rs.getProductSubOptionId(), rs);
			}
			for(BatchProductRsVO rs : originalList){
				oldProductRsMap.put(rs.getProductSubOptionId(), rs);
			}
			for(BatchProductRsVO originalProduct : originalList){
				BatchProductRsVO newProductRs = newProductRsMap.get(originalProduct.getProductSubOptionId());
				if(newProductRs == null){
					//old product kena deleted
					ProductInventoryVO inventory = new ProductInventoryVO(originalProduct.getProductSubOptionId(), batch.getStorageLocation(), 
							null, false,
							originalProduct.getQty(), null, GeneralUtils.MODE_BATCH, batch.getBatchId(), batch.getDate());
					productInventoryList.add(inventory);
				}else{ //existing product to update
					//check qty difference
					String remark = "old: " + originalProduct.getQty() + ", new: " + newProductRs.getQty();
					if(originalProduct.getQty().compareTo(newProductRs.getQty()) > 0) {
						ProductInventoryVO inventory = new ProductInventoryVO(newProductRs.getProductSubOptionId(), null, 
								batch.getStorageLocation(), false,
								originalProduct.getQty() - newProductRs.getQty(), remark, GeneralUtils.MODE_BATCH, batch.getBatchId(), batch.getDate());
						productInventoryList.add(inventory);
					}else if(originalProduct.getQty().compareTo(newProductRs.getQty()) < 0){
						ProductInventoryVO inventory = new ProductInventoryVO(newProductRs.getProductSubOptionId(), null, 
								batch.getStorageLocation(), true,
								newProductRs.getQty() - originalProduct.getQty(), remark, GeneralUtils.MODE_BATCH, batch.getBatchId(), batch.getDate());
						productInventoryList.add(inventory);
					}
				}
			}
			
			//new product to add
			for(Integer prdSuboptionId : newProductRsMap.keySet()){
				BatchProductRsVO oldProductRs = oldProductRsMap.get(prdSuboptionId);
				if(oldProductRs == null){
					//new product added
					ProductInventoryVO inventory = new ProductInventoryVO(prdSuboptionId, null, 
							batch.getStorageLocation(), true,
							newProductRsMap.get(prdSuboptionId).getQty(), null, GeneralUtils.MODE_BATCH, batch.getBatchId(), batch.getDate());
					productInventoryList.add(inventory);
				}
			}
		}
		return productInventoryList;
	}
	
	private BigDecimal calculateTotalProductCost(List<BatchIntakeProductVO> productList) {
		BigDecimal totalProductCost = BigDecimal.ZERO;
		if(productList != null && !productList.isEmpty()) {
			for(BatchIntakeProductVO product: productList){
				BigDecimal i = product.getUnitcost().multiply(BigDecimal.valueOf(product.getQty()));
				totalProductCost = totalProductCost.add(i);
			}
		}
		return totalProductCost;
	}

	private BigDecimal calculateAdditionalCost(BigDecimal inputTotalCost, BigDecimal totalProductCost) {
		return inputTotalCost.subtract(totalProductCost);
	}
	
	private List<Integer> getIdsFromBatchIntakeProductList(List<BatchIntakeProductVO> productList) {
		List<Integer> idList = new ArrayList<Integer>(); 
		if(productList != null && !productList.isEmpty()) {
			for(BatchIntakeProductVO product: productList) {
				if(product.getBatchProductId() != null) {
					idList.add(product.getBatchProductId());
				}
			}
		}
		return idList;
	}
	
	private List<Integer> getIdsFromBatchProductRsList(List<BatchProductRsVO> originalList) {
		List<Integer> idList = new ArrayList<Integer>(); 
		if(originalList != null && !originalList.isEmpty()) {
			for(BatchProductRsVO product: originalList) {
				if(product.getProductSubOptionId() != null) {
					idList.add(product.getProductSubOptionId());
				}
			}
		}
		return idList;
	}
	
	private List<Integer> getSubOptionIdsFromProduct(List<ProductSubOptionVO> suboptionList) {
		List<Integer> suboptionIdList = new ArrayList<Integer>();
		if(suboptionList != null && !suboptionList.isEmpty()) {
			for(ProductSubOptionVO suboption: suboptionList) {
				suboptionIdList.add(suboption.getProductSuboptionId());
			}
		}
		return suboptionIdList;
	}
	
	@RequestMapping(value = "/editBatchIntake", method = RequestMethod.POST)
    public String saveEditBatchIntake(@ModelAttribute("batchIntakeForm") @Validated BatchStockIntakeVO batchIntake, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpSession session) {  
    	
		logger.debug("saveEditBatchIntake() : " + batchIntake.toString());
		if (result.hasErrors()) {
			return "updateBatchIntake";
		} else {
			batchIntakeProductList = (List<BatchIntakeProductVO>) session.getAttribute("productList");
			//update batch stock intake
			BigDecimal totalProductCost = calculateTotalProductCost(batchIntakeProductList);
			BigDecimal addcost = calculateAdditionalCost(batchIntake.getTotalCost(), totalProductCost);
			if(addcost.signum() == -1) {
				result.rejectValue("totalCost", "error.lessthan.batchintakeform.totalcost");
				return "updateBatchIntake";
			}
			batchIntake.setAdditionalCost(addcost);
			batchIntake.setDeleteInd(GeneralUtils.NOT_DELETED);
//			batchIntakeManagementService.updateBatchStockIntake(batchIntake);
			
			
			List<Integer> idList = getIdsFromBatchIntakeProductList(batchIntakeProductList);
			List<BatchProductRsVO> originalList = batchProductRSManagementService.getBatchproductByBatchId(batchIntake.getBatchId());
//			batchProductRSManagementService.deleteBatchproductNotInBatchProductidList(batchIntake.getBatchid(), idList);
			List<BatchProductRsVO> batchProductList = new ArrayList<BatchProductRsVO>();
			List<BatchProductRsVO> batchProductRsList = new ArrayList<BatchProductRsVO>();
			if(originalList != null && !originalList.isEmpty()) {
				List<Integer> originalIdList = getIdsFromBatchProductRsList(originalList);
				List<ProductSubOptionVO> productsuboptionList = productSubOptionManagementService.getAllProductsuboptionsByProductIdList(originalIdList);
				List<Integer> retrievedIdList = getSubOptionIdsFromProduct(productsuboptionList);
				for(Iterator<BatchProductRsVO> i = originalList.iterator() ; i.hasNext();) {
					if(!retrievedIdList.contains(i.next().getProductSubOptionId()))
						i.remove();
				}
			}
			
			if(batchIntakeProductList != null && !batchIntakeProductList.isEmpty()) {
				for(BatchIntakeProductVO product: batchIntakeProductList){
					BatchProductRsVO batchProductRs = batchProductRSManagementService.findById(product.getBatchProductId());
					if(batchProductRs.getBatchProductRsId() == null){ //new
						List<Integer> suboptionIdList = getSubOptionIdsFromProduct(product.getSubOptionList());
						ProductSubOptionRsVO rs = productService.findProductSubOptionRs(product.getProduct().getProductId(), suboptionIdList);
						if(rs.getProductSuboptionRsId() == null){
							redirectAttributes.addFlashAttribute("css", "danger");
							redirectAttributes.addFlashAttribute("msg", "Invalid Product(s)!");
							return "redirect:updateBatchIntake";
						}
						batchProductRs = new BatchProductRsVO();
						batchProductRs.setBatchId(batchIntake.getBatchId());
						batchProductRs.setProductSubOptionId(rs.getProductSuboptionRsId());
						batchProductRs.setUnitCost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteInd(GeneralUtils.NOT_DELETED);
						batchProductList.add(batchProductRs);
						batchProductRsList.add(batchProductRs);
//						batchProductRSManagementService.saveBatchproduct(batchProductRs);
					}else{ //existing
						batchProductRs.setUnitCost(product.getUnitcost());
						batchProductRs.setQty(product.getQty());
						batchProductRs.setDeleteInd(GeneralUtils.NOT_DELETED);
						batchProductRSManagementService.updateBatchproductRS(batchProductRs);
						batchProductRsList.add(batchProductRs);
					}
				}
			}
			
			List<ProductInventoryVO> productInventoryList = compareBatchProductsQtyDifference(batchIntake, originalList, batchProductRsList);
			batchIntakeManagementService.editBatchstockintake(batchIntake, idList, batchProductList, productInventoryList);
			batchIntakeProductList = new ArrayList<BatchIntakeProductVO>();
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Batch intake updated successfully!");
		}
		
		
        return "redirect:listBatchIntake";  
    }  
	
}