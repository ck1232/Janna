package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class ProductTagsVO extends Base implements Serializable {
    private Integer tagsId;

	private String name;

	private Integer productId;

	private static final long serialVersionUID = 1L;

	public Integer getTagsId() {
		return tagsId;
	}

	public void setTagsId(Integer tagsId) {
		this.tagsId = tagsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", tagsId=").append(tagsId);
		sb.append(", name=").append(name);
		sb.append(", productId=").append(productId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		sb.append(", from super class ");
		sb.append(super.toString());
		return sb.toString();
	}
}