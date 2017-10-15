package com.example.app.controllers;

public class CustomException extends RuntimeException {

  public CustomException(String message, Throwable cause) {
    super(message, cause);
  }


}
