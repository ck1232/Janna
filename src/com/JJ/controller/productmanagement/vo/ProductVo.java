package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.JJ.model.FileMeta;
import com.JJ.model.Productsubcategory;

public class ProductVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer generatedId;
	private String productName;
	private Integer weight;
	private List<OptionVo> optionList;
	private Integer subcategoryId;
	private LinkedList<FileMeta> images;
	private String productInfo;
	private BigDecimal unitPrice;
	private List<String> tags;
	private String paypalProductButtonId;
	
	private Productsubcategory productSubCategory;
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
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**
	 * @return the generatedId
	 */
	public Integer getGeneratedId() {
		return generatedId;
	}
	/**
	 * @param generatedId the generatedId to set
	 */
	public void setGeneratedId(Integer generatedId) {
		this.generatedId = generatedId;
	}
	/**
	 * @return the paypalProductButtonId
	 */
	public String getPaypalProductButtonId() {
		return paypalProductButtonId;
	}
	/**
	 * @param paypalProductButtonId the paypalProductButtonId to set
	 */
	public void setPaypalProductButtonId(String paypalProductButtonId) {
		this.paypalProductButtonId = paypalProductButtonId;
	}
	/**
	 * @return the productSubCategory
	 */
	public Productsubcategory getProductSubCategory() {
		return productSubCategory;
	}
	/**
	 * @param productSubCategory the productSubCategory to set
	 */
	public void setProductSubCategory(Productsubcategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	
	
}
