package kr.ac.gwnu.gwnu_newbie.graduate.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "liberal_arts_credit")
public class LiberalArtsCredit {

    @Id
    @OneToOne
    @JoinColumn(name = "graduate_id", nullable = false)
    private GraduateDetail graduateDetail;

    @Column(name = "basic_liberal", nullable = false)
    private Integer basicLiberal;

    @Column(name = "balance_liberal", nullable = false)
    private Integer balanceLiberal;

    @Column(name = "special_liberal", nullable = false)
    private Integer specialLiberal;
}