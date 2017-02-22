package com.JJ.controller.inventorymanagement;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class InventoryHistorySearchCriteria{
	
	private String productname;
	
	private String mode;
	
	private String location;
	
	private String createdby;
	
	private String createddate;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}


	
}
