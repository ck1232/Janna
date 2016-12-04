package com.JJ.controller.batchintakemanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import com.JJ.service.batchintakemanagement.BatchIntakeManagementService;
import com.JJ.service.batchproductrsmanagement.BatchProductRSManagementService;
import com.JJ.service.productmanagement.ProductService;
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
	private BatchIntakeFormValidator batchIntakeFormValidator;
	
	private List<BatchProductVo> productList;
	private ProductVo productVo;
	private List<BatchIntakeProduct> batchIntakeProductList; 
	
	@Autowired
	public BatchIntakeManagementController(BatchIntakeManagementService batchIntakeManagementService,
			ProductService productService,
			BatchProductRSManagementService batchProductRSManagementService,
			BatchIntakeFormValidator batchIntakeFormValidator) {
		this.batchIntakeManagementService = batchIntakeManagementService;
		this.productService = productService;
		this.batchProductRSManagementService = batchProductRSManagementService;
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
		return GeneralUtils.convertListToJSONString(batchIntakeList);
	}
	
	@RequestMapping(value = "/createBatchIntake", method = RequestMethod.GET)
    public String showAddBatchIntakeForm(Model model) {  
    	logger.debug("loading showAddBatchIntakeForm");
    	Batchstockintake batchIntake = new Batchstockintake();
    	batchIntake.setDate(new Date());
    	productList = new ArrayList<BatchProductVo>();
    	model.addAttribute("batchIntakeForm", batchIntake);
    	model.addAttribute("productList", productList);
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
			batchIntake.setAdditionalcost(batchIntake.getTotalcost().subtract(totalProductCost));
			batchIntake.setDeleteind(GeneralUtils.NOT_DELETED);
			batchIntakeManagementService.saveBatchstockintake(batchIntake);
			if(batchIntakeProductList != null) {
				for(BatchIntakeProduct product: batchIntakeProductList){
					BatchproductRs batchProductRs = new BatchproductRs();
					batchProductRs.setBatchid(batchIntake.getBatchid());
					batchProductRs.setProductid(product.getProduct().getProductid());
					List<SubOptionVo> suboptionList = product.getSubOptionList();
					if(suboptionList.size() >= 1) 
						batchProductRs.setProductsuboption1id(suboptionList.get(0).getSubOptionId());
					if(suboptionList.size() >= 2) 
						batchProductRs.setProductsuboption2id(suboptionList.get(1).getSubOptionId());
					if(suboptionList.size() == 3) 
						batchProductRs.setProductsuboption3id(suboptionList.get(2).getSubOptionId());
					
					batchProductRs.setUnitcost(product.getUnitcost());
					batchProductRs.setQty(product.getQty());
					batchProductRSManagementService.saveBatchproduct(batchProductRs);
				}
			}
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
		
		batchIntakeManagementService.deleteBatchstockintake(ids);
		batchProductRSManagementService.deleteBatchproduct(ids);
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
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> getProductNameList() {
		logger.debug("getting product list");
		List<Product> productList = productService.getAllProducts();		
		return productList;
		/*if(productList != null && productList.size() > 0){
			return GeneralUtils.convertListToJSONString(productList);
		}
		return GeneralUtils.convertListToJSONString(new ArrayList<Product>());*/
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
		
		if(batchIntakeProductList == null) { 
			batchIntakeProductList = new ArrayList<BatchIntakeProduct>();
		}
		
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
}