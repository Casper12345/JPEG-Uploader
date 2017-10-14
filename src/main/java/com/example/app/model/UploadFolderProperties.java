package com.example.app.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("uploadFolderProperties")
public class UploadFolderProperties {

  private String uploadFolder = "uploadFolder";

  public String getUploadFolder() {
    return uploadFolder;
  }

  public void setUploadFolder(String uploadFolder) {
    this.uploadFolder = uploadFolder;
  }

}
