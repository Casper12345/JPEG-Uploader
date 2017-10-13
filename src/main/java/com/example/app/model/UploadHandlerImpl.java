package com.example.app.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadHandlerImpl {

  public static void main(String[] args) {
    UploadHandlerImpl u = new UploadHandlerImpl();
  }


  public boolean initFolder(String folder) {
    return new File("uploadFolder/" + folder).mkdir();
  }


  public boolean fileSaver(MultipartFile files[]) {

    String folder = files[0].getOriginalFilename()
        .substring(0, files[0].getOriginalFilename().lastIndexOf('/'));

    initFolder(folder);

    for (MultipartFile m : files) {

      String filename = StringUtils.cleanPath(m.getOriginalFilename()
          .substring(m.getOriginalFilename().lastIndexOf('/') + 1));

      System.out.println(filename);

      try {
        Files.copy(m.getInputStream(), Paths.get("uploadFolder/" + folder).resolve(filename),
            StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  public long fileCounter(String path) {
    int count = 0;
    try {
      return Files.list(Paths.get("uploadFolder/" + path)).count();
    } catch (IOException e) {
      return count;
    }
  }


}
