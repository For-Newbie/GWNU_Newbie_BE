package kr.ac.gwnu.gwnu_newbie.club.domain.repository;

import kr.ac.gwnu.gwnu_newbie.club.domain.ClubJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClubJoinRepository extends JpaRepository<ClubJoin, Long> {

    @Query("SELECT cj FROM ClubJoin cj JOIN FETCH cj.club")
    List<ClubJoin> findAllWithClub();
}
