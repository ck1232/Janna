package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeSalaryDbObject extends Base implements Serializable {
    private Integer salaryId;

    private Date salaryDate;

    private Integer employeeId;

    private BigDecimal basicSalaryAmt;

    private BigDecimal overTimeAmt;

    private BigDecimal overTimeHours;

    private String overTimeRemarks;

    private BigDecimal allowance;

    private BigDecimal medical;

    private BigDecimal leaveBalance;

    private BigDecimal leaveTaken;

    private BigDecimal unpaidLeaveAmt;

    private String unpaidLeaveRemarks;

    private BigDecimal employeeCpf;

    private BigDecimal employerCpf;

    private BigDecimal cdacAmt;

    private BigDecimal sdlAmt;

    private BigDecimal fwLevy;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getBasicSalaryAmt() {
        return basicSalaryAmt;
    }

    public void setBasicSalaryAmt(BigDecimal basicSalaryAmt) {
        this.basicSalaryAmt = basicSalaryAmt;
    }

    public BigDecimal getOverTimeAmt() {
        return overTimeAmt;
    }

    public void setOverTimeAmt(BigDecimal overTimeAmt) {
        this.overTimeAmt = overTimeAmt;
    }

    public BigDecimal getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(BigDecimal overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    public String getOverTimeRemarks() {
        return overTimeRemarks;
    }

    public void setOverTimeRemarks(String overTimeRemarks) {
        this.overTimeRemarks = overTimeRemarks == null ? null : overTimeRemarks.trim();
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public void setAllowance(BigDecimal allowance) {
        this.allowance = allowance;
    }

    public BigDecimal getMedical() {
        return medical;
    }

    public void setMedical(BigDecimal medical) {
        this.medical = medical;
    }

    public BigDecimal getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(BigDecimal leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public BigDecimal getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(BigDecimal leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    public BigDecimal getUnpaidLeaveAmt() {
        return unpaidLeaveAmt;
    }

    public void setUnpaidLeaveAmt(BigDecimal unpaidLeaveAmt) {
        this.unpaidLeaveAmt = unpaidLeaveAmt;
    }

    public String getUnpaidLeaveRemarks() {
        return unpaidLeaveRemarks;
    }

    public void setUnpaidLeaveRemarks(String unpaidLeaveRemarks) {
        this.unpaidLeaveRemarks = unpaidLeaveRemarks == null ? null : unpaidLeaveRemarks.trim();
    }

    public BigDecimal getEmployeeCpf() {
        return employeeCpf;
    }

    public void setEmployeeCpf(BigDecimal employeeCpf) {
        this.employeeCpf = employeeCpf;
    }

    public BigDecimal getEmployerCpf() {
        return employerCpf;
    }

    public void setEmployerCpf(BigDecimal employerCpf) {
        this.employerCpf = employerCpf;
    }

    public BigDecimal getCdacAmt() {
        return cdacAmt;
    }

    public void setCdacAmt(BigDecimal cdacAmt) {
        this.cdacAmt = cdacAmt;
    }

    public BigDecimal getSdlAmt() {
        return sdlAmt;
    }

    public void setSdlAmt(BigDecimal sdlAmt) {
        this.sdlAmt = sdlAmt;
    }

    public BigDecimal getFwLevy() {
        return fwLevy;
    }

    public void setFwLevy(BigDecimal fwLevy) {
        this.fwLevy = fwLevy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", salaryId=").append(salaryId);
        sb.append(", salaryDate=").append(salaryDate);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", basicSalaryAmt=").append(basicSalaryAmt);
        sb.append(", overTimeAmt=").append(overTimeAmt);
        sb.append(", overTimeHours=").append(overTimeHours);
        sb.append(", overTimeRemarks=").append(overTimeRemarks);
        sb.append(", allowance=").append(allowance);
        sb.append(", medical=").append(medical);
        sb.append(", leaveBalance=").append(leaveBalance);
        sb.append(", leaveTaken=").append(leaveTaken);
        sb.append(", unpaidLeaveAmt=").append(unpaidLeaveAmt);
        sb.append(", unpaidLeaveRemarks=").append(unpaidLeaveRemarks);
        sb.append(", employeeCpf=").append(employeeCpf);
        sb.append(", employerCpf=").append(employerCpf);
        sb.append(", cdacAmt=").append(cdacAmt);
        sb.append(", sdlAmt=").append(sdlAmt);
        sb.append(", fwLevy=").append(fwLevy);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}