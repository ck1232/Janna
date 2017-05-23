package com.JJ.controller.reportmanagement.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
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
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
@Component
public class ExpenseReport implements ReportInterface {
	
	private ExpenseManagementService expenseService;
	private PaymentManagementService paymentService;
	
	@Autowired
	public ExpenseReport(ExpenseManagementService expenseService,
			PaymentManagementService paymentService) {
		this.expenseService = expenseService;
		this.paymentService = paymentService;
	}



	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		List<ExpenseVO> dbVoList = expenseService.getAllExpense(dateAsOf, endDate);
		if(dbVoList != null && !dbVoList.isEmpty()) {
			List<ExpenseReportVO> expenseReportList = new ArrayList<ExpenseReportVO>();
			for(ExpenseVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId("expense", vo.getExpenseId());
				ExpenseReportVO expenseReportVo;
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						expenseReportVo = new ExpenseReportVO();
						expenseReportVo.setExpense(vo);
						if(paymentVO.getPaymentMode() == 2 && 
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
			LinkedHashMap<String, List<ExpenseReportVO>> expenseReportMap = new LinkedHashMap<String, List<ExpenseReportVO>>();
			Calendar cal = Calendar.getInstance();
			for(ExpenseReportVO expensevo : expenseReportList){
				cal.setTime(expensevo.getExpense().getExpenseDate());
				String month = new SimpleDateFormat("MMM").format(cal.getTime());
				if(expenseReportMap.containsKey(month)){
					expenseReportMap.get(month).add(expensevo);
				}else{
					List<ExpenseReportVO> toPutList = new ArrayList<ExpenseReportVO>();
					toPutList.add(expensevo);
					expenseReportMap.put(month, toPutList);
				}
			}
			ReportMapping reportMapping = new ReportMapping();
			reportMapping.addDateMapping("Date", "expense.expenseDate");
			reportMapping.addTextMapping("Expense Type", "expense.expensetype");
			reportMapping.addTextMapping("Invoice No", "expense.invoiceNo");
			reportMapping.addTextMapping("Description", "expense.description");
			reportMapping.addTextMapping("Mode of Payment", "paymentDetail.paymentModeString");
			reportMapping.addMoneyMapping("Amount", "paymentDetail.paymentAmt");
			reportMapping.addTextMapping("Supplier", "expense.supplier");
			reportMapping.addDateMapping("Date Paid", "paymentDetail.paymentDate");
			reportMapping.addTextMapping("Cheque No", "paymentDetail.chequeNum");
			reportMapping.addDateMapping("Date deducted (per Bank)", "paymentDetail.debitDate");
			reportMapping.addTextMapping("Remark", "paymentDetail.remarks");
			
			for(String key : expenseReportMap.keySet()){
				Sheet sheet = workbook.createSheet(key);
				ReportUtils.writeData(sheet, expenseReportMap.get(key), reportMapping);
			}
		}
		return workbook;
	}
	
}
