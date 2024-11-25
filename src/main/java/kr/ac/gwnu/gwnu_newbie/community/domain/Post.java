package kr.ac.gwnu.gwnu_newbie.community.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "post_title", nullable = false, length = 100)
    private String postTitle;

    @Lob
    @Column(name = "post_content", nullable = false)
    private String postContent;

    @Column(name = "post_created_at", nullable = false, updatable = false)
    private LocalDateTime postCreatedAt;

    @Column(name = "post_updated_at", nullable = false)
    private LocalDateTime postUpdatedAt;

    @Column(name = "category_name", nullable = false, length = 30)
    private String categoryName;

    @Builder
    private Post(User user, String postTitle, String postContent,
                 LocalDateTime postCreatedAt, LocalDateTime postUpdatedAt, String categoryName) {
        this.user = user;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCreatedAt = postCreatedAt;
        this.postUpdatedAt = postUpdatedAt;
        this.categoryName = categoryName;
    }
}