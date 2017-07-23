package com.JJ.controller.promotionmanagement.vo;

import java.io.Serializable;
import java.util.Date;

import com.JJ.model.Base;

public class PromotionVO extends Base implements Serializable {
    private Integer promotionId;

    private String promotionName;

    private Date promotionStartDate;

    private Date promotionEndDate;

    private String isActive;
    
    private Boolean isActiveBoolean;

    private String promotionMessage;
    
    private String promotionperiod;
	
	public String getPromotionperiod() {
		return promotionperiod;
	}

	public void setPromotionperiod(String promotionperiod) {
		this.promotionperiod = promotionperiod;
	}

    private static final long serialVersionUID = 1L;

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName == null ? null : promotionName.trim();
    }

    public Date getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

	public Boolean getIsActiveBoolean() {
		return isActiveBoolean;
	}

	public void setIsActiveBoolean(Boolean isActiveBoolean) {
		this.isActiveBoolean = isActiveBoolean;
	}

	public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage == null ? null : promotionMessage.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", promotionId=").append(promotionId);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", promotionStartDate=").append(promotionStartDate);
        sb.append(", promotionEndDate=").append(promotionEndDate);
        sb.append(", isActive=").append(isActive);
        sb.append(", promotionMessage=").append(promotionMessage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}