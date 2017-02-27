package com.JJ.service.invoicemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.invoicemanagement.InvoiceVo;
import com.JJ.dao.InvoiceMapper;
import com.JJ.helper.GeneralUtils;
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
	
	public Invoice getInvoiceById(Integer id) {
		InvoiceExample invoiceExample = new InvoiceExample();
		invoiceExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andInvoiceidEqualTo(id);
		List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);
		if(invoiceList != null && invoiceList.size() > 0) {
			return invoiceList.get(0);
		}
		return null;
	}
	
	
	public void saveInvoice(Invoice invoice) {
		invoiceMapper.insert(invoice);
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
				if(invoicedata.getInvoiceid() != null && getInvoiceById(invoicedata.getInvoiceid()) == null) {
					saveInvoice(invoicedata);
					fileUploadCount++;
				}
			}
		}
		return fileUploadCount;
	}
	
	/* Invoice END */
	
	
}
