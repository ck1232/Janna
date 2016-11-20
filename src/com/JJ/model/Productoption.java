package com.JJ.model;

import java.util.List;

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
	
	public List<Productsuboption> getSubOptionsList() {
		return subOptionsList;
	}

	public void setSubOptionsList(List<Productsuboption> subOptionsList) {
		this.subOptionsList = subOptionsList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Productoption other = (Productoption) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//non-db variable
	private List<Productsuboption> subOptionsList;
	
}