package com.example.app.model;

import org.springframework.web.multipart.MultipartFile;

public interface FormatChecker {

  boolean isFile(MultipartFile multipartFile);

}
