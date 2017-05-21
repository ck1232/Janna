package com.JJ.controller.reportmanagement.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
@Component
public class ExpenseReport implements ReportInterface {
	
	private InvoiceManagementService invoiceService;
	
	@Autowired
	public ExpenseReport(InvoiceManagementService invoiceService) {
		this.invoiceService = invoiceService;
	}



	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		Sheet sheet = workbook.createSheet("Expense report");
		List<InvoiceVO> vo = invoiceService.getAllInvoice();
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addNumberMapping("Invoice ID", "invoiceId");
		ReportUtils.writeData(sheet, vo, reportMapping);
		return workbook;
	}
	
}
