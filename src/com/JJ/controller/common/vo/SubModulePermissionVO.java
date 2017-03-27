package com.JJ.controller.common.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class SubModulePermissionVO extends Base implements Serializable {
    private Integer permissionId;

    private Integer roleId;

    private Integer submoduleId;

    private Integer permissionTypeId;
    
    private String submodulename;
    
	private String permissiontype;

    private static final long serialVersionUID = 1L;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSubmoduleId() {
        return submoduleId;
    }

    public void setSubmoduleId(Integer submoduleId) {
        this.submoduleId = submoduleId;
    }

    public Integer getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(Integer permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public String getSubmodulename() {
		return submodulename;
	}

	public void setSubmodulename(String submodulename) {
		this.submodulename = submodulename;
	}

	public String getPermissiontype() {
		return permissiontype;
	}

	public void setPermissiontype(String permissiontype) {
		this.permissiontype = permissiontype;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", submoduleId=").append(submoduleId);
        sb.append(", permissionTypeId=").append(permissionTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}