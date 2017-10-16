package com.example.app.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class implementing FormatChecker. Checks if format is instance of JPEG by checking signature of
 * first 4 bytes of file.
 */
@ConfigurationProperties("formatChecker")
public class JPEGChecker implements FormatChecker {

  /**
   * Method that verifies if files is JPEG by checking file signature.
   *
   * @return boolean
   */
  @Override
  public boolean isFile(MultipartFile multipartFile) {

    try {
      DataInputStream ins = new DataInputStream(
          new BufferedInputStream(multipartFile.getInputStream()));
      int readFour = ins.readInt();

      // checks first 4 bytes.
      // result should be between FF D8 FF E0 -3 and FF D8 FF E8 -3.

      final int LIM1 = 0xffd8ffe0 - 3;
      final int LIM2 = 0xffd8ffe8 + 3;

      return LIM1 < readFour && readFour < LIM2;


    } catch (IOException e) {
      return false;
    }


  }
}
