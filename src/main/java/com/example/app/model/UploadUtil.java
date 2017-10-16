package com.example.app.model;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Utility class for UploadHandler.
 */
@ConfigurationProperties("uploadUtil")
public class UploadUtil {

  private String pathFolder;

  @Autowired
  public UploadUtil(UploadFolderProperties properties) {
    this.pathFolder = properties.getUploadFolder();
  }

  /**
   * Method for generating folder name as string. Consists of original folder name plus timestamp.
   * If folder exists it generates random string of characters and concats it to the original file
   * name.
   */
  public String createFolderName(String uploadFolder) {

    String timeStamp = new GetTime().getTimeStamp();
    String newFolderName = uploadFolder + "-" + timeStamp;

    if (checkIfFolderExists(newFolderName)) {
      return uploadFolder + generateRandomString() + "-" + timeStamp;
    } else {
      return uploadFolder + "-" + timeStamp;
    }
  }

  /**
   * Method for checking if folder exists.
   *
   * @param folder string folder name.
   * @return boolean
   */
  private boolean checkIfFolderExists(String folder) {
    return Files.exists(Paths.get(pathFolder + "/" + folder));
  }

  /**
   * Method for generating random string of 8 characters. Non-numerical. Uses random string util
   * from org.apache.commons.lang.
   */
  private String generateRandomString() {
    return RandomStringUtils.random(8, true, false);
  }

}
