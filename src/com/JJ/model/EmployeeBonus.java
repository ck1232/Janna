package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeBonus extends Base{
	private static final long serialVersionUID = 1L;

	private Integer bonusid;

    private Date bonusdate;

    private Integer employeeid;

    private BigDecimal bonusamount;

    private BigDecimal employeecpf;

    private BigDecimal employercdf;

    private String status;

    public Integer getBonusid() {
        return bonusid;
    }

    public void setBonusid(Integer bonusid) {
        this.bonusid = bonusid;
    }

    public Date getBonusdate() {
        return bonusdate;
    }

    public void setBonusdate(Date bonusdate) {
        this.bonusdate = bonusdate;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public BigDecimal getBonusamount() {
        return bonusamount;
    }

    public void setBonusamount(BigDecimal bonusamount) {
        this.bonusamount = bonusamount;
    }

    public BigDecimal getEmployeecpf() {
        return employeecpf;
    }

    public void setEmployeecpf(BigDecimal employeecpf) {
        this.employeecpf = employeecpf;
    }

    public BigDecimal getEmployercdf() {
        return employercdf;
    }

    public void setEmployercdf(BigDecimal employercdf) {
        this.employercdf = employercdf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}