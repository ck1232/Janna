package com.JJ.controller.batchintakemanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Batchstockintake;
import com.JJ.model.JsonResponse;
import com.JJ.model.Product;
import com.JJ.service.batchintakemanagement.BatchIntakeManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.validator.BatchIntakeFormValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/batchintake")
public class BatchIntakeManagementController {
	private static final Logger logger = Logger.getLogger(BatchIntakeManagementController.class);
	
	private BatchIntakeManagementService batchIntakeManagementService;
	private ProductService productService;
	private BatchIntakeFormValidator batchIntakeFormValidator;
	
	private List<BatchProductVo> productList;
	private ProductVo product;
	
	@Autowired
	public BatchIntakeManagementController(BatchIntakeManagementService batchIntakeManagementService,
			ProductService productService,
			BatchIntakeFormValidator batchIntakeFormValidator) {
		this.batchIntakeManagementService = batchIntakeManagementService;
		this.productService = productService;
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
			batchIntake.setDeleteind(GeneralUtils.NOT_DELETED);
			batchIntakeManagementService.saveBatchstockintake(batchIntake);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Batch intake added successfully!");
		}
		
		
        return "redirect:listBatchIntake";  
    }  
	
	@RequestMapping(value = "/getBatchProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBatchProductList() {
		List<BatchProductVo> batchIntakeList = new ArrayList<BatchProductVo>();
		return GeneralUtils.convertListToJSONString(batchIntakeList);
	}
	
	@RequestMapping(value = "/getProductNameList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getProductNameList() {
		logger.debug("getting product name list");
		List<String> productNameList = new ArrayList<String>();
		List<Product> productList = productService.getAllProducts();
		if(productList != null && productList.size() > 0){
			for(Product product : productList){
				productNameList.add(product.getProductname());
			}
		}
		return productNameList;
	}
	
	@RequestMapping(value = "/getBatchProductVo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse getBatchProductVo(@RequestBody String productName) {
		logger.debug(productName);
		product = (productService.getAllProductsByName(productName)).get(0);
		return new JsonResponse("success");
	}
	
}