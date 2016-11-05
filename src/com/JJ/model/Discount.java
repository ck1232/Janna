package com.JJ.model;

import java.math.BigDecimal;

public class Discount {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.discountId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private Integer discountid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.promoId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private Integer promoid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.discountName
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private String discountname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.discountType
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private String discounttype;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.discountValue
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private BigDecimal discountvalue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column discount.deleteInd
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	private String deleteind;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.discountId
	 * @return  the value of discount.discountId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public Integer getDiscountid() {
		return discountid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.discountId
	 * @param discountid  the value for discount.discountId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setDiscountid(Integer discountid) {
		this.discountid = discountid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.promoId
	 * @return  the value of discount.promoId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public Integer getPromoid() {
		return promoid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.promoId
	 * @param promoid  the value for discount.promoId
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setPromoid(Integer promoid) {
		this.promoid = promoid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.discountName
	 * @return  the value of discount.discountName
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public String getDiscountname() {
		return discountname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.discountName
	 * @param discountname  the value for discount.discountName
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setDiscountname(String discountname) {
		this.discountname = discountname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.discountType
	 * @return  the value of discount.discountType
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public String getDiscounttype() {
		return discounttype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.discountType
	 * @param discounttype  the value for discount.discountType
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setDiscounttype(String discounttype) {
		this.discounttype = discounttype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.discountValue
	 * @return  the value of discount.discountValue
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public BigDecimal getDiscountvalue() {
		return discountvalue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.discountValue
	 * @param discountvalue  the value for discount.discountValue
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setDiscountvalue(BigDecimal discountvalue) {
		this.discountvalue = discountvalue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column discount.deleteInd
	 * @return  the value of discount.deleteInd
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public String getDeleteind() {
		return deleteind;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column discount.deleteInd
	 * @param deleteind  the value for discount.deleteInd
	 * @mbggenerated  Wed Nov 02 23:18:43 SGT 2016
	 */
	public void setDeleteind(String deleteind) {
		this.deleteind = deleteind;
	}

	@Override
	public String toString() {
		return "Discount [discountid=" + discountid + ", promoid=" + promoid + ", discountname=" + discountname
				+ ", discounttype=" + discounttype + ", discountvalue=" + discountvalue + ", deleteind=" + deleteind
				+ "]";
	}
}