package kr.ac.gwnu.gwnu_newbie.graduate.domain.dto;

public record GraduateResponseDto(
        Long id,
        Integer classOf,
        String major,
        LiberalArtsDto liberalArts,
        MajorDto majorSubjects,
        Integer teachingSubjects,
        Integer totalCredits,
        Integer graduationCredits
) {
    public static GraduateResponseDto of(
            Long id,
            Integer classOf,
            String major,
            LiberalArtsDto liberalArts,
            MajorDto majorSubjects,
            Integer teachingSubjects,
            Integer totalCredits,
            Integer graduationCredits
    ) {
        return new GraduateResponseDto(
                id, classOf, major, liberalArts, majorSubjects,
                teachingSubjects, totalCredits, graduationCredits
        );
    }
}