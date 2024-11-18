package kr.ac.gwnu.gwnu_newbie.graduate.domain.dto;

public record LiberalArtsDto(
        Integer basicLiberal,
        Integer balanceLiberal,
        Integer specialLiberal,
        Integer total
) {
    public static LiberalArtsDto of(
            Integer basicLiberal,
            Integer balanceLiberal,
            Integer specialLiberal,
            Integer total
    ) {
        return new LiberalArtsDto(basicLiberal, balanceLiberal, specialLiberal, total);
    }
}