package com.example.app.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadHandlerImpl implements UploadHandler {


  private String uploadFolder;
  private FileHandler fileHandler;

  @Autowired
  public UploadHandlerImpl(UploadFolderProperties properties, FileHandler fileHandler) {
    this.fileHandler = fileHandler;
    this.uploadFolder = properties.getUploadFolder();
  }


  private boolean initFolder(String folder) {
    return new File(uploadFolder + "/" + folder).mkdir();
  }


  public int fileSaver(MultipartFile files[]) {

    MultipartFile[] checkedFiles = fileHandler.checkedFiles(files);

    int counter = 0;

    if (checkedFiles.length > 0) {
      String folder = checkedFiles[0].getOriginalFilename()
          .substring(0, checkedFiles[0].getOriginalFilename()
              .lastIndexOf('/'));

      initFolder(folder);

      for (MultipartFile m : checkedFiles) {

        String filename = StringUtils.cleanPath(m.getOriginalFilename()
            .substring(m.getOriginalFilename().lastIndexOf('/') + 1));

        try {
          Files.copy(m.getInputStream(), Paths.get(uploadFolder + "/" + folder).resolve(filename),
              StandardCopyOption.REPLACE_EXISTING);
          counter++;
        } catch (IOException e) {
          return counter;
        }
      }

      return counter;

    } else {
      return 0;
    }

  }

  public long fileCounter(String path) {
    int count = 0;
    try {
      return Files.list(Paths.get(uploadFolder + "/" + path)).count();
    } catch (IOException e) {
      return count;
    }
  }


}
