package com.JJ.controller.batchintakemanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.JJ.model.Base;

public class BatchProductRsVO extends Base implements Serializable {
    private Integer batchProductRsId;

    private Integer batchId;

    private Integer productSubOptionId;

    private BigDecimal unitCost;

    private Integer qty;

    private static final long serialVersionUID = 1L;

    public Integer getBatchProductRsId() {
        return batchProductRsId;
    }

    public void setBatchProductRsId(Integer batchProductRsId) {
        this.batchProductRsId = batchProductRsId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getProductSubOptionId() {
        return productSubOptionId;
    }

    public void setProductSubOptionId(Integer productSubOptionId) {
        this.productSubOptionId = productSubOptionId;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", batchProductRsId=").append(batchProductRsId);
        sb.append(", batchId=").append(batchId);
        sb.append(", productSubOptionId=").append(productSubOptionId);
        sb.append(", unitCost=").append(unitCost);
        sb.append(", qty=").append(qty);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}