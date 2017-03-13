package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeSalary extends Base{
	private static final long serialVersionUID = 1L;

	private Integer salaryid;

    private Date salarydate;

    private Integer employeeid;

    private BigDecimal basicsalaryamount;

    private BigDecimal overtimeamount;

    private BigDecimal overtimehours;

    private String overtimeremark;

    private BigDecimal allowance;

    private BigDecimal unpaidleaveamount;

    private String unpaidleaveremark;

    private BigDecimal employeecpf;

    private BigDecimal employercpf;

    private BigDecimal cdacamount;

    private BigDecimal sdlamount;

    private BigDecimal fwlevy;

    private String status;

    public Integer getSalaryid() {
        return salaryid;
    }

    public void setSalaryid(Integer salaryid) {
        this.salaryid = salaryid;
    }

    public Date getSalarydate() {
        return salarydate;
    }

    public void setSalarydate(Date salarydate) {
        this.salarydate = salarydate;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public BigDecimal getBasicsalaryamount() {
        return basicsalaryamount;
    }

    public void setBasicsalaryamount(BigDecimal basicsalaryamount) {
        this.basicsalaryamount = basicsalaryamount;
    }

    public BigDecimal getOvertimeamount() {
        return overtimeamount;
    }

    public void setOvertimeamount(BigDecimal overtimeamount) {
        this.overtimeamount = overtimeamount;
    }

    public BigDecimal getOvertimehours() {
        return overtimehours;
    }

    public void setOvertimehours(BigDecimal overtimehours) {
        this.overtimehours = overtimehours;
    }

    public String getOvertimeremark() {
        return overtimeremark;
    }

    public void setOvertimeremark(String overtimeremark) {
        this.overtimeremark = overtimeremark;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public void setAllowance(BigDecimal allowance) {
        this.allowance = allowance;
    }

    public BigDecimal getUnpaidleaveamount() {
        return unpaidleaveamount;
    }

    public void setUnpaidleaveamount(BigDecimal unpaidleaveamount) {
        this.unpaidleaveamount = unpaidleaveamount;
    }

    public String getUnpaidleaveremark() {
        return unpaidleaveremark;
    }

    public void setUnpaidleaveremark(String unpaidleaveremark) {
        this.unpaidleaveremark = unpaidleaveremark;
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

    public BigDecimal getCdacamount() {
        return cdacamount;
    }

    public void setCdacamount(BigDecimal cdacamount) {
        this.cdacamount = cdacamount;
    }

    public BigDecimal getSdlamount() {
        return sdlamount;
    }

    public void setSdlamount(BigDecimal sdlamount) {
        this.sdlamount = sdlamount;
    }

    public BigDecimal getFwlevy() {
        return fwlevy;
    }

    public void setFwlevy(BigDecimal fwlevy) {
        this.fwlevy = fwlevy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}