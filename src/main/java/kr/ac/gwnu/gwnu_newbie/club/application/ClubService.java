package kr.ac.gwnu.gwnu_newbie.club.application;

import kr.ac.gwnu.gwnu_newbie.club.domain.Club;
import kr.ac.gwnu.gwnu_newbie.club.domain.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
}
