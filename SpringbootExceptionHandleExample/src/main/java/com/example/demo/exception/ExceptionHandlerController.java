package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler
	@ResponseBody
	public ExceptionResponse handleException(UserNotFoundException exception,HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrormsg(exception.getMessage());
		exceptionResponse.setUri(request.getRequestURI());
		return exceptionResponse;	
	}
	

}
