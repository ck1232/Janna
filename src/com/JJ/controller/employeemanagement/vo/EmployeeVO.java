package com.JJ.controller.employeemanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class EmployeeVO extends Base implements Serializable {
    private Integer employeeId;

    private String name;

    private String employeeType;
    
    private String employeeTypeString;

    private Date dob;
    
    private String dobString;

    private String nationality;

    private BigDecimal basicSalary;

    private Date employmentStartDate;
    
    private String employmentStartDateString;

    private Date employmentEndDate;
    
    private String employmentEndDateString;

    private String cdacInd;
    
    private Boolean cdacIndBoolean;

    private Integer version;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;

    private static final long serialVersionUID = 1L;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType == null ? null : employeeType.trim();
    }

    public String getEmployeeTypeString() {
		return employeeTypeString;
	}

	public void setEmployeeTypeString(String employeeTypeString) {
		this.employeeTypeString = employeeTypeString == null ? null : employeeTypeString.trim();
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
		this.dobString = dobString == null ? null : dobString.trim();
	}

	public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Date getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(Date employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public String getEmploymentStartDateString() {
		return employmentStartDateString;
	}

	public void setEmploymentStartDateString(String employmentStartDateString) {
		this.employmentStartDateString = employmentStartDateString == null ? null : employmentStartDateString.trim();
	}

	public Date getEmploymentEndDate() {
        return employmentEndDate;
    }

    public void setEmploymentEndDate(Date employmentEndDate) {
        this.employmentEndDate = employmentEndDate;
    }

    public String getEmploymentEndDateString() {
		return employmentEndDateString;
	}

	public void setEmploymentEndDateString(String employmentEndDateString) {
		this.employmentEndDateString = employmentEndDateString == null ? null : employmentEndDateString.trim();
	}

	public String getCdacInd() {
        return cdacInd;
    }

    public void setCdacInd(String cdacInd) {
        this.cdacInd = cdacInd == null ? null : cdacInd.trim();
    }

    public Boolean getCdacIndBoolean() {
		return cdacIndBoolean;
	}

	public void setCdacIndBoolean(Boolean cdacIndBoolean) {
		this.cdacIndBoolean = cdacIndBoolean;
	}

	public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(String deleteInd) {
        this.deleteInd = deleteInd == null ? null : deleteInd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", name=").append(name);
        sb.append(", employeeType=").append(employeeType);
        sb.append(", dob=").append(dob);
        sb.append(", nationality=").append(nationality);
        sb.append(", basicSalary=").append(basicSalary);
        sb.append(", employmentStartDate=").append(employmentStartDate);
        sb.append(", employmentEndDate=").append(employmentEndDate);
        sb.append(", cdacInd=").append(cdacInd);
        sb.append(", version=").append(version);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", deleteInd=").append(deleteInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}