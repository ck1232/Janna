package com.JJ.controller.discountmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.JJ.model.Base;

public class DiscountVO extends Base implements Serializable {
    private Integer discountId;

    private Integer promoId;

    private String discountName;

    private String discountType;

    private BigDecimal discountValue;

    private String applyType;

    private static final long serialVersionUID = 1L;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName == null ? null : discountName.trim();
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discountId=").append(discountId);
        sb.append(", promoId=").append(promoId);
        sb.append(", discountName=").append(discountName);
        sb.append(", discountType=").append(discountType);
        sb.append(", discountValue=").append(discountValue);
        sb.append(", applyType=").append(applyType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}