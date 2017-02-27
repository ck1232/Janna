package com.JJ.controller.invoicemanagement;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.JJ.model.FileMeta;
import com.JJ.model.Invoice;
import com.JJ.model.JsonResponse;
import com.JJ.service.invoicemanagement.InvoiceManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/invoice")
public class InvoiceManagementController {
	private static final Logger logger = Logger.getLogger(InvoiceManagementController.class);
	
	private InvoiceManagementService invoiceManagementService;
	List<Invoice> invoiceList;
	InvoiceVo invoiceVo;
	
	@Autowired
	public InvoiceManagementController(InvoiceManagementService invoiceManagementService) {
		this.invoiceManagementService = invoiceManagementService;
	}
	
	
	@RequestMapping(value = "/listInvoice", method = RequestMethod.GET)  
    public String listInvoice(Model model) {  
    	logger.debug("loading listInvoice");
    	
    	invoiceVo = new InvoiceVo();
    	model.addAttribute("invoiceForm", invoiceVo);
        return "listInvoice";  
    }

	
	@RequestMapping(value = "/getInvoiceList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInventoryProductList() {
		logger.debug("getting inventory history list");
		invoiceList = invoiceManagementService.getAllInvoice();
		return GeneralUtils.convertListToJSONString(invoiceList);
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
			redirectAttributes.addFlashAttribute("msg", "Please upload at least one file!");
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