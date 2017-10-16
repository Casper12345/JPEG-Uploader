package com.example.app;

import com.example.app.controllers.ControllerUtil;
import com.example.app.model.FileHandler;
import com.example.app.model.JPEGChecker;
import com.example.app.model.UploadFolderHelper;
import com.example.app.model.UploadFolderProperties;
import com.example.app.model.UploadUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Main entry point of spring boot application.
 * Contains configuration properties for autowired
 * dependencies.
 */
@SpringBootApplication
@EnableConfigurationProperties({UploadFolderProperties.class,
    FileHandler.class, JPEGChecker.class, UploadUtil.class, ControllerUtil.class,
    UploadFolderHelper.class})

public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }


  /**
   * CommandLineRunner interface that calls checkAndCreateUploadFolder. Runs to check and create
   * destination folder for upload sub-folders.
   */
  @Bean
  CommandLineRunner init(UploadFolderHelper helper) {
    return (args) -> {
      helper.checkAndCreateUploadFolder();
    };
  }

}
