package com.JJ.controller.batchintakemanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class BatchStockIntakeVO extends Base implements Serializable {
    private Integer batchId;

    private String remarks;

    private Date date;

    private Integer storageLocation;

    private BigDecimal totalCost;

    private BigDecimal additionalCost;
    
    private String storageLocationName;

    private static final long serialVersionUID = 1L;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(Integer storageLocation) {
        this.storageLocation = storageLocation;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(BigDecimal additionalCost) {
        this.additionalCost = additionalCost;
    }
    
    public String getStorageLocationName() {
		return storageLocationName;
	}

	public void setStorageLocationName(String storageLocationName) {
		this.storageLocationName = storageLocationName;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", batchId=").append(batchId);
        sb.append(", remarks=").append(remarks);
        sb.append(", date=").append(date);
        sb.append(", storageLocation=").append(storageLocation);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", additionalCost=").append(additionalCost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}