package kr.ac.gwnu.gwnu_newbie.graduate.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "graduate_detail")
public class GraduateDetail {

    @Id
    @OneToOne
    @JoinColumn(name = "graduate_id", nullable = false)
    private Graduate graduate;

    @Column(name = "liberal_arts", nullable = false)
    private Integer liberalArts;

    @Column(name = "major_subjects", nullable = false)
    private Integer majorSubjects;

    @Column(name = "teaching_subjects")
    private Integer teachingSubjects;

    @Column(name = "credit", nullable = false)
    private Integer credit;

    @OneToOne(mappedBy = "graduateDetail", cascade = CascadeType.ALL)
    private LiberalArtsCredit liberalArtsCredit;

    @OneToOne(mappedBy = "graduateDetail", cascade = CascadeType.ALL)
    private MajorCredit majorCredit;
}