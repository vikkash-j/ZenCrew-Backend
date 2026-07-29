package com.hrms.zencrew.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hrms.zencrew.dto.response.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
		ApiErrorResponse error = new ApiErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now()); 
		return new ResponseEntity<ApiErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ApiErrorResponse> handleDuplicateResource(DuplicateResourceException ex){
		ApiErrorResponse error = new ApiErrorResponse(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				LocalDateTime.now()); 
		return new ResponseEntity<ApiErrorResponse>(error,HttpStatus.CONFLICT);

    }
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiErrorResponse> handleIllegalArgument(IllegalArgumentException ex){
		ApiErrorResponse error = new ApiErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				LocalDateTime.now()); 
		return new ResponseEntity<ApiErrorResponse>(error,HttpStatus.BAD_REQUEST);

    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponse> handleGeneralException(Exception ex){
		ApiErrorResponse error = new ApiErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				LocalDateTime.now()); 
		return new ResponseEntity<ApiErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }
	
	
	
}
