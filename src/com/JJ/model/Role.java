package com.JJ.model;

import java.util.Date;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.name
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.createdby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private String createdby;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.createdon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private Date createdon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.updatedby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private String updatedby;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.updatedon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private Date updatedon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.version
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    private Byte version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.createdby
     *
     * @return the value of role.createdby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public String getCreatedby() {
        return createdby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.createdby
     *
     * @param createdby the value for role.createdby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.createdon
     *
     * @return the value of role.createdon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public Date getCreatedon() {
        return createdon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.createdon
     *
     * @param createdon the value for role.createdon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.updatedby
     *
     * @return the value of role.updatedby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public String getUpdatedby() {
        return updatedby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.updatedby
     *
     * @param updatedby the value for role.updatedby
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.updatedon
     *
     * @return the value of role.updatedon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public Date getUpdatedon() {
        return updatedon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.updatedon
     *
     * @param updatedon the value for role.updatedon
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.version
     *
     * @return the value of role.version
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public Byte getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.version
     *
     * @param version the value for role.version
     *
     * @mbggenerated Mon Oct 10 23:45:27 SGT 2016
     */
    public void setVersion(Byte version) {
        this.version = version;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createdby=" + createdby + ", createdon=" + createdon
				+ ", updatedby=" + updatedby + ", updatedon=" + updatedon + ", version=" + version + "]";
	}
}