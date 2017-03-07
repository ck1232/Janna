package com.JJ.controller.inventorymanagement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.JJ.controller.batchintakemanagement.BatchIntakeProduct;

public class InventoryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remarks;
	private String locationTo;
	private Integer locationToId;
	private Integer locationFromId;
	private String locationFrom;
	private String mode = "AD-HOC";
	private Date date;
	private String dateString;
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
	public List<BatchIntakeProduct> getProductItems() {
		return productItems;
	}
	public void setProductItems(List<BatchIntakeProduct> productItems) {
		this.productItems = productItems;
	}
	/**
	 * @return the dateString
	 */
	public String getDateString() {
		return dateString;
	}
	/**
	 * @param dateString the dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	/**
	 * @return the locationToId
	 */
	public Integer getLocationToId() {
		return locationToId;
	}
	/**
	 * @param locationToId the locationToId to set
	 */
	public void setLocationToId(Integer locationToId) {
		this.locationToId = locationToId;
	}
	/**
	 * @return the locationFromId
	 */
	public Integer getLocationFromId() {
		return locationFromId;
	}
	/**
	 * @param locationFromId the locationFromId to set
	 */
	public void setLocationFromId(Integer locationFromId) {
		this.locationFromId = locationFromId;
	}
	
	
}
