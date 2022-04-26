package com.example.fileAPI.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileRepositoryImpl implements FileRepository{

    private final Map<String, File> fileSystem = new HashMap<>();

    @Override
    public String getFileByName(String name) {
        try {
            return Files.readString(Paths.get("src/main/resources/" + name + ".tmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveFile(String name, MultipartFile file) {
        File fileStored = new File("src/main/resources/" + name + ".tmp");
        try {
            file.transferTo(fileStored);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileSystem.put(name, fileStored);
    }
}
