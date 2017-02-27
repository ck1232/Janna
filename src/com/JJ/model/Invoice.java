package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice extends Base{
	
	private static final long serialVersionUID = 1L;

	private Integer invoiceid;

    private String messenger;

    private Date invoicedate;

    private BigDecimal totalprice;

    private Integer chequeid;

    private String paymentmode;

    private String status;

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getChequeid() {
        return chequeid;
    }

    public void setChequeid(Integer chequeid) {
        this.chequeid = chequeid;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", messenger=" + messenger + ", invoicedate=" + invoicedate
				+ ", totalprice=" + totalprice + ", chequeid=" + chequeid + ", paymentmode=" + paymentmode + ", status="
				+ status + "]";
	}
}