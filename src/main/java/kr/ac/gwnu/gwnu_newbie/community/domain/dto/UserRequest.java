package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

public record UserRequest(
        String userName,
        String name,
        String nickname,
        String password
) {

}