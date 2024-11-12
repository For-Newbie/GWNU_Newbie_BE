package kr.ac.gwnu.gwnu_newbie.club.domain.dto;

import kr.ac.gwnu.gwnu_newbie.club.domain.Club;

public record ClubResponseDto(
        Long id,
        String clubName,
        String clubContent,
        String clubIcon,
        String clubImages,
        String clubCategory
) {
    public static ClubResponseDto from(Club club) {
        return new ClubResponseDto(
                club.getId(),
                club.getClubName(),
                club.getClubContent(),
                club.getClubIcon(),
                club.getClubImages(),
                club.getClubCategory()
        );
    }
}
