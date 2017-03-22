package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionPaymentInfoDbObject extends Base implements Serializable {
    private String transactionId;

    private String ebayTransactionId;

    private String parentTransactionId;

    private String receiptId;

    private String transactionType;

    private String paymentType;

    private String refundSourceCodeType;

    private String expectedeCheckClearDate;

    private String paymentDate;

    private BigDecimal grossAmt;

    private BigDecimal feeAmt;

    private BigDecimal financingFeeAmt;

    private BigDecimal financingTotalCost;

    private BigDecimal financingMonthlyPayment;

    private String isFinancing;

    private BigDecimal settleAmt;

    private BigDecimal taxAmt;

    private String exchangeRate;

    private String paymentStatus;

    private String invoiceId;

    private String custom;

    private String memo;

    private String salesTax;

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

    public String getEbayTransactionId() {
        return ebayTransactionId;
    }

    public void setEbayTransactionId(String ebayTransactionId) {
        this.ebayTransactionId = ebayTransactionId == null ? null : ebayTransactionId.trim();
    }

    public String getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(String parentTransactionId) {
        this.parentTransactionId = parentTransactionId == null ? null : parentTransactionId.trim();
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId == null ? null : receiptId.trim();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType == null ? null : transactionType.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getRefundSourceCodeType() {
        return refundSourceCodeType;
    }

    public void setRefundSourceCodeType(String refundSourceCodeType) {
        this.refundSourceCodeType = refundSourceCodeType == null ? null : refundSourceCodeType.trim();
    }

    public String getExpectedeCheckClearDate() {
        return expectedeCheckClearDate;
    }

    public void setExpectedeCheckClearDate(String expectedeCheckClearDate) {
        this.expectedeCheckClearDate = expectedeCheckClearDate == null ? null : expectedeCheckClearDate.trim();
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate == null ? null : paymentDate.trim();
    }

    public BigDecimal getGrossAmt() {
        return grossAmt;
    }

    public void setGrossAmt(BigDecimal grossAmt) {
        this.grossAmt = grossAmt;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public BigDecimal getFinancingFeeAmt() {
        return financingFeeAmt;
    }

    public void setFinancingFeeAmt(BigDecimal financingFeeAmt) {
        this.financingFeeAmt = financingFeeAmt;
    }

    public BigDecimal getFinancingTotalCost() {
        return financingTotalCost;
    }

    public void setFinancingTotalCost(BigDecimal financingTotalCost) {
        this.financingTotalCost = financingTotalCost;
    }

    public BigDecimal getFinancingMonthlyPayment() {
        return financingMonthlyPayment;
    }

    public void setFinancingMonthlyPayment(BigDecimal financingMonthlyPayment) {
        this.financingMonthlyPayment = financingMonthlyPayment;
    }

    public String getIsFinancing() {
        return isFinancing;
    }

    public void setIsFinancing(String isFinancing) {
        this.isFinancing = isFinancing == null ? null : isFinancing.trim();
    }

    public BigDecimal getSettleAmt() {
        return settleAmt;
    }

    public void setSettleAmt(BigDecimal settleAmt) {
        this.settleAmt = settleAmt;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate == null ? null : exchangeRate.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom == null ? null : custom.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax == null ? null : salesTax.trim();
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
        sb.append(", ebayTransactionId=").append(ebayTransactionId);
        sb.append(", parentTransactionId=").append(parentTransactionId);
        sb.append(", receiptId=").append(receiptId);
        sb.append(", transactionType=").append(transactionType);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", refundSourceCodeType=").append(refundSourceCodeType);
        sb.append(", expectedeCheckClearDate=").append(expectedeCheckClearDate);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", grossAmt=").append(grossAmt);
        sb.append(", feeAmt=").append(feeAmt);
        sb.append(", financingFeeAmt=").append(financingFeeAmt);
        sb.append(", financingTotalCost=").append(financingTotalCost);
        sb.append(", financingMonthlyPayment=").append(financingMonthlyPayment);
        sb.append(", isFinancing=").append(isFinancing);
        sb.append(", settleAmt=").append(settleAmt);
        sb.append(", taxAmt=").append(taxAmt);
        sb.append(", exchangeRate=").append(exchangeRate);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", custom=").append(custom);
        sb.append(", memo=").append(memo);
        sb.append(", salesTax=").append(salesTax);
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