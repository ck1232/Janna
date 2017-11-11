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
import org.springframework.context.annotation.Scope;
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

import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.controller.common.vo.JsonResponseVO;
import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.controller.productmanagement.vo.ResponseProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.filelinkmanagement.ImageService;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productmanagement.ProductImageService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/product")
public class ProductManagementController {
	private static final Logger logger = Logger.getLogger(ProductManagementController.class);
	private ProductService productService;
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
    private ProductOptionManagementService productOptionManagementService;
    private ProductImageService productImageService;
    private ProductVO newProduct;
    private ProductOptionVO selectedOption;
    private ImageService imageService;
    private static final int code_limit = 6;
    
	@Autowired
	public ProductManagementController(ProductService productService, ProductCategoryManagementService productCategoryManagementService,
			ProductSubCategoryManagementService productSubCategoryManagementService, 
			ProductOptionManagementService productOptionManagementService,
			ProductImageService productImageService,
			ImageService imageService){
		this.productService = productService;
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productOptionManagementService = productOptionManagementService;
		this.productImageService = productImageService;
		this.imageService = imageService;
	}
	
	public List<ProductCategoryVO> getProductCategoryList(){
		List<ProductCategoryVO> categoryList = productCategoryManagementService.getAllCategories();
		if(categoryList != null && categoryList.size() > 0){
			List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllSubCategories();
			if(subcategoryList != null && subcategoryList.size() > 0){
				Map<Integer, List<ProductSubCategoryVO>> subcategoryMap = new HashMap<Integer, List<ProductSubCategoryVO>>();
				for(ProductSubCategoryVO subcategory : subcategoryList){
					if(!subcategoryMap.containsKey(subcategory.getCategoryId())){
						subcategoryMap.put(subcategory.getCategoryId(), new ArrayList<ProductSubCategoryVO>());
					}
					subcategoryMap.get(subcategory.getCategoryId()).add(subcategory);
				}
				for(ProductCategoryVO category : categoryList){
					category.setSubcategoryList(subcategoryMap.get(category.getCategoryId()));
				}
			}
			return categoryList;
		}else{
			return new ArrayList<ProductCategoryVO>();
		}
	}
	
	@RequestMapping("/listProduct")  
    public String listProduct(HttpSession session, Model model) {
    	logger.debug("loading listProduct");
    	List<ProductVO> productList = productService.getAllProducts();
    	model.addAttribute("productList", productList);
        return "listProduct";  
    } 
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductList() {
		logger.debug("getting Product list");
		List<ProductVO> productList = productService.getAllProducts();
		return GeneralUtils.convertListToJSONString(productList);
	}
	
	@RequestMapping("/createProduct")
	public String createProduct(HttpSession session, Model model){
		logger.debug("loading create product");
		newProduct = new ProductVO();
		model.addAttribute("productForm", newProduct);
		model.addAttribute("categoryList", getProductCategoryList());
		session.setAttribute("product", newProduct);
		return "createProduct";
	}
	
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public String editProduct(HttpSession session, Model model, @RequestParam("editBtn") Integer id){
		logger.debug("loading edit product");
		if(id != null){
			List<ProductVO> productList = productService.getAllProductVo(id);
			if(productList != null && productList.size() > 0){
				newProduct = productList.get(0);
				model.addAttribute("productForm", newProduct);
				model.addAttribute("categoryList", getProductCategoryList());
				session.setAttribute("product", newProduct);
				return "editProduct";
			}
		}
			return "listProduct";
		
	}
	
	@RequestMapping(value = "/getProductOptionsList",method = RequestMethod.GET)
	public @ResponseBody String getProductOptionsList(HttpSession session){
		logger.debug("getting Product Options list");
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct != null && newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			return GeneralUtils.convertListToJSONString(newProduct.getOptionList());
		}else{
			return GeneralUtils.convertListToJSONString(new ArrayList<ProductOptionVO>());
		}
	}
	
	@RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMetaVO> upload(HttpSession session, MultipartHttpServletRequest request, HttpServletResponse response) {
		newProduct = (ProductVO) session.getAttribute("product");
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
            FileMetaVO fileMeta = new FileMetaVO();
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
            		newProduct.setImages(new LinkedList<FileMetaVO>());
            	}
            	fileMeta.setSequence(newProduct.getImages().size() + 1);
            	newProduct.getImages().add(fileMeta);
            	return newProduct.getImages();
            }
            reshuffleImage(newProduct.getImages());
       }
        
       // result will be like this
       // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
       return null;
	}
	
	@RequestMapping(value = "/removeUploadImage",method = RequestMethod.POST)
	public @ResponseBody JsonResponseVO removeUploadImage(HttpSession session, HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName, HttpServletResponse response) {
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct != null && newProduct.getImages() != null && newProduct.getImages().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMetaVO> iterator = newProduct.getImages().iterator();
			while(iterator.hasNext()){
				FileMetaVO file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
					iterator.remove();
					break;
				}
			}
			reshuffleImage(newProduct.getImages());
		}
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/getPreUploadImage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileMetaVO> getPreUploadImage(HttpSession session) {
		newProduct = (ProductVO) session.getAttribute("product");
		newProduct.setImages(imageService.convertImageLinkVOToFileMetaVO(newProduct.getImagesLink()));
		if(newProduct == null || newProduct.getImages() == null ){
			return new ArrayList<FileMetaVO>();
		}else{
			Collections.sort(newProduct.getImages(),new ImageCompare());
			return newProduct.getImages();
		}
	}
	
	@RequestMapping(value = "/sortImage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveOption(HttpSession session, @RequestBody List<String> orderList) {
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct.getImages() != null && newProduct.getImages().size() > 0){
			for(FileMetaVO image : newProduct.getImages()){
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
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/getProductOptionName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getProductOptionList() {
		logger.debug("getting product productOption list");
		List<String> productOptionList = new ArrayList<String>();
		List<ProductOptionVO> optionList = productOptionManagementService.getAllProductoptions();
		if(optionList != null && optionList.size() > 0){
			for(ProductOptionVO option : optionList){
				productOptionList.add(option.getName());
			}
		}
		return productOptionList;
	}
	private String generateCode(String name){
		String code = "";
		if(name == null || name.trim().isEmpty()){
			return code;
		}
		String noSpaceName = name.replace(" ", "");
		if(noSpaceName.length() <= code_limit){
			code = noSpaceName;
			return code;
		}
		//split by spacebar
		String[] splitName = name.split(" ");
		if(splitName.length > 1){
			//take the first character of each word
			for(String word : splitName){
				code += word.charAt(0);
			}
			
			//if code more than limit, substring it
			if(code.length() > code_limit){
				code = code.substring(0, code_limit);
			}else{
				//use the last word to fill up the remaining length
				int shortFor = code_limit - code.length();
				//if last word is less than shortFor, use whole word
				String lastWord = splitName[splitName.length - 1];
				if(lastWord.length() <= shortFor){
					code += lastWord.substring(1);
				}else{
					//take the last few characters equals to shortFor
					code += lastWord.substring(lastWord.length()- shortFor, lastWord.length());
				}
			}
			
		}else{
			code = splitName[0];
			if(code.length() > code_limit){
				code = code.substring(code.length() - code_limit);
			}
		}
		return code;
	}
	private ProductOptionVO generateSubOptionCode(ProductOptionVO option){
		if(option != null && option.getSubOptionList() != null && option.getSubOptionList().size() > 0){
			for(ProductSubOptionVO subOption : option.getSubOptionList()){
				String name = subOption.getName();
				subOption.setCode(generateCode(name));
			}
		}
		return option;
	}
	
	private ProductVO generateProductCode(ProductVO product){
		if(product.getProductCode() == null || product.getProductCode().trim().isEmpty()){
			product.setProductCode(generateCode(product.getProductName()));
		}else{
			String noSpaceName = product.getProductCode().replace(" ", "");
			if(noSpaceName.length() > code_limit){
				product.setProductCode(noSpaceName.substring(0, code_limit));
			}else{
				product.setProductCode(noSpaceName);
			}
			
		}
		//TODO check for duplicate, add running number if duplicate
		List<String> productCodeList = productService.getExisitingProductCode(product.getProductId());
		int counter = 1;
		String productCode = product.getProductCode();
		while(productCodeList.contains(productCode)){
			productCode = product.getProductCode()+counter++;
		}
		product.setProductCode(productCode);
		//generate suboption code
		if(product.getOptionList() != null && product.getOptionList().size() > 0){
			for(ProductOptionVO option : product.getOptionList()){
				option = generateSubOptionCode(option);
			}
		}
		
		return product;
	}
	
	@RequestMapping(value = "/saveAddOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveAddOption(HttpSession session, @RequestBody ProductOptionVO option) {
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct != null){
			if(newProduct.getOptionList() == null){
				newProduct.setOptionList(new ArrayList<ProductOptionVO>());
			}
			for(ProductOptionVO optionVo : newProduct.getOptionList()){
				if(optionVo.getName().equalsIgnoreCase(option.getName())){
					return new JsonResponseVO("fail", "Option Name already exists.");
				}
			}
			newProduct.getOptionList().add(option);
		}
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/saveEditOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveEditOption(HttpSession session, @RequestBody ProductOptionVO option) {
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct != null && newProduct.getOptionList() != null){
			for(ProductOptionVO optionVo : newProduct.getOptionList()){
				if(optionVo.getName().equalsIgnoreCase(option.getName()) && optionVo.getProductOptionId() != option.getProductOptionId()){
					return new JsonResponseVO("fail", "Option Name already exists.");
				}
			}
		}
		if(selectedOption != null){
			selectedOption.setName(option.getName());
			selectedOption.setProductOptionId(option.getProductOptionId());
			selectedOption.setSequence(option.getSequence());
			selectedOption.setSubOptionList(option.getSubOptionList());
			selectedOption = null;
		}
		return new JsonResponseVO("success");
	}
	
	//current not in use
	@RequestMapping(value = "/sortOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO sortOption(@RequestBody List<ProductOptionVO> optionList) {
		logger.debug(optionList);
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/editOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductOptionVO sortOption(HttpSession session, @RequestBody ProductOptionVO optionName) {
		logger.debug(optionName.getName());
		newProduct = (ProductVO) session.getAttribute("product");
		if(newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			for(ProductOptionVO option: newProduct.getOptionList()){
				if(option.getName() != null && option.getName().compareToIgnoreCase(optionName.getName()) == 0){
					selectedOption = option;
					return option;
				}
			}
		}
		return new ProductOptionVO();
	}
	
	@RequestMapping(value = "/deleteOption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO deleteOption(HttpSession session, @RequestBody List<String> selectedOptions) {
		newProduct = (ProductVO) session.getAttribute("product");
		if(selectedOptions != null && selectedOptions.size() > 0 && newProduct.getOptionList() != null && newProduct.getOptionList().size() > 0){
			for(String option : selectedOptions){
				Iterator<ProductOptionVO> i = newProduct.getOptionList().iterator();
				while(i.hasNext()){
					ProductOptionVO optionVo = i.next();
					if(optionVo.getName() != null && optionVo.getName().compareToIgnoreCase(option) == 0){
						i.remove();
						break;
					}
				}
			}
		}
		
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(HttpSession session, @ModelAttribute("productForm") ResponseProductVO responseProduct, final RedirectAttributes redirectAttributes) {
		newProduct = (ProductVO) session.getAttribute("product");
		ProductVO product = new ProductVO();
		product.setProductId(newProduct.getProductId());
		product.setProductName(responseProduct.getProductName());
		product.setProductInfo(responseProduct.getProductInfo());
		product.setWeight(responseProduct.getWeight());
		product.setSubCategoryId(responseProduct.getSubCategoryId());
		product.setUnitAmt(responseProduct.getUnitAmt());
		product.setTags(responseProduct.getTags());
		product.setOptionList(newProduct.getOptionList());
		product = generateProductCode(product);
		reshuffleImage(newProduct.getImages());
		product.setImages(newProduct.getImages());
		
		//temp solution for option sequence
		if(product.getOptionList() != null && product.getOptionList().size() > 0){
			int size = product.getOptionList().size();
			for(int i =0;i<size;i++){
				product.getOptionList().get(i).setSequence(i+1);
			}
		}
		
		productService.saveProduct(product);
		redirectAttributes.addFlashAttribute("css", "success");
		if(product.getProductId() != null){
			redirectAttributes.addFlashAttribute("msg", "Product saved successfully!");
		}else{
			redirectAttributes.addFlashAttribute("msg", "Product added successfully!");
		}
		return "redirect:listProduct";
	}

	private void reshuffleImage(LinkedList<FileMetaVO> images) {
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
	public void getImage(HttpSession session, @PathVariable Integer imageId, HttpServletRequest request, HttpServletResponse response){
		newProduct = (ProductVO) session.getAttribute("product");
		if(this.newProduct != null && this.newProduct.getImages() != null && this.newProduct.getImages().size() > 0){
			for(FileMetaVO image : newProduct.getImages()){
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
		ImageLinkVO image = productImageService.getCoverImageByProductId(productId);
		if(image != null && image.getBytes() != null){
			 try {
				response.setContentType("image/jpeg");
				response.getOutputStream().write(image.getBytes(),0,image.getBytes().length);
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
	
	class ImageCompare implements Comparator<FileMetaVO>{

		@Override
		public int compare(FileMetaVO o1, FileMetaVO o2) {
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
