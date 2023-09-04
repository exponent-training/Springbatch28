package com.example.demo.entity;

public class ExceptionResponse {

	private String errormsg;
	
	private String uri;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errormsg=" + errormsg + ", uri=" + uri + "]";
	}
	
	
}
