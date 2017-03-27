package com.JJ.controller.batchintakemanagement.vo;

import java.io.Serializable;

import com.JJ.model.Base;

public class StorageLocationVO extends Base implements Serializable {
    private Integer locationId;

    private String name;

    private String address;

    private Integer postalCode;

    private static final long serialVersionUID = 1L;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", locationId=").append(locationId);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}