package kr.ac.gwnu.gwnu_newbie.community.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_created_at", nullable = false, updatable = false)
    private LocalDateTime commentCreatedAt;

    @Builder
    private Comment(Post post, User user, String commentContent, LocalDateTime commentCreatedAt) {
        this.post = post;
        this.user = user;
        this.commentContent = commentContent;
        this.commentCreatedAt = commentCreatedAt;
    }
}