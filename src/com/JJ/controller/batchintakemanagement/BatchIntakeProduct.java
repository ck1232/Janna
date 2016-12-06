package com.JJ.controller.batchintakemanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.model.Product;

public class BatchIntakeProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer batchProductId;
	private Product product;
	private List<SubOptionVo> subOptionList;
	private BigDecimal unitcost;
	private Integer qty;
	private int hashCode;
	public Integer getBatchProductId() {
		return batchProductId;
	}
	public void setBatchProductId(Integer batchProductId) {
		this.batchProductId = batchProductId;
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((subOptionList == null) ? 0 : subOptionList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchIntakeProduct other = (BatchIntakeProduct) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (subOptionList == null) {
			if (other.subOptionList != null)
				return false;
		} else if (!subOptionList.equals(other.subOptionList))
			return false;
		return true;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
}
