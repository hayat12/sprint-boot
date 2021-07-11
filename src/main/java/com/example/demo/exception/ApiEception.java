package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiEception {
  private final String messsage;
  private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;
  public  ApiEception(String messsage, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp){
    this.messsage = messsage;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.timestamp = timestamp;
  }

  public String getMesssage() {
    return messsage;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }
}
