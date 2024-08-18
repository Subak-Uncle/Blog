package com.subakuncle.fileio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {

    private final String uploadDir = "src/main/resources/uploads/";

    public String saveByteArrayAsFile(byte[] content, String fileName) throws IOException {

        Path dirPath = Paths.get(uploadDir);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        String extension = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + "_" + new Date().toString() + extension;

        Path path = Paths.get(uploadDir, newFileName);
        Files.write(path, content);
        return path.toString();
    }

    public String saveMultipartFile(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();
        String extension = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + "_" + new Date().toString() + extension;

        Path path = Paths.get(uploadDir + fileName);
        file.transferTo(path);
        return path.toString();
    }

}
