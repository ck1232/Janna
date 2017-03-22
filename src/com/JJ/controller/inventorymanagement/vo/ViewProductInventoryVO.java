package com.JJ.controller.inventorymanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.JJ.model.Base;

public class ViewProductInventoryVO extends Base implements Serializable {
    private Integer productId;

    private String productName;

    private BigDecimal qty;

    private static final long serialVersionUID = 1L;

    public ViewProductInventoryVO(Integer productId, String productName, BigDecimal qty) {
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getQty() {
        return qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", qty=").append(qty);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}