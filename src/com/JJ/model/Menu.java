package com.JJ.model;

import java.util.Date;
import java.util.List;

public class Menu {
	private List<Module> moduleList;
	private Date dteUpdated;
	
	public List<Module> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	public Date getDteUpdated() {
		return dteUpdated;
	}
	public void setDteUpdated(Date dteUpdated) {
		this.dteUpdated = dteUpdated;
	}
	
	
}
