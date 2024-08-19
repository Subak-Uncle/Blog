package kr.helloworldlabs.xrapi.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Size;
import kr.helloworldlabs.xrapi.response.DataDTO;
import kr.helloworldlabs.xrapi.response.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ObjectMapper objectMapper;

    private final static String STRING_REQUEST_VALID_MESSAGE = "parameter 이름으로 문자열을 입력해주세요! 빈 문자열과 null이 포함되면 안됩니다.";
    private final static String JSON_REQUEST_VALID_MESSAGE = "JSON을 Request Body에 포함시켜주세요.";

    @GetMapping(value = "/string")
    public ResponseEntity<String> getStringWithQueryParameter(@RequestParam(name = "parameter") String request ) {
        if (request == null || request.isEmpty()) {
            request = STRING_REQUEST_VALID_MESSAGE;
        }
        return ResponseEntity.ok().body(request);
    }

    @GetMapping(value = "/string/{parameter}")
    public ResponseEntity<String> getStringWithPathParameter(@PathVariable(value = "parameter") String request) {
        if (request == null || request.isEmpty()) {
            request = STRING_REQUEST_VALID_MESSAGE;
        }
        return ResponseEntity.ok().body(request);
    }

    @GetMapping(value = "/string/to-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getJsonFromString (@RequestParam Map<String, Object> request) {
        return ResponseEntity.ok(request);
    }

    @PostMapping("/string")
    public ResponseEntity<String> postStringWithQueryParameter(@RequestBody String request) {
        if (request ==null || request.isEmpty()) {
            request = STRING_REQUEST_VALID_MESSAGE;
        }
        return ResponseEntity.ok().body(request);
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getJsonFromJson (){

        ResponseDTO response = new ResponseDTO(
                LocalDateTime.now(),
                "제목입니다.",
                "내용입니다.",
                DataDTO.of(1, "메타버스 아카데미")
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/json/{json}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getJsonFromJsonPath (@PathVariable(value = "json") String jsonString) throws IOException {
        Map<String, Object> jsonMap = objectMapper.readValue(jsonString, Map.class);
        return ResponseEntity.ok(jsonMap);
    }

    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> jsonApiWithBody(@RequestBody Map<String, Object> request) {
        if (request == null || request.isEmpty()) {
            request.put("message", JSON_REQUEST_VALID_MESSAGE);
        }
        return ResponseEntity.ok().body(request);
    }

    @GetMapping(value = "/file")
    public ResponseEntity<byte[]> getFileFromFile(@RequestParam("filename") String filename) throws IOException {

        if (filename == null || filename.isEmpty() || !filename.equals("helloworld")) {
            throw new FileNotFoundException();
        }
        String fileExtension = ".png";
        log.info("filename: {}", filename);
        try {
            Resource resource = new ClassPathResource("uploads/" + filename + fileExtension);
            Path filePath = resource.getFile().toPath();
            log.info("file path: {}", filePath);
            byte[] data = Files.readAllBytes(filePath);
            log.info("data: {}", data);

            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
        } catch (IOException e) {
            log.error("File reading error: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/file")
    public ResponseEntity<Resource> postFileAndReturn (@RequestParam("file") MultipartFile file) throws IOException {

        InputStreamResource resource = new InputStreamResource(file.getInputStream());

        String fileName = file.getOriginalFilename();
        // 파일 이름을 UTF-8로 인코딩합니다
        String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\"");
        headers.add(HttpHeaders.CONTENT_TYPE, file.getContentType());

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/byte")
    public ResponseEntity<byte[]> postByte(
            @RequestBody @Size(max = 1073741824) byte[] fileData,
            @RequestHeader(value = "Content-Type", required = false) String contentType,
            @RequestHeader(value = "File-Name", required = false) String fileName) {

        HttpHeaders headers = new HttpHeaders();

        if (contentType != null && !contentType.isEmpty()) {
            headers.setContentType(MediaType.parseMediaType(contentType));
        } else {
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        }

        if (fileName != null && !fileName.isEmpty()) {
            headers.setContentDispositionFormData("attachment", fileName);
        }

        return ResponseEntity.ok()
                .headers(headers)
                .body(fileData);
    }
}
