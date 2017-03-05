package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Expense extends Base{
	
	private static final long serialVersionUID = 1L;

	private Integer expenseid;

    private Integer expensetypeid;

    private String invoiceno;

    private String description;

    private Date expensedate;

    private String supplier;

    private BigDecimal totalamount;

    private String remark;

    public Integer getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(Integer expenseid) {
        this.expenseid = expenseid;
    }

    public Integer getExpensetypeid() {
        return expensetypeid;
    }

    public void setExpensetypeid(Integer expensetypeid) {
        this.expensetypeid = expensetypeid;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpensedate() {
        return expensedate;
    }

    public void setExpensedate(Date expensedate) {
        this.expensedate = expensedate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Override
	public String toString() {
		return "Expense [expenseid=" + expenseid + ", expensetypeid=" + expensetypeid + ", invoiceno=" + invoiceno
				+ ", description=" + description + ", expensedate=" + expensedate + ", supplier=" + supplier
				+ ", totalamount=" + totalamount + ", remark=" + remark + "]";
	}
    

	//non db fields
    private String expensetype;
    
    public String getexpensetype() {
		return expensetype;
	}

	public void setexpensetype(String expensetype) {
		this.expensetype = expensetype;
	}
    
}