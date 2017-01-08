package com.JJ.service.invoicemanagement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.InvoiceMapper;
import com.JJ.model.Invoice;
import com.JJ.model.InvoiceExample;

@Service
@Transactional
public class InvoiceManagementService {
	private static final Logger logger = Logger.getLogger(InvoiceManagementService.class);
	private InvoiceMapper invoiceMapper;
	
	@Autowired
	public InvoiceManagementService(InvoiceMapper invoiceMapper) {
		this.invoiceMapper = invoiceMapper;
	}


	public void updateInvoice(String type, Integer invoiceNo, String messenger,
			Date invoiceDate, Double totalPrice) throws Exception {
		Invoice invoice = new Invoice();
		invoice.setInvoiceid(invoiceNo);
		invoice.setMessenger(messenger);
		invoice.setTotalprice(new BigDecimal(totalPrice));
		invoice.setInvoicedate(invoiceDate);
		invoice.setDteupdated(new Date());
		InvoiceExample example = new InvoiceExample();
		example.createCriteria().andInvoiceidEqualTo(invoiceNo);
		List<Invoice> invoiceList = invoiceMapper.selectByExample(example);
		if(type.equals("new")){
			if(invoiceList == null || invoiceList.size() == 0){
				invoice.setDtecreated(new Date());
				invoiceMapper.insertSelective(invoice);
			}
			
		}else if (type.equals("update")){
			if(invoiceList != null && invoiceList.size() > 0){
				invoice.setDtecreated(null);
				invoiceMapper.updateByPrimaryKeySelective(invoice);
			}else{
				invoice.setDtecreated(new Date());
				invoiceMapper.insertSelective(invoice);
			}
		}
	}

}
