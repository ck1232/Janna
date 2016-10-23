package com.JJ.model;

import java.util.List;

public class RolesPermission {
	private String roleid;
	private String rolename;
	private String submoduleId;
	private String submoduleName;
	private List<String> permissionList;
	private String permission;
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
	public List<String> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<String> permissionList) {
		this.permissionList = permissionList;
	}
	
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
