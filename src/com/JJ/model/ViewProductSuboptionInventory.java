package com.JJ.model;

import java.math.BigDecimal;

public class ViewProductSuboptionInventory {
    private String productname;

    private Integer productid;

    private String suboption1name;

    private Integer suboption1id;

    private String suboption2name;

    private Integer suboption2id;

    private String suboption3name;

    private Integer suboption3id;

    private BigDecimal qty;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getSuboption1name() {
        return suboption1name;
    }

    public void setSuboption1name(String suboption1name) {
        this.suboption1name = suboption1name;
    }

    public Integer getSuboption1id() {
        return suboption1id;
    }

    public void setSuboption1id(Integer suboption1id) {
        this.suboption1id = suboption1id;
    }

    public String getSuboption2name() {
        return suboption2name;
    }

    public void setSuboption2name(String suboption2name) {
        this.suboption2name = suboption2name;
    }

    public Integer getSuboption2id() {
        return suboption2id;
    }

    public void setSuboption2id(Integer suboption2id) {
        this.suboption2id = suboption2id;
    }

    public String getSuboption3name() {
        return suboption3name;
    }

    public void setSuboption3name(String suboption3name) {
        this.suboption3name = suboption3name;
    }

    public Integer getSuboption3id() {
        return suboption3id;
    }

    public void setSuboption3id(Integer suboption3id) {
        this.suboption3id = suboption3id;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}