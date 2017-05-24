package com.JJ.controller.reportmanagement.vo;

import java.io.Serializable;

import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;

public class SalaryBonusReportVO implements Serializable {
    
	private SalaryBonusVO salarybonus;
    
    private PaymentDetailVO paymentDetail;
    

	public SalaryBonusVO getSalarybonus() {
		return salarybonus;
	}

	public void setSalarybonus(SalaryBonusVO salarybonus) {
		this.salarybonus = salarybonus;
	}

	public PaymentDetailVO getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetailVO paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
}