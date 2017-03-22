package com.JJ.model;

import java.io.Serializable;
import java.util.Date;

public class TransactionDetailDbObject extends Base implements Serializable {
    private String transactionId;

    private String tplReferenceId;

    private String giftMessage;

    private String giftReceipt;

    private String giftWrapName;

    private String buyerEmailOptIn;

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

    public String getTplReferenceId() {
        return tplReferenceId;
    }

    public void setTplReferenceId(String tplReferenceId) {
        this.tplReferenceId = tplReferenceId == null ? null : tplReferenceId.trim();
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage == null ? null : giftMessage.trim();
    }

    public String getGiftReceipt() {
        return giftReceipt;
    }

    public void setGiftReceipt(String giftReceipt) {
        this.giftReceipt = giftReceipt == null ? null : giftReceipt.trim();
    }

    public String getGiftWrapName() {
        return giftWrapName;
    }

    public void setGiftWrapName(String giftWrapName) {
        this.giftWrapName = giftWrapName == null ? null : giftWrapName.trim();
    }

    public String getBuyerEmailOptIn() {
        return buyerEmailOptIn;
    }

    public void setBuyerEmailOptIn(String buyerEmailOptIn) {
        this.buyerEmailOptIn = buyerEmailOptIn == null ? null : buyerEmailOptIn.trim();
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
        sb.append(", tplReferenceId=").append(tplReferenceId);
        sb.append(", giftMessage=").append(giftMessage);
        sb.append(", giftReceipt=").append(giftReceipt);
        sb.append(", giftWrapName=").append(giftWrapName);
        sb.append(", buyerEmailOptIn=").append(buyerEmailOptIn);
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