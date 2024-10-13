package kr.ac.gwnu.gwnu_newbie.club.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "club_join")
public class ClubJoin {

    @Id
    @OneToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Column(name = "join_paths", nullable = false, length = 100)
    private String joinPaths;

    @Column(name = "join_path_icons", nullable = false, length = 100)
    private String joinPathIcons;

    @Lob
    @Column(name = "join_content", nullable = false)
    private String joinContent;
}