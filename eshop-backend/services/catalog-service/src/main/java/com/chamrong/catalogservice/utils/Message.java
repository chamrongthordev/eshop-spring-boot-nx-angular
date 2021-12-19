package com.chamrong.catalogservice.utils;

/** Created by Chamrong on 12 Dec, 2021 */
public class Message {
  private Message() {
    // nothing to here
  }

  public static String deleteSuccess(String sourceName, String fieldName, String value) {
    return String.format(
        "%s has %s: %s has been delete successfully.", sourceName, fieldName, value);
  }

  public static String logMethodInfoProccessing(String methodName, String className) {
    return String.format("Inside %s of %s", methodName, className);
  }
}
