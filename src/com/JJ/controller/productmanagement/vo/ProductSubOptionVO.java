package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class ProductSubOptionVO extends Base implements Serializable {
    private Integer productSuboptionId;

    private Integer productId;

    private Integer productOptionId;

    private String name;

    private String displayInd;

    private String code;
    
    private String optionName;
    
    private int seq;

    private static final long serialVersionUID = 1L;

    public Integer getProductSuboptionId() {
        return productSuboptionId;
    }

    public void setProductSuboptionId(Integer productSuboptionId) {
        this.productSuboptionId = productSuboptionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(Integer productOptionId) {
        this.productOptionId = productOptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDisplayInd() {
        return displayInd;
    }

    public void setDisplayInd(String displayInd) {
        this.displayInd = displayInd == null ? null : displayInd.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOptionName() {
		return optionName;
	}

	public int getSeq() {
		return seq;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productSuboptionId=").append(productSuboptionId);
        sb.append(", productId=").append(productId);
        sb.append(", productOptionId=").append(productOptionId);
        sb.append(", name=").append(name);
        sb.append(", displayInd=").append(displayInd);
        sb.append(", code=").append(code);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}