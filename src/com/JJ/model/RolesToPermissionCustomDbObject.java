package com.JJ.model;

public class RolesToPermissionCustomDbObject {
	
	private Integer roleId;
	private String roleName;
	private String submoduleId;
	private String submoduleName;
	private String permission;
	private String permissionId;
	private Integer permissionTypeId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getSubmoduleId() {
		return submoduleId;
	}
	public void setSubmoduleId(String submoduleId) {
		this.submoduleId = submoduleId;
	}
	public String getSubmoduleName() {
		return submoduleName;
	}
	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public Integer getPermissionTypeId() {
		return permissionTypeId;
	}
	public void setPermissionTypeId(Integer permissionTypeId) {
		this.permissionTypeId = permissionTypeId;
	}
	
}