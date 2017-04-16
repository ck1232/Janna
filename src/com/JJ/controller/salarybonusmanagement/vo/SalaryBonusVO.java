package com.JJ.controller.salarybonusmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.JJ.model.Base;

public class SalaryBonusVO extends Base implements Serializable {
    private Integer id;

    private Date date;
    
    private String dateString;

    private Integer employeeId;
    
    private String name;
    
    private String employeeType;
    
    private Date dob;

    private String nationality;
    
    private Date employmentStartDate;

    private Date employmentEndDate;

    private String cdacInd;

    private BigDecimal basicSalaryAmt;

    private BigDecimal overTimeAmt;

    private BigDecimal overTimeHours;

    private String overTimeRemarks;

    private BigDecimal allowance;
    
    private BigDecimal medical;

    private BigDecimal unpaidLeaveAmt;

    private String unpaidLeaveRemarks;

    private BigDecimal employeeCpf;

    private BigDecimal employerCpf;

    private BigDecimal cdacAmt;

    private BigDecimal sdlAmt;

    private BigDecimal fwLevy;
    
    private BigDecimal grossAmt;
    
	private BigDecimal takehomeAmt;
	
	private BigDecimal bonusAmt;
	
	private String type;

    private String status;

    private static final long serialVersionUID = 1L;

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
		this.dateString = dateString == null ? null : dateString.trim();
	}

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
		this.nationality = nationality == null ? null : nationality.trim();
	}

	public Date getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(Date employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public Date getEmploymentEndDate() {
		return employmentEndDate;
	}

	public void setEmploymentEndDate(Date employmentEndDate) {
		this.employmentEndDate = employmentEndDate;
	}

	public String getCdacInd() {
		return cdacInd;
	}

	public void setCdacInd(String cdacInd) {
		this.cdacInd = cdacInd == null ? null : cdacInd.trim();
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

    public BigDecimal getGrossAmt() {
		return grossAmt;
	}

	public void setGrossAmt(BigDecimal grossAmt) {
		this.grossAmt = grossAmt;
	}

	public BigDecimal getTakehomeAmt() {
		return takehomeAmt;
	}

	public void setTakehomeAmt(BigDecimal takehomeAmt) {
		this.takehomeAmt = takehomeAmt;
	}

	public BigDecimal getBonusAmt() {
		return bonusAmt;
	}

	public void setBonusAmt(BigDecimal bonusAmt) {
		this.bonusAmt = bonusAmt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
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
        sb.append(", id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", basicSalaryAmt=").append(basicSalaryAmt);
        sb.append(", overTimeAmt=").append(overTimeAmt);
        sb.append(", overTimeHours=").append(overTimeHours);
        sb.append(", overTimeRemarks=").append(overTimeRemarks);
        sb.append(", allowance=").append(allowance);
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