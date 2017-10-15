package com.example.app;

import com.example.app.controllers.ControllerUtil;
import com.example.app.model.FileHandler;
import com.example.app.model.JPEGChecker;
import com.example.app.model.UploadFolderProperties;
import com.example.app.model.UploadUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UploadFolderProperties.class,
    FileHandler.class, JPEGChecker.class, UploadUtil.class, ControllerUtil.class})

public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }


}
