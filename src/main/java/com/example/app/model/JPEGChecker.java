package com.example.app.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

@ConfigurationProperties("formatChecker")
public class JPEGChecker implements FormatChecker {

  @Override
  public boolean isFile(MultipartFile multipartFile) {

    try {
      DataInputStream ins = new DataInputStream(
          new BufferedInputStream(multipartFile.getInputStream()));
      int readFour = ins.readInt();

      // between FF D8 FF E0 and FF D8 FF E8

      final int LIM1 = 0xffd8ffe0 - 3;
      final int LIM2 = 0xffd8ffe8 + 3;

      return LIM1 < readFour && readFour < LIM2;


    } catch (IOException e) {
      return false;
    }


  }
}
