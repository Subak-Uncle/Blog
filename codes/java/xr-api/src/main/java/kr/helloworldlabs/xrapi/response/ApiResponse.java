package kr.helloworldlabs.xrapi.response;

public record ApiResponse (
        String message
){
    public static ApiResponse of(String message) {
        return new ApiResponse(message);
    }
}
