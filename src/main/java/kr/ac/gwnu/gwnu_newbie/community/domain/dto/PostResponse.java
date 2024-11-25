package kr.ac.gwnu.gwnu_newbie.community.domain.dto;

import kr.ac.gwnu.gwnu_newbie.community.domain.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        UserResponse user,
        String postTitle,
        String postContent,
        String categoryName,
        LocalDateTime postCreatedAt,
        LocalDateTime postUpdatedAt,
        boolean isPostWriter
) {
    public static PostResponse from(Post post, String currentUserName) {
        return new PostResponse(
                post.getId(),
                UserResponse.from(post.getUser()),
                post.getPostTitle(),
                post.getPostContent(),
                post.getCategoryName(),
                post.getPostCreatedAt(),
                post.getPostUpdatedAt(),
                post.getUser().getUserName().equals(currentUserName)
        );
    }
}
