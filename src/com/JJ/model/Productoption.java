package com.JJ.model;

public class Productoption extends Base{

	@Override
	public String toString() {
		return "Productoption [productoptionid=" + productoptionid + ", name=" + name + ", displayind=" + displayind
				+ ", sequence=" + sequence + ", getDeleteind()=" + getDeleteind() + ", getCreatedby()=" + getCreatedby()
				+ ", getCreatedon()=" + getCreatedon() + ", getUpdatedby()=" + getUpdatedby() + ", getUpdatedon()="
				+ getUpdatedon() + ", getVersion()=" + getVersion() + "]";
	}

	private Integer productoptionid;

	private String name;

	private Boolean displayind;

	private Integer sequence;
	
	public Integer getProductoptionid() {
		return productoptionid;
	}

	public void setProductoptionid(Integer productoptionid) {
		this.productoptionid = productoptionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDisplayind() {
		return displayind;
	}

	public void setDisplayind(Boolean displayind) {
		this.displayind = displayind;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
}