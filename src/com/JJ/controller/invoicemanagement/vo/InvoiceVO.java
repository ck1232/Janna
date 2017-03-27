package com.JJ.controller.invoicemanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class InvoiceVO extends Base implements Serializable {
    private Integer invoiceId;

    private String messenger;

    private Date invoiceDate;

    private BigDecimal totalAmt;

    private String status;
    
    //non db fields
    
  	private String invoicedateString;
  	
    private static final long serialVersionUID = 1L;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger == null ? null : messenger.trim();
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    
    public String getInvoicedateString() {
  		return invoicedateString;
  	}

  	public void setInvoicedateString(String invoicedateString) {
  		this.invoicedateString = invoicedateString;
  	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", messenger=").append(messenger);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", totalAmt=").append(totalAmt);
        sb.append(", status=").append(status);
        sb.append(", invoicedateString=").append(invoicedateString);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}