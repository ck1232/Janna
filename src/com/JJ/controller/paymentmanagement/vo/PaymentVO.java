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
	private Boolean paymentmodedirector;
	private BigDecimal directoramount;
	private Boolean paymentmodegiro;
	private BigDecimal giroamount;
	private String type;
	
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
	
	public Boolean getPaymentmodedirector() {
		return paymentmodedirector;
	}

	public void setPaymentmodedirector(Boolean paymentmodedirector) {
		this.paymentmodedirector = paymentmodedirector;
	}

	public BigDecimal getDirectoramount() {
		return directoramount;
	}

	public void setDirectoramount(BigDecimal directoramount) {
		this.directoramount = directoramount;
	}

	public Boolean getPaymentmodegiro() {
		return paymentmodegiro;
	}

	public void setPaymentmodegiro(Boolean paymentmodegiro) {
		this.paymentmodegiro = paymentmodegiro;
	}

	public BigDecimal getGiroamount() {
		return giroamount;
	}

	public void setGiroamount(BigDecimal giroamount) {
		this.giroamount = giroamount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PaymentVO [referenceType=" + referenceType + ", paymentDate=" + paymentDate + ", paymentdateString="
				+ paymentdateString + ", paymentmodecash=" + paymentmodecash + ", cashamount=" + cashamount
				+ ", paymentmodecheque=" + paymentmodecheque + ", chequeId=" + chequeId + ", chequeno=" + chequeno
				+ ", chequeamount=" + chequeamount + ", chequedate=" + chequedate + ", chequedateString="
				+ chequedateString + ", paymentmodedirector=" + paymentmodedirector + ", directoramount="
				+ directoramount + ", paymentmodegiro=" + paymentmodegiro + ", giroamount=" + giroamount + "]";
	}

}
