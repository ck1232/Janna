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
    
    private Date bounceDate;
    
    private String bounceDateString;
    
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

    public Date getBounceDate() {
		return bounceDate;
	}

	public void setBounceDate(Date bounceDate) {
		this.bounceDate = bounceDate;
	}

	public String getBounceDateString() {
		return bounceDateString;
	}

	public void setBounceDateString(String bounceDateString) {
		this.bounceDateString = bounceDateString;
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}