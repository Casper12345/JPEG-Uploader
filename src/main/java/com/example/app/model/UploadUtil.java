package com.example.app.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("uploadUtil")
public class UploadUtil {

  private String pathFolder;

  @Autowired
  public UploadUtil(UploadFolderProperties properties) {
    this.pathFolder = properties.getUploadFolder();
  }

  public String createFolderName(String uploadFolder) {

    String timeStamp = new GetTime().getTimeStamp();
    String newFolderName = uploadFolder + "-" + timeStamp;

    if (checkIfFolderExists(newFolderName)) {
      return uploadFolder + generateRandomString() + "-" + timeStamp;
    } else {
      return uploadFolder + "-" + timeStamp;
    }
  }

  private boolean checkIfFolderExists(String folder) {
    return Files.exists(Paths.get(pathFolder + "/" + folder));
  }

  private String generateRandomString() {
    return RandomStringUtils.random(8, true, false);
  }


  public long fileCounter(String path, String uploadFolder) {
    int count = 0;
    try {
      return Files.list(Paths.get(uploadFolder + "/" + path)).count();
    } catch (IOException e) {
      return count;
    }
  }

}
