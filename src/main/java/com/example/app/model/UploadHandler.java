package com.example.app.model;

import org.springframework.web.multipart.MultipartFile;

public interface UploadHandler {

  int fileSaver(MultipartFile files[]);

}
