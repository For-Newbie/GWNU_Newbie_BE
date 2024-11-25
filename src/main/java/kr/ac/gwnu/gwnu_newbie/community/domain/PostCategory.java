package kr.ac.gwnu.gwnu_newbie.community.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post_category")
@NoArgsConstructor
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, length = 30, unique = true)
    private String categoryName;

    @Column(name = "description", length = 200)
    private String description;

    @Builder
    private PostCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}