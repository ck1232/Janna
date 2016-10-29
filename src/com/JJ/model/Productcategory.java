package com.JJ.model;

public class Productcategory {

	@Override
	public String toString() {
		return "Productcategory [id=" + id + ", name=" + name + ", isparent=" + isparent + ", displayind=" + displayind
				+ ", deleteind=" + deleteind + ", isparentString=" + isparentString + ", displayindString="
				+ displayindString + "]";
	}


	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productcategory.id
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productcategory.name
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productcategory.isParent
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    private Boolean isparent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    private Boolean displayind;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    private String deleteind;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productcategory.id
     *
     * @return the value of productcategory.id
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productcategory.id
     *
     * @param id the value for productcategory.id
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productcategory.name
     *
     * @return the value of productcategory.name
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productcategory.name
     *
     * @param name the value for productcategory.name
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productcategory.isParent
     *
     * @return the value of productcategory.isParent
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public Boolean getIsparent() {
        return isparent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productcategory.isParent
     *
     * @param isparent the value for productcategory.isParent
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productcategory.displayInd
     *
     * @return the value of productcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public Boolean getDisplayind() {
        return displayind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productcategory.displayInd
     *
     * @param displayind the value for productcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public void setDisplayind(Boolean displayind) {
        this.displayind = displayind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productcategory.deleteInd
     *
     * @return the value of productcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public String getDeleteind() {
        return deleteind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productcategory.deleteInd
     *
     * @param deleteind the value for productcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 15:22:30 SGT 2016
     */
    public void setDeleteind(String deleteind) {
        this.deleteind = deleteind;
    }
    
    
    //non db fields - for display in data table
    
    private String isparentString;

    private String displayindString;

	public void setIsparentString() {
		if(isparent.booleanValue()) {
			this.isparentString =  "Y";
		}else{
			this.isparentString =  "N";
		}
	}

	public void setDisplayindString() {

		if(displayind.booleanValue()) {
			this.displayindString =  "Y";
    	}else{
    		this.displayindString =  "N";
    	}
	} 
    
}