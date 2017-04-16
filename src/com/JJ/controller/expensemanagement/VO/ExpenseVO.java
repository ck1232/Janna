package com.JJ.controller.expensemanagement.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.JJ.model.Base;
import com.JJ.validator.annotation.InDateRange;

public class ExpenseVO extends Base implements Serializable {
    private Integer expenseId;
    
    @NotNull(message="error.notempty.expenseform.expensetype")
    @Min(value=1L, message="error.notempty.expenseform.expensetype")
    private Integer expenseTypeId;

    private String invoiceNo;

    private String description;

    private Date expenseDate;
    
    private String supplier;
    
//    @NotNull(message="error.notempty.expenseform.totalamount")
//    @NotEmpty(message="error.notempty.expenseform.totalamount")
//    @DecimalMin(value="1", message="error.notvalid.expenseform.totalamount")
//    @Digits(integer=6, fraction=2, message="error.decimal.twodecimcalpoint")
    private BigDecimal totalAmt;

    private String remarks;

    private String status;
    
    //non db fields
    private String expensetype;
    
    @NotNull(message="error.notempty.expenseform.expensedate")
    @NotEmpty(message="error.notempty.expenseform.expensedate")
    @InDateRange(dateFormat="dd/MM/yyyy", message="error.notvalid.expenseform.expensedate")
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}