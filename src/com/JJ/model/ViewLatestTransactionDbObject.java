package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ViewLatestTransactionDbObject extends Base implements Serializable {
    private String transactionId;

    private Date timeStamp;

    private String type;

    private String payer;

    private String payerName;

    private String status;

    private BigDecimal grossAmt;

    private BigDecimal feeaAmt;

    private BigDecimal netAmt;

    private Date createdOn;

    private static final long serialVersionUID = 1L;

    public ViewLatestTransactionDbObject(String transactionId, Date timeStamp, String type, String payer, String payerName, String status, BigDecimal grossAmt, BigDecimal feeaAmt, BigDecimal netAmt, Date createdOn) {
        this.transactionId = transactionId;
        this.timeStamp = timeStamp;
        this.type = type;
        this.payer = payer;
        this.payerName = payerName;
        this.status = status;
        this.grossAmt = grossAmt;
        this.feeaAmt = feeaAmt;
        this.netAmt = netAmt;
        this.createdOn = createdOn;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getType() {
        return type;
    }

    public String getPayer() {
        return payer;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getGrossAmt() {
        return grossAmt;
    }

    public BigDecimal getFeeaAmt() {
        return feeaAmt;
    }

    public BigDecimal getNetAmt() {
        return netAmt;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transactionId=").append(transactionId);
        sb.append(", timeStamp=").append(timeStamp);
        sb.append(", type=").append(type);
        sb.append(", payer=").append(payer);
        sb.append(", payerName=").append(payerName);
        sb.append(", status=").append(status);
        sb.append(", grossAmt=").append(grossAmt);
        sb.append(", feeaAmt=").append(feeaAmt);
        sb.append(", netAmt=").append(netAmt);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}