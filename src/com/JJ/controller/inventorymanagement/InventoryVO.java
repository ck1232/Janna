package com.JJ.controller.inventorymanagement;

import java.io.Serializable;
import java.util.Date;

import com.JJ.model.Storagelocation;

public class InventoryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remarks;
	private Storagelocation locationTo;
	private Storagelocation locationFrom;
	private int qty;
	private double unitCost;
	private String mode = "AD-HOC";
	private String deleteInd;
	private Date date;
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Storagelocation getLocationTo() {
		return locationTo;
	}
	public void setLocationTo(Storagelocation locationTo) {
		this.locationTo = locationTo;
	}
	public Storagelocation getLocationFrom() {
		return locationFrom;
	}
	public void setLocationFrom(Storagelocation locationFrom) {
		this.locationFrom = locationFrom;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
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
	
	
}
