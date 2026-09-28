package com.hrms.zencrew.exception;


import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

@Component
public class SecurityExceptionHandler {
	
	private final ObjectMapper objectMapper;
	
	public SecurityExceptionHandler(ObjectMapper objectMapper) {
		
		this.objectMapper = objectMapper;
	}
	
	public void sendUnauthorized(HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException exception) throws Exception{
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		Map<String, Object> body = new HashMap<>();
		
		body.put("Status", HttpStatus.UNAUTHORIZED.value());
		body.put("message", "Unthorized. Please Login");
		body.put("timestamp", LocalDateTime.now());
		
		response.getWriter().write(objectMapper.writeValueAsString(body));
		
	}
	
	public void sendForbidden(
			HttpServletRequest request, 
			HttpServletResponse response,
			AccessDeniedException exception) throws Exception{
		
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		Map<String, Object> body = new HashMap<>();
		
		body.put("Status", HttpStatus.FORBIDDEN.value());
		body.put("message", "Access Denied. you do not have the permission");
		body.put("timeStamp", LocalDateTime.now());
		
		response.getWriter().write(objectMapper.writeValueAsString(body));
	}
			
}
