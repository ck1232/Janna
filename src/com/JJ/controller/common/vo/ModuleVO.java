package com.JJ.controller.common.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.JJ.model.Base;

public class ModuleVO extends Base implements Serializable {
    private Integer moduleId;

    private String moduleName;

    private String icon;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;
    
    private List<SubModuleVO> subModuleList;
    
    private static final long serialVersionUID = 1L;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(String deleteInd) {
        this.deleteInd = deleteInd == null ? null : deleteInd.trim();
    }

    public List<SubModuleVO> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<SubModuleVO> subModuleList) {
		this.subModuleList = subModuleList;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleId=").append(moduleId);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", icon=").append(icon);
        sb.append(", version=").append(version);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", deleteInd=").append(deleteInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}