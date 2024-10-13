package kr.ac.gwnu.gwnu_newbie.club.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_name", nullable = false, length = 30)
    private String clubName;

    @Column(name = "club_content", nullable = false, columnDefinition = "TEXT")
    private String clubContent;

    @Column(name = "club_icon", length = 30)
    private String clubIcon;

    @Column(name = "club_images", length = 100)
    private String clubImages;

    @Column(name = "club_category", nullable = false, length = 30)
    private String clubCategory;

    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL)
    private ClubJoin clubJoin;
}