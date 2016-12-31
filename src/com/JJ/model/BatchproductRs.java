package com.JJ.model;

import java.math.BigDecimal;

public class BatchproductRs extends Base{
    @Override
	public String toString() {
		return "BatchproductRs [batchproductid=" + batchproductid + ", batchid=" + batchid + ", productsuboptionid="
				+ productsuboptionid + ", unitcost=" + unitcost + ", qty=" + qty + ", getDeleteind()=" + getDeleteind()
				+ ", getCreatedby()=" + getCreatedby() + ", getCreatedon()=" + getCreatedon() + ", getUpdatedby()="
				+ getUpdatedby() + ", getUpdatedon()=" + getUpdatedon() + ", getVersion()=" + getVersion() + "]";
	}

	private Integer batchproductid;

    private Integer batchid;

    private Integer productsuboptionid;

    private BigDecimal unitcost;

    private Integer qty;

    public Integer getBatchproductid() {
        return batchproductid;
    }

    public void setBatchproductid(Integer batchproductid) {
        this.batchproductid = batchproductid;
    }

    public Integer getBatchid() {
        return batchid;
    }

    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    public Integer getProductsuboptionid() {
        return productsuboptionid;
    }

    public void setProductsuboptionid(Integer productsuboptionid) {
        this.productsuboptionid = productsuboptionid;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}