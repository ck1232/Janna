package com.JJ.controller.productcategorymanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.productcategorymanagement.ProductCategoryManagementService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsubcategorymanagement.ProductSubCategoryManagementService;
import com.JJ.validator.ProductCategoryFormValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/category")
public class ProductCategoryManagementController {
	private static final Logger logger = Logger.getLogger(ProductCategoryManagementController.class);
	
	private ProductCategoryManagementService productCategoryManagementService;
	private ProductSubCategoryManagementService productSubCategoryManagementService;
	private ProductService productService;
	private ProductCategoryFormValidator productCategoryFormValidator;
	private ProductCategoryVO productCategory;
	@Value("${image.folder}")
    private String imageFolderSource;

	@Autowired
	public ProductCategoryManagementController(ProductCategoryManagementService productCategoryManagementService, 
			ProductSubCategoryManagementService productSubCategoryManagementService,
			ProductService productService,
			ProductCategoryFormValidator productCategoryFormValidator){
		this.productCategoryManagementService = productCategoryManagementService;
		this.productSubCategoryManagementService = productSubCategoryManagementService;
		this.productService = productService;
		this.productCategoryFormValidator = productCategoryFormValidator;
	}
	
	@RequestMapping("/listProductCategory")  
    public String listProductCategory(HttpSession session) {  
    	logger.debug("loading listProductCategory");
        return "listProductCategory";  
    } 
	
	@RequestMapping(value = "/getProductCategoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductCategoryList() {
		logger.debug("getting Product Category list");
		List<ProductCategoryVO> productCategoryList = productCategoryManagementService.getAllCategories();
		return GeneralUtils.convertListToJSONString(productCategoryList);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.GET)
    public String showAddProductCategoryForm(Model model) {  
    	logger.debug("loading showAddProductCategoryForm");
    	ProductCategoryVO productCategoryVO = new ProductCategoryVO();
    	productCategoryVO.setIsParent("1");
    	productCategoryVO.setDisplayInd("1");
    	
    	model.addAttribute("categoryForm", productCategoryVO);
        return "createProductCategory";  
    }  
	
	@InitBinder("categoryForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(productCategoryFormValidator);
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.POST)
    public String saveProductCategory(@ModelAttribute("categoryForm") @Validated ProductCategoryVO productCategoryVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
		productCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		logger.debug("saveProductcategory() : " + productCategoryVO.toString());
		if (result.hasErrors()) {
			return "createProductCategory";
		} else {
			productCategoryManagementService.saveProductCategory(productCategoryVO);
			if(productCategoryVO.getIsParentBoolean()) {
				ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
				productSubCategoryVO.setName(productCategoryVO.getCategoryName());
		    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		    	productSubCategoryVO.setCategoryId(new Integer(productCategoryVO.getCategoryId()));
		    	productSubCategoryVO.setDisplayIndBoolean(productCategoryVO.getDisplayIndBoolean());
				productSubCategoryManagementService.saveProductSubCategory(productSubCategoryVO);
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Category added successfully!");
		}
		
		
        return "redirect:listProductCategory";  
    }  
	
	@RequestMapping(value = "/deleteProductCategory", method = RequestMethod.POST)
	public String deleteProductCategory(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listProductCategory";
		}
		for (String id : ids) {
			productCategoryManagementService.deleteProductCategory(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product Category(s) deleted successfully!");
		return "redirect:listProductCategory";
	}
	
	
	
	@RequestMapping(value = "/updateProductCategory", method = RequestMethod.POST)
	public String getCategoryToUpdate(HttpSession session, @RequestParam("editBtn") String id, Model model) {
		logger.debug("id = " + id);
		productCategory = productCategoryManagementService.findById(new Integer(id));
		if (productCategory == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		initImages(session, model);
		model.addAttribute("categoryForm", productCategory);
		return "updateProductCategory";
	}
	
	private void initImages(HttpSession session, Model model){
		if(productCategory.getImageMetaList() == null){
			productCategory.setImageMetaList(new LinkedList<FileMetaVO>());
			for(ImageLinkVO img: productCategory.getImageList()) { //imageList from DB convert to imageMeta for display
				FileMetaVO fileMeta = new FileMetaVO();
				
		        fileMeta.setFileName(img.getImagePath().substring(img.getImagePath().lastIndexOf("\\")+1));
		        String filePath = imageFolderSource+img.getImagePath().substring(0,img.getImagePath().lastIndexOf("\\")) + "/" + fileMeta.getFileName();
		        filePath = filePath.replace("/", "\\");
		        File file = new File(filePath);
		        FileInputStream fin = null;
		        try {
		            // create FileInputStream object
		            fin = new FileInputStream(file);
		            byte fileContent[] = new byte[(int)file.length()];
		            fin.read(fileContent);
		            img.setSize(file.length());
			        fileMeta.setFileSize(file.length()/1024+" Kb");
			        fileMeta.setFileType(new MimetypesFileTypeMap().getContentType(file));
			        fileMeta.setBytes(fileContent);
			        fileMeta.setSequence(img.getSequence());
			        fileMeta.setImageId(img.getImageLinkId());
			        productCategory.getImageMetaList().add(fileMeta);
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
			}
    	}
		reshuffleFiles(productCategory.getImageMetaList());
		session.setAttribute("productCategory", productCategory);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(productCategory.getImageList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("images", json);
	}
	
	@RequestMapping(value = "/updateProductCategory/{id}", method = RequestMethod.GET)
	public String getCategoryToUpdateByRedirect(@PathVariable String id, HttpSession session, Model model) {
		logger.debug("id = " + id);
		productCategory = productCategoryManagementService.findById(new Integer(id));
		if (productCategory == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		initImages(session, model);
		model.addAttribute("categoryForm", productCategory);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/updateProductCategoryToDb", method = RequestMethod.POST)
	public String updateProductCategory(@ModelAttribute("categoryForm") @Validated ProductCategoryVO productCategoryVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpSession session) {
		
		logger.debug("updateProductCategory() : " + productCategoryVO.toString());
		
		productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
		if (!result.hasErrors()) {
			ProductCategoryVO currentCategory = productCategoryManagementService.findById(productCategoryVO.getCategoryId());
			if(productCategoryVO.getIsParentBoolean() != currentCategory.getIsParentBoolean()){ // to parent
				//check if category contains products
				List<ProductSubCategoryVO> subcategoryList = productSubCategoryManagementService.getAllProductSubCategoryByCategory(productCategoryVO.getCategoryId());
				for(ProductSubCategoryVO psc: subcategoryList) {
					List<ProductVO> productList = productService.getAllProductsBySubCategory(psc.getSubCategoryId());
					if(productList.size() > 0){
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Please remove products from the category!");
						return "redirect:updateProductCategory/" + productCategoryVO.getCategoryId();
					}
				}
			}
			
			//process image files
			HashMap<Integer, FileMetaVO> imageHM = new HashMap<Integer, FileMetaVO>();
			Iterator<FileMetaVO> i  = productCategory.getImageMetaList().iterator();
			while(i.hasNext()){
				FileMetaVO fileVo = i.next();
				if(fileVo.getImageId() != null){ //already exist
					imageHM.put(fileVo.getImageId(), fileVo);
				}else{ //newly uploaded
					ImageLinkVO imageVO = convertFileMetaVOToImageLinkVO(fileVo, productCategoryVO);
					productCategory.getImageList().add(imageVO);
				}
			}	
			
			boolean pass = true;
			for(ImageLinkVO img : productCategory.getImageList()){
				if(img.getImageLinkId() == null) { //new
					if(!uploadFileToDisk(img)){ //if fail upload
						redirectAttributes.addFlashAttribute("css", "danger");
						redirectAttributes.addFlashAttribute("msg", "Error with uploading " + img.getFileName() + "!");
						pass = false;
						break;
					}
				}else{ //existing
					if(!img.isRemoveInd()) {
						FileMetaVO file = imageHM.get(img.getImageLinkId());
						img.setSequence(file.getSequence());
					}
//					else{ //if delete in dropzone
//						if(!deleteFileFromDisk(imageFolderSource+img.getImagePath().substring(StringUtils.ordinalIndexOf(img.getImagePath(), "\\",3)+1))) {
//							redirectAttributes.addFlashAttribute("css", "danger");
//							redirectAttributes.addFlashAttribute("msg", "Error with deleting " + img.getFileName() + "!");
//							pass = false;
//							break;
//						}
//					}
				}
			}
			if(pass){
				productCategoryManagementService.initUpdateProductCategory(productCategoryVO, productCategory.getImageList(), productCategory.getDeletedImageList());
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Product Category updated successfully!");
				return "redirect:listProductCategory";
			}
			return "redirect:updateProductCategory/" + productCategoryVO.getCategoryId();
		}
		initImages(session, model);
		return "updateProductCategory";
	}
	
	private ImageLinkVO convertFileMetaVOToImageLinkVO(FileMetaVO fileVO, ProductCategoryVO productCategoryVO) {
		ImageLinkVO imageVO = new ImageLinkVO();
		imageVO.setRefType(GeneralUtils.TYPE_PRODUCT_CATEGORY);
		imageVO.setRefId(productCategoryVO.getCategoryId());
		imageVO.setImagePath(imageFolderSource+GeneralUtils.CATEGORY_PATH+fileVO.getFileName());
		imageVO.setSequence(fileVO.getSequence());
		imageVO.setFileName(fileVO.getFileName());
		imageVO.setBytes(fileVO.getBytes());
		return imageVO;
	}
	
	private boolean uploadFileToDisk(ImageLinkVO img) {
		//fileName - filename.jpg
		//img.imagePath - d://images/category\filename.jpg
		//
		try {
			int i = 1;
			int s = StringUtils.ordinalIndexOf(img.getImagePath(), "/", 3);
			String fileLoc = imageFolderSource.replace("/", "\\")+img.getImagePath().substring(s+1);
			int periodIndex = fileLoc.lastIndexOf(".");
			int slashIndex = fileLoc.lastIndexOf("\\");
			String fileName = fileLoc.substring(slashIndex+1, periodIndex);
			
			while(checkFileExist(fileLoc)){
				fileLoc = fileLoc.substring(0,slashIndex+1) + fileName + "_" + i + fileLoc.substring(periodIndex);
				periodIndex = fileLoc.lastIndexOf(".");
				slashIndex = fileLoc.lastIndexOf("\\");
				img.setFileName(fileLoc.substring(slashIndex+1));
				i++;
			}
			img.setImagePath(fileLoc);
			FileOutputStream fos = new FileOutputStream(img.getImagePath());
			fos.write(img.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean checkFileExist(String path){
		File file = new File(path);
		if(file.exists()){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean deleteFileFromDisk(String imgPath) {
		try {
			File file = new File(imgPath);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMetaVO> upload(HttpSession session, MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            if(!checkFileFormat(mpf)){
            	return null;
            }
            
            FileMetaVO fileMeta = new FileMetaVO();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
               fileMeta.setBytes(mpf.getBytes());
           } catch (IOException e) {
               e.printStackTrace();
           }
            productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
            if(productCategory != null){
            	if(productCategory.getImageMetaList() == null){
            		productCategory.setImageMetaList(new LinkedList<FileMetaVO>());
            	}
            	fileMeta.setSequence(productCategory.getImageMetaList().size() + 1);
            	productCategory.getImageMetaList().add(fileMeta);
            	return productCategory.getImageMetaList();
            }
       }
        reshuffleFiles(productCategory.getImageMetaList());
        return null;
	}
	
	@RequestMapping(value = "/removeUploadFile",method = RequestMethod.POST)
	public @ResponseBody JsonResponseVO removeUploadFile(HttpSession session, HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName,
			HttpServletResponse response) {
		productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
		if(productCategory != null && productCategory.getImageMetaList() != null && productCategory.getImageMetaList().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMetaVO> iterator = productCategory.getImageMetaList().iterator();
			while(iterator.hasNext()){
				FileMetaVO file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
					for(ImageLinkVO imageVO : productCategory.getImageList()) {
						if(imageVO.getImageLinkId() != null && imageVO.getImageLinkId().equals(file.getImageId()))
							imageVO.setRemoveInd(true);
					}
					iterator.remove();
					break;
				}
			}
			reshuffleFiles(productCategory.getImageMetaList());
		}
		session.setAttribute("productCategory", productCategory);
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/sortImage", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveOption(HttpSession session, @RequestBody List<String> orderList) {
		ProductCategoryVO vo = (ProductCategoryVO) session.getAttribute("productCategory");
		if(vo.getImageMetaList() != null && vo.getImageMetaList().size() > 0){
			for(FileMetaVO image : vo.getImageMetaList()){
				int index = orderList.indexOf(image.getFileName());
				if(index < 0){
					image.setSequence(0);
				}
				else{
					image.setSequence(index + 1);
				}
			}
			reshuffleFiles(vo.getImageMetaList());
		}
		return new JsonResponseVO("success");
	}
	
	private boolean checkFileFormat(MultipartFile mpf) {
		try {
			ImageIO.read(mpf.getInputStream());
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private void reshuffleFiles(LinkedList<FileMetaVO> files) {
		if(files != null && files.size() > 0){
			Collections.sort(files,new FileCompare());
			for(int i=0;i<files.size(); i++){
				files.get(i).setSequence(i+1);
			}
		}
	}
	
	class FileCompare implements Comparator<FileMetaVO>{

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
