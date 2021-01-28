package com.cruds.srs.exception;

public class SMSException extends RuntimeException{
	
	private String info;

	
	

	public SMSException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SMSException(String info) {
		super();
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
