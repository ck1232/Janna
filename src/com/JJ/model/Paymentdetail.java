package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Paymentdetail extends Base {
	private static final long serialVersionUID = 1L;

	private Integer paymentdetailid;

    private Date paymentdate;

    private Integer paymentmode;

    private BigDecimal paymentamount;

    private String chequenum;

    private String bouncechqind;
    
    public Paymentdetail(){}
    
    public Paymentdetail(Date paymentdate, Integer paymentmode, BigDecimal paymentamount, String chequenum, String bouncechqind) {
    	this.paymentdate = paymentdate;
    	this.paymentmode = paymentmode;
    	this.paymentamount = paymentamount;
    	this.chequenum = chequenum;
    	this.bouncechqind = bouncechqind;
    }

    public Integer getPaymentdetailid() {
        return paymentdetailid;
    }

    public void setPaymentdetailid(Integer paymentdetailid) {
        this.paymentdetailid = paymentdetailid;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Integer getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(Integer paymentmode) {
        this.paymentmode = paymentmode;
    }

    public BigDecimal getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(BigDecimal paymentamount) {
        this.paymentamount = paymentamount;
    }

    public String getChequenum() {
        return chequenum;
    }

    public void setChequenum(String chequenum) {
        this.chequenum = chequenum;
    }

    public String getBouncechqind() {
        return bouncechqind;
    }

    public void setBouncechqind(String bouncechqind) {
        this.bouncechqind = bouncechqind;
    }

	@Override
	public String toString() {
		return "Paymentdetail [paymentdetailid=" + paymentdetailid + ", paymentdate=" + paymentdate + ", paymentmode="
				+ paymentmode + ", paymentamount=" + paymentamount + ", chequenum=" + chequenum + ", bouncechqind="
				+ bouncechqind + "]";
	}
	
	//non db fields
	private String paymentmodeString;
	
	private String paymentdateString;
	
	public String getPaymentmodeString() {
		return paymentmodeString;
	}

	public void setPaymentmodeString(String paymentmodeString) {
		this.paymentmodeString = paymentmodeString;
	}

	public String getPaymentdateString() {
		return paymentdateString;
	}

	public void setPaymentdateString(String paymentdateString) {
		this.paymentdateString = paymentdateString;
	}

}