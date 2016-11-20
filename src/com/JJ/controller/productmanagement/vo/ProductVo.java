package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.JJ.model.FileMeta;

public class ProductVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;
	private List<OptionVo> optionList;
	private Integer subcategoryId;
	private LinkedList<FileMeta> images;
	private String productInfo;
	private BigDecimal unitPrice;
	
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
	public List<OptionVo> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<OptionVo> optionList) {
		this.optionList = optionList;
	}
	public Integer getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public LinkedList<FileMeta> getImages() {
		return images;
	}
	public void setImages(LinkedList<FileMeta> images) {
		this.images = images;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
