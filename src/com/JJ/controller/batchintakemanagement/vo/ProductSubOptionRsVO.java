package com.JJ.controller.batchintakemanagement.vo;

import java.io.Serializable;

import com.JJ.controller.productmanagement.vo.ProductOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.model.Base;

public class ProductSubOptionRsVO extends Base implements Serializable {
    private Integer productSuboptionRsId;

    private Integer productId;

    private Integer suboption1Id;

    private Integer suboption2Id;

    private Integer suboption3Id;
    
    private ProductVO product;
    
    private ProductOptionVO subOption1;
    
    private ProductOptionVO subOption2;
    
    private ProductOptionVO subOption3;

    private static final long serialVersionUID = 1L;

    public Integer getProductSuboptionRsId() {
        return productSuboptionRsId;
    }

    public void setProductSuboptionRsId(Integer productSuboptionRsId) {
        this.productSuboptionRsId = productSuboptionRsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSuboption1Id() {
        return suboption1Id;
    }

    public void setSuboption1Id(Integer suboption1Id) {
        this.suboption1Id = suboption1Id;
    }

    public Integer getSuboption2Id() {
        return suboption2Id;
    }

    public void setSuboption2Id(Integer suboption2Id) {
        this.suboption2Id = suboption2Id;
    }

    public Integer getSuboption3Id() {
        return suboption3Id;
    }

    public void setSuboption3Id(Integer suboption3Id) {
        this.suboption3Id = suboption3Id;
    }

    public ProductVO getProduct() {
		return product;
	}

	public ProductOptionVO getSubOption1() {
		return subOption1;
	}

	public ProductOptionVO getSubOption2() {
		return subOption2;
	}

	public ProductOptionVO getSubOption3() {
		return subOption3;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public void setSubOption1(ProductOptionVO subOption1) {
		this.subOption1 = subOption1;
	}

	public void setSubOption2(ProductOptionVO subOption2) {
		this.subOption2 = subOption2;
	}

	public void setSubOption3(ProductOptionVO subOption3) {
		this.subOption3 = subOption3;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productSuboptionRsId=").append(productSuboptionRsId);
        sb.append(", productId=").append(productId);
        sb.append(", suboption1Id=").append(suboption1Id);
        sb.append(", suboption2Id=").append(suboption2Id);
        sb.append(", suboption3Id=").append(suboption3Id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}