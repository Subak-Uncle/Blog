package com.subakuncle.fileio.controller;

import com.subakuncle.fileio.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/files")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload/bytes")
    public ResponseEntity<String> uploadByteArray(@RequestBody byte[] content,
                                                  @RequestParam("fileName") String fileName) {
        System.out.println(fileName);
        try {
            String filePath = fileService.saveByteArrayAsFile(content, fileName);
            return ResponseEntity.ok("File saved at: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("저장에 실패하였습니다.");
        }
    }

    @PostMapping("/upload/multipart")
    public ResponseEntity<String> uploadMultipartFile(@RequestParam("file") MultipartFile file) {
        try {
            String filePath = fileService.saveMultipartFile(file);
            return ResponseEntity.ok("File saved at: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("저장에 실패하였습니다.");
        }
    }
}
