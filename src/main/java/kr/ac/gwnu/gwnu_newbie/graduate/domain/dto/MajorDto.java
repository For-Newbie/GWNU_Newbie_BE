package kr.ac.gwnu.gwnu_newbie.graduate.domain.dto;

public record MajorDto(
        Integer basicMajor,
        Integer requireMajor,
        Integer selectMajor,
        Integer total
) {
    public static MajorDto of(
            Integer basicMajor,
            Integer requireMajor,
            Integer selectMajor,
            Integer total
    ) {
        return new MajorDto(basicMajor, requireMajor, selectMajor, total);
    }
}