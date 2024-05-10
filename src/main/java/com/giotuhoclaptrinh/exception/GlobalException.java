package com.giotuhoclaptrinh.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.giotuhoclaptrinh.dto.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalException {
	
	 @ExceptionHandler(value = Exception.class)
	    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
	        log.error("Exception: ", exception);
	        ApiResponse apiResponse = new ApiResponse();
            
	        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
	        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

	        return ResponseEntity.badRequest().body(apiResponse);
	    }
	
	@ExceptionHandler(value = AppException.class)// khai báo từng exception
	ResponseEntity<ApiResponse> handleAppException(AppException appException){
		ErrorCode errorCode = appException.getErrorCode();

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());
		return ResponseEntity.badRequest().body(apiResponse);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
		FieldError fieldError = exception.getBindingResult().getFieldError();
		
		String enumKey =fieldError.getDefaultMessage();

        ErrorCode errorCode = ErrorCode.valueOf(enumKey);
        ApiResponse apiResponse = new ApiResponse();
		
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

	
}
