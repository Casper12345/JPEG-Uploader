package com.example.app.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Utility class for creating and destroying cookie.
 */
@ConfigurationProperties("uploadUtil")
public class ControllerUtil {

  /**
   * Method for creating cookie that messages to /completed.
   *
   * @param message message to pass as escaped string.
   * @param response servlet response.
   */
  public void cookieMessageCreater(String message, HttpServletResponse response) {
    Cookie cookie = new Cookie("message", message);
    cookie.setHttpOnly(false);
    cookie.setPath("/completed");
    // time to live 20 seconds
    cookie.setMaxAge(20);
    response.addCookie(cookie);
  }

  /**
   * Method for destroying cookie at /completed.
   *
   * @param response servlet response.
   */
  public void deleteCookie(HttpServletResponse response) {
    Cookie cookie = new Cookie("message", null);
    cookie.setPath("/completed");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  }

}
