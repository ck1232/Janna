package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class ProductSubCategoryVO extends Base implements Serializable {
    private Integer subCategoryId;

    private String name;

    private Integer categoryId;

    private String displayInd;
    
    private String displayIndString;

    private static final long serialVersionUID = 1L;

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDisplayInd() {
        return displayInd;
    }

    public void setDisplayInd(String displayInd) {
        this.displayInd = displayInd == null ? null : displayInd.trim();
    }

    public String getDisplayIndString() {
		return displayIndString;
	}

	public void setDisplayIndString(String displayIndString) {
		this.displayIndString = displayIndString;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subCategoryId=").append(subCategoryId);
        sb.append(", name=").append(name);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", displayInd=").append(displayInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}