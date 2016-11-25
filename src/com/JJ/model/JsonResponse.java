package com.JJ.model;

public class JsonResponse {
	private String status;
	private String jsonString;
	
	public JsonResponse(String status) {
		super();
		this.status = status;
	}
	
	public JsonResponse() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
}
