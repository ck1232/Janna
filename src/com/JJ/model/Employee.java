package com.JJ.model;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private Integer employeeid;

    private String name;

    private String employmenttype;

    private Date dob;

    private String nationality;

    private BigDecimal basicsalary;

    private String defunctind;

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

    public String getDefunctind() {
        return defunctind;
    }

    public void setDefunctind(String defunctind) {
        this.defunctind = defunctind;
    }
}