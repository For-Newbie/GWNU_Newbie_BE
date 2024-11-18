package kr.ac.gwnu.gwnu_newbie.graduate.domain.repository;

import kr.ac.gwnu.gwnu_newbie.graduate.domain.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {
    Optional<Graduate> findByMajorAndClassOf(String major, Integer classOf);
}