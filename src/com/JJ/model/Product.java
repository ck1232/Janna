package com.JJ.model;

import java.math.BigDecimal;

public class Product extends Base{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productid;

    private String productname;

    private BigDecimal unitprice;

    private Integer weight;

    private Integer subcategoryid;

    private String desciption;

    private String paypalid;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(Integer subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getPaypalid() {
        return paypalid;
    }

    public void setPaypalid(String paypalid) {
        this.paypalid = paypalid;
    }
    
    
}