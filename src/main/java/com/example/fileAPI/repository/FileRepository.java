package com.example.fileAPI.repository;

import org.springframework.web.multipart.MultipartFile;

public interface FileRepository {
    String getFileByName(String name);

    void saveFile(String name, MultipartFile file);
}
