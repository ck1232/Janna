package com.JJ.controller.productcategorymanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.controller.productcategorymanagement.VO.ProductCategoryVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.filelinkmanagement.NewImageService;
import com.JJ.service.productcategorymanagement.ProductCategoryMgmtService;

@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/category")
public class NewProductCategoryManagementController {
	private static final Logger logger = Logger.getLogger(NewProductCategoryManagementController.class);
	
	private ProductCategoryMgmtService productCategoryMgmtService;
	private NewImageService imageService;
	@Value("${image.folder}")
    private String imageFolderSource;

	@Autowired
	public NewProductCategoryManagementController(ProductCategoryMgmtService productCategoryMgmtService,
			NewImageService imageService){
		this.productCategoryMgmtService = productCategoryMgmtService;
		this.imageService = imageService;
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
}
