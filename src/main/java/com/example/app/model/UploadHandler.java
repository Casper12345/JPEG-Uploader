package com.example.app.model;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface UploadHandler {

  int fileSaver(MultipartFile files[]) throws IOException;

}
