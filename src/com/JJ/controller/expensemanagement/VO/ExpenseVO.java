package com.JJ.controller.expensemanagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class ExpenseVO extends Base implements Serializable {
    private Integer expenseId;

    private Integer expenseTypeId;

    private String invoiceNo;

    private String description;

    private Date expenseDate;

    private String supplier;

    private BigDecimal totalAmt;

    private String remarks;

    private String status;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;
    
    //non db fields
    private String expensetype;
    
    private String expensedateString;
    
	private static final long serialVersionUID = 1L;

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
    
    public String getexpensetype() {
		return expensetype;
	}

	public void setexpensetype(String expensetype) {
		this.expensetype = expensetype;
	}

    public String getExpensedateString() {
		return expensedateString;
	}

	public void setExpensedateString(String expensedateString) {
		this.expensedateString = expensedateString;
	}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expenseId=").append(expenseId);
        sb.append(", expensetype=").append(expensetype);
        sb.append(", expenseTypeId=").append(expenseTypeId);
        sb.append(", invoiceNo=").append(invoiceNo);
        sb.append(", description=").append(description);
        sb.append(", expenseDate=").append(expenseDate);
        sb.append(", expensedateString=").append(expensedateString);
        sb.append(", supplier=").append(supplier);
        sb.append(", totalAmt=").append(totalAmt);
        sb.append(", remarks=").append(remarks);
        sb.append(", status=").append(status);
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