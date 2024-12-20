package kr.ac.gwnu.gwnu_newbie.community.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "nickname", nullable = false, length = 30)
    private String nickname;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "user_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "user_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "role", nullable = false, length = 30)
    private String role;

    @Builder
    private User(String userName, String name, String nickname, String password,
                 LocalDateTime createdAt, LocalDateTime updatedAt, String role) {
        this.userName = userName;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }
}