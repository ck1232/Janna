package com.JJ.model;

import java.util.Date;

public class ProductsuboptionRs extends Base{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productsuboptionid;

    private Integer productid;

    private Integer suboption1id;

    private Integer suboption2id;

    private Integer suboption3id;

    private String deleteind;

    private String createdby;

    private Date createdon;

    private String updatedby;

    private Date updatedon;

    private Integer version;

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

    public Integer getSuboption1id() {
        return suboption1id;
    }

    public void setSuboption1id(Integer suboption1id) {
        this.suboption1id = suboption1id;
    }

    public Integer getSuboption2id() {
        return suboption2id;
    }

    public void setSuboption2id(Integer suboption2id) {
        this.suboption2id = suboption2id;
    }

    public Integer getSuboption3id() {
        return suboption3id;
    }

    public void setSuboption3id(Integer suboption3id) {
        this.suboption3id = suboption3id;
    }

    public String getDeleteind() {
        return deleteind;
    }

    public void setDeleteind(String deleteind) {
        this.deleteind = deleteind;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}