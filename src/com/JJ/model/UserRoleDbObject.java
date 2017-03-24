package com.JJ.model;

import java.io.Serializable;
import java.util.Date;

public class UserRoleDbObject extends Base implements Serializable {
    private Integer userRoleId;

    private Integer roleId;

    private Integer userId;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;

    private static final long serialVersionUID = 1L;

    public UserRoleDbObject() {
	}

	public UserRoleDbObject(Integer userRoleId, Integer roleId, Integer userId, Integer version, String createdBy, Date createdOn, String updatedBy, Date updatedOn, String deleteInd) {
        this.userRoleId = userRoleId;
        this.roleId = roleId;
        this.userId = userId;
        this.version = version;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.deleteInd = deleteInd;
    }

    public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public Integer getUserRoleId() {
        return userRoleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getVersion() {
        return version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userRoleId=").append(userRoleId);
        sb.append(", roleId=").append(roleId);
        sb.append(", userId=").append(userId);
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