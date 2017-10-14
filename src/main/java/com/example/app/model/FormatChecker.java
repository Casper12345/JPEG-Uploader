package com.example.app.model;

import java.io.File;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

public interface FormatChecker {

  boolean isFile(MultipartFile multipartFile);

}
