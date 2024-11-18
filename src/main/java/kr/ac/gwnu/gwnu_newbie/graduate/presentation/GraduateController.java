package kr.ac.gwnu.gwnu_newbie.graduate.presentation;

import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import kr.ac.gwnu.gwnu_newbie.graduate.application.GraduateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/graduates")
public class GraduateController implements GraduateControllerSwagger {

    private final GraduateService graduateService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllGraduateRequirements() {
        return ResponseUtil.createSuccessResponse(graduateService.getAllGraduateRequirements());
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> getGraduateRequirements(
            @RequestParam String major,
            @RequestParam Integer classOf) {
        return ResponseUtil.createSuccessResponse(graduateService.getGraduateRequirements(major, classOf));
    }
}