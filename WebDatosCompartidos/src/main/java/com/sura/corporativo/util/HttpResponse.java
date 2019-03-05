package com.sura.corporativo.util;

public class HttpResponse {
	private final String statusCode;
	private final String statusMessage;
	private final String responseDesc;
	

	public HttpResponse(String statusCode, String statusMessage, String responseDesc) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.responseDesc = responseDesc;
		
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public String getResponseDesc() {
		return responseDesc;
	}


}