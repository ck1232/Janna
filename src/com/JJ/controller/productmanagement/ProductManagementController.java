package com.JJ.controller.productmanagement;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.JJ.model.ProductimageWithBLOBs;
import com.JJ.model.Productoption;
import com.JJ.model.Productsubcategory;
import com.JJ.service.paypal.PayPalErrorException;
import com.JJ.service.paypal.PayPalService;
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
    private OptionVo selectedOption;
    private PayPalService paypalService;
	@Autowired
	public ProductManagementController(ProductService productService, ProductCategoryManagementService productCategoryManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService, ProductOptionManagementService productOptionManagementService,
			PayPalService paypalService){
		this.productService = productService;
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productOptionManagementService = productOptionManagementService;
		this.paypalService = paypalService;
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
    public String listProduct(HttpSession session, Model model) {
    	logger.debug("loading listProduct");
    	List<Product> productList = productService.getAllProducts();
    	model.addAttribute("productList", productList);
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
	
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public String editProduct(Model model, @RequestParam("editBtn") Integer id){
		logger.debug("loading edit product");
		if(id != null){
			List<ProductVo> productList = productService.getAllProductVo(id);
			if(productList != null && productList.size() > 0){
				newProduct = productList.get(0);
				model.addAttribute("productForm", newProduct);
				model.addAttribute("categoryList", getProductCategoryList());
				return "editProduct";
			}
		}
			return "listProduct";
		
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
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
            //2.4 add to files
            if(newProduct != null){
            	if(newProduct.getImages() == null){
            		newProduct.setImages(new LinkedList<FileMeta>());
            	}
            	fileMeta.setSequence(newProduct.getImages().size() + 1);
            	newProduct.getImages().add(fileMeta);
            	return newProduct.getImages();
            }
       }
        reshuffleImage(newProduct.getImages());
       // result will be like this
       // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
       return null;
	}
	
	@RequestMapping(value = "/removeUploadImage",method = RequestMethod.POST)
	public @ResponseBody JsonResponse removeUploadImage(HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName, HttpServletResponse response) {
		if(newProduct != null && newProduct.getImages() != null && newProduct.getImages().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMeta> iterator = newProduct.getImages().iterator();
			while(iterator.hasNext()){
				FileMeta file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
					iterator.remove();
					break;
				}
			}
			reshuffleImage(newProduct.getImages());
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/getPreUploadImage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileMeta> getPreUploadImage() {
		if(newProduct == null || newProduct.getImages() == null ){
			return new ArrayList<FileMeta>();
		}else{
			return newProduct.getImages();
		}
	}
	
	@RequestMapping(value = "/sortImage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveOption(@RequestBody List<String> orderList) {
		if(newProduct.getImages() != null && newProduct.getImages().size() > 0){
			for(FileMeta image : newProduct.getImages()){
				int index = orderList.indexOf(image.getFileName());
				if(index < 0){
					image.setSequence(0);
				}
				else{
					image.setSequence(index + 1);
				}
			}
			reshuffleImage(newProduct.getImages());
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
	
	@RequestMapping(value = "/saveAddOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveAddOption(@RequestBody OptionVo option) {
		if(newProduct != null){
			if(newProduct.getOptionList() == null){
				newProduct.setOptionList(new ArrayList<OptionVo>());
			}
			for(OptionVo optionVo : newProduct.getOptionList()){
				if(optionVo.getOptionName().equalsIgnoreCase(option.getOptionName())){
					return new JsonResponse("fail", "Option Name already exists.");
				}
			}
			newProduct.getOptionList().add(option);
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/saveEditOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse saveEditOption(@RequestBody OptionVo option) {
		if(newProduct != null && newProduct.getOptionList() != null){
			for(OptionVo optionVo : newProduct.getOptionList()){
				if(optionVo.getOptionName().equalsIgnoreCase(option.getOptionName()) && optionVo.getOptionId() != option.getOptionId()){
					return new JsonResponse("fail", "Option Name already exists.");
				}
			}
		}
		
		if(selectedOption != null){
			selectedOption.setOptionName(option.getOptionName());
			selectedOption.setOptionId(option.getOptionId());
			selectedOption.setSequence(option.getSequence());
			selectedOption.setSubOptionList(option.getSubOptionList());
			selectedOption = null;
		}
		return new JsonResponse("success");
	}
	
	//current not in use
	@RequestMapping(value = "/sortOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse sortOption(@RequestBody List<OptionVo> optionList) {
		logger.debug(optionList);
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/editOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OptionVo sortOption(@RequestBody OptionVo optionName) {
		logger.debug(optionName.getOptionName());

		if(newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			for(OptionVo option: newProduct.getOptionList()){
				if(option.getOptionName() != null && option.getOptionName().compareToIgnoreCase(optionName.getOptionName()) == 0){
					selectedOption = option;
					return option;
				}
			}
		}
		return new OptionVo();
	}
	
	@RequestMapping(value = "/deleteOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse deleteOption(@RequestBody List<String> selectedOptions) {
		if(selectedOptions != null && selectedOptions.size() > 0 && newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			for(String option : selectedOptions){
				Iterator<OptionVo> i = newProduct.getOptionList().iterator();
				while(i.hasNext()){
					OptionVo optionVo = i.next();
					if(optionVo.getOptionName() != null && optionVo.getOptionName().compareToIgnoreCase(option) == 0){
						i.remove();
						break;
					}
				}
			}
		}
		
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productForm") ProductVo product, final RedirectAttributes redirectAttributes) {
		product.setOptionList(newProduct.getOptionList());
		reshuffleImage(newProduct.getImages());
		product.setImages(newProduct.getImages());
		
		//temp solution for option sequence
		if(product.getOptionList() != null && product.getOptionList().size() > 0){
			int size = product.getOptionList().size();
			for(int i =0;i<size;i++){
				product.getOptionList().get(i).setSequence(i+1);
			}
		}
		
		
		try{
			productService.saveProduct(product);
			redirectAttributes.addFlashAttribute("css", "success");
			if(product.getId() != null){
				redirectAttributes.addFlashAttribute("msg", "Product saved successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "Product added successfully!");
			}
		}catch(Exception ex){
			redirectAttributes.addFlashAttribute("css", "danger");
			if(ex instanceof PayPalErrorException){
				redirectAttributes.addFlashAttribute("msg", ((PayPalErrorException)ex).getPayPalErrorMsg());
			}else{
				redirectAttributes.addFlashAttribute("msg", ex.getMessage());
			}
		}
		return "redirect:listProduct";
	}

	private void reshuffleImage(LinkedList<FileMeta> images) {
		if(images != null && images.size() > 0){
			Collections.sort(images,new ImageCompare());
			for(int i=0;i<images.size(); i++){
				images.get(i).setSequence(i+1);
			}
		}
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam(value = "checkboxId", required=false) List<Integer> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listProduct";
		}
		productService.deleteProduct(ids);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product(s) deleted successfully!");
		return "redirect:listProduct";
	}
	
	@RequestMapping(value="/getImage/{imageId}", method = RequestMethod.GET)
	public void getImage(@PathVariable Integer imageId, HttpServletRequest request, HttpServletResponse response){
		if(this.newProduct != null && this.newProduct.getImages() != null && this.newProduct.getImages().size() > 0){
			for(FileMeta image : newProduct.getImages()){
				if(image.getImageId() == imageId){
					  response.setContentType(image.getFileType());
					  try {
						response.getOutputStream().write(image.getBytes(),0,image.getBytes().length);
						response.getOutputStream().flush();  
						break;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				}
			}
		}
	}	
	
	@RequestMapping(value="/getProductImage/{productId}", method = RequestMethod.GET)
	public void getProductImage(@PathVariable Integer productId, HttpServletRequest request, HttpServletResponse response){
		ProductimageWithBLOBs image = productService.getCoverImageByProductId(productId);
		if(image != null){
			 try {
				response.setContentType(image.getFiletype());
				response.getOutputStream().write(image.getThumbnailimage(),0,image.getThumbnailimage().length);
				response.getOutputStream().flush();  
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			InputStream is;
			try {
				is = request.getSession().getServletContext().getResourceAsStream("/development/images/No-image-found.jpg");
				ByteArrayOutputStream bos=new ByteArrayOutputStream();
				int b;
				byte[] buffer = new byte[1024];
				while((b=is.read(buffer))!=-1){
				   bos.write(buffer,0,b);
				}
				byte[] fileBytes=bos.toByteArray();
				is.close();
				bos.close();
				response.setContentType("image/jpeg");
				response.getOutputStream().write(fileBytes,0,fileBytes.length);
				response.getOutputStream().flush();  
				return;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	class ImageCompare implements Comparator<FileMeta>{

		@Override
		public int compare(FileMeta o1, FileMeta o2) {
			if(o1.getSequence() != null && o2.getSequence() != null){
				return o1.getSequence().compareTo(o2.getSequence());
			}else if(o1.getSequence() != null){
				return 1;
			}else if(o2.getSequence() != null){
				return -1;
			}
			return 0;
		}
		
	}
}
