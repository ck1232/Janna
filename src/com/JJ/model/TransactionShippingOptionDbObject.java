package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionShippingOptionDbObject extends Base implements Serializable {
    private String transactionId;

    private String shippingCalculationMode;

    private String insuranceOptionSelected;

    private String shippingOptionIsDefault;

    private BigDecimal shippingOptionAmt;

    private String shippingOptionName;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;

    private static final long serialVersionUID = 1L;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getShippingCalculationMode() {
        return shippingCalculationMode;
    }

    public void setShippingCalculationMode(String shippingCalculationMode) {
        this.shippingCalculationMode = shippingCalculationMode == null ? null : shippingCalculationMode.trim();
    }

    public String getInsuranceOptionSelected() {
        return insuranceOptionSelected;
    }

    public void setInsuranceOptionSelected(String insuranceOptionSelected) {
        this.insuranceOptionSelected = insuranceOptionSelected == null ? null : insuranceOptionSelected.trim();
    }

    public String getShippingOptionIsDefault() {
        return shippingOptionIsDefault;
    }

    public void setShippingOptionIsDefault(String shippingOptionIsDefault) {
        this.shippingOptionIsDefault = shippingOptionIsDefault == null ? null : shippingOptionIsDefault.trim();
    }

    public BigDecimal getShippingOptionAmt() {
        return shippingOptionAmt;
    }

    public void setShippingOptionAmt(BigDecimal shippingOptionAmt) {
        this.shippingOptionAmt = shippingOptionAmt;
    }

    public String getShippingOptionName() {
        return shippingOptionName;
    }

    public void setShippingOptionName(String shippingOptionName) {
        this.shippingOptionName = shippingOptionName == null ? null : shippingOptionName.trim();
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
        sb.append(", transactionId=").append(transactionId);
        sb.append(", shippingCalculationMode=").append(shippingCalculationMode);
        sb.append(", insuranceOptionSelected=").append(insuranceOptionSelected);
        sb.append(", shippingOptionIsDefault=").append(shippingOptionIsDefault);
        sb.append(", shippingOptionAmt=").append(shippingOptionAmt);
        sb.append(", shippingOptionName=").append(shippingOptionName);
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