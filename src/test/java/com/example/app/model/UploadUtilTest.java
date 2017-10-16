package com.example.app.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Stress tests UploadUtil
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UploadUtilTest {

  @Test
  public void createFolderNameTest() throws Exception {

    UploadFolderProperties properties = new UploadFolderProperties();
    UploadUtil uploadUtil = new UploadUtil(properties);

    uploadUtil.createFolderName("folder");



  }

}