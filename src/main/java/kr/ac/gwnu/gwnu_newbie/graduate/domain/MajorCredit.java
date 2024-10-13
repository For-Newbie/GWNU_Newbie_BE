package kr.ac.gwnu.gwnu_newbie.graduate.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "major_credit")
public class MajorCredit {

    @Id
    @OneToOne
    @JoinColumn(name = "graduate_id", nullable = false)
    private GraduateDetail graduateDetail;

    @Column(name = "basic_major", nullable = false)
    private Integer basicMajor;

    @Column(name = "require_major", nullable = false)
    private Integer requireMajor;

    @Column(name = "select_major", nullable = false)
    private Integer selectMajor;
}