package com.JJ.model;

public class Productsuboption {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.productSubOptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private Integer productsuboptionid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.productId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private Integer productid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.productoptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private Integer productoptionid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.name
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.sequence
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private Integer sequence;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsuboption.displayInd
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    private Boolean displayind;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.productSubOptionId
     *
     * @return the value of productsuboption.productSubOptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public Integer getProductsuboptionid() {
        return productsuboptionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.productSubOptionId
     *
     * @param productsuboptionid the value for productsuboption.productSubOptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setProductsuboptionid(Integer productsuboptionid) {
        this.productsuboptionid = productsuboptionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.productId
     *
     * @return the value of productsuboption.productId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public Integer getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.productId
     *
     * @param productid the value for productsuboption.productId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.productoptionId
     *
     * @return the value of productsuboption.productoptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public Integer getProductoptionid() {
        return productoptionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.productoptionId
     *
     * @param productoptionid the value for productsuboption.productoptionId
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setProductoptionid(Integer productoptionid) {
        this.productoptionid = productoptionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.name
     *
     * @return the value of productsuboption.name
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.name
     *
     * @param name the value for productsuboption.name
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.sequence
     *
     * @return the value of productsuboption.sequence
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.sequence
     *
     * @param sequence the value for productsuboption.sequence
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsuboption.displayInd
     *
     * @return the value of productsuboption.displayInd
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public Boolean getDisplayind() {
        return displayind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsuboption.displayInd
     *
     * @param displayind the value for productsuboption.displayInd
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    public void setDisplayind(Boolean displayind) {
        this.displayind = displayind;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productsuboption other = (Productsuboption) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
}