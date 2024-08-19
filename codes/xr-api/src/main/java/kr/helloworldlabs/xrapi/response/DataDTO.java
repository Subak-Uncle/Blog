package kr.helloworldlabs.xrapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO {
    private int id;
    private String name;

    public static DataDTO of(int id, String name) {
        return new DataDTO(id, name);
    }
}
