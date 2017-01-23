package com.JJ.controller.webhook.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.paypal.api.payments.Links;

public class Webhook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date create_time;
	private String resource_type;
	private String event_type;
	private String summary;
	private List<Links> links;
	private Resource resource;
	private String event_version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	/**
	 * @return the event_type
	 */
	public String getEvent_type() {
		return event_type;
	}
	/**
	 * @param event_type the event_type to set
	 */
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	/**
	 * @return the links
	 */
	public List<Links> getLinks() {
		return links;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	/**
	 * @return the event_version
	 */
	public String getEvent_version() {
		return event_version;
	}
	/**
	 * @param event_version the event_version to set
	 */
	public void setEvent_version(String event_version) {
		this.event_version = event_version;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
}
