package com.JJ.lookup.VO;

import java.io.Serializable;

import com.JJ.model.Base;

public class PaymentModeVO extends Base implements Serializable {
    private Integer paymentModeId;

    private String paymentMode;

    private static final long serialVersionUID = 1L;

    public Integer getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(Integer paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode == null ? null : paymentMode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paymentModeId=").append(paymentModeId);
        sb.append(", paymentMode=").append(paymentMode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}