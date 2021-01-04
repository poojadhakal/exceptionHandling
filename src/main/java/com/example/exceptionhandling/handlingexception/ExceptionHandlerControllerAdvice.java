package com.example.exceptionhandling.handlingexception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
	
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request method not supported");
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media not supported");
		details.add(ex.getMessage());
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
		}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("path Variable is missing");
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
		}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request param is missing");
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
	}
	

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Mismatch of type");
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request body is not readable");
		ExceptionResponse response = new ExceptionResponse(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(response);
		}

	@ExceptionHandler(ResourceNotFoundException.class)
	//@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleResourceNotFound( ResourceNotFoundException ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Resource Not Found");
		ExceptionResponse response = new ExceptionResponse(message,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

			}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFound(IdNotFoundException ex) {
		System.out.println("IdNotFounexception is not running");
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Resource Not Found");
		ExceptionResponse response = new ExceptionResponse(message,details,HttpStatus.NOT_FOUND,LocalDateTime.now());
		response.setStatus(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

			}
}
//
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	public @ResponseBody ExceptionResponse handleException(final Exception exception,
//			final HttpServletRequest request) {
//
//		ExceptionResponse error = new ExceptionResponse();
//		error.setErrorMessage(exception.getMessage());
//		error.callerURL(request.getRequestURI());
//
//		return error;
//	}



