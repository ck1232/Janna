package com.JJ.controller.common.vo;

import java.util.Date;
import java.util.List;

public class MenuVO {
	private List<ModuleVO> moduleList;
	private Date dteUpdated;
	
	public List<ModuleVO> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<ModuleVO> moduleList) {
		this.moduleList = moduleList;
	}
	public Date getDteUpdated() {
		return dteUpdated;
	}
	public void setDteUpdated(Date dteUpdated) {
		this.dteUpdated = dteUpdated;
	}
	
	
}
