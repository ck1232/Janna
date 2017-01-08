package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer invoiceid;

    private String messenger;

    private Date invoicedate;

    private BigDecimal totalprice;

    private Date dtecreated;

    private Date dteupdated;

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

    public Date getDtecreated() {
        return dtecreated;
    }

    public void setDtecreated(Date dtecreated) {
        this.dtecreated = dtecreated;
    }

    public Date getDteupdated() {
        return dteupdated;
    }

    public void setDteupdated(Date dteupdated) {
        this.dteupdated = dteupdated;
    }
}