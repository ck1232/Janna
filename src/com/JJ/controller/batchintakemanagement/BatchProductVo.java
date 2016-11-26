package com.JJ.controller.batchintakemanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class BatchProductVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;
	private Map<String, String> optionList;
//	private String option1;
//	private String option2;
//	private String option3;
//	private String suboption1;
//	private String suboption2;
//	private String suboption3;
	private BigDecimal unitPrice;
	private int quantity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Map<String, String> getOptionList() {
		return optionList;
	}
	public void setOptionList(Map<String, String> optionList) {
		this.optionList = optionList;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
