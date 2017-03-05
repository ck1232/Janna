package com.JJ.controller.invoicemanagement;

public enum InvoiceStatus {
	PENDING("Pending"),
	PAID("Paid"),
	ALL("All");
	private String status;
	
	InvoiceStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
	
}
