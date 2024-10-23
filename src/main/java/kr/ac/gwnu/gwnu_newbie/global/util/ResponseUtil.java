package kr.ac.gwnu.gwnu_newbie.global.util;

import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private static final String DEFAULT_SUCCESS_MESSAGE = "성공적으로 처리 완료 되었습니다.";
    private static final HttpStatus DEFAULT_SUCCESS_STATUS = HttpStatus.OK;

    public static ResponseEntity<ResponseDto> createSuccessResponse(Object body) {
        return createSuccessResponse(DEFAULT_SUCCESS_STATUS , DEFAULT_SUCCESS_MESSAGE, body);
    }

    public static ResponseEntity<ResponseDto> createSuccessResponse(String message, Object body) {
        return createSuccessResponse(DEFAULT_SUCCESS_STATUS , message, body);
    }

    public static ResponseEntity<ResponseDto> createSuccessResponse(HttpStatus status, String message, Object body) {
        return ResponseEntity
                .status(status)
                .body(new ResponseDto(status.value(), message, body));
    }
}
