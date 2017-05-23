package com.JJ.controller.reportmanagement.vo;

import java.io.Serializable;

import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;

public class SalaryReportVO implements Serializable {
    
	private SalaryBonusVO salary;
    
    private PaymentDetailVO paymentDetail;
    
	public SalaryBonusVO getSalary() {
		return salary;
	}

	public void setSalary(SalaryBonusVO salary) {
		this.salary = salary;
	}

	public PaymentDetailVO getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetailVO paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
}