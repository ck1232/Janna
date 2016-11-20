package com.JJ.controller.productmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.productmanagement.vo.OptionVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.FileMeta;
import com.JJ.model.JsonResponse;
import com.JJ.model.Product;
import com.JJ.model.Productcategory;
import com.JJ.model.Productoption;
import com.JJ.model.Productsubcategory;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/product/product")
public class ProductManagementController {
	private static final Logger logger = Logger.getLogger(ProductManagementController.class);
	private ProductService productService;
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
    private ProductOptionManagementService productOptionManagementService;
    private ProductVo newProduct;
	@Autowired
	public ProductManagementController(ProductService productService, ProductCategoryManagementService productCategoryManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService, ProductOptionManagementService productOptionManagementService){
		this.productService = productService;
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productOptionManagementService = productOptionManagementService;
	}
	
	public List<Productcategory> getProductCategoryList(){
		List<Productcategory> categoryList = productCategoryManagementService.getAllCategories();
		if(categoryList != null && categoryList.size() > 0){
			List<Productsubcategory> subcategoryList = productSubCategoryManagementService.getAllSubCategories();
			if(subcategoryList != null && subcategoryList.size() > 0){
				Map<Integer, List<Productsubcategory>> subcategoryMap = new HashMap<Integer, List<Productsubcategory>>();
				for(Productsubcategory subcategory : subcategoryList){
					if(!subcategoryMap.containsKey(subcategory.getProductcategoryid())){
						subcategoryMap.put(subcategory.getProductcategoryid(), new ArrayList<Productsubcategory>());
					}
					subcategoryMap.get(subcategory.getProductcategoryid()).add(subcategory);
				}
				for(Productcategory category : categoryList){
					category.setSubcategoryList(subcategoryMap.get(category.getId()));
				}
			}
			return categoryList;
		}else{
			return new ArrayList<Productcategory>();
		}
	}
	
	@RequestMapping("/listProduct")  
    public String listProduct(HttpSession session) {  
    	logger.debug("loading listProduct");
        return "listProduct";  
    } 
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductList() {
		logger.debug("getting Product list");
		List<Product> productList = productService.getAllProducts();
		return GeneralUtils.convertListToJSONString(productList);
	}
	
	@RequestMapping("/createProduct")
	public String createProduct(Model model){
		logger.debug("loading create product");
		newProduct = new ProductVo();
		model.addAttribute("productForm", newProduct);
		model.addAttribute("categoryList", getProductCategoryList());
		return "createProduct";
	}
	
	@RequestMapping(value = "/getProductOptionsList",method = RequestMethod.GET)
	public @ResponseBody String getProductOptionsList(){
		logger.debug("getting Product Options list");
		if(newProduct != null && newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			return GeneralUtils.convertListToJSONString(newProduct.getOptionList());
		}else{
			return GeneralUtils.convertListToJSONString(new ArrayList<OptionVo>());
		}
		
	}
	
	@RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		//1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
//        User userAccount = (User) request.getSession().getAttribute("userAccount");
        //2. get each file
        while(itr.hasNext()){

            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next()); 
//            System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

            //2.2 if files > 10 remove the first from the list
            if(newProduct!= null && newProduct.getImages() != null && newProduct.getImages().size() >= 10)
            	newProduct.getImages().pop();

            //2.3 create new fileMeta
            FileMeta fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
               fileMeta.setBytes(mpf.getBytes());
//               Integer stagingId = productService.insertImageStaging(fileMeta.getBytes(), fileMeta.getFileName(), userAccount.getUsername());
//               fileMeta.setImageStagingId(stagingId);
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
            //2.4 add to files
            if(newProduct != null){
            	if(newProduct.getImages() == null){
            		newProduct.setImages(new LinkedList<FileMeta>());
            	}
            	newProduct.getImages().add(fileMeta);
            	return newProduct.getImages();
            }
       }
            
       // result will be like this
       // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
       return null;
	}
	
	@RequestMapping(value = "/removeUploadImage",method = RequestMethod.POST)
	public @ResponseBody JsonResponse upload(HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName, HttpServletResponse response) {
		if(newProduct != null && newProduct.getImages() != null && newProduct.getImages().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMeta> iterator = newProduct.getImages().iterator();
			while(iterator.hasNext()){
				FileMeta file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
//					productService.deleteImageStaging(file.getImageStagingId());
					iterator.remove();
					break;
				}
			}
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/getProductOptionName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getProductOptionList() {
		logger.debug("getting product productOption list");
		List<String> productOptionList = new ArrayList<String>();
		List<Productoption> optionList = productOptionManagementService.getAllProductoptions();
		if(optionList != null && optionList.size() > 0){
			for(Productoption option : optionList){
				productOptionList.add(option.getName());
			}
		}
		return productOptionList;
	}
	
	/*@RequestMapping(value = "/addNewSubOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse addNewSubOption(@RequestParam(value="option", required=true) String option,@RequestParam(value="subOption", required=false) String subOption) {
		logger.debug("add new sub option");
		if(option != null && !option.trim().isEmpty() && subOption != null && !subOption.trim().isEmpty()){
			Productoption productOption = new Productoption();
			productOption.setName(option);
			if(productOptionsList == null){
				productOptionsList = new ArrayList<Productoption>();
			}
			if(!productOptionsList.contains(productOption)){
				productOptionsList.add(productOption);
			}
			Productsuboption suboption = new Productsuboption();
			suboption.setName(subOption);
			
			Productoption pOption = productOptionsList.get(productOptionsList.indexOf(productOption));
			if(pOption.getSubOptionsList() == null){
				pOption.setSubOptionsList(new ArrayList<Productsuboption>());
			}
			pOption.getSubOptionsList().add(suboption);
		}
		return new JsonResponse("success");
	}*/
	
	@RequestMapping(value = "/saveOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveOption(@RequestBody OptionVo option) {
		if(newProduct != null){
			if(newProduct.getOptionList() == null){
				newProduct.setOptionList(new ArrayList<OptionVo>());
			}
			newProduct.getOptionList().add(option);
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/saveNewProduct", method = RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("productForm") ProductVo product, final RedirectAttributes redirectAttributes) {
		product.setOptionList(newProduct.getOptionList());
		product.setImages(newProduct.getImages());
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product added successfully!");
		return "redirect:listProduct";
	}
}