package com.JJ.model;

public class Productoption extends Base {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productoptionid;

    private String name;

    private Boolean displayind;

    @Override
	public String toString() {
		return "Productoption [productoptionid=" + productoptionid + ", name=" + name + ", displayind=" + displayind
				+ ", getDeleteind()=" + getDeleteind() + ", getCreatedby()=" + getCreatedby() + ", getCreatedon()="
				+ getCreatedon() + ", getUpdatedby()=" + getUpdatedby() + ", getUpdatedon()=" + getUpdatedon()
				+ ", getVersion()=" + getVersion() + "]";
	}

	public Integer getProductoptionid() {
        return productoptionid;
    }

    public void setProductoptionid(Integer productoptionid) {
        this.productoptionid = productoptionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisplayind() {
        return displayind;
    }

    public void setDisplayind(Boolean displayind) {
        this.displayind = displayind;
    }
}