package kr.ac.gwnu.gwnu_newbie.community.domain.repository;

import kr.ac.gwnu.gwnu_newbie.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByNickname(String nickname);
}