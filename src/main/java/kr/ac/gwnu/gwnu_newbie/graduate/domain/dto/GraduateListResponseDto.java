package kr.ac.gwnu.gwnu_newbie.graduate.domain.dto;

import java.util.List;

public record GraduateListResponseDto(
        List<GraduateResponseDto> graduateList,
        int totalCount
) {
    public static GraduateListResponseDto of(List<GraduateResponseDto> graduateList) {
        return new GraduateListResponseDto(graduateList, graduateList.size());
    }
}