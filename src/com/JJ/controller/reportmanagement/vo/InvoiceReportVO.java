package com.JJ.controller.reportmanagement.vo;

import java.io.Serializable;

import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;

public class InvoiceReportVO implements Serializable {
    
	private InvoiceVO invoice;
    
    private PaymentDetailVO paymentDetail;

	public InvoiceVO getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceVO invoice) {
		this.invoice = invoice;
	}

	public PaymentDetailVO getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetailVO paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
}