package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

import kr.ac.gwnu.gwnu_newbie.community.domain.User;

public record UserResponse(
        Long id,
        String userName,
        String name,
        String nickname
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getName(),
                user.getNickname()
        );
    }
}