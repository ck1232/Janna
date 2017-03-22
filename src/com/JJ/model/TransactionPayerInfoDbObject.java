package com.JJ.model;

import java.io.Serializable;
import java.util.Date;

public class TransactionPayerInfoDbObject extends Base implements Serializable {
    private String transactionId;

    private String payer;

    private String payerId;

    private String payerStatus;

    private String payerName;

    private String payerCountry;

    private String payerBusiness;

    private String contactPhone;

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

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId == null ? null : payerId.trim();
    }

    public String getPayerStatus() {
        return payerStatus;
    }

    public void setPayerStatus(String payerStatus) {
        this.payerStatus = payerStatus == null ? null : payerStatus.trim();
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName == null ? null : payerName.trim();
    }

    public String getPayerCountry() {
        return payerCountry;
    }

    public void setPayerCountry(String payerCountry) {
        this.payerCountry = payerCountry == null ? null : payerCountry.trim();
    }

    public String getPayerBusiness() {
        return payerBusiness;
    }

    public void setPayerBusiness(String payerBusiness) {
        this.payerBusiness = payerBusiness == null ? null : payerBusiness.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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
        sb.append(", payer=").append(payer);
        sb.append(", payerId=").append(payerId);
        sb.append(", payerStatus=").append(payerStatus);
        sb.append(", payerName=").append(payerName);
        sb.append(", payerCountry=").append(payerCountry);
        sb.append(", payerBusiness=").append(payerBusiness);
        sb.append(", contactPhone=").append(contactPhone);
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