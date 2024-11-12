package kr.ac.gwnu.gwnu_newbie.club.application;

import kr.ac.gwnu.gwnu_newbie.club.domain.dto.ClubJoinResponseDto;
import kr.ac.gwnu.gwnu_newbie.club.domain.repository.ClubJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubJoinService {

    private final ClubJoinRepository clubJoinRepository;

    public List<ClubJoinResponseDto> getAllClubJoinInfo() {
        return clubJoinRepository.findAllWithClub().stream()
                .map(ClubJoinResponseDto::from)
                .toList();
    }
}
