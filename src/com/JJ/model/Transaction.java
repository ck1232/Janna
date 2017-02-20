package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private String transactionid;

    private Date timestamp;

    private String type;

    private String payer;

    private String payername;

    private String status;

    private BigDecimal grossamt;

    private BigDecimal feeamt;

    private BigDecimal netamt;

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayername() {
        return payername;
    }

    public void setPayername(String payername) {
        this.payername = payername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getGrossamt() {
        return grossamt;
    }

    public void setGrossamt(BigDecimal grossamt) {
        this.grossamt = grossamt;
    }

    public BigDecimal getFeeamt() {
        return feeamt;
    }

    public void setFeeamt(BigDecimal feeamt) {
        this.feeamt = feeamt;
    }

    public BigDecimal getNetamt() {
        return netamt;
    }

    public void setNetamt(BigDecimal netamt) {
        this.netamt = netamt;
    }
}