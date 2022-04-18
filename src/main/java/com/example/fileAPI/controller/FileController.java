package com.example.fileAPI.controller;

import com.example.fileAPI.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/getFile")
    public ResponseEntity<String> getFileByName(@RequestParam String name) {
        return ResponseEntity.ok().body(fileService.getFileByName(name));
    }

    @PostMapping("/file")
    public ResponseEntity<HttpStatus> saveFile(@RequestParam String name,
                                               @RequestBody MultipartFile file) {
        fileService.saveFile(name, file);
        return ResponseEntity.ok().build();
    }
}
