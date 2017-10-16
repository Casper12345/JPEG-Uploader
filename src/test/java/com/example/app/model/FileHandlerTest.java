package com.example.app.model;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

public class FileHandlerTest {

  @Test
  public void checkedFilesTestIfFilterEmpty() throws Exception {

    byte jpegImage[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe0};
    byte cannonJpegBytes[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe2};
    byte SPIFFJpgBytes[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe8};

    byte empty[] = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};
    byte empty2[] = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};
    byte empty3[] = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};

    FormatChecker formatChecker = new JPEGChecker();
    FileHandler f = new FileHandler(formatChecker);

    MockMultipartFile f1 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", jpegImage);

    MockMultipartFile f2 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", cannonJpegBytes);

    MockMultipartFile f3 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", SPIFFJpgBytes);

    MockMultipartFile f4 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", empty);

    MockMultipartFile f5 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", empty2);

    MockMultipartFile f6 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", empty3);

    MultipartFile[] m = new MockMultipartFile[6];

    m[0] = f1;
    m[1] = f2;
    m[2] = f3;
    m[3] = f4;
    m[4] = f5;
    m[5] = f6;

    assertEquals(f.checkedFiles(m).length, 3);

  }


}