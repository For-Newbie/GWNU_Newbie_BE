package kr.ac.gwnu.gwnu_newbie.club.application;

import kr.ac.gwnu.gwnu_newbie.club.domain.dto.ClubResponseDto;
import kr.ac.gwnu.gwnu_newbie.club.domain.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {

    private final ClubRepository clubRepository;

    public List<ClubResponseDto> getAllClubs() {
        return clubRepository.findAll().stream()
                .map(ClubResponseDto::from)
                .toList();
    }

    public List<ClubResponseDto> getClubsByCategory(String category) {
        return clubRepository.findByClubCategory(category).stream()
                .map(ClubResponseDto::from)
                .toList();
    }
}
