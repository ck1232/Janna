package com.JJ.model;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Base {
    
	public Base(String deleteind, String createdby, Date createdon, String updatedby, Date updatedon, Integer version) {
		this.deleteind = deleteind;
		this.createdby = createdby;
		this.createdon = createdon;
		this.updatedby = updatedby;
		this.updatedon = updatedon;
		this.version = version;
	}

	private String deleteind;

	private String createdby;

	private Date createdon;

	private String updatedby;

	private Date updatedon;

	private Integer version;
	
	public Base() {
	}
	
	public Base(UserDetails principal) {
		deleteind = "N";
		createdby = principal.getUsername();
		createdon = new Date();
		updatedby = principal.getUsername();
		updatedon = new Date();
		version = 1;
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
}