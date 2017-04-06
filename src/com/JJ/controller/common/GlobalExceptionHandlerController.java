package com.JJ.controller.common;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandlerController {
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandlerController.class);
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(Exception e) {
        logger.debug("A null pointer exception ocurred " + e);
        return "pageNotFound";
    }
	
	@ExceptionHandler(javax.el.PropertyNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleErrorException(Exception e) {
        logger.debug("A null pointer exception ocurred " + e);
        return "pageError";
    }
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public String handleMethodNotAllowedException(Exception e) {
        logger.debug("A null pointer exception ocurred " + e);
        return "pageError";
    }
}
