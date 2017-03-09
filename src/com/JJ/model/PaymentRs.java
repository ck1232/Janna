package com.JJ.model;

public class PaymentRs extends Base {
	private static final long serialVersionUID = 1L;

	private Integer paymentrsid;

    private String referencetype;

    private Integer referenceid;

    private Integer paymentdetailid;

    public Integer getPaymentrsid() {
        return paymentrsid;
    }

    public void setPaymentrsid(Integer paymentrsid) {
        this.paymentrsid = paymentrsid;
    }

    public String getReferencetype() {
        return referencetype;
    }

    public void setReferencetype(String referencetype) {
        this.referencetype = referencetype;
    }

    public Integer getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(Integer referenceid) {
        this.referenceid = referenceid;
    }

    public Integer getPaymentdetailid() {
        return paymentdetailid;
    }

    public void setPaymentdetailid(Integer paymentdetailid) {
        this.paymentdetailid = paymentdetailid;
    }

	@Override
	public String toString() {
		return "PaymentRs [paymentrsid=" + paymentrsid + ", referencetype=" + referencetype + ", referenceid="
				+ referenceid + ", paymentdetailid=" + paymentdetailid + "]";
	}
    
    
}