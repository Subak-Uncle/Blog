package kr.helloworldlabs.xrapi.presentation;

import kr.helloworldlabs.xrapi.response.ApiResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class MainController {

    private static final String BASE_URL = "http://mtvs.helloworldlabs.kr:7771";

    @GetMapping("/")
    public ResponseEntity<ApiResponse> index() {
        return ResponseEntity.ok().body(ApiResponse.of(BASE_URL + "/docs 로 이동하여 API 명세서를 다운로드 받아주세요."));
    }


    @GetMapping("/docs")
    public ResponseEntity<Resource> getDocs() throws UnsupportedEncodingException {

        String filePath = "/uploads/api_docs.pdf";
        String encodedFileName = URLEncoder.encode("api_docs.pdf", "UTF-8").replaceAll("\\+", "%20");

        Resource resource = new ClassPathResource(filePath);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();


        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
