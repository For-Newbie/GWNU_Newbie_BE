package kr.ac.gwnu.gwnu_newbie.global.dto;

public record ResponseDto(
        int code,
        String message,
        Object body
) {
}