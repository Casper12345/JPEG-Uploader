package com.example.app.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Property class for upload folder path. File will be created at root folder level.
 */
@ConfigurationProperties("uploadFolderProperties")
public class UploadFolderProperties {

  /**
   * Name of upload folder. Needs to be set here, not by setter. Class could be made into
   * singleton.
   */
  private final String UPLOADFOLDER = "uploadFolder";

  public String getUploadFolder() {
    return UPLOADFOLDER;
  }

}
