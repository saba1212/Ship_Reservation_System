package com.cruds.srs.exception;

public class SRSException extends RuntimeException{
	
	private String info;

	
	

	public SRSException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SRSException(String info) {
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
