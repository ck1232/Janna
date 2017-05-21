package com.JJ.lookup.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class ExpenseTypeVO extends Base implements Serializable {
    private Integer expenseTypeId;

    private String expenseType;

    private static final long serialVersionUID = 1L;

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType == null ? null : expenseType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expenseTypeId=").append(expenseTypeId);
        sb.append(", expenseType=").append(expenseType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}