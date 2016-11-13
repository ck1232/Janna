package com.JJ.model;

public class Submodulepermission extends Base {

	@Override
	public String toString() {
		return "Submodulepermission [roleid=" + roleid + ", submoduleid=" + submoduleid + ", permission=" + permission
				+ ", getDeleteind()=" + getDeleteind() + ", getCreatedby()=" + getCreatedby() + ", getCreatedon()="
				+ getCreatedon() + ", getUpdatedby()=" + getUpdatedby() + ", getUpdatedon()=" + getUpdatedon()
				+ ", getVersion()=" + getVersion() + "]";
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodulepermission.roleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	private Integer roleid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodulepermission.submoduleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	private Integer submoduleid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodulepermission.permission
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	private String permission;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodulepermission.roleId
	 * @return  the value of submodulepermission.roleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodulepermission.roleId
	 * @param roleid  the value for submodulepermission.roleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodulepermission.submoduleId
	 * @return  the value of submodulepermission.submoduleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public Integer getSubmoduleid() {
		return submoduleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodulepermission.submoduleId
	 * @param submoduleid  the value for submodulepermission.submoduleId
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public void setSubmoduleid(Integer submoduleid) {
		this.submoduleid = submoduleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodulepermission.permission
	 * @return  the value of submodulepermission.permission
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodulepermission.permission
	 * @param permission  the value for submodulepermission.permission
	 * @mbggenerated  Wed Nov 09 23:39:44 SGT 2016
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	//non db field
	private String submodulename;
	private String permissiontype;
	
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
	
}