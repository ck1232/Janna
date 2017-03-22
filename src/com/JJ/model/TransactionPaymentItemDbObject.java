package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionPaymentItemDbObject extends Base implements Serializable {
    private String transactionId;

    private String ebayItemTxnId;

    private String name;

    private String number;

    private String quantity;

    private BigDecimal shippingAmt;

    private BigDecimal handlingAmt;

    private String couponId;

    private BigDecimal couponAmt;

    private String couponAmtCurrency;

    private BigDecimal amt;

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

    public String getEbayItemTxnId() {
        return ebayItemTxnId;
    }

    public void setEbayItemTxnId(String ebayItemTxnId) {
        this.ebayItemTxnId = ebayItemTxnId == null ? null : ebayItemTxnId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public BigDecimal getShippingAmt() {
        return shippingAmt;
    }

    public void setShippingAmt(BigDecimal shippingAmt) {
        this.shippingAmt = shippingAmt;
    }

    public BigDecimal getHandlingAmt() {
        return handlingAmt;
    }

    public void setHandlingAmt(BigDecimal handlingAmt) {
        this.handlingAmt = handlingAmt;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public BigDecimal getCouponAmt() {
        return couponAmt;
    }

    public void setCouponAmt(BigDecimal couponAmt) {
        this.couponAmt = couponAmt;
    }

    public String getCouponAmtCurrency() {
        return couponAmtCurrency;
    }

    public void setCouponAmtCurrency(String couponAmtCurrency) {
        this.couponAmtCurrency = couponAmtCurrency == null ? null : couponAmtCurrency.trim();
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
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
        sb.append(", ebayItemTxnId=").append(ebayItemTxnId);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", quantity=").append(quantity);
        sb.append(", shippingAmt=").append(shippingAmt);
        sb.append(", handlingAmt=").append(handlingAmt);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponAmt=").append(couponAmt);
        sb.append(", couponAmtCurrency=").append(couponAmtCurrency);
        sb.append(", amt=").append(amt);
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