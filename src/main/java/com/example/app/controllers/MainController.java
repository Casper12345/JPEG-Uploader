package com.example.app.controllers;

import com.example.app.model.UploadHandlerImpl;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

  @GetMapping("/")
  public String index(Map<String, Object> model) {
    model.put("uploaded", uploadHandler.fileCounter("TrialFolder"));
    return "index";
  }

  private UploadHandlerImpl uploadHandler = new UploadHandlerImpl();

  @PostMapping("/")
  public String uploadPost(@RequestParam("file") MultipartFile[] file,
      Map<String, Object> model) {

    if(file.length > 0){
      uploadHandler.fileSaver(file);
    }

    return "redirect:/";
  }

  @GetMapping("/helper")
  public String helper(Map<String, Object> model) {

    return "index3";
  }


}
