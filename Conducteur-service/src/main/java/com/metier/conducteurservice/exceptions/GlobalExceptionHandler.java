package com.metier.conducteurservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler
{
    /*
    *Handle specific exceptions
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
    {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), 404, "Not Found", exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
    }

    /*
     *Handle specific api exceptions
     */
    @ExceptionHandler(ApiException.class)
    ResponseEntity<?> handleApiException(ApiException exception, WebRequest request)
    {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), request.hashCode(), request.getDescription(false), exception.getMessage(), request.getContextPath());
        return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
    }

    /*
     *Handle global exceptions
     */
    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request)
    {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), request.hashCode(), request.getDescription(false), exception.getMessage(), request.getContextPath());
        return new ResponseEntity(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
