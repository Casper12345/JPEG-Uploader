package com.example.app.controllers;

import com.example.app.model.UploadHandler;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    model.put("uploaded", 0);
    return "index";
  }

  @PostMapping("/")
  public String uploadPost(@RequestParam("file") MultipartFile[] file,
      Map<String, Object> model) {

    int uploaded = 0;

    if (file.length > 0) {
       uploaded = uploadHandler.fileSaver(file);
    }

    return "redirect:/";
  }

  @GetMapping("/helper")
  public String helper(Map<String, Object> model) {

    return "index3";
  }


}
