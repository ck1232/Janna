package com.JJ.controller.salarybonusmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Employee;

public class SalaryBonusVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date date;
	private String dateString;
	private Employee employee;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
