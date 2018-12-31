package com.example.demo.framework.exception;

public class CommonDefineException extends RuntimeException {
	private static final long serialVersionUID = 4652246794612761395L;

	private String exceptionCode;
	
	CommonDefineException(String code,String msg){
		super(msg);
		this.exceptionCode = code;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
}
