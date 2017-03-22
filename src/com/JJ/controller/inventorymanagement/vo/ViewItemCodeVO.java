package com.JJ.controller.inventorymanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class ViewItemCodeVO extends Base implements Serializable {
    private Integer productSuboptionRsId;

    private Integer productId;

    private String productName;

    private String suboption1Name;

    private Integer suboption1Id;

    private String suboption2Name;

    private Integer suboption2Id;

    private String suboption3Name;

    private Integer suboption3Id;

    private String itemCode;

    private static final long serialVersionUID = 1L;

    public ViewItemCodeVO(Integer productSuboptionRsId, Integer productId, String productName, String suboption1Name, Integer suboption1Id, String suboption2Name, Integer suboption2Id, String suboption3Name, Integer suboption3Id, String itemCode) {
        this.productSuboptionRsId = productSuboptionRsId;
        this.productId = productId;
        this.productName = productName;
        this.suboption1Name = suboption1Name;
        this.suboption1Id = suboption1Id;
        this.suboption2Name = suboption2Name;
        this.suboption2Id = suboption2Id;
        this.suboption3Name = suboption3Name;
        this.suboption3Id = suboption3Id;
        this.itemCode = itemCode;
    }

    public Integer getProductSuboptionRsId() {
        return productSuboptionRsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSuboption1Name() {
        return suboption1Name;
    }

    public Integer getSuboption1Id() {
        return suboption1Id;
    }

    public String getSuboption2Name() {
        return suboption2Name;
    }

    public Integer getSuboption2Id() {
        return suboption2Id;
    }

    public String getSuboption3Name() {
        return suboption3Name;
    }

    public Integer getSuboption3Id() {
        return suboption3Id;
    }

    public String getItemCode() {
        return itemCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productSuboptionRsId=").append(productSuboptionRsId);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", suboption1Name=").append(suboption1Name);
        sb.append(", suboption1Id=").append(suboption1Id);
        sb.append(", suboption2Name=").append(suboption2Name);
        sb.append(", suboption2Id=").append(suboption2Id);
        sb.append(", suboption3Name=").append(suboption3Name);
        sb.append(", suboption3Id=").append(suboption3Id);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}