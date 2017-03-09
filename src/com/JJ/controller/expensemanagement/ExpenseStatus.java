package com.JJ.controller.expensemanagement;

public enum ExpenseStatus {
	UNPAID("Unpaid"),
	PAID("Paid"),
	PAID_PARTIAL("PaidPartial"),
	ALL("All");
	private String status;
	
	ExpenseStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
	
}
