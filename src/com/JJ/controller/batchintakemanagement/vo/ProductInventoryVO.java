package com.JJ.controller.batchintakemanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class ProductInventoryVO extends Base implements Serializable {
    

	private Integer productInventoryId;

    private Integer productSuboptionRsId;

    private Integer transferFrom;

    private Integer transferTo;

    private Boolean plusOrMinus;

    private Integer qty;

    private String remarks;

    private BigDecimal unitAmt;

    private String mode;

    private Integer referenceId;

    private Date date;

    private String deleteRemarks;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;
    
    private String product;
    
    private ProductSubOptionRsVO productSuboption;
    
    private StorageLocationVO fromLocation;
    
    private StorageLocationVO toLocation;
    
    private String location;
    
    private String itemCode;

    private static final long serialVersionUID = 1L;
    
    
    
    public ProductInventoryVO() {}

	public ProductInventoryVO(Integer productSuboptionRsId,
			Integer transferFrom, Integer transferTo, Boolean plusOrMinus,
			Integer qty, String remarks) {
		super();
		this.productSuboptionRsId = productSuboptionRsId;
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.plusOrMinus = plusOrMinus;
		this.qty = qty;
		this.remarks = remarks;
	}

    public ProductInventoryVO(Integer productSuboptionRsId,
			Integer transferFrom, Integer transferTo, Boolean plusOrMinus,
			Integer qty, String remarks, String mode, Integer referenceId) {
		super();
		this.productSuboptionRsId = productSuboptionRsId;
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.plusOrMinus = plusOrMinus;
		this.qty = qty;
		this.remarks = remarks;
		this.mode = mode;
		this.referenceId = referenceId;
	}



	public Integer getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(Integer productInventoryId) {
        this.productInventoryId = productInventoryId;
    }

    public Integer getProductSuboptionRsId() {
        return productSuboptionRsId;
    }

    public void setProductSuboptionRsId(Integer productSuboptionRsId) {
        this.productSuboptionRsId = productSuboptionRsId;
    }

    public Integer getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(Integer transferFrom) {
        this.transferFrom = transferFrom;
    }

    public Integer getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(Integer transferTo) {
        this.transferTo = transferTo;
    }

    public Boolean getPlusOrMinus() {
        return plusOrMinus;
    }

    public void setPlusOrMinus(Boolean plusOrMinus) {
        this.plusOrMinus = plusOrMinus;
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
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public BigDecimal getUnitAmt() {
        return unitAmt;
    }

    public void setUnitAmt(BigDecimal unitAmt) {
        this.unitAmt = unitAmt;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeleteRemarks() {
        return deleteRemarks;
    }

    public void setDeleteRemarks(String deleteRemarks) {
        this.deleteRemarks = deleteRemarks == null ? null : deleteRemarks.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(String deleteInd) {
        this.deleteInd = deleteInd == null ? null : deleteInd.trim();
    }

    public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public ProductSubOptionRsVO getProductSuboption() {
		return productSuboption;
	}

	public void setProductSuboption(ProductSubOptionRsVO productSuboption) {
		this.productSuboption = productSuboption;
	}

	public StorageLocationVO getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(StorageLocationVO fromLocation) {
		this.fromLocation = fromLocation;
	}

	public StorageLocationVO getToLocation() {
		return toLocation;
	}

	public void setToLocation(StorageLocationVO toLocation) {
		this.toLocation = toLocation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productInventoryId=").append(productInventoryId);
        sb.append(", productSuboptionRsId=").append(productSuboptionRsId);
        sb.append(", transferFrom=").append(transferFrom);
        sb.append(", transferTo=").append(transferTo);
        sb.append(", plusOrMinus=").append(plusOrMinus);
        sb.append(", qty=").append(qty);
        sb.append(", remarks=").append(remarks);
        sb.append(", unitAmt=").append(unitAmt);
        sb.append(", mode=").append(mode);
        sb.append(", referenceId=").append(referenceId);
        sb.append(", date=").append(date);
        sb.append(", deleteRemarks=").append(deleteRemarks);
        sb.append(", version=").append(version);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", deleteInd=").append(deleteInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}