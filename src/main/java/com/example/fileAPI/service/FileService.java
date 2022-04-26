package com.example.fileAPI.service;

import com.example.fileAPI.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String getFileByName(String name) {
        return fileRepository.getFileByName(name);
    }

    public void saveFile(String name, MultipartFile file) {
        fileRepository.saveFile(name, file);
    }
}
