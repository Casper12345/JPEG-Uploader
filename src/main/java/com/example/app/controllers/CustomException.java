package com.example.app.controllers;

/**
 * Customs exception that is thrown with IOExceptions.
 */
public class CustomException extends RuntimeException {

  /**
   * Constructor containing custom message and original exception.
   *
   * @param message custom message.
   * @param original original exception.
   */
  public CustomException(String message, Throwable original) {
    super(message, original);
  }

}
