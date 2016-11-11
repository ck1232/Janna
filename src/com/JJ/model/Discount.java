package com.JJ.model;

import java.math.BigDecimal;

public class Discount extends Base{
	
	private Integer discountid;
	
	private Integer promoid;

	private String discountname;
	
	private String discounttype;

	private BigDecimal discountvalue;

	private String applytype;
	
	public Integer getDiscountid() {
		return discountid;
	}

	public void setDiscountid(Integer discountid) {
		this.discountid = discountid;
	}

	public Integer getPromoid() {
		return promoid;
	}

	public void setPromoid(Integer promoid) {
		this.promoid = promoid;
	}

	public String getDiscountname() {
		return discountname;
	}

	public void setDiscountname(String discountname) {
		this.discountname = discountname;
	}

	public String getDiscounttype() {
		return discounttype;
	}

	public void setDiscounttype(String discounttype) {
		this.discounttype = discounttype;
	}

	public BigDecimal getDiscountvalue() {
		return discountvalue;
	}

	public void setDiscountvalue(BigDecimal discountvalue) {
		this.discountvalue = discountvalue;
	}

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}
	
	@Override
	public String toString() {
		return "Discount [discountid=" + discountid + ", promoid=" + promoid + ", discountname=" + discountname
				+ ", discounttype=" + discounttype + ", discountvalue=" + discountvalue + ", applytype=" + applytype
				+ ", getDeleteind()=" + getDeleteind() + ", getCreatedby()=" + getCreatedby() + ", getCreatedon()="
				+ getCreatedon() + ", getUpdatedby()=" + getUpdatedby() + ", getUpdatedon()=" + getUpdatedon()
				+ ", getVersion()=" + getVersion() + "]";
	}
	
}