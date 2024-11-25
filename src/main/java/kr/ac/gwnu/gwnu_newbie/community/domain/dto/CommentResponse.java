package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

import kr.ac.gwnu.gwnu_newbie.community.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        UserResponse user,
        String commentContent,
        LocalDateTime commentCreatedAt,
        boolean isCommentWriter
) {
    public static CommentResponse from(Comment comment, String currentUserName) {
        return new CommentResponse(
                comment.getId(),
                UserResponse.from(comment.getUser()),
                comment.getCommentContent(),
                comment.getCommentCreatedAt(),
                comment.getUser().getUserName().equals(currentUserName)
        );
    }
}