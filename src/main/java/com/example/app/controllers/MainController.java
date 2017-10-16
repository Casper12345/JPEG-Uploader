package com.example.app.controllers;

import com.example.app.model.UploadHandler;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Main controller class.
 */
@Controller
public class MainController {

  private UploadHandler uploadHandler;
  private ControllerUtil controllerUtil;

  @Autowired
  public void setUploadHandler(UploadHandler uploadHandler) {
    this.uploadHandler = uploadHandler;
  }

  @Autowired
  public void setControllerUtil(ControllerUtil controllerUtil) {
    this.controllerUtil = controllerUtil;
  }

  /**
   * Get mapping for /. Renders index.html with empty.html injected.
   *
   * @param model mapping thymeleaf variable 'template' dynamically deciding what html to inject.
   */
  @GetMapping("/")
  public String index(Map<String, Object> model, HttpServletResponse response) {
    controllerUtil.deleteCookie(response);
    model.put("template", "empty");
    return "index";
  }

  /**
   * Get mapping for /completed Renders index.html with response.html injected.
   *
   * Sets 'message' variable in response.html to cookie message.
   *
   * @param model mapping thymeleaf variable 'template' dynamically deciding what html to inject.
   */
  @GetMapping("/completed")
  public String completed(@CookieValue(value = "message", required = false) String cookie,
      Map<String, Object> model) {

    model.put("template", "response");

    if (cookie == null) {
      model.put("message", "");
    } else {
      model.put("message", cookie);
    }

    return "index";
  }

  /**
   * Post mapping for /. NB! AJAX redirect to /completed is performed by main.js.
   *
   * @param file multipart files from post request send from main.js.
   */
  @PostMapping("/")
  public String uploadPost(@RequestParam("file") MultipartFile[] file,
      HttpServletResponse response) {

    int uploaded = 0;

    if (file.length > 0) {
      try {
        uploaded = uploadHandler.fileSaver(file);
      } catch (IOException e) {
        throw new CustomException("Folder could not be initiated", e);
      }
    }

    controllerUtil.cookieMessageCreater(String.valueOf(uploaded) + " JPEG files found and uploaded"
        .replaceAll(" ", "%20"), response);

    return "redirect:completed";
  }


}
