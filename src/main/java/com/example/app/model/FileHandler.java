package com.example.app.model;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

/**
 * File handler class for checking validity of files.
 */
@ConfigurationProperties("fileHandler")
public class FileHandler {

  private FormatChecker formatChecker;

  @Autowired
  public FileHandler(FormatChecker formatChecker) {
    this.formatChecker = formatChecker;
  }

  /**
   * Method for filtering files if: they are empty or do not adhere to FormatChecker.isFile.
   */
  public MultipartFile[] checkedFiles(MultipartFile[] multipartFiles) {
    return Arrays.stream(multipartFiles)
        .filter(b -> !b.isEmpty())
        .filter(this::fileChecker)
        .toArray(MultipartFile[]::new);
  }

  /**
   * Method for checking isFile
   *
   * @return boolean
   */
  private boolean fileChecker(MultipartFile multipartFile) {
    return formatChecker.isFile(multipartFile);
  }

}
