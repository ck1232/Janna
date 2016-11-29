package com.JJ.controller.batchintakemanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.model.Product;

public class BatchIntakeProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product product;
	private List<SubOptionVo> subOptionList;
	private BigDecimal unitcost;
	private Integer qty;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public List<SubOptionVo> getSubOptionList() {
		return subOptionList;
	}
	public void setSubOptionList(List<SubOptionVo> subOptionList) {
		this.subOptionList = subOptionList;
	}
	public BigDecimal getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}
	
	
}
