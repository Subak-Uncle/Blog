package kr.helloworldlabs.xrapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static String BAD_REQUEST_EXCEPTION_MESSAGE = "요청 인자가 잘못되었습니다. 명세서를 참고하여 수정해주세요.";
    private final static String STRING_REQUEST_VALID_MESSAGE = "parameter 이름으로 문자열을 입력해주세요! 빈 문자열과 null이 포함되면 안됩니다.";

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleException(final NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.of("명세서를 참고하여 url과 HTTP Method를 수정해주세요!"));
    }

    @ExceptionHandler({MultipartException.class, MissingServletRequestPartException.class})
    public ResponseEntity<ApiResponse> handleMultipartException(final MultipartException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of("첨부 파일이 의도와 다릅니다! key 값으로 'file'을 입력했는지 확인해주세요."));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(final IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of(BAD_REQUEST_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ApiResponse> handleFileNotFoundException(final FileNotFoundException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of("존재하지 않은 파일 명으로 요청을 보내주셨습니다. 명세서를 참고하여 filename을 helloworld로 수정해주세요."));
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse> handleHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of(BAD_REQUEST_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponse> handleIllegalStateException(final IllegalStateException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of(BAD_REQUEST_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> handleMissingServletRequestParameterException(final MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of(STRING_REQUEST_VALID_MESSAGE));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(final HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.of("Request Body에 값을 추가해주세요."));
    }
}
