package kr.ac.gwnu.gwnu_newbie.club.domain.dto;

import kr.ac.gwnu.gwnu_newbie.club.domain.ClubJoin;

public record ClubJoinResponseDto(
        Long clubId,
        String clubName,
        String joinPaths,
        String joinPathIcons,
        String joinContent
) {
    public static ClubJoinResponseDto from(ClubJoin clubJoin) {
        return new ClubJoinResponseDto(
                clubJoin.getClub().getId(),
                clubJoin.getClub().getClubName(),
                clubJoin.getJoinPaths(),
                clubJoin.getJoinPathIcons(),
                clubJoin.getJoinContent()
        );
    }
}
