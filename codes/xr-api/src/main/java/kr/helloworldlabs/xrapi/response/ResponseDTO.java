package kr.helloworldlabs.xrapi.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private LocalDateTime timestamp;
    private String title;
    private String content;
    private DataDTO data;

}

