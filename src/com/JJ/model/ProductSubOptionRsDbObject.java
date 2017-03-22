package com.JJ.model;

import java.io.Serializable;
import java.util.Date;

public class ProductSubOptionRsDbObject extends Base implements Serializable {
    private Integer productSuboptionRsId;

    private Integer productId;

    private Integer suboption1Id;

    private Integer suboption2Id;

    private Integer suboption3Id;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;

    private static final long serialVersionUID = 1L;

    public Integer getProductSuboptionRsId() {
        return productSuboptionRsId;
    }

    public void setProductSuboptionRsId(Integer productSuboptionRsId) {
        this.productSuboptionRsId = productSuboptionRsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSuboption1Id() {
        return suboption1Id;
    }

    public void setSuboption1Id(Integer suboption1Id) {
        this.suboption1Id = suboption1Id;
    }

    public Integer getSuboption2Id() {
        return suboption2Id;
    }

    public void setSuboption2Id(Integer suboption2Id) {
        this.suboption2Id = suboption2Id;
    }

    public Integer getSuboption3Id() {
        return suboption3Id;
    }

    public void setSuboption3Id(Integer suboption3Id) {
        this.suboption3Id = suboption3Id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(String deleteInd) {
        this.deleteInd = deleteInd == null ? null : deleteInd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productSuboptionRsId=").append(productSuboptionRsId);
        sb.append(", productId=").append(productId);
        sb.append(", suboption1Id=").append(suboption1Id);
        sb.append(", suboption2Id=").append(suboption2Id);
        sb.append(", suboption3Id=").append(suboption3Id);
        sb.append(", version=").append(version);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", deleteInd=").append(deleteInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}