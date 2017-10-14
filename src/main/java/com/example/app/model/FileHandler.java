package com.example.app.model;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

@ConfigurationProperties("fileHandler")
public class FileHandler {

  private FormatChecker formatChecker;

  @Autowired
  public FileHandler(JPEGChecker formatChecker) {
    this.formatChecker = formatChecker;
  }


  public MultipartFile[] checkedFiles(MultipartFile[] multipartFiles) {
    return Arrays.stream(multipartFiles)
        .filter(b -> !b.isEmpty())
        .filter(this::fileChecker)
        .toArray(MultipartFile[]::new);
  }

  private boolean fileChecker(MultipartFile multipartFile) {
    return formatChecker.isFile(multipartFile);
  }

}
