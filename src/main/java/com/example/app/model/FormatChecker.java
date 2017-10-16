package com.example.app.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interface for FormatChecker.
 */
public interface FormatChecker {

  /**
   * Method that verified file format.
   *
   * @return boolean.
   */
  boolean isFile(MultipartFile multipartFile);

}
