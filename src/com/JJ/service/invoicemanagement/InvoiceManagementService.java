package com.JJ.service.invoicemanagement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.invoicemanagement.InvoiceSearchCriteria;
import com.JJ.controller.invoicemanagement.InvoiceVo;
import com.JJ.dao.InvoiceMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Expense;
import com.JJ.model.ExpenseExample;
import com.JJ.model.FileMeta;
import com.JJ.model.Invoice;
import com.JJ.model.InvoiceExample;

@Service
@Transactional
public class InvoiceManagementService {
	
	private InvoiceMapper invoiceMapper;
	private ExcelFileHelper excelFileHelper;
	@Autowired
	public InvoiceManagementService(InvoiceMapper invoiceMapper) {
		this.invoiceMapper = invoiceMapper;
	}
		
	/* Invoice START */
	public List<Invoice> getAllInvoice() {
		InvoiceExample invoiceExample = new InvoiceExample();
		invoiceExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);
		return invoiceList;
	}
	
	public List<Invoice> getAllInvoiceByIdList(List<Integer> idList) {
		InvoiceExample example = new InvoiceExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andInvoiceidIn(idList);
		example.setOrderByClause("invoiceDate desc");
		List<Invoice> invoiceList = invoiceMapper.selectByExample(example);
		return invoiceList;
	}
	
	public Invoice getInvoiceById(Integer id) {
		InvoiceExample invoiceExample = new InvoiceExample();
		invoiceExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andInvoiceidEqualTo(id);
		List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);
		if(invoiceList != null && invoiceList.size() > 0) {
			return invoiceList.get(0);
		}
		return null;
	}
	
	public List<Invoice> searchInvoice(InvoiceSearchCriteria searchCriteria) {
		List<Invoice> invoiceList = getAllInvoice();
		List<Invoice> filteredList = new ArrayList<Invoice>();
		
		for(Invoice invoice : invoiceList) {
			if(!searchCriteria.getMessenger().trim().equalsIgnoreCase(invoice.getMessenger())) continue;
			if(!searchCriteria.getStatus().equalsIgnoreCase("ALL")&& !searchCriteria.getStatus().trim().equalsIgnoreCase(invoice.getStatus())) continue;
			if(!searchCriteria.getInvoicedatefrom().isEmpty()){
				try {
					if(null == invoice.getInvoicedate()) continue;
					Date datefrom = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getInvoicedatefrom());
					if(invoice.getInvoicedate().compareTo(datefrom) < 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!searchCriteria.getInvoicedateto().isEmpty()){
				try {
					if(null == invoice.getInvoicedate()) continue;
					Date dateto = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getInvoicedateto());
					Calendar c = Calendar.getInstance();
					c.setTime(dateto);
					c.add(Calendar.DATE, 1);
					if(invoice.getInvoicedate().compareTo(c.getTime()) > 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			filteredList.add(invoice);
		}
		return filteredList;
	}
	
	
	public void saveInvoice(Invoice invoice) {
		invoiceMapper.insert(invoice);
	}
	
	public void updateInvoice(Invoice invoice) {
		Invoice savedInvoice = getInvoiceById(invoice.getInvoiceid());
		savedInvoice.setMessenger(invoice.getMessenger());
		savedInvoice.setInvoicedate(invoice.getInvoicedate());
		savedInvoice.setTotalprice(invoice.getTotalprice());
		savedInvoice.setStatus(invoice.getStatus());
		invoiceMapper.updateByPrimaryKey(savedInvoice);
	}
	
	public void saveInvoiceList(List<Invoice> invoiceList) {
		for(Invoice invoice : invoiceList)
			saveInvoice(invoice);
	}
	
	public void deleteInvoice(Integer invoiceid) {
		invoiceMapper.deleteByPrimaryKey(invoiceid);
	}
	
	public void deleteInvoiceList(List<Integer> invoiceidList) {
		for(Integer invoiceid : invoiceidList)
			deleteInvoice(invoiceid);
	}
	
	public int saveInvoiceFromUploadFile(InvoiceVo invoice) {
		excelFileHelper = new ExcelFileHelper();
		Invoice invoicedata;
		int fileUploadCount = 0;
		for(FileMeta file : invoice.getInvoiceList()) {
			invoicedata = excelFileHelper.readFromFile(file.getBytes());
			if(invoicedata != null){
				invoicedata.setStatus(GeneralUtils.STATUS_PENDING);
				Invoice savedInvoice = getInvoiceById(invoicedata.getInvoiceid());
				if(invoicedata.getInvoiceid() != null && savedInvoice == null) {
					saveInvoice(invoicedata);
					fileUploadCount++;
				}else if(invoicedata.getInvoiceid() != null && savedInvoice != null){
					updateInvoice(invoicedata);
					fileUploadCount++;
				}
			}
		}
		return fileUploadCount;
	}
	
	public HSSFWorkbook writeToFile(File inputfile, List<Invoice> invoiceList, String statementPeriod) {
		excelFileHelper = new ExcelFileHelper();
		HSSFWorkbook wb = excelFileHelper.writeToFile(inputfile, invoiceList, statementPeriod);
		return wb;
	}
	
	/* Invoice END */
	
	
}
