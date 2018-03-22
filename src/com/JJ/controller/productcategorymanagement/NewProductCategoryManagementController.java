package com.JJ.controller.productcategorymanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.JJ.service.filelinkmanagement.NewImageService;
import com.JJ.service.productcategorymanagement.ProductCategoryMgmtService;
import com.JJ.service.productmanagement.ProductMgmtService;
import com.JJ.validator.ProductCategoryFormValidator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/category")
public class NewProductCategoryManagementController {
	private static final Logger logger = Logger.getLogger(NewProductCategoryManagementController.class);
	
	private ProductCategoryMgmtService productCategoryMgmtService;
	private ProductMgmtService productMgmtService;
	private NewImageService imageService;
	@Value("${image.folder}")
    private String imageFolderSource;
	private ProductCategoryFormValidator productCategoryFormValidator;
	@Autowired
	public NewProductCategoryManagementController(ProductCategoryMgmtService productCategoryMgmtService,
			NewImageService imageService,
			ProductCategoryFormValidator productCategoryFormValidator,
			ProductMgmtService productMgmtService){
		this.productCategoryMgmtService = productCategoryMgmtService;
		this.imageService = imageService;
		this.productCategoryFormValidator = productCategoryFormValidator;
		this.productMgmtService = productMgmtService;
	}
	
	@RequestMapping("/listProductCategory")  
    public String listProductCategory(HttpSession session) {  
    	logger.debug("loading listProductCategory");
        return "listProductCategory";  
    } 
	
	@RequestMapping(value = "/getProductCategoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProductCategoryList() {
		logger.debug("getting Product Category list");
		List<ProductCategoryVO> productCategoryList = productCategoryMgmtService.getAllProductCategoryList();
		return GeneralUtils.convertListToJSONString(productCategoryList);
	}
	
	@RequestMapping(value="/getImage/{id}", method = RequestMethod.GET)
	public void getProductImage(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
		ImageLinkVO image = productCategoryMgmtService.getCoverImageByCategoryId(Long.parseLong(id));
		if(image != null && image.getBytes() != null){
			 try {
				response.setContentType(image.getContentType());
				response.getOutputStream().write(image.getBytes(),0,image.getBytes().length);
				response.getOutputStream().flush();  
				return;
			} catch (Exception e) {
				logger.error("getProductImage-1: Exception", e);
			}
		}else{
			imageService.getNoFileFoundImage(response);
		}
	}
	
	@RequestMapping(value = "/createProductCategory", method = RequestMethod.GET)
    public String showAddProductCategoryForm(Model model) {  
    	logger.debug("loading showAddProductCategoryForm");
    	ProductCategoryVO productCategoryVO = new ProductCategoryVO();
    	productCategoryVO.setIsParentBoolean(Boolean.TRUE);
    	productCategoryVO.setDisplayIndBoolean(Boolean.TRUE);
    	
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
			//create a same name sub category if is a new parent category
			if(productCategoryVO.getIsParentBoolean()) {
				List<ProductSubCategoryVO> list = new ArrayList<ProductSubCategoryVO>();
				ProductSubCategoryVO productSubCategoryVO = new ProductSubCategoryVO();
				productSubCategoryVO.setName(productCategoryVO.getCategoryName());
		    	productSubCategoryVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		    	productSubCategoryVO.setCategoryId(productCategoryVO.getCategoryId());
		    	productSubCategoryVO.setDisplayIndBoolean(productCategoryVO.getDisplayIndBoolean());
		    	list.add(productSubCategoryVO);
		    	productCategoryVO.setSubcategoryList(list);
			}
			productCategoryMgmtService.saveProductCategory(productCategoryVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Product Category added successfully!");
		}
		
		
        return "redirect:listProductCategory";  
    }
	
	@RequestMapping(value = "/editProductCategory", method = RequestMethod.POST)
	public String getCategoryToUpdate(HttpSession session, @RequestParam("editBtn") String id, Model model) {
		logger.debug("id = " + id);
		ProductCategoryVO productCategory = productCategoryMgmtService.getProductCategoryVOById(new Long(id));
		if (productCategory == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product Category not found");
		}
		session.setAttribute("productCategory", productCategory);
		initImages(session, model, productCategory);
		model.addAttribute("categoryForm", productCategory);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/updateProductCategory", method = RequestMethod.POST)
	public String updateProductCategory(@ModelAttribute("categoryForm") @Validated ProductCategoryVO productCategoryVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpSession session) {
		
		logger.debug("updateProductCategory() : " + productCategoryVO.toString());
		ProductCategoryVO productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
		if (!result.hasErrors()) {
			ProductCategoryVO currentCategory = productCategoryMgmtService.getProductCategoryVOById(productCategoryVO.getCategoryId());
			if(productCategoryVO.getIsParentBoolean() != currentCategory.getIsParentBoolean()){ // to parent
				//check if category contains products
				List<ProductSubCategoryVO> subcategoryList = currentCategory.getSubcategoryList();
				List<ProductVO> productList = productMgmtService.getProductVOBySubCategory(subcategoryList);
				if(productList.size() > 0){
					redirectAttributes.addFlashAttribute("css", "danger");
					redirectAttributes.addFlashAttribute("msg", "Please remove products from the category!");
					return "redirect:updateProductCategory/" + productCategoryVO.getCategoryId();
				}
			}
			
			//process image files
			HashMap<Long, FileMetaVO> imageHM = new HashMap<Long, FileMetaVO>();
			Iterator<FileMetaVO> i  = productCategory.getImageMetaList().iterator();
			while(i.hasNext()){
				FileMetaVO fileVo = i.next();
				if(fileVo.getImageId() != null){ //already exist
					imageHM.put(fileVo.getImageId(), fileVo);
				}else{ //newly uploaded
					LinkedList<ImageLinkVO> imageVO = NewImageService.convertFileMetaVOListToImageLinkVOList(Arrays.asList(fileVo), "Category");
					if(productCategory.getImageList() == null){
						productCategory.setImageList(new ArrayList<ImageLinkVO>());
					}
					productCategory.getImageList().add(imageVO.get(0));
				}
			}	
			
			boolean pass = true;
			if(productCategory.getImageList() != null){
				for(ImageLinkVO img : productCategory.getImageList()){
					if(img.getImageLinkId() == null) { //new
						if(!imageService.uploadFileToDisk(img)){ //if fail upload
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
					}
				}
			}
			if(pass){
				productCategoryVO.setImageList(productCategory.getImageList());
				productCategoryMgmtService.saveProductCategory(productCategoryVO);
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Product Category updated successfully!");
				return "redirect:listProductCategory";
			}
			return "redirect:updateProductCategory/" + productCategoryVO.getCategoryId();
		}
		initImages(session, model, productCategoryVO);
		return "updateProductCategory";
	}
	
	@RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMetaVO> upload(HttpSession session, MultipartHttpServletRequest request, HttpServletResponse response) {
		ProductCategoryVO productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
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
		ProductCategoryVO productCategory = (ProductCategoryVO) session.getAttribute("productCategory");
		if(productCategory != null && productCategory.getImageMetaList() != null && productCategory.getImageMetaList().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
				for(ImageLinkVO imageVO : productCategory.getImageList()) {
					if(imageVO.getFileName().compareToIgnoreCase(fileName) == 0){
						imageVO.setRemoveInd(true);
						imageVO.setDeleteInd(GeneralUtils.DELETED);
					}
				}
			reshuffleFiles(productCategory.getImageMetaList());
		}
		session.setAttribute("productCategory", productCategory);
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
	
	@RequestMapping(value = "/deleteProductCategory", method = RequestMethod.POST)
	public String deleteProductCategory(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listProductCategory";
		}
		for (String id : ids) {
			ProductCategoryVO productCategoryVO = productCategoryMgmtService.getProductCategoryVOById(Long.parseLong(id));
			productCategoryVO.setDeleteInd(GeneralUtils.DELETED);
			productCategoryMgmtService.saveProductCategory(productCategoryVO);
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Product Category(s) deleted successfully!");
		return "redirect:listProductCategory";
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
	
	private void initImages(HttpSession session, Model model, ProductCategoryVO productCategory){
		if(productCategory.getImageMetaList() == null){
			productCategory.setImageMetaList(new LinkedList<FileMetaVO>());
			if(productCategory.getImageList() != null){
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
