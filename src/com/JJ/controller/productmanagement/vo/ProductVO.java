package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.model.Base;

public class ProductVO extends Base implements Serializable {
    private Integer productId;

    private String productName;

    private BigDecimal unitAmt;

    private Integer weight;

    private Integer subCategoryId;

    private String description;

    private String productCode;

    private String paypayId;

    private List<ProductOptionVO> optionList;
    
    private LinkedList<FileMetaVO> images;
    
    private LinkedList<ImageLinkVO> imagesLink;
    
    private List<String> tags;
    
    private ProductSubCategoryVO subCategory;
    
    private String productInfo;
    
    private static final long serialVersionUID = 1L;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getUnitAmt() {
        return unitAmt;
    }

    public void setUnitAmt(BigDecimal unitAmt) {
        this.unitAmt = unitAmt;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getPaypayId() {
        return paypayId;
    }

    public void setPaypayId(String paypayId) {
        this.paypayId = paypayId == null ? null : paypayId.trim();
    }

    public List<ProductOptionVO> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<ProductOptionVO> optionList) {
		this.optionList = optionList;
	}

	public LinkedList<FileMetaVO> getImages() {
		return images;
	}

	public void setImages(LinkedList<FileMetaVO> images) {
		this.images = images;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public ProductSubCategoryVO getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ProductSubCategoryVO subCategory) {
		this.subCategory = subCategory;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public LinkedList<ImageLinkVO> getImagesLink() {
		return imagesLink;
	}

	public void setImagesLink(LinkedList<ImageLinkVO> imagesLink) {
		this.imagesLink = imagesLink;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", unitAmt=").append(unitAmt);
        sb.append(", weight=").append(weight);
        sb.append(", subCategoryId=").append(subCategoryId);
        sb.append(", description=").append(description);
        sb.append(", productCode=").append(productCode);
        sb.append(", paypayId=").append(paypayId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}