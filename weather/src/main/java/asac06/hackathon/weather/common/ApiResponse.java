package asac06.hackathon.weather.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer status;
    private String message;
    private T data;

    public static ApiResponse errorResponse(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getStatus().value(), errorCode.getDesc(), null);
    }
}
