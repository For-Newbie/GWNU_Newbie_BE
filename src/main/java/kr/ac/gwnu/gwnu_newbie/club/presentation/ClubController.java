package kr.ac.gwnu.gwnu_newbie.club.presentation;

import kr.ac.gwnu.gwnu_newbie.club.application.ClubService;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllClubs() {
        return ResponseUtil.createSuccessResponse(clubService.getAllClubs());
    }
}
