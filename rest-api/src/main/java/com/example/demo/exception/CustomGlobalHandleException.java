package com.example.demo.exception;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.notfound.AbstractNotFoundException;

@ControllerAdvice
public class CustomGlobalHandleException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AbstractNotFoundException.class)
	public void handleNotFoundException(HttpServletResponse response) throws IOException
	{
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public void handleConstraintViolationException(HttpServletResponse response) throws IOException
	{
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler(Exception.class)
	public void handleRestException(HttpServletResponse response) throws IOException
	{
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"server is error, please try other time");
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// log file at here, request get UserPrintical
		Map<String, Object> body = new LinkedHashMap<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		body.put("timestamp", dateFormat.format(new Date()));
		body.put("status", status.value());
		List<String> errors = ex.getBindingResult()
							.getFieldErrors().stream()
							.map(error -> error.getDefaultMessage())
							.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<Object>(body, headers, status);
	}
	
}
