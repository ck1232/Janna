package com.JJ.controller.inventorymanagement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.JJ.controller.batchintakemanagement.BatchIntakeProduct;
import com.JJ.controller.batchintakemanagement.BatchProductVo;

public class InventoryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remarks;
	private String locationTo;
	private String locationFrom;
	private String mode = "AD-HOC";
	private String deleteInd;
	private Date date;
	private List<BatchIntakeProduct> productItems;
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLocationTo() {
		return locationTo;
	}
	public void setLocationTo(String locationTo) {
		this.locationTo = locationTo;
	}
	public String getLocationFrom() {
		return locationFrom;
	}
	public void setLocationFrom(String locationFrom) {
		this.locationFrom = locationFrom;
	}
	public String getMode() {
		return mode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}
	public List<BatchIntakeProduct> getProductItems() {
		return productItems;
	}
	public void setProductItems(List<BatchIntakeProduct> productItems) {
		this.productItems = productItems;
	}
	
	
}
