package com.giotuhoclaptrinh.exception;

import java.io.Serializable;

public class AppException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	 public AppException(ErrorCode errorCode) {
	        super(errorCode.getMessage());
	        this.errorCode = errorCode;
	    }

	    private ErrorCode errorCode;

	    public ErrorCode getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(ErrorCode errorCode) {
	        this.errorCode = errorCode;
	    }
	

}
