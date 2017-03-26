package com.JJ.controller.customeraddressmanagement.VO;

import java.io.Serializable;

import com.JJ.model.Base;

public class CustomerAddressVO extends Base implements Serializable {
    private Integer addressId;

    private Integer customerId;

    private String recipientName;

    private String address;

    private Long contactNumber;

    private Integer postalCode;

    private String country;
    
    private String defaultInd;

    private static final long serialVersionUID = 1L;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName == null ? null : recipientName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
    
    public String getDefaultInd() {
        return defaultInd;
    }

    public void setDefaultInd(String defaultInd) {
        this.defaultInd = defaultInd == null ? null : defaultInd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", customerId=").append(customerId);
        sb.append(", recipientName=").append(recipientName);
        sb.append(", address=").append(address);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", country=").append(country);
        sb.append(", defaultInd=").append(defaultInd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}