package com.example.app.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class for handling upload of Multipart files to disk.
 */
@Service
public class UploadHandlerImpl implements UploadHandler {

  private String uploadFolder;
  private FileHandler fileHandler;
  private UploadUtil uploadUtil;

  /**
   * Constructor takes properties, fileHandler and uploadUtil via DI.
   *
   * @param properties UploadFolderProperties
   * @param fileHandler FileHandler
   * @param uploadUtil UploadUtil
   */
  @Autowired
  public UploadHandlerImpl(UploadFolderProperties properties,
      FileHandler fileHandler, UploadUtil uploadUtil) {
    this.fileHandler = fileHandler;
    this.uploadFolder = properties.getUploadFolder();
    this.uploadUtil = uploadUtil;
  }

  /**
   * Method for creating subfolder of files from one upload.
   *
   * @param folder String name of folder.
   * @return Path to folder
   * @throws IOException if folder cannot be created.
   */
  private Path initFolder(String folder) throws IOException {
    return Files.createDirectory(Paths.get(uploadFolder + "/" + folder));
  }

  /**
   * Method for saving files to disk. Counts uploaded files.
   *
   * @param files filtered multipart files.
   * @return int of uploaded files counted.
   * @throws IOException rethrows IOException if folder cannot be initiated
   */
  public int fileSaver(MultipartFile[] files) throws IOException {

    MultipartFile[] checkedFiles = fileHandler.checkedFiles(files);

    int counter = 0;

    if (checkedFiles.length > 0) {
      String folder = checkedFiles[0].getOriginalFilename()
          .substring(0, checkedFiles[0].getOriginalFilename()
              .lastIndexOf('/'));

      String newFolderName = uploadUtil.createFolderName(folder);

      // rethrows IOException for initFolder
      initFolder(newFolderName);

      for (MultipartFile m : checkedFiles) {

        String filename = StringUtils.cleanPath(m.getOriginalFilename()
            .substring(m.getOriginalFilename().lastIndexOf('/') + 1));

        try {
          Files.copy(m.getInputStream(), Paths.get(uploadFolder + "/" + newFolderName)
              .resolve(filename));
          counter++;
        } catch (IOException e) {
          return counter;
        }
      }

      return counter;

    } else {
      return counter;
    }

  }

}
