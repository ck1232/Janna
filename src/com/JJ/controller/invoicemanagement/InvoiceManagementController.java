package com.JJ.controller.invoicemanagement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.model.Expense;
import com.JJ.model.FileMeta;
import com.JJ.model.Invoice;
import com.JJ.model.JsonResponse;
import com.JJ.model.Paymentdetail;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.validator.InvoiceSearchValidator;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/invoice")
public class InvoiceManagementController {
	private static final Logger logger = Logger.getLogger(InvoiceManagementController.class);
	
	private InvoiceManagementService invoiceManagementService;
	private PaymentManagementService paymentManagementService;
	private InvoiceSearchValidator invoiceSearchValidator;
	private PaymentModeLookup paymentModeLookup;
	List<Invoice> invoiceList;
	InvoiceVo invoiceVo;
	InvoiceSearchCriteria searchCriteria;
	Map<String,String> statusList;
	
	@Autowired
	public InvoiceManagementController(InvoiceManagementService invoiceManagementService,
			PaymentManagementService paymentManagementService,
			InvoiceSearchValidator invoiceSearchValidator,
			PaymentModeLookup paymentModeLookup) {
		this.invoiceManagementService = invoiceManagementService;
		this.paymentManagementService = paymentManagementService;
		this.invoiceSearchValidator = invoiceSearchValidator;
		this.paymentModeLookup = paymentModeLookup;
	}
	
	
	@RequestMapping(value = "/listInvoice", method = RequestMethod.GET)  
    public String listInvoice(Model model) {  
    	logger.debug("loading listInvoice");
    	
    	invoiceVo = new InvoiceVo();
    	searchCriteria = new InvoiceSearchCriteria();
    	
    	statusList = new LinkedHashMap<String,String>();
    	statusList.put(InvoiceStatus.PAID.toString(), InvoiceStatus.PAID.getStatus());
    	statusList.put(InvoiceStatus.PENDING.toString(), InvoiceStatus.PENDING.getStatus());
    	model.addAttribute("invoiceForm", invoiceVo);
    	model.addAttribute("exportForm", searchCriteria);
    	model.addAttribute("statusList", statusList);
        return "listInvoice";  
    }

	
	@RequestMapping(value = "/getInvoiceList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory history list");
		invoiceList = invoiceManagementService.getAllInvoice();
		return GeneralUtils.convertListToJSONString(invoiceList);
	}
	
	@RequestMapping(value = "/viewInvoice", method = RequestMethod.POST)
	public String viewInvoice(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		Invoice invoice = invoiceManagementService.getInvoiceById(new Integer(id));
		if (invoice == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Invoice not found");
		}else{
			invoice.setInvoicedateString(new SimpleDateFormat("dd/MM/yyyy").format(invoice.getInvoicedate()));
			model.addAttribute("invoice", invoice);
			List<Paymentdetail> paymentList = paymentManagementService.getAllPaymentByRefTypeAndRefId("invoice", invoice.getInvoiceid());
			if(paymentList != null && paymentList.size() > 0){
				for(Paymentdetail payment : paymentList) {
					payment.setPaymentdateString(new SimpleDateFormat("dd/MM/yyyy").format(payment.getPaymentdate()));
					payment.setPaymentmodeString(paymentModeLookup.getPaymentModeById(payment.getPaymentmode()));
				}
			}
			model.addAttribute("paymentList", paymentList);
		}
		return "viewInvoice";

	}
	
	private boolean checkFileFormat(String filename) {
		String[] split = filename.split(Pattern.quote("."));
		String format = split[split.length-1];
		if(format.equals("xls") || format.equals("xlsx")){
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            if(!checkFileFormat(mpf.getOriginalFilename())){
            	return null;
            }
            
            FileMeta fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
               fileMeta.setBytes(mpf.getBytes());
           } catch (IOException e) {
               e.printStackTrace();
           }
            if(invoiceVo != null){
            	if(invoiceVo.getInvoiceList() == null){
            		invoiceVo.setInvoiceList(new LinkedList<FileMeta>());
            	}
            	fileMeta.setSequence(invoiceVo.getInvoiceList().size() + 1);
            	invoiceVo.getInvoiceList().add(fileMeta);
            	return invoiceVo.getInvoiceList();
            }
       }
        reshuffleFiles(invoiceVo.getInvoiceList());
        return null;
	}
	
	@RequestMapping(value = "/removeUploadFile",method = RequestMethod.POST)
	public @ResponseBody JsonResponse removeUploadFile(HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName, HttpServletResponse response) {
		if(invoiceVo != null && invoiceVo.getInvoiceList() != null && invoiceVo.getInvoiceList().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMeta> iterator = invoiceVo.getInvoiceList().iterator();
			while(iterator.hasNext()){
				FileMeta file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
					iterator.remove();
					break;
				}
			}
			reshuffleFiles(invoiceVo.getInvoiceList());
		}
		return new JsonResponse("success");
	}
	
	@RequestMapping(value = "/sortFile", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse sortFile(@RequestBody List<String> orderList) {
		if(invoiceVo.getInvoiceList() != null && invoiceVo.getInvoiceList().size() > 0){
			for(FileMeta file : invoiceVo.getInvoiceList()){
				int index = orderList.indexOf(file.getFileName());
				if(index < 0){
					file.setSequence(0);
				}
				else{
					file.setSequence(index + 1);
				}
			}
			reshuffleFiles(invoiceVo.getInvoiceList());
		}
		return new JsonResponse("success");
	}

	private void reshuffleFiles(LinkedList<FileMeta> files) {
		if(files != null && files.size() > 0){
			Collections.sort(files,new FileCompare());
			for(int i=0;i<files.size(); i++){
				files.get(i).setSequence(i+1);
			}
		}
	}
	
	
	@RequestMapping(value = "/uploadInvoice", method = RequestMethod.POST)
	public String saveInvoice(final RedirectAttributes redirectAttributes) {
		if(invoiceVo == null || invoiceVo.getInvoiceList() == null || invoiceVo.getInvoiceList().isEmpty()) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please upload at least one excel file!");
		}else{
			
			int fileUploadCount = invoiceManagementService.saveInvoiceFromUploadFile(invoiceVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", fileUploadCount + " invoice(s) added successfully!");
		}
		return "redirect:listInvoice";
	}
	
	@RequestMapping(value = "/deleteInvoice", method = RequestMethod.POST)
	public String deleteInvoice(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listInvoice";
		}
		for (String id : ids) {
			invoiceManagementService.deleteInvoice(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Invoice(s) deleted successfully!");
		return "redirect:listInvoice";
	}
	
	@InitBinder("exportForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(invoiceSearchValidator);
	}
	
	@RequestMapping(value="/downloadExcel", method = RequestMethod.POST)
    public String downloadExcel(@ModelAttribute("exportForm") @Validated InvoiceSearchCriteria searchCriteria, 
    		BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response,
    		final RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			List<Invoice> invoiceList = invoiceManagementService.searchInvoice(searchCriteria);
			if(invoiceList != null && !invoiceList.isEmpty()){
				String statementPeriod = getStatementPeriod(searchCriteria);
				downloadExcel(invoiceList, statementPeriod, request, response);
				return null;
			}
			else{
				redirectAttributes.addFlashAttribute("css", "danger");
				redirectAttributes.addFlashAttribute("msg", "No invoice result is found!");
				statusList = new LinkedHashMap<String,String>();
				statusList.put(InvoiceStatus.PAID.toString(), InvoiceStatus.PAID.getStatus());
		    	statusList.put(InvoiceStatus.PENDING.toString(), InvoiceStatus.PENDING.getStatus());
		    	
		    	model.addAttribute("invoiceForm", invoiceVo);
		    	model.addAttribute("exportForm", searchCriteria);
		    	model.addAttribute("statusList", statusList);
				return "redirect:listInvoice";
			}
				
		}
		statusList = new LinkedHashMap<String,String>();
		statusList.put(InvoiceStatus.PAID.toString(), InvoiceStatus.PAID.getStatus());
    	statusList.put(InvoiceStatus.PENDING.toString(), InvoiceStatus.PENDING.getStatus());
    	
    	model.addAttribute("invoiceForm", invoiceVo);
    	model.addAttribute("exportForm", searchCriteria);
    	model.addAttribute("statusList", statusList);
        return "listInvoice"; 
    }
	
	private String getStatementPeriod(InvoiceSearchCriteria searchCriteria) {
		SimpleDateFormat sdfWithoutSlash = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat sdfWithSlash = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dateFrom;
		String dateTo;
		
		try{
			if(!searchCriteria.getInvoicedatefrom().equals("")) {
				dateFrom = sdfWithoutSlash.format(sdfWithSlash.parse(searchCriteria.getInvoicedatefrom()));
			}else{
				dateFrom = sdfWithoutSlash.format(date);
			}
			
			if(!searchCriteria.getInvoicedateto().equals("")) {
				dateTo = sdfWithoutSlash.format(sdfWithSlash.parse(searchCriteria.getInvoicedateto()));
			}else{
				dateTo = sdfWithoutSlash.format(date);
			}
			
			if(dateFrom.equals(dateTo)) {
				return "of " + dateTo;
			}else if(!dateFrom.equals(dateTo)) {
				return "from " + dateFrom + " to " + dateTo;
			}
			
		}catch(Exception e) {
			logger.info("Error formatting statement period for invoice exporting.");
		}
		return "";
	}
	
	public void downloadExcel(List<Invoice> invoiceList, String statementPeriod, 
			HttpServletRequest request, HttpServletResponse response) {
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/template/");
        File file = new File(dataDirectory+"/invoice_summary_template.xls");
        HSSFWorkbook wb = invoiceManagementService.writeToFile(file, invoiceList, statementPeriod);
        if(wb != null){
        	response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=invoice_summary.xls");
            try{
            	wb.write(response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	
	
	
	class FileCompare implements Comparator<FileMeta>{

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