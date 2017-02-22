package com.JJ.model;


public class Productsuboption extends Base {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productsuboptionid;

    private Integer productid;

    private Integer productoptionid;

    private String name;

    private String code;

    private Boolean displayind;
    
    public Integer getProductsuboptionid() {
        return productsuboptionid;
    }

    public void setProductsuboptionid(Integer productsuboptionid) {
        this.productsuboptionid = productsuboptionid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductoptionid() {
        return productoptionid;
    }

    public void setProductoptionid(Integer productoptionid) {
        this.productoptionid = productoptionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDisplayind() {
        return displayind;
    }

    public void setDisplayind(Boolean displayind) {
        this.displayind = displayind;
    }
}