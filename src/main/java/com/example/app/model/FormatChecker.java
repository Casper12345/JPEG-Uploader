package com.example.app.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class FormatChecker {


  public boolean isJPEG(File filename) throws Exception {
    try (DataInputStream ins = new DataInputStream(
        new BufferedInputStream(new FileInputStream(filename)))) {
      return ins.readInt() == 0xffd8ffe0;
    }
  }

  private File convert(MultipartFile file) throws IOException {

    File convertedFile = new File(file.getOriginalFilename());
    boolean cf = convertedFile.createNewFile();
    FileOutputStream fos = new FileOutputStream(convertedFile);
    fos.write(file.getBytes());
    fos.close();
    return convertedFile;

  }


}
