package com.JJ.model;

public class Storagelocation extends Base{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storagelocation.locationid
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    private Integer locationid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storagelocation.locationname
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    private String locationname;

    @Override
	public String toString() {
		return "Storagelocation [locationid=" + locationid + ", locationname=" + locationname + ", address=" + address
				+ ", postalcode=" + postalcode + "]";
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storagelocation.address
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storagelocation.postalCode
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    private Integer postalcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storagelocation.locationid
     *
     * @return the value of storagelocation.locationid
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public Integer getLocationid() {
        return locationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storagelocation.locationid
     *
     * @param locationid the value for storagelocation.locationid
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storagelocation.locationname
     *
     * @return the value of storagelocation.locationname
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public String getLocationname() {
        return locationname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storagelocation.locationname
     *
     * @param locationname the value for storagelocation.locationname
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storagelocation.address
     *
     * @return the value of storagelocation.address
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storagelocation.address
     *
     * @param address the value for storagelocation.address
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storagelocation.postalCode
     *
     * @return the value of storagelocation.postalCode
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public Integer getPostalcode() {
        return postalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storagelocation.postalCode
     *
     * @param postalcode the value for storagelocation.postalCode
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }
}