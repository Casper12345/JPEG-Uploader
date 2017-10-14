package com.example.app;

import com.example.app.model.FileHandler;
import com.example.app.model.FormatChecker;
import com.example.app.model.JPEGChecker;
import com.example.app.model.UploadFolderProperties;
import com.example.app.model.UploadHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({UploadFolderProperties.class, FileHandler.class, JPEGChecker.class})

public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }


}
