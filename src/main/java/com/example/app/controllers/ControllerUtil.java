package com.example.app.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("uploadUtil")
public class ControllerUtil {

  public void cookieMessageCreater(String message, HttpServletResponse response) {
    Cookie cookie = new Cookie("message", message);
    cookie.setPath("/completed");
    // 10 minutes time to live
    cookie.setMaxAge(60 * 10);
    response.addCookie(cookie);
  }

  public void deleteCookie(HttpServletResponse response) {
    Cookie cookie = new Cookie("message", null); // Not necessary, but saves bandwidth.
    cookie.setPath("/completed");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
    response.addCookie(cookie);
  }

}
