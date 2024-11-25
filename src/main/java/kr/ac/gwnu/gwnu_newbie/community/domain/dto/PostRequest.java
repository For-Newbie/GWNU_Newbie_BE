package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

public record PostRequest(
        String postTitle,
        String postContent,
        String categoryName
) {

}