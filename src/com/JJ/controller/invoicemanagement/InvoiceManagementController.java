package com.JJ.controller.invoicemanagement;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.context.annotation.Scope;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.JsonResponseVO;
import com.JJ.controller.invoicemanagement.vo.InvoiceUploadVO;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.paymentmanagement.vo.PaymentRsVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.grantmanagement.GrantManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.paymentmanagement.PaymentRSManagementService;
import com.JJ.validator.GrantFormValidator;
import com.JJ.validator.InvoiceSearchValidator;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/invoice")
@SessionAttributes({"invoiceUploadVo", "statusList"})
public class InvoiceManagementController {
	private static final Logger logger = Logger.getLogger(InvoiceManagementController.class);
	
	private PaymentManagementController paymentManagementController;
	private PaymentRSManagementService paymentRSManagementService;
	private InvoiceManagementService invoiceManagementService;
	private GrantManagementService grantManagementService;
	private PaymentManagementService paymentManagementService;
	private InvoiceSearchValidator invoiceSearchValidator;
	private GrantFormValidator grantFormValidator;

	private static final String uploadPassword = "uploadExcelFile1232";
	@Autowired
	public InvoiceManagementController(PaymentManagementController paymentManagementController,
			PaymentRSManagementService paymentRSManagementService,
			InvoiceManagementService invoiceManagementService,
			GrantManagementService grantManagementService,
			PaymentManagementService paymentManagementService,
			InvoiceSearchValidator invoiceSearchValidator) {
		this.paymentManagementController = paymentManagementController;
		this.paymentRSManagementService = paymentRSManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.grantManagementService = grantManagementService;
		this.paymentManagementService = paymentManagementService;
		this.invoiceSearchValidator = invoiceSearchValidator;
	}
	
	
	@RequestMapping(value = "/listInvoice", method = RequestMethod.GET)  
    public String listInvoice(Model model) {  
    	logger.debug("loading listInvoice");
    	
    	InvoiceSearchCriteria searchCriteria = new InvoiceSearchCriteria();
    	
    	Map<String,String> statusList = new LinkedHashMap<String,String>();
    	statusList.put(InvoiceStatusEnum.PAID.toString(), InvoiceStatusEnum.PAID.getStatus());
    	statusList.put(InvoiceStatusEnum.PENDING.toString(), InvoiceStatusEnum.PENDING.getStatus());
    	model.addAttribute("exportForm", searchCriteria);
    	model.addAttribute("invoiceUploadVo", new InvoiceUploadVO());
    	model.addAttribute("statusList", statusList);
        return "listInvoice";  
    }

	
	@RequestMapping(value = "/getInvoiceList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInvoiceList() {
		logger.debug("get Invoice List");
		List<InvoiceVO> invoiceList = invoiceManagementService.getAllInvoice();
		List<InvoiceVO> grantList = grantManagementService.getAllGrant();
		if(!grantList.isEmpty()){
			invoiceList.addAll(grantList);
		}
		return GeneralUtils.convertListToJSONString(invoiceList);
	}
	
	@RequestMapping(value = "/getMessengerList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<InvoiceVO> getMessengerList() {
		logger.debug("getting messenger list");
		List<String> messengerList = invoiceManagementService.getAllMessenger();		
		List<InvoiceVO> invoiceList = new ArrayList<InvoiceVO>();
		for(String s: messengerList) {
			InvoiceVO invoice = new InvoiceVO();
			invoice.setMessenger(s);
			invoiceList.add(invoice);
		}
		return invoiceList;
	}
	
	@RequestMapping(value = "/viewInvoice", method = RequestMethod.POST)
	public String viewInvoice(@RequestParam("viewBtn") String id, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("id = " + id);
		InvoiceVO invoiceVO = null;
		String[] splitId = id.split("-");
		if(splitId[0] != null && splitId[1] != null){
			if(splitId[1].toLowerCase().equals("invoice")) {
				invoiceVO = invoiceManagementService.getInvoiceById(Integer.valueOf(splitId[0]));
			}else if(splitId[1].toLowerCase().equals("grant")) {
				invoiceVO = grantManagementService.getGrantById(Integer.valueOf(splitId[0]));
			}
		}
		if (invoiceVO == null) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Invoice not found!");
			return "redirect:listInvoice";
		}
		model.addAttribute("invoice", invoiceVO);
		List<PaymentDetailVO> paymentList = paymentManagementService.getAllPaymentByRefTypeAndRefId(invoiceVO.getType(), Integer.valueOf(splitId[0]));
		model.addAttribute("paymentList", paymentList);
		List<PaymentRsVO> rsList = new ArrayList<PaymentRsVO>();
		if(paymentList != null && paymentList.size() > 0){
			rsList = paymentRSManagementService.getAllPaymentByPaymentDetailId(paymentList.get(0).getPaymentDetailId());
		}
		List<InvoiceVO> otherList = new ArrayList<InvoiceVO>();
		List<Integer> idList = new ArrayList<Integer>();
		if(rsList != null && !rsList.isEmpty()) {
			for(PaymentRsVO vo : rsList) {
				if(vo.getReferenceId() != null && !splitId[0].equals(String.valueOf(vo.getReferenceId()))) {
					idList.add(vo.getReferenceId());
				}
			}
			otherList = invoiceManagementService.getAllInvoiceByIdList(idList);
		}
		model.addAttribute("otherList", otherList);
		return "viewInvoice";

	}
	
	@RequestMapping(value = "/createGrant", method = RequestMethod.GET)
    public String showAddGrantForm(Model model) {  
    	logger.debug("loading showAddGrantForm");
    	InvoiceVO invoiceVO = new InvoiceVO();
    	model.addAttribute("grantForm", invoiceVO);
        return "createGrant";  
    }  
	
	@InitBinder("grantForm")
	protected void initBinderForGrant(WebDataBinder binder) {
		binder.setValidator(grantFormValidator);
	}
	
	@RequestMapping(value = "/createGrant", method = RequestMethod.POST)
    public String saveGrant(@ModelAttribute("grantForm") @Validated InvoiceVO invoiceVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		GeneralUtils.validate(invoiceVO, "grantForm" ,result);
		logger.debug("saveGrant() : " + invoiceVO.toString());
		if (result.hasErrors()) {
			return "createGrant";
		} else {
			invoiceVO.setStatus(GeneralUtils.STATUS_PENDING);
			grantManagementService.saveGrant(invoiceVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Grant added successfully!");
		}
        return "redirect:listInvoice";  
    }  
	
	@RequestMapping(value = "/createGrantAndPay", method = RequestMethod.POST)
    public String saveGrantAndPay(@ModelAttribute("grantForm") @Validated InvoiceVO invoiceVO, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		GeneralUtils.validate(invoiceVO, "grantForm" ,result);
		List<String> idList = new ArrayList<String>();
		logger.debug("saveGrantAndPay() : " + invoiceVO.toString());
		if (result.hasErrors()) {
			return "createGrant";
		} else {
			invoiceVO.setStatus(GeneralUtils.STATUS_PENDING);
			grantManagementService.saveGrant(invoiceVO);			
			idList.add(invoiceVO.getGrantId().toString()+"-grant");
		}
		return paymentManagementController.createPayInvoice(idList, redirectAttributes, model);
    }  
	
	@RequestMapping(value = "/updateGrant", method = RequestMethod.POST)
	public String getGrantToUpdate(@RequestParam("editBtn") String id, Model model, 
			final RedirectAttributes redirectAttributes) {
		String[] splitId = id.split("-");
		if(splitId[0] != null && splitId[1] != null){
			InvoiceVO grantVO = grantManagementService.getGrantById(new Integer(splitId[0]));
			if(grantVO.getGrantId() == null){
				redirectAttributes.addFlashAttribute("css", "danger");
				redirectAttributes.addFlashAttribute("msg", "Grant not found!");
				return "redirect:listInvoice";
			}
			logger.debug("Loading update grant page for " + grantVO.toString());
			model.addAttribute("grantForm", grantVO);
		}
		return "updateGrant";
	}
	
	@RequestMapping(value = "/updateGrantToDb", method = RequestMethod.POST)
	public String updateGrant(@ModelAttribute("grantForm") @Validated InvoiceVO grantVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateGrant() : " + grantVO.toString());
		GeneralUtils.validate(grantVO, "grantForm" ,result);
		if (result.hasErrors()) {
			return "updateGrant";
		} else {
			grantVO.setInvoiceDate(GeneralUtils.convertStringToDate(grantVO.getInvoicedateString(), "dd/MM/yyyy"));
			grantManagementService.updateGrant(grantVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Grant updated successfully!");
		}
		
		return "redirect:listInvoice";
	}
	
	@RequestMapping(value = "/createBadDebt", method = RequestMethod.POST)
	public String createBadDebt(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listInvoice";
		}
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			String[] splitId = id.split("-");
			if(splitId[0] != null && splitId[1] != null){
				if(splitId[1].toLowerCase().equals("invoice")) {
					idList.add(new Integer(splitId[0]));
					logger.debug("bad debt invoice: "+ id);
				}else if(splitId[1].toLowerCase().equals("grant")) {
					logger.debug("bad debt grant: "+ id);
					redirectAttributes.addFlashAttribute("css", "danger");
					redirectAttributes.addFlashAttribute("msg", "Grant(s) cannot be set as BAD DEBT!");
					return "redirect:listInvoice";
				}
			}
			
		}
		if(!idList.isEmpty()){
			invoiceManagementService.updateBadDebt(idList);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Invoice(s) set as BAD DEBT successfully!");
		return "redirect:listInvoice";
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
	public @ResponseBody LinkedList<FileMetaVO> upload(MultipartHttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("invoiceUploadVo") InvoiceUploadVO invoiceUploadVo) {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            if(!checkFileFormat(mpf.getOriginalFilename())){
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
            if(invoiceUploadVo != null){
            	if(invoiceUploadVo.getInvoiceList() == null){
            		invoiceUploadVo.setInvoiceList(new LinkedList<FileMetaVO>());
            	}
            	fileMeta.setSequence(invoiceUploadVo.getInvoiceList().size() + 1);
            	invoiceUploadVo.getInvoiceList().add(fileMeta);
            	return invoiceUploadVo.getInvoiceList();
            }
       }
        reshuffleFiles(invoiceUploadVo.getInvoiceList());
        return null;
	}
	
	@RequestMapping(value = "/removeUploadFile",method = RequestMethod.POST)
	public @ResponseBody JsonResponseVO removeUploadFile(HttpServletRequest request,@RequestParam(value="fileName", required=false) String fileName,
			HttpServletResponse response, @ModelAttribute("invoiceUploadVo") InvoiceUploadVO invoiceUploadVo) {
		if(invoiceUploadVo != null && invoiceUploadVo.getInvoiceList() != null && invoiceUploadVo.getInvoiceList().size() > 0 && fileName != null && !fileName.trim().isEmpty()){
			Iterator<FileMetaVO> iterator = invoiceUploadVo.getInvoiceList().iterator();
			while(iterator.hasNext()){
				FileMetaVO file = iterator.next();
				if(file.getFileName().compareToIgnoreCase(fileName) == 0){
					iterator.remove();
					break;
				}
			}
			reshuffleFiles(invoiceUploadVo.getInvoiceList());
		}
		return new JsonResponseVO("success");
	}
	
	@RequestMapping(value = "/sortFile", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO sortFile(@RequestBody List<String> orderList,
			@ModelAttribute("invoiceUploadVo") InvoiceUploadVO invoiceUploadVo) {
		if(invoiceUploadVo.getInvoiceList() != null && invoiceUploadVo.getInvoiceList().size() > 0){
			for(FileMetaVO file : invoiceUploadVo.getInvoiceList()){
				int index = orderList.indexOf(file.getFileName());
				if(index < 0){
					file.setSequence(0);
				}
				else{
					file.setSequence(index + 1);
				}
			}
			reshuffleFiles(invoiceUploadVo.getInvoiceList());
		}
		return new JsonResponseVO("success");
	}

	private void reshuffleFiles(LinkedList<FileMetaVO> files) {
		if(files != null && files.size() > 0){
			Collections.sort(files,new FileCompare());
			for(int i=0;i<files.size(); i++){
				files.get(i).setSequence(i+1);
			}
		}
	}
	
	
	@RequestMapping(value = "/uploadInvoice", method = RequestMethod.POST)
	public String saveInvoice(final RedirectAttributes redirectAttributes,
			@ModelAttribute("invoiceUploadVo") InvoiceUploadVO invoiceUploadVo, Model model) {
		if(invoiceUploadVo == null || invoiceUploadVo.getInvoiceList() == null || invoiceUploadVo.getInvoiceList().isEmpty()) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please upload at least one excel file!");
		}else{
			try{
				int fileUploadCount = invoiceManagementService.saveInvoiceFromUploadFile(invoiceUploadVo);
				logger.debug("upload done");
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", fileUploadCount + " invoice(s) added successfully!");
			}catch(Exception ex){
				logger.debug("error:",ex);
				redirectAttributes.addFlashAttribute("css", "danger");
				redirectAttributes.addFlashAttribute("msg", "Upload failed");
			}
			
			model.addAttribute("invoiceUploadVo", new InvoiceUploadVO());
			
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
			String[] splitId = id.split("-");
			if(splitId[0] != null && splitId[1] != null){
				if(splitId[1].toLowerCase().equals("invoice")) {
					invoiceManagementService.deleteInvoice(new Integer(splitId[0]));
					logger.debug("deleted invoice: "+ id);
				}else if(splitId[1].toLowerCase().equals("grant")) {
					grantManagementService.deleteGrant(new Integer(splitId[0]));
					logger.debug("deleted grant: "+ id);
				}
			}
			
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Invoice/Grant(s) deleted successfully!");
		return "redirect:listInvoice";
	}
	
	@RequestMapping(value = "/payInvoice", method = RequestMethod.POST)
    public String payInvoice(@RequestParam("payBtn") String id, Model model,
    		final RedirectAttributes redirectAttributes) {
		List<String> idList = new ArrayList<String>();
		idList.add(id);
		return paymentManagementController.createPayInvoice(idList, redirectAttributes, model);
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
			List<InvoiceVO> invoiceList = invoiceManagementService.searchInvoice(searchCriteria);
			if(invoiceList != null && !invoiceList.isEmpty()){
				String statementPeriod = getStatementPeriod(searchCriteria);
				downloadExcel(invoiceList, statementPeriod, request, response);
				return null;
			}
			else{
				redirectAttributes.addFlashAttribute("css", "danger");
				redirectAttributes.addFlashAttribute("msg", "No invoice result is found!");
		    	
		    	model.addAttribute("exportForm", searchCriteria);
				return "redirect:listInvoice";
			}
				
		}
    	
    	model.addAttribute("exportForm", searchCriteria);
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
	
	public void downloadExcel(List<InvoiceVO> invoiceList, String statementPeriod, 
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
	
	@RequestMapping(value = "/saveExcelInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponseVO saveExcelInvoice(@RequestParam(value = "invoiceId") Integer invoiceId,
			@RequestParam(value = "messenger") String messenger,
			@RequestParam(value = "dateString") String invoiceDateString,
			@RequestParam(value = "amt") BigDecimal totalAmt,
			@RequestParam(value = "password", required = false) String password){
		if(password.compareTo(uploadPassword) != 0){
			return new JsonResponseVO("error uploading");
		}
		try{
			Date invoiceDate = GeneralUtils.convertStringToDate(invoiceDateString, "dd/MM/yyyy");
			InvoiceVO invoiceVO = new InvoiceVO();
			invoiceVO.setInvoiceId(invoiceId);
			invoiceVO.setDeleteInd(GeneralUtils.NOT_DELETED);
			invoiceVO.setInvoiceDate(invoiceDate);
			invoiceVO.setMessenger(messenger);
			invoiceVO.setTotalAmt(totalAmt);
			
			InvoiceVO savedInvoice = invoiceManagementService.getInvoiceById(invoiceVO.getInvoiceId());
			if(invoiceVO.getInvoiceId() != null && savedInvoice == null) {
				invoiceVO.setStatus(GeneralUtils.STATUS_PENDING);
				invoiceManagementService.saveInvoice(invoiceVO);
			}else if(invoiceVO.getInvoiceId() != null && savedInvoice != null){
				if(savedInvoice.getStatus() != null &&
						savedInvoice.getStatus().compareTo(InvoiceStatusEnum.PAID.getStatus()) == 0){
					invoiceVO.setTotalAmt(savedInvoice.getTotalAmt());
				}
				invoiceVO.setStatus(savedInvoice.getStatus());
				invoiceManagementService.updateInvoice(invoiceVO);
			}
		}catch(Exception ex){
			return new JsonResponseVO("uploading failed");
		}
		return new JsonResponseVO("uploading success");
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