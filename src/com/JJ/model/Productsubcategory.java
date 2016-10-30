package com.JJ.model;

public class Productsubcategory {
    @Override
	public String toString() {
		return "Productsubcategory [id=" + id + ", name=" + name + ", productcategoryid=" + productcategoryid
				+ ", displayind=" + displayind + ", deleteind=" + deleteind + ", displayindString=" + displayindString
				+ "]";
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsubcategory.id
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsubcategory.name
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsubcategory.productCategoryId
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    private Integer productcategoryid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsubcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    private Boolean displayind;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column productsubcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    private String deleteind;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsubcategory.id
     *
     * @return the value of productsubcategory.id
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsubcategory.id
     *
     * @param id the value for productsubcategory.id
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsubcategory.name
     *
     * @return the value of productsubcategory.name
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsubcategory.name
     *
     * @param name the value for productsubcategory.name
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsubcategory.productCategoryId
     *
     * @return the value of productsubcategory.productCategoryId
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public Integer getProductcategoryid() {
        return productcategoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsubcategory.productCategoryId
     *
     * @param productcategoryid the value for productsubcategory.productCategoryId
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public void setProductcategoryid(Integer productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsubcategory.displayInd
     *
     * @return the value of productsubcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public Boolean getDisplayind() {
        return displayind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsubcategory.displayInd
     *
     * @param displayind the value for productsubcategory.displayInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public void setDisplayind(Boolean displayind) {
        this.displayind = displayind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column productsubcategory.deleteInd
     *
     * @return the value of productsubcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public String getDeleteind() {
        return deleteind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column productsubcategory.deleteInd
     *
     * @param deleteind the value for productsubcategory.deleteInd
     *
     * @mbggenerated Sat Oct 29 23:10:05 SGT 2016
     */
    public void setDeleteind(String deleteind) {
        this.deleteind = deleteind;
    }
    
    //non db fields - for display in data table

    private String displayindString;

	public void setDisplayindString() {

		if(displayind.booleanValue()) {
			this.displayindString =  "Y";
    	}else{
    		this.displayindString =  "N";
    	}
	} 
}