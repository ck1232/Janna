package com.JJ.controller.invoicemanagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.service.invoicemanagement.InvoiceManagementService;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/invoice")
public class InvoiceController {
	private static final Logger logger = Logger.getLogger(InvoiceController.class);
	private InvoiceManagementService invoiceService;
	
	@Autowired
	public InvoiceController(InvoiceManagementService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@RequestMapping(value = "/invoice", method = RequestMethod.POST)  
    public @ResponseBody String createInvoice(HttpServletRequest request,@RequestParam(value="invoiceNo", required=true) Integer invoiceNo,
    		@RequestParam(value="totalPrice", required=true) Double totalPrice,
    		@RequestParam(value="messenger", required=true) String messenger,
    		@RequestParam(value="invoiceDate", required=true) String invoiceDate,
    		@RequestParam(value="type", required=true) String type) {  
		
    	logger.debug("loading invoiceNo" + invoiceNo);
    	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	try {
			Date dteInvoice = formatter.parse(invoiceDate);
			invoiceService.updateInvoice(type, invoiceNo, messenger, dteInvoice, totalPrice);
			logger.debug(dteInvoice.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
    	return null;
    } 
	
	
}
