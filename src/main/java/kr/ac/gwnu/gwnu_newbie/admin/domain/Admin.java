package kr.ac.gwnu.gwnu_newbie.admin.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_password", nullable = false)
    private String adminPassword;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Permission> permissions;
}