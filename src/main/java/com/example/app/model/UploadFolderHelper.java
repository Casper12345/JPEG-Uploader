package com.example.app.model;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Class for creating checking and creating upload folder.
 */
@ConfigurationProperties("uploadFolderHelper")
public class UploadFolderHelper {

  private String pathFolder;

  @Autowired
  public UploadFolderHelper(UploadFolderProperties properties) {
    this.pathFolder = properties.getUploadFolder();
  }

  /**
   * Method for creating upload folder if it does not exist.
   */
  public void checkAndCreateUploadFolder() {
    if (!checkIfUploadFolderExists()) {
      try {
        createUploadFolder();
      } catch (IOException e) {
        if (!(e instanceof FileAlreadyExistsException)) {
          e.printStackTrace();
        }
      }
    }

  }

  /**
   * Method for creating upload folder.
   */
  private Path createUploadFolder() throws IOException {
    return Files.createDirectory(Paths.get(pathFolder));
  }

  /**
   * Method for checking if upload folder exists.
   */
  private boolean checkIfUploadFolderExists() {
    return Files.exists(Paths.get(pathFolder));
  }

}
