package kr.ac.gwnu.gwnu_newbie.graduate.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "graduate")
public class Graduate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "graduate_id")
    private Long id;

    @Column(name = "class_of", nullable = false)
    private Integer classOf;

    @Column(name = "major", nullable = false, length = 30)
    private String major;

    @OneToOne(mappedBy = "graduate", cascade = CascadeType.ALL)
    private GraduateDetail graduateDetail;
}