package com.JJ.controller.salarybonusmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SalaryBonusVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date date;
	private String dateString;
	private Integer employeeid;
    private String name;
    private String employmenttype;
    private Date dob;
    private String nationality;
    private BigDecimal basicsalary;
    private Date employstartdate;
    private Date employenddate;
    private String cdacind;
	private BigDecimal grossamount;
	private BigDecimal takehomeamount;
	private BigDecimal bonusamount;
	private String type;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmploymenttype() {
		return employmenttype;
	}
	public void setEmploymenttype(String employmenttype) {
		this.employmenttype = employmenttype;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public BigDecimal getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(BigDecimal basicsalary) {
		this.basicsalary = basicsalary;
	}
	public Date getEmploystartdate() {
		return employstartdate;
	}
	public void setEmploystartdate(Date employstartdate) {
		this.employstartdate = employstartdate;
	}
	public Date getEmployenddate() {
		return employenddate;
	}
	public void setEmployenddate(Date employenddate) {
		this.employenddate = employenddate;
	}
	public String getCdacind() {
		return cdacind;
	}
	public void setCdacind(String cdacind) {
		this.cdacind = cdacind;
	}
	public BigDecimal getGrossamount() {
		return grossamount;
	}
	public void setGrossamount(BigDecimal grossamount) {
		this.grossamount = grossamount;
	}
	public BigDecimal getTakehomeamount() {
		return takehomeamount;
	}
	public void setTakehomeamount(BigDecimal takehomeamount) {
		this.takehomeamount = takehomeamount;
	}
	public BigDecimal getBonusamount() {
		return bonusamount;
	}
	public void setBonusamount(BigDecimal bonusamount) {
		this.bonusamount = bonusamount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
