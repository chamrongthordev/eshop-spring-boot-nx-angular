package com.chamrong.catalogservice.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private String fieldValue;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
    // example: Post not found with id: '1'
    super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;

    log.error(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
  }
}
