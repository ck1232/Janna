package com.JJ.controller.employeemanagement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer employeeid;

    private String name;

    private String employmenttype;

    private Date dob;
    
    private String dobString;

    private String nationality;

    private BigDecimal basicsalary;

    private Date employstartdate;
    
    private String employstartdateString;

    private Date employenddate;
    
    private String employenddateString;

    private String cdacind;
    
    private Boolean cdacindBoolean;

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

    public String getDobString() {
		return dobString;
	}

	public void setDobString(String dobString) {
		this.dobString = dobString;
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

    public String getEmploystartdateString() {
		return employstartdateString;
	}

	public void setEmploystartdateString(String employstartdateString) {
		this.employstartdateString = employstartdateString;
	}

	public Date getEmployenddate() {
        return employenddate;
    }

    public void setEmployenddate(Date employenddate) {
        this.employenddate = employenddate;
    }

    public String getEmployenddateString() {
		return employenddateString;
	}

	public void setEmployenddateString(String employenddateString) {
		this.employenddateString = employenddateString;
	}

	public String getCdacind() {
        return cdacind;
    }

    public void setCdacind(String cdacind) {
        this.cdacind = cdacind;
    }

	public Boolean getCdacindBoolean() {
		return cdacindBoolean;
	}

	public void setCdacindBoolean(Boolean cdacindBoolean) {
		this.cdacindBoolean = cdacindBoolean;
	}
	
	
}
