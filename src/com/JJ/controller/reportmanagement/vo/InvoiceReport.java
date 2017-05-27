package com.JJ.controller.reportmanagement.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.invoicemanagement.InvoiceStatusEnum;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.helper.vo.ExcelColumn.ColumnStyle;
import com.JJ.service.grantmanagement.GrantManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
@Component
public class InvoiceReport implements ReportInterface {

	private InvoiceManagementService invoiceService;
	private GrantManagementService grantService;
	private PaymentManagementService paymentService;
	
	@Autowired
	public InvoiceReport(InvoiceManagementService invoiceService,
			GrantManagementService grantService,
			PaymentManagementService paymentService) {
		this.invoiceService = invoiceService;
		this.grantService = grantService;
		this.paymentService = paymentService;
	}

	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		
		List<InvoiceVO> dbVoList = invoiceService.getAllInvoice(dateAsOf, endDate);
		List<InvoiceVO> grantList = grantService.getAllGrant(dateAsOf, endDate);
		if(!grantList.isEmpty()){
			dbVoList.addAll(grantList);
		}
		if(dbVoList != null && !dbVoList.isEmpty()) {
			List<InvoiceReportVO> allInvoiceReportList = new ArrayList<InvoiceReportVO>();
			for(InvoiceVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId(vo.getType(), 
						vo.getType().equals("invoice") ? vo.getInvoiceId() : vo.getGrantId());
				InvoiceReportVO invoiceReportVo;
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						invoiceReportVo = new InvoiceReportVO();
						invoiceReportVo.setInvoice(vo);
						if(paymentVO.getPaymentMode() == 2 && 
								(paymentVO.getBounceChequeInd() != null && paymentVO.getBounceChequeInd().equals("Y")))
							continue;
						invoiceReportVo.setPaymentDetail(paymentVO);
						allInvoiceReportList.add(invoiceReportVo);
					}
				}else{
					if(vo.getStatus().equals(InvoiceStatusEnum.PENDING.toString())) {
						invoiceReportVo = new InvoiceReportVO();
						invoiceReportVo.setInvoice(vo);
						allInvoiceReportList.add(invoiceReportVo);
					}
				}
			}
			
			Collections.sort(allInvoiceReportList, new InvoiceReportComparator());			
			ReportMapping reportMapping = new ReportMapping();
			reportMapping.addNumberMapping("Invoice No.", "invoice.invoiceId");
			reportMapping.addTextMapping("Name", "invoice.messenger");
			reportMapping.addDateMapping("Date of Invoice", "invoice.invoiceDate");
			reportMapping.addMoneyMapping("Amount", "invoice.totalAmt");
			reportMapping.addTextMapping("Payment Mode", "paymentDetail.paymentModeString");
			reportMapping.addDateMapping("Cheque Date", "paymentDetail.paymentDate");
			reportMapping.addTextMapping("Cheque No", "paymentDetail.chequeNum");
			reportMapping.addMoneyMapping("Cheque amount", "paymentDetail.paymentAmt");
			reportMapping.addDateMapping("Date debited (per Bank)", "paymentDetail.debitDate");;
			Sheet sheet = workbook.createSheet("Invoice");
			ReportUtils.writeRow(sheet, "TOTAL / CONSOLIDATION", 1, ColumnStyle.Bold);
			ReportUtils.writeBlankRows(sheet, 6);
			ReportUtils.writeRow(sheet, "DETAILS", 1, ColumnStyle.Bold);
			ReportUtils.writeData(sheet, allInvoiceReportList, reportMapping);
			
		}
		return workbook;
	}
	
	class InvoiceReportComparator implements Comparator<InvoiceReportVO> {
		@Override
		public int compare(InvoiceReportVO o1, InvoiceReportVO o2) {
			if(o1.getInvoice().getInvoiceDate() == null && o2.getInvoice().getInvoiceDate() == null){
				return 0;
			}else if(o1.getInvoice().getInvoiceDate() == null && o2.getInvoice().getInvoiceDate() != null){
				return -1;
			}else if(o1.getInvoice().getInvoiceDate() != null && o2.getInvoice().getInvoiceDate() == null){
				return 1;
			}
			return o1.getInvoice().getInvoiceDate().compareTo(o2.getInvoice().getInvoiceDate()) * -1;
		}
	}

}
