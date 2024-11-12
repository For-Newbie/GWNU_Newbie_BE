package kr.ac.gwnu.gwnu_newbie.club.presentation;

import kr.ac.gwnu.gwnu_newbie.club.application.ClubService;
import kr.ac.gwnu.gwnu_newbie.club.presentation.swagger.ClubControllerSwagger;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController implements ClubControllerSwagger {

    private final ClubService clubService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllClubs() {
        return ResponseUtil.createSuccessResponse(clubService.getAllClubs());
    }

    @GetMapping("/{category}")
    public ResponseEntity<ResponseDto> getClubsByCategory(@PathVariable String category) {
        return ResponseUtil.createSuccessResponse(clubService.getClubsByCategory(category));
    }
}
