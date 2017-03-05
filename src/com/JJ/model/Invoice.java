package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private Integer invoiceid;

    private String messenger;

    private Date invoicedate;

    private BigDecimal totalprice;

    private String status;

    private String deleteind;

    private Date createdon;

    private String createdby;

    private Date updatedon;

    private String updatedby;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleteind() {
        return deleteind;
    }

    public void setDeleteind(String deleteind) {
        this.deleteind = deleteind;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }
}