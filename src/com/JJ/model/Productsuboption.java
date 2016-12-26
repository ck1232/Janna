package com.JJ.model;

import java.util.Date;

public class Productsuboption extends Base{
    private Integer productsuboptionid;
	private Integer productid;
	private Integer productoptionid;
	private String name;
	private Boolean displayind;
	private String deleteind;
	private String createdby;
	private Date createdon;
	private String updatedby;
	private Date updatedon;
	private Integer version;

	public Integer getProductsuboptionid() {
		return productsuboptionid;
	}

	public void setProductsuboptionid(Integer productsuboptionid) {
		this.productsuboptionid = productsuboptionid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

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

	public String getDeleteind() {
		return deleteind;
	}

	public void setDeleteind(String deleteind) {
		this.deleteind = deleteind;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
		Productsuboption other = (Productsuboption) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
}