package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ChequeDbObject extends Base implements Serializable {
    private Integer chequeId;

    private String chequeNum;

    private Date chequeDate;

    private BigDecimal chequeAmt;

    private Date debitDate;

    private String remarks;

    private String bounceChequeInd;

    private Date bounceDate;

    private static final long serialVersionUID = 1L;

    public Integer getChequeId() {
        return chequeId;
    }

    public void setChequeId(Integer chequeId) {
        this.chequeId = chequeId;
    }

    public String getChequeNum() {
        return chequeNum;
    }

    public void setChequeNum(String chequeNum) {
        this.chequeNum = chequeNum == null ? null : chequeNum.trim();
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public BigDecimal getChequeAmt() {
        return chequeAmt;
    }

    public void setChequeAmt(BigDecimal chequeAmt) {
        this.chequeAmt = chequeAmt;
    }

    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getBounceChequeInd() {
        return bounceChequeInd;
    }

    public void setBounceChequeInd(String bounceChequeInd) {
        this.bounceChequeInd = bounceChequeInd == null ? null : bounceChequeInd.trim();
    }

    public Date getBounceDate() {
        return bounceDate;
    }

    public void setBounceDate(Date bounceDate) {
        this.bounceDate = bounceDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chequeId=").append(chequeId);
        sb.append(", chequeNum=").append(chequeNum);
        sb.append(", chequeDate=").append(chequeDate);
        sb.append(", chequeAmt=").append(chequeAmt);
        sb.append(", debitDate=").append(debitDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", bounceChequeInd=").append(bounceChequeInd);
        sb.append(", bounceDate=").append(bounceDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}