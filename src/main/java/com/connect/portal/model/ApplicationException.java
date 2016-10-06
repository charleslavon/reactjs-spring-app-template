package com.connect.portal.model;

public class ApplicationException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private int httpExceptionCode;
	
	
	public ApplicationException(int httpExceptionCode, String msg) {
		this.msg = msg;
		this.httpExceptionCode = httpExceptionCode;
	}
	
	public ApplicationException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public int getHttpExceptionCode() {
		return httpExceptionCode;
	}

}
