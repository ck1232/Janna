package com.JJ.controller.demomanagement;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.model.Product;
import com.JJ.model.ProductimageWithBLOBs;
import com.JJ.service.productmanagement.ProductService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/demo")
public class DemoController {
	private static final Logger logger = Logger.getLogger(DemoController.class);
	private ProductService productService;
	
	@Autowired
	public DemoController(ProductService productService) {
		this.productService = productService;
	}


	@RequestMapping("/listProduct")  
    public String listProduct(HttpSession session, Model model) {
    	logger.debug("loading listProduct");
    	List<Product> productList = productService.getAllProducts();
    	model.addAttribute("productList", productList);
        return "listBuyProduct";  
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
}
