package com.JJ.controller.webhook.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;

public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Amount amount;
	private String id;
	private String parent_payment;
	private Date update_time;
	private String state;
	private Date create_time;
	private List<Links> links;
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent_payment() {
		return parent_payment;
	}
	public void setParent_payment(String parent_payment) {
		this.parent_payment = parent_payment;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public List<Links> getLinks() {
		return links;
	}
	public void setLinks(List<Links> links) {
		this.links = links;
	}
}
