package com.example.app.controllers;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

/**
 * Global class for exception catching/handling.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private ControllerUtil controllerUtil;

  @Autowired
  public void setControllerUtil(ControllerUtil controllerUtil) {
    this.controllerUtil = controllerUtil;
  }

  /**
   * Catches CustomExceptions.
   *
   * @param e exception.
   * @param response servlet response.
   * @return redirects to completed. NB! AJAX redirect is performed by script.
   */
  @ExceptionHandler(CustomException.class)
  public String customExceptionHandler(CustomException e, HttpServletResponse response) {

    controllerUtil.cookieMessageCreater("An Error Occurred - No files were uploaded"
        .replaceAll(" ", "%20"), response);

    return "redirect:completed";

  }

  /**
   * Catches All Exceptions. Does not catch Errors.
   * Thymeleaf refers automatically to error.html in templates.
   *
   * @param e exception.
   * @param response servlet response.
   * @return redirects to completed. NB! AJAX redirect is performed by script.
   */
  @ExceptionHandler(Exception.class)
  public String exceptionHandler(Exception e, HttpServletResponse response) {

    controllerUtil
        .cookieMessageCreater("An Error Occurred - No files were uploaded".replaceAll(" ", "%20"),
            response);

    return "redirect:completed";

  }

  /**
   * Catches MultipartExceptions. Custom message for SizeLimitExceededException and
   * FileSizeLimitExceededException.
   */
  @ExceptionHandler(MultipartException.class)
  public String multipartHandler(MultipartException e, HttpServletResponse response) {

    if (ExceptionUtils.getRootCause(e) instanceof FileUploadBase.SizeLimitExceededException) {

      controllerUtil.cookieMessageCreater("Overall file size was exceeded"
          .replaceAll(" ", "%20"), response);
    } else if (ExceptionUtils
        .getRootCause(e) instanceof FileUploadBase.FileSizeLimitExceededException) {

      controllerUtil.cookieMessageCreater("File size was exceeded"
          .replaceAll(" ", "%20"), response);
    } else {
      controllerUtil
          .cookieMessageCreater("An Error Occurred - No files were uploaded".replaceAll(" ", "%20"),
              response);
    }

    return "redirect:completed";
  }


}
