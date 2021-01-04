package com.example.exceptionhandling.handlingexception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	
	private String message;
	private List<String> details;
	private HttpStatus status;
	private LocalDateTime timestamp;
	
	
	//private String requestedURI;

	
	public ExceptionResponse(String message, List<String> details, HttpStatus status, LocalDateTime timestamp) {
		this.message=message;
		this.details= details;
		this.status=status;
		this.timestamp= timestamp;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

//	public String getRequestedURI() {
//		return requestedURI;
//	}
//
//	public void callerURL(final String requestedURI) {
//		this.requestedURI = requestedURI;
//	}


}
