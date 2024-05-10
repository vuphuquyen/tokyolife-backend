package com.giotuhoclaptrinh.exception;

public enum ErrorCode {
	 USER_EXISTED(1002, "User existed"),
	 USERNAME_INVALID(1003, "Username must be at least {min} characters"),
	 UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
	 USER_NOT_EXISTED(1005, "User not existed"),
	 INVALID_PASSWORD(1004, "Password must be at least {min} characters"),
	UNAUTHENTICATED(1006, "Unauthenticated");
	
	private final int code;
    private final String message;
    

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
