package com.example.app.controllers;

import com.example.app.model.UploadHandler;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

  private UploadHandler uploadHandler;

  @Autowired
  public void setUploadHandler(UploadHandler uploadHandler) {
    this.uploadHandler = uploadHandler;
  }

  @GetMapping("/")
  public String index(Map<String, Object> model) {
    model.put("template", "empty");
    return "index";
  }

  @GetMapping("/completed")
  public String completed(@CookieValue("numberOfFiles") String cookie, Map<String, Object> model) {

    model.put("template", "response");

    if (cookie == null) {
      model.put("uploaded", "0");
    } else {
      model.put("uploaded", cookie);
    }

    return "index";
  }

  @PostMapping("/")
  public String uploadPost(@RequestParam("file") MultipartFile[] file,
      HttpServletResponse response) {

    int uploaded = 0;

    if (file.length > 0) {
      uploaded = uploadHandler.fileSaver(file);
    }

    Cookie cookie = new Cookie("numberOfFiles", String.valueOf(uploaded));
    cookie.setPath("/completed");
    response.addCookie(cookie);

    return "redirect:completed";
  }

  @GetMapping("/helper")
  public String helper(Map<String, Object> model) {
    return "index3";
  }


}
