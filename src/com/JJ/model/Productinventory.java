package com.JJ.model;

import java.math.BigDecimal;

import com.JJ.controller.productmanagement.vo.ProductSubOptionRsVo;

public class Productinventory extends Base{
    private Integer productinventoryid;

    private Integer productsuboptionid;

    private Integer transferfrom;

    private Integer transferto;

    private Boolean plusorminus;

    private Integer qty;

    private String remarks;

    private BigDecimal unitcost;

    private String mode;

    private Integer referenceid;

    private String deleteremarks;
    
    /*non db fields start*/
    
    private String product;
    
    private ProductSubOptionRsVo productSuboption;
    
    private Storagelocation fromLocation;
    
    private Storagelocation toLocation;
    
    private String location;
    
    public String getProduct() {
		return product;
	}
    
    public void setProduct() {
    	this.product = this.productSuboption.getProduct().getProductName();
    	if(this.productSuboption.getSuboption1id() != null) 
    		this.product = this.product + ", " + this.productSuboption.getSubOption1().getSubOptionList().get(0).getSubOptionName();	
    	else
    		return;
    	
    	
    	if(this.productSuboption.getSuboption2id() != null) 
    		this.product = this.product + ", " + this.productSuboption.getSubOption2().getSubOptionList().get(0).getSubOptionName();	
    	else
    		return;
    	
    	
    	if(this.productSuboption.getSuboption3id() != null) 
    		this.product = this.product + ", " + this.productSuboption.getSubOption3().getSubOptionList().get(0).getSubOptionName();	
    	else
    		return;
    	
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public ProductSubOptionRsVo getProductSuboption() {
		return productSuboption;
	}

	public void setProductSuboption(ProductSubOptionRsVo productSuboption) {
		this.productSuboption = productSuboption;
	}

	public Storagelocation getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(Storagelocation fromLocation) {
		this.fromLocation = fromLocation;
	}
	
	public Storagelocation getToLocation() {
		return toLocation;
	}

	public void setToLocation(Storagelocation toLocation) {
		this.toLocation = toLocation;
	}

	public String getLocation() {
    	return this.location;
	}

	public void setLocation() {
		if(transferfrom == null && transferto != null) 
			this.location = "Added to " + toLocation.getLocationname();
    	
		else if(transferfrom != null && transferto == null) 
    		this.location = "Deleted from " + fromLocation.getLocationname();
    	
		else if(transferfrom != null && transferto != null)
    		this.location = "From " + fromLocation.getLocationname() + " to " + toLocation.getLocationname();
		
		else
			this.location = "";
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	/*non db fields end*/


	public Integer getProductinventoryid() {
        return productinventoryid;
    }

    public void setProductinventoryid(Integer productinventoryid) {
        this.productinventoryid = productinventoryid;
    }

    public Integer getProductsuboptionid() {
        return productsuboptionid;
    }

    public void setProductsuboptionid(Integer productsuboptionid) {
        this.productsuboptionid = productsuboptionid;
    }

    public Productinventory(Integer productsuboptionid, Integer transferfrom, Integer transferto, Boolean plusorminus,
			Integer qty, String remarks) {
		super();
		this.productsuboptionid = productsuboptionid;
		this.transferfrom = transferfrom;
		this.transferto = transferto;
		this.plusorminus = plusorminus;
		this.qty = qty;
		this.remarks = remarks;
	}

	public Productinventory(Integer productsuboptionid, Integer transferfrom, Integer transferto, Boolean plusorminus,
			Integer qty, String remarks, String mode, Integer referenceid) {
		super();
		this.productsuboptionid = productsuboptionid;
		this.transferfrom = transferfrom;
		this.transferto = transferto;
		this.plusorminus = plusorminus;
		this.qty = qty;
		this.remarks = remarks;
		this.mode = mode;
		this.referenceid = referenceid;
	}

	public Productinventory() {
		super();
	}

	public Integer getTransferfrom() {
        return transferfrom;
    }

    public void setTransferfrom(Integer transferfrom) {
        this.transferfrom = transferfrom;
    }

    public Integer getTransferto() {
        return transferto;
    }

    public void setTransferto(Integer transferto) {
        this.transferto = transferto;
    }

    public Boolean getPlusorminus() {
        return plusorminus;
    }

    public void setPlusorminus(Boolean plusorminus) {
        this.plusorminus = plusorminus;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(Integer referenceid) {
        this.referenceid = referenceid;
    }

    public String getDeleteremarks() {
        return deleteremarks;
    }

    public void setDeleteremarks(String deleteremarks) {
        this.deleteremarks = deleteremarks;
    }
    
    
}