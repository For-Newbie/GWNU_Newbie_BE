package kr.ac.gwnu.gwnu_newbie.club.presentation;

import kr.ac.gwnu.gwnu_newbie.club.application.ClubJoinService;
import kr.ac.gwnu.gwnu_newbie.club.presentation.swagger.ClubJoinControllerSwagger;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs/join")
@RequiredArgsConstructor
public class ClubJoinController implements ClubJoinControllerSwagger {

    private final ClubJoinService clubJoinService;

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto> getAllClubJoinInfo() {
        return ResponseUtil.createSuccessResponse(clubJoinService.getAllClubJoinInfo());
    }
}
