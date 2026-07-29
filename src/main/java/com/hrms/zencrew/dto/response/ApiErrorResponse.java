package com.hrms.zencrew.dto.response;

import java.time.LocalDateTime;

public class ApiErrorResponse  {
	
	private int status;
	
	private String message;
	
	private LocalDateTime timeStamp;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ApiErrorResponse(int status, String message, LocalDateTime timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public ApiErrorResponse() {
		super();
	}
	
	

}
