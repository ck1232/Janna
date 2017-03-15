package com.JJ.model;

import java.util.Date;

public class User extends Base {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", status=" + status + ", name="
				+ name + ", emailaddress=" + emailaddress + ", lastlogints=" + lastlogints + ", enabled=" + enabled
				+ ", getDeleteind()=" + getDeleteind() + ", getCreatedby()=" + getCreatedby() + ", getCreatedon()="
				+ getCreatedon() + ", getUpdatedby()=" + getUpdatedby() + ", getUpdatedon()=" + getUpdatedon()
				+ ", getVersion()=" + getVersion() + "]";
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.userid
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private String userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.status
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.name
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.emailaddress
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private String emailaddress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.lastlogints
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private Date lastlogints;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.enabled
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	private Boolean enabled;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.userid
	 * @return  the value of user.userid
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.userid
	 * @param userid  the value for user.userid
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.status
	 * @return  the value of user.status
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.status
	 * @param status  the value for user.status
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.name
	 * @return  the value of user.name
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.name
	 * @param name  the value for user.name
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.emailaddress
	 * @return  the value of user.emailaddress
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getEmailaddress() {
		return emailaddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.emailaddress
	 * @param emailaddress  the value for user.emailaddress
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.lastlogints
	 * @return  the value of user.lastlogints
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public Date getLastlogints() {
		return lastlogints;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.lastlogints
	 * @param lastlogints  the value for user.lastlogints
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setLastlogints(Date lastlogints) {
		this.lastlogints = lastlogints;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.enabled
	 * @return  the value of user.enabled
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.enabled
	 * @param enabled  the value for user.enabled
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
    
}