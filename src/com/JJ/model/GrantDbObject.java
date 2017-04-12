package com.JJ.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GrantDbObject extends Base implements Serializable {
    private Integer grantId;

    private String organisation;

    private Date grantDate;

    private BigDecimal totalAmt;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getGrantId() {
        return grantId;
    }

    public void setGrantId(Integer grantId) {
        this.grantId = grantId;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation == null ? null : organisation.trim();
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
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
        sb.append(", grantId=").append(grantId);
        sb.append(", organisation=").append(organisation);
        sb.append(", grantDate=").append(grantDate);
        sb.append(", totalAmt=").append(totalAmt);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}