package com.JJ.controller.paymentmanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class PaymentRsVO extends Base implements Serializable {
    private Integer paymentRsId;

    private String referenceType;

    private Integer referenceId;

    private Integer paymentDetailId;
    
    private static final long serialVersionUID = 1L;

    public Integer getPaymentRsId() {
        return paymentRsId;
    }

    public void setPaymentRsId(Integer paymentRsId) {
        this.paymentRsId = paymentRsId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType == null ? null : referenceType.trim();
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(Integer paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paymentRsId=").append(paymentRsId);
        sb.append(", referenceType=").append(referenceType);
        sb.append(", referenceId=").append(referenceId);
        sb.append(", paymentDetailId=").append(paymentDetailId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}