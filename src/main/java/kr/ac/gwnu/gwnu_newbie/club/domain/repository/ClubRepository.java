package kr.ac.gwnu.gwnu_newbie.club.domain.repository;

import kr.ac.gwnu.gwnu_newbie.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    List<Club> findByClubCategory(String category);
}
