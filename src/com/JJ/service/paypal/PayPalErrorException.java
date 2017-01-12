package com.JJ.service.paypal;

import java.util.List;

import urn.ebay.apis.eBLBaseComponents.ErrorType;

public class PayPalErrorException extends Exception {

	public PayPalErrorException(String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
	private List<ErrorType> payPalErrorList;
	
	public PayPalErrorException(List<ErrorType> payPalErrorList) {
		this.payPalErrorList = payPalErrorList;
	}
	public PayPalErrorException() {
	}
	public List<ErrorType> getPayPalErrorList() {
		return payPalErrorList;
	}
	public void setPayPalErrorList(List<ErrorType> payPalErrorList) {
		this.payPalErrorList = payPalErrorList;
	}
	public String getPayPalErrorMsg(){
		if(payPalErrorList != null && payPalErrorList.size() > 0){
			StringBuilder sb = new StringBuilder();
			for(ErrorType error : payPalErrorList){
				sb.append("PayPal Error:");
				sb.append(error.getLongMessage());
				sb.append(",");
			}
			return sb.toString();
		}
		return null;
	}
}
