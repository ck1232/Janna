package com.JJ.controller.productmanagement.vo;

public class ProductSubOptionRsVo {
	private Integer productsuboptionid;

    private Integer productid;

    private Integer suboption1id;

    private Integer suboption2id;

    private Integer suboption3id;
    
    private ProductVo product;
   
    private OptionVo subOption1;
    
    private OptionVo subOption2;
    
    private OptionVo subOption3;
    

	public Integer getProductsuboptionid() {
		return productsuboptionid;
	}

	public void setProductsuboptionid(Integer productsuboptionid) {
		this.productsuboptionid = productsuboptionid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getSuboption1id() {
		return suboption1id;
	}

	public void setSuboption1id(Integer suboption1id) {
		this.suboption1id = suboption1id;
	}

	public Integer getSuboption2id() {
		return suboption2id;
	}

	public void setSuboption2id(Integer suboption2id) {
		this.suboption2id = suboption2id;
	}

	public Integer getSuboption3id() {
		return suboption3id;
	}

	public void setSuboption3id(Integer suboption3id) {
		this.suboption3id = suboption3id;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

	public OptionVo getSubOption1() {
		return subOption1;
	}

	public void setSubOption1(OptionVo subOption1) {
		this.subOption1 = subOption1;
	}

	public OptionVo getSubOption2() {
		return subOption2;
	}

	public void setSubOption2(OptionVo subOption2) {
		this.subOption2 = subOption2;
	}

	public OptionVo getSubOption3() {
		return subOption3;
	}

	public void setSubOption3(OptionVo subOption3) {
		this.subOption3 = subOption3;
	}
}
