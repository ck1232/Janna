package com.JJ.controller.reportmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import com.JJ.lookup.vo.ExpenseTypeVO;
import com.JJ.lookup.vo.PaymentModeVO;

public class SummaryReportVO1 implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SummaryReportVO1(String month, List<ExpenseTypeVO> expenseTypeList, List<PaymentModeVO> paymentModeList) {
		this.month = month;
		this.expenseCategorySum = new LinkedHashMap<String, BigDecimal>();
		for(ExpenseTypeVO type : expenseTypeList) {
			this.expenseCategorySum.put(type.getExpenseType(), BigDecimal.ZERO);
		}
		this.expenseCategorySum.put("total", BigDecimal.ZERO);
		this.paymentCategorySum = new LinkedHashMap<String, BigDecimal>();
		for(PaymentModeVO type : paymentModeList){
			this.paymentCategorySum.put(type.getPaymentMode(), BigDecimal.ZERO);
		}
		this.paymentCategorySum.put("unpaid", BigDecimal.ZERO);
		this.paymentCategorySum.put("total", BigDecimal.ZERO);
	}

	private String month;
	
	private LinkedHashMap<String, BigDecimal> paymentCategorySum;
	
	private LinkedHashMap<String, BigDecimal> expenseCategorySum;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public LinkedHashMap<String, BigDecimal> getPaymentCategorySum() {
		return paymentCategorySum;
	}

	public void setPaymentCategorySum(LinkedHashMap<String, BigDecimal> paymentCategorySum) {
		this.paymentCategorySum = paymentCategorySum;
	}

	public LinkedHashMap<String, BigDecimal> getExpenseCategorySum() {
		return expenseCategorySum;
	}

	public void setExpenseCategorySum(LinkedHashMap<String, BigDecimal> expenseCategorySum) {
		this.expenseCategorySum = expenseCategorySum;
	}
}