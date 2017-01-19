package com.JJ.model;

import java.math.BigDecimal;

public class Productinventory extends Base{
    private Integer productinventoryid;

    private Integer productsuboptionid;

    private Integer transferfrom;

    private Integer transferto;

    private Boolean plusorminus;

    private Integer qty;

    private String remarks;

    private BigDecimal unitcost;

    private String mode;

    private Integer referenceid;

    private String deleteremarks;

    public Integer getProductinventoryid() {
        return productinventoryid;
    }

    public void setProductinventoryid(Integer productinventoryid) {
        this.productinventoryid = productinventoryid;
    }

    public Integer getProductsuboptionid() {
        return productsuboptionid;
    }

    public void setProductsuboptionid(Integer productsuboptionid) {
        this.productsuboptionid = productsuboptionid;
    }

    public Productinventory(Integer productsuboptionid, Integer transferfrom, Integer transferto, Boolean plusorminus,
			Integer qty, String remarks) {
		super();
		this.productsuboptionid = productsuboptionid;
		this.transferfrom = transferfrom;
		this.transferto = transferto;
		this.plusorminus = plusorminus;
		this.qty = qty;
		this.remarks = remarks;
	}

	public Productinventory() {
		super();
	}

	public Integer getTransferfrom() {
        return transferfrom;
    }

    public void setTransferfrom(Integer transferfrom) {
        this.transferfrom = transferfrom;
    }

    public Integer getTransferto() {
        return transferto;
    }

    public void setTransferto(Integer transferto) {
        this.transferto = transferto;
    }

    public Boolean getPlusorminus() {
        return plusorminus;
    }

    public void setPlusorminus(Boolean plusorminus) {
        this.plusorminus = plusorminus;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(Integer referenceid) {
        this.referenceid = referenceid;
    }

    public String getDeleteremarks() {
        return deleteremarks;
    }

    public void setDeleteremarks(String deleteremarks) {
        this.deleteremarks = deleteremarks;
    }
}