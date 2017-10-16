package com.example.app.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class JPEGCheckerTest {


  @Test
  public void testIsFile() throws Exception {

    byte jpegImage[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe0};
    byte cannonJpegBytes[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe2};
    byte SPIFFJpgBytes[] = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe8};

    byte pdfBytes[] = {(byte) 0x25, (byte) 0x50, (byte) 0x44, (byte) 0x46};
    byte gifBytes[] = {(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38};
    byte docXBytes[] = {(byte) 0x50, (byte) 0x4b, (byte) 0x03, (byte) 0x04};

    MockMultipartFile f1 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", jpegImage);

    MockMultipartFile f2 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", cannonJpegBytes);

    MockMultipartFile f3 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", SPIFFJpgBytes);

    MockMultipartFile f4 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", pdfBytes);

    MockMultipartFile f5 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", gifBytes);

    MockMultipartFile f6 =
        new MockMultipartFile("data", "filename.jpg", "text/plain", docXBytes);

    JPEGChecker n = new JPEGChecker();

    assertTrue(n.isFile(f1));
    assertTrue(n.isFile(f2));
    assertTrue(n.isFile(f3));

    assertFalse(n.isFile(f4));
    assertFalse(n.isFile(f5));
    assertFalse(n.isFile(f6));

  }


}