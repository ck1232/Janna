package com.JJ.model;

import java.io.Serializable;
import java.util.Date;

public class ImageLinkRsDbObject extends Base implements Serializable {
    private Integer imageLinkRsId;

    private String refType;

    private Integer refId;

    private Integer imageLinkId;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private String deleteInd;

    private Integer version;

    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public Integer getImageLinkRsId() {
        return imageLinkRsId;
    }

    public void setImageLinkRsId(Integer imageLinkRsId) {
        this.imageLinkRsId = imageLinkRsId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType == null ? null : refType.trim();
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Integer getImageLinkId() {
        return imageLinkId;
    }

    public void setImageLinkId(Integer imageLinkId) {
        this.imageLinkId = imageLinkId;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imageLinkRsId=").append(imageLinkRsId);
        sb.append(", refType=").append(refType);
        sb.append(", refId=").append(refId);
        sb.append(", imageLinkId=").append(imageLinkId);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", deleteInd=").append(deleteInd);
        sb.append(", version=").append(version);
        sb.append(", sequence=").append(sequence);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}