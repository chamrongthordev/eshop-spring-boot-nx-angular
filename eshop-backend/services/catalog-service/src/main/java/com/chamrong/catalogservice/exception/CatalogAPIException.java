package com.chamrong.catalogservice.exception;

import org.springframework.http.HttpStatus;

public class CatalogAPIException extends RuntimeException {
  private HttpStatus status;
  private String message;

  public CatalogAPIException(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  public CatalogAPIException(HttpStatus status, String message, String message1) {
    super(message);
    this.status = status;
    this.message = message1;
  }

  public HttpStatus getStatus() {
    return status;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
