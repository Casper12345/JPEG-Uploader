package com.example.app.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;


@ControllerAdvice
public class GlobalExceptionHandler {

  private ControllerUtil controllerUtil;

  @Autowired
  public void setControllerUtil(ControllerUtil controllerUtil) {
    this.controllerUtil = controllerUtil;
  }

  @ExceptionHandler(CustomException.class)
  public String customExceptionHandler(CustomException e, HttpServletResponse response) {

    controllerUtil.cookieMessageCreater("An Error Occurred - No files were uploaded"
            .replaceAll(" ", "%20"), response);

    return "redirect:completed";

  }

  @ExceptionHandler(Exception.class)
  public String exceptionHandler(CustomException e, HttpServletResponse response) {

    controllerUtil.cookieMessageCreater("An Error Occurred - No files were uploaded".replaceAll(" ", "%20"),
        response);

    return "redirect:completed";

  }


  @ExceptionHandler(MultipartException.class)
  public String multipartHandler(MultipartException e, HttpServletResponse response) {

    if (ExceptionUtils.getRootCause(e) instanceof FileUploadBase.SizeLimitExceededException) {

      controllerUtil.cookieMessageCreater("Overall file size is exceeded"
          .replaceAll(" ", "%20"), response);
    }

    if (ExceptionUtils.getRootCause(e) instanceof FileUploadBase.FileSizeLimitExceededException) {

      controllerUtil.cookieMessageCreater("File size is exceeded".replaceAll(" ", "%20"), response);
    }

    return "redirect:completed";
  }



}
