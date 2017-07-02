package com.JJ.controller.reportmanagement.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.lookup.vo.ExpenseTypeVO;
import com.JJ.lookup.vo.PaymentModeVO;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
@Component
public class ChinaStockReport implements ReportInterface {
	
	private ExpenseManagementService expenseService;
	private PaymentManagementService paymentService;
	private ExpenseTypeLookup expenseTypeLookup;
	private PaymentModeLookup paymentModeLookup;
	@Autowired
	public ChinaStockReport(ExpenseManagementService expenseService,
			PaymentManagementService paymentService,
			ExpenseTypeLookup expenseTypeLookup,
			PaymentModeLookup paymentModeLookup) {
		this.expenseService = expenseService;
		this.paymentService = paymentService;
		this.expenseTypeLookup = expenseTypeLookup;
		this.paymentModeLookup = paymentModeLookup;
	}



	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		ExpenseTypeVO expenseTypeVO = expenseTypeLookup.getExpenseTypeByValueMap().get("Stock(China)");
		PaymentModeVO chequeModeVo = paymentModeLookup.getPaymentModeByValueMap().get("Cheque");
		List<ExpenseVO> dbVoList = expenseService.getAllExpense(dateAsOf, endDate, expenseTypeVO.getExpenseTypeId());
		List<ExpenseReportVO> expenseReportList = new ArrayList<ExpenseReportVO>();
		if(dbVoList != null && !dbVoList.isEmpty()) {
			for(ExpenseVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId("expense", vo.getExpenseId());
				ExpenseReportVO expenseReportVo;
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						expenseReportVo = new ExpenseReportVO();
						expenseReportVo.setExpense(vo);
						if(paymentVO.getPaymentMode() == chequeModeVo.getPaymentModeId() && 
								(paymentVO.getBounceChequeInd() != null && paymentVO.getBounceChequeInd().equals("Y")))
							continue;
						expenseReportVo.setPaymentDetail(paymentVO);
						expenseReportList.add(expenseReportVo);
					}
				}else{
					expenseReportVo = new ExpenseReportVO();
					expenseReportVo.setExpense(vo);
					expenseReportList.add(expenseReportVo);
				}
			}
			
		}
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addDateMapping("Date", "expense.expenseDate");
		reportMapping.addTextMapping("Invoice", "expense.invoiceNo");
		reportMapping.addTextMapping("Description", "expense.description");
		reportMapping.addTextMapping("Mode of Payment", "paymentDetail.paymentModeString");
		reportMapping.addChinaMoneyMapping("Amount (RMB)", "paymentDetail.paymentAmt");
		reportMapping.addTextMapping("Cheque No.", "paymentDetail.chequeNum");
		Sheet sheet = workbook.createSheet("RMB Purchase");
		ReportUtils.writeData(sheet, expenseReportList, reportMapping, "");
		return workbook;
	}
	
}
