package com.example.demo.exception;

public class ApiRequestException extends RuntimeException {
  public ApiRequestException(String message){
    super(message);
  }
  ApiRequestException(String message, Throwable cause){
    super(message, cause);
  }
}
