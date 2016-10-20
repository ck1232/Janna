package com.JJ.model;

import java.util.List;

public class Submodule {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.id
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.parentId
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private Integer parentid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.name
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.icon
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private String icon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.url
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column submodule.deleteInd
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	private String deleteind;

	//non-DB fields
	private String parentModuleName;
	private List<Submodulepermissiontype> submodulepermissiontypeList;
	
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.id
	 * @return  the value of submodule.id
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.id
	 * @param id  the value for submodule.id
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.parentId
	 * @return  the value of submodule.parentId
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.parentId
	 * @param parentid  the value for submodule.parentId
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.name
	 * @return  the value of submodule.name
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.name
	 * @param name  the value for submodule.name
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.icon
	 * @return  the value of submodule.icon
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.icon
	 * @param icon  the value for submodule.icon
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.url
	 * @return  the value of submodule.url
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.url
	 * @param url  the value for submodule.url
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column submodule.deleteInd
	 * @return  the value of submodule.deleteInd
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public String getDeleteind() {
		return deleteind;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column submodule.deleteInd
	 * @param deleteind  the value for submodule.deleteInd
	 * @mbggenerated  Sat Oct 15 18:00:34 SGT 2016
	 */
	public void setDeleteind(String deleteind) {
		this.deleteind = deleteind;
	}

	//non-DB fields START
	public String getParentModuleName() {
		return parentModuleName;
	}

	public void setParentModuleName(String parentModuleName) {
		this.parentModuleName = parentModuleName;
	}
	
	public List<Submodulepermissiontype> getSubmodulepermissiontypeList() {
		return submodulepermissiontypeList;
	}

	public void setSubmodulepermissiontypeList(List<Submodulepermissiontype> submodulepermissiontypeList) {
		this.submodulepermissiontypeList = submodulepermissiontypeList;
	}
	//non-DB fields END
}