package com.javatechie.aws.lambda.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse notFoundException(NotFoundException ex) {
    log.error("Error de NotFoundException : {}", ex.getMessage());
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage(),
        new ArrayList<>());
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse badRequestException(BadRequestException ex) {
    log.error("Error de MethodArgumentNotValidException : {}", ex.getMessage());
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), ex.getMessage(),
        new ArrayList<>());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    log.error("Error de MethodArgumentNotValidException : {}", ex.getMessage());
    List<ErrorDetail> details = new ArrayList<ErrorDetail>();
    ex.getBindingResult().getFieldErrors().forEach(item -> {
      details.add(new ErrorDetail(item.getField(), item.getDefaultMessage()));
    });
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
        "Validacion de campos", details);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMethodArgumentNotValid(HttpMessageNotReadableException ex) {
    log.error("Error de HttpMessageNotReadableException : {}", ex.getMessage());
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), ex.getMessage(),
        null);
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleBindingException(BindException ex) {
    log.error("Error de BindException : {}", ex.getMessage());
    List<ErrorDetail> details = new ArrayList<ErrorDetail>();
    ex.getBindingResult().getFieldErrors().forEach(item -> {
      details.add(new ErrorDetail(item.getField(), item.getDefaultMessage()));
    });
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
        "Validacion de campos", details);
  }
  
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleConstraintViolationException(ConstraintViolationException ex) {
    log.error("Error de ConstraintViolationException : {}", ex.getMessage());
    
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
        ex.getMessage(), null);
  }
}
