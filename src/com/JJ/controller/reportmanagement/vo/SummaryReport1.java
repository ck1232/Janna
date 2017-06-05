package com.JJ.controller.reportmanagement.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.lookup.vo.ExpenseTypeVO;
import com.JJ.lookup.vo.PaymentModeVO;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
@Component
public class SummaryReport1 implements ReportInterface {

	private ExpenseManagementService expenseService;
	private PaymentManagementService paymentService;
	private ExpenseTypeLookup expenseType;
	private PaymentModeLookup paymentMode;
	
	private final static String monthFormat = "MMM";
	private final static String Total = "Total";
	
	@Autowired
	public SummaryReport1(ExpenseManagementService expenseService,
			PaymentManagementService paymentService,
			ExpenseTypeLookup expenseType,
			PaymentModeLookup paymentMode) {
		this.expenseService = expenseService;
		this.paymentService = paymentService;
		this.expenseType = expenseType;
		this.paymentMode = paymentMode;
	}

	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		List<ExpenseVO> dbVoList = expenseService.getAllExpense(dateAsOf, endDate);
		if(dbVoList != null && !dbVoList.isEmpty()) {
			List<SummaryReportVO1> summaryReportList = new ArrayList<SummaryReportVO1>();
			Map<String,SummaryReportVO1> reportHM = new HashMap<String,SummaryReportVO1>();
			reportHM.put("Total", new SummaryReportVO1("Total", expenseType.getExpenseTypeList(), paymentMode.getPaymentModeList()));
			for(ExpenseVO vo : dbVoList) {
				if(!vo.getexpensetype().equals("Stock(China)")){
					generateForExpense(reportHM, vo);
					generateForPayment(reportHM, vo);
				}
			}
			summaryReportList.addAll(reportHM.values());
			summaryReportList = GeneralUtils.sortByMonth(summaryReportList);
			
			//Expense ReportMapping
			ReportMapping reportMapping = new ReportMapping();
			reportMapping.addTextMapping("Expenses by Type (exclude Salary)", "month");
			for(ExpenseTypeVO type : expenseType.getExpenseTypeList()){
				if(!type.getExpenseType().equals("Stock(China)"))
					reportMapping.addMoneyMapping(type.getExpenseType(), "expenseCategorySum("+type.getExpenseType()+")");
			}
			reportMapping.addMoneyMapping(Total, "expenseCategorySum(total)");
			Sheet sheet = workbook.createSheet("Summary");
			ReportUtils.writeBlankRows(sheet, 2);
			ReportUtils.writeData(sheet, summaryReportList, reportMapping, "month");		
			
			//Payment ReportMapping
			reportMapping = new ReportMapping();
			reportMapping.addTextMapping("Payment records (exclude salary)", "month");
			for(PaymentModeVO payment : paymentMode.getPaymentModeList()){
				reportMapping.addMoneyMapping(payment.getPaymentMode(), "paymentCategorySum("+payment.getPaymentMode()+")");
			}
			reportMapping.addMoneyMapping("Not Paid", "paymentCategorySum(unpaid)");
			reportMapping.addMoneyMapping(Total, "paymentCategorySum(total)");
			ReportUtils.writeBlankRows(sheet, 2);
			ReportUtils.writeData(sheet, summaryReportList, reportMapping, "month");		
		}
		
		return workbook;
	}
	
	private void generateForExpense(Map<String,SummaryReportVO1> reportHM, ExpenseVO vo) {
		String expMonth = GeneralUtils.convertDateToString(vo.getExpenseDate(), monthFormat);
		if(!reportHM.containsKey(expMonth)){
			reportHM.put(expMonth, new SummaryReportVO1(expMonth, expenseType.getExpenseTypeList(), paymentMode.getPaymentModeList()));
		}
		LinkedHashMap<String, BigDecimal> expenseCategorySumMap = reportHM.get(expMonth).getExpenseCategorySum();
		if(!expenseCategorySumMap.containsKey(vo.getexpensetype())){
			expenseCategorySumMap.put(vo.getexpensetype(), BigDecimal.ZERO);
		}
		//calculation for total for each expense category
		BigDecimal totalForCategory = expenseCategorySumMap.get(vo.getexpensetype()).add(vo.getTotalAmt());
		BigDecimal totalForAll = expenseCategorySumMap.get("total").add(vo.getTotalAmt());
		expenseCategorySumMap.put(vo.getexpensetype(), totalForCategory);
		expenseCategorySumMap.put("total", totalForAll);
		
		//calculation for grand total
		BigDecimal grandTotalForCategory = reportHM.get(Total).getExpenseCategorySum().get(vo.getexpensetype()).add(vo.getTotalAmt());
		BigDecimal grandTotalForAll = reportHM.get(Total).getExpenseCategorySum().get("total").add(vo.getTotalAmt());
		reportHM.get(Total).getExpenseCategorySum().put(vo.getexpensetype(), grandTotalForCategory);
		reportHM.get(Total).getExpenseCategorySum().put("total", grandTotalForAll);
	}
	
	private void generateForPayment(Map<String,SummaryReportVO1> reportHM, ExpenseVO vo) {
		String expMonth = GeneralUtils.convertDateToString(vo.getExpenseDate(), monthFormat);
		List<PaymentDetailVO> paymentVOList = paymentService.getAllPaymentByRefTypeAndRefId("expense", vo.getExpenseId());
		if(!paymentVOList.isEmpty()){ //if paid
			for(PaymentDetailVO payment : paymentVOList) {
				String payMonth = GeneralUtils.convertDateToString(payment.getPaymentDate(), monthFormat);
				if(!reportHM.containsKey(payMonth)) {
					reportHM.put(payMonth, new SummaryReportVO1(payMonth, expenseType.getExpenseTypeList(), paymentMode.getPaymentModeList()));
				}
				LinkedHashMap<String, BigDecimal> paymentCategorySumMap = reportHM.get(payMonth).getPaymentCategorySum();
				if(!paymentCategorySumMap.containsKey(payment.getPaymentModeString())){
					paymentCategorySumMap.put(payment.getPaymentModeString(), BigDecimal.ZERO);
				}
				
				//calculation for each payment category
				BigDecimal totalForPCategory = computeTotalForPayment(reportHM, payMonth, payment.getPaymentModeString(), payment.getPaymentAmt());
				BigDecimal totalForPAll = computeTotalForPayment(reportHM, payMonth, "total", payment.getPaymentAmt());
				paymentCategorySumMap.put(payment.getPaymentModeString(), totalForPCategory);
				paymentCategorySumMap.put("total", totalForPAll);
				
				//calculation for grand total
				BigDecimal grandTotalForPCategory = computeTotalForPayment(reportHM, Total, payment.getPaymentModeString(), payment.getPaymentAmt());
				BigDecimal grandTotalForPAll = computeTotalForPayment(reportHM, Total, "total", payment.getPaymentAmt());
				reportHM.get(Total).getPaymentCategorySum().put(payment.getPaymentModeString(), grandTotalForPCategory);
				reportHM.get(Total).getPaymentCategorySum().put("total", grandTotalForPAll);
			}
		}else{ //if unpaid
			//calculation for unpaid category
			BigDecimal totalForUnpaid = computeTotalForPayment(reportHM, expMonth, "unpaid", vo.getTotalAmt());
			BigDecimal totalForPAll = computeTotalForPayment(reportHM, expMonth, "total", vo.getTotalAmt());
			reportHM.get(expMonth).getPaymentCategorySum().put("unpaid", totalForUnpaid);
			reportHM.get(expMonth).getPaymentCategorySum().put("total", totalForPAll);
			
			//calculation for grand total
			BigDecimal grandTotalForUnpaid = computeTotalForPayment(reportHM, Total, "unpaid", vo.getTotalAmt());
			BigDecimal grandTotalForPAll = computeTotalForPayment(reportHM, Total, "total", vo.getTotalAmt());
			reportHM.get(Total).getPaymentCategorySum().put("unpaid", grandTotalForUnpaid);
			reportHM.get(Total).getPaymentCategorySum().put("total", grandTotalForPAll);
		}
	}
	
	private BigDecimal computeTotalForPayment(Map<String,SummaryReportVO1> reportHM, String month, String category, BigDecimal valueToAdd) {
		BigDecimal total = reportHM.get(month).getPaymentCategorySum().get(category).add(valueToAdd);
		return total;
	}

}
