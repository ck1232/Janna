package com.JJ.controller.invoicemanagement;

public enum InvoiceStatusEnum {
	PENDING("Pending"),
	PAID("Paid"),
	ALL("All");
	private String status;
	
	InvoiceStatusEnum(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
	
}