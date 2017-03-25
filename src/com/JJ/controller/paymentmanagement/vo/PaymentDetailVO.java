package com.JJ.controller.paymentmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class PaymentDetailVO extends Base implements Serializable {
	
    private Integer paymentDetailId;

    private Date paymentDate;
    
    private String paymentDateString;

    private Integer paymentMode;
    
    private String paymentModeString;

    private BigDecimal paymentAmt;

    private String chequeId;
    
    private String chequeNum;
    
    private String bounceChequeInd;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;
    
    private static final long serialVersionUID = 1L;

    public Integer getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(Integer paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public String getPaymentDateString() {
  		return paymentDateString;
  	}

  	public void setPaymentDateString(String paymentDateString) {
  		this.paymentDateString = paymentDateString == null ? null : paymentDateString.trim();
  	}

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }
    
    public String getPaymentModeString() {
  		return paymentModeString;
  	}

  	public void setPaymentModeString(String paymentModeString) {
  		this.paymentModeString = paymentModeString == null ? null : paymentModeString.trim();
  	}

    public BigDecimal getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(BigDecimal paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getChequeId() {
        return chequeId;
    }

    public void setChequeId(String chequeId) {
        this.chequeId = chequeId;
    }

    public String getChequeNum() {
		return chequeNum;
	}

	public void setChequeNum(String chequeNum) {
		this.chequeNum = chequeNum == null ? null : chequeNum.trim();
	}

	public String getBounceChequeInd() {
		return bounceChequeInd;
	}

	public void setBounceChequeInd(String bounceChequeInd) {
		this.bounceChequeInd = bounceChequeInd == null ? null : bounceChequeInd.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paymentDetailId=").append(paymentDetailId);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentMode=").append(paymentMode);
        sb.append(", paymentAmt=").append(paymentAmt);
        sb.append(", chequeId=").append(chequeId);
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