package com.example.app.model;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface for Upload Handler.
 */
public interface UploadHandler {

  /**
   * Method for saving file multipart files to disk.
   */
  int fileSaver(MultipartFile[] files) throws IOException;

}
