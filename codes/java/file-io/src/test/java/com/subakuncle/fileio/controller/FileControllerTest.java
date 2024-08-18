package com.subakuncle.fileio.controller;

import com.subakuncle.fileio.service.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileControllerTest {

    @InjectMocks
    private FileController fileController;

    @Mock
    private FileService fileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUploadByteArray() throws IOException {
        byte[] content = "test content".getBytes();
        String fileName = "test.txt";
        String expectedPath = "uploads/test.txt";

        Mockito.when(fileService.saveByteArrayAsFile(Mockito.any(byte[].class), Mockito.anyString()))
                .thenReturn(expectedPath);

        ResponseEntity<String> response = fileController.uploadByteArray(content, fileName);

        assertEquals("File saved at: " + expectedPath, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUploadMultipartFile() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file", "test.txt", "text/plain", "test content".getBytes());
        String expectedPath = "uploads/test.txt";

        Mockito.when(fileService.saveMultipartFile(Mockito.any(MockMultipartFile.class)))
                .thenReturn(expectedPath);

        ResponseEntity<String> response = fileController.uploadMultipartFile(file);

        assertEquals("File saved at: " + expectedPath, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

}