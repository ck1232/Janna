package com.JJ.controller.paymentmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String referenceType;
	private Date paymentDate;
	private String paymentdateString;
	private Boolean paymentmodecash;
	private BigDecimal cashamount;
	private Boolean paymentmodecheque;
	private String chequeId;
	private String chequeno;
	private BigDecimal chequeamount;
	private Date chequedate;
	private String chequedateString;
	
	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentdateString() {
		return paymentdateString;
	}
	public void setPaymentdateString(String paymentdateString) {
		this.paymentdateString = paymentdateString;
	}
	public Boolean getPaymentmodecash() {
		return paymentmodecash;
	}
	public void setPaymentmodecash(Boolean paymentmodecash) {
		this.paymentmodecash = paymentmodecash;
	}
	public BigDecimal getCashamount() {
		return cashamount;
	}
	public void setCashamount(BigDecimal cashamount) {
		this.cashamount = cashamount;
	}

	public Boolean getPaymentmodecheque() {
		return paymentmodecheque;
	}

	public void setPaymentmodecheque(Boolean paymentmodecheque) {
		this.paymentmodecheque = paymentmodecheque;
	}

	public String getChequeId() {
		return chequeId;
	}

	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}

	public String getChequeno() {
		return chequeno;
	}

	public void setChequeno(String chequeno) {
		this.chequeno = chequeno;
	}

	public BigDecimal getChequeamount() {
		return chequeamount;
	}

	public void setChequeamount(BigDecimal chequeamount) {
		this.chequeamount = chequeamount;
	}

	public Date getChequedate() {
		return chequedate;
	}

	public void setChequedate(Date chequedate) {
		this.chequedate = chequedate;
	}

	public String getChequedateString() {
		return chequedateString;
	}

	public void setChequedateString(String chequedateString) {
		this.chequedateString = chequedateString;
	}
	
	@Override
	public String toString() {
		return "PaymentVo [referenceType=" + referenceType + ", paymentDate=" + paymentDate + ", paymentdateString="
				+ paymentdateString + ", paymentmodecash=" + paymentmodecash + ", cashamount=" + cashamount
				+ ", paymentmodecheque=" + paymentmodecheque + ", chequeno=" + chequeno + ", chequeamount="
				+ chequeamount + ", chequedate=" + chequedate + ", chequedateString=" + chequedateString + "]";
	}
	
}
