package com.JJ.controller.productcategorymanagement.VO;

import java.io.Serializable;
import java.util.List;

import com.JJ.controller.productmanagement.vo.ProductSubCategoryVO;
import com.JJ.model.Base;

public class ProductCategoryVO extends Base implements Serializable {
    private Integer categoryId;

    private String categoryName;

    private String isParent;
    
    private String isParentString;
    
    private Boolean isParentBoolean;

    private String displayInd;
    
    private String displayIndString;
    
    private Boolean displayIndBoolean;

    private List<ProductSubCategoryVO> subcategoryList;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent == null ? null : isParent.trim();
    }

    public String getIsParentString() {
		return isParentString;
	}

	public void setIsParentString(String isParentString) {
		this.isParentString = isParentString;
	}

	public Boolean getIsParentBoolean() {
		return isParentBoolean;
	}

	public void setIsParentBoolean(Boolean isParentBoolean) {
		this.isParentBoolean = isParentBoolean;
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
	
    public Boolean getDisplayIndBoolean() {
		return displayIndBoolean;
	}

	public void setDisplayIndBoolean(Boolean displayIndBoolean) {
		this.displayIndBoolean = displayIndBoolean;
	}

	public List<ProductSubCategoryVO> getSubcategoryList() {
		return subcategoryList;
	}

	public void setSubcategoryList(List<ProductSubCategoryVO> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", isParent=").append(isParent);
        sb.append(", displayInd=").append(displayInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}