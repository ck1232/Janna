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

    private BigDecimal employercpf;

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

    public BigDecimal getEmployercpf() {
        return employercpf;
    }

    public void setEmployercpf(BigDecimal employercpf) {
        this.employercpf = employercpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "EmployeeBonus [bonusid=" + bonusid + ", bonusdate=" + bonusdate + ", employeeid=" + employeeid
				+ ", bonusamount=" + bonusamount + ", employeecpf=" + employeecpf + ", employercpf=" + employercpf
				+ ", status=" + status + "]";
	}
}