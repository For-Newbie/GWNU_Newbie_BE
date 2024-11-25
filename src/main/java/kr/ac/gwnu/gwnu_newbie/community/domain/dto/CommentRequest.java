package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

public record CommentRequest(
        Long postId,
        String commentContent
) {

}