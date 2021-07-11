package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(value = {ApiRequestException.class})
  public ResponseEntity<Object> hanObjectRespinseEntityException(ApiRequestException e){
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    //1. create payload
    final ApiEception apiEception = new ApiEception(
            e.getMessage(),
            e,
            badRequest,
            ZonedDateTime.now(ZoneId.of("Z"))
    );
    //2. return response entity

    return  new ResponseEntity<>(apiEception, badRequest);
  }
}
