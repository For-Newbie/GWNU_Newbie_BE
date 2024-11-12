package kr.ac.gwnu.gwnu_newbie.schedule.presentation;

import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import kr.ac.gwnu.gwnu_newbie.schedule.application.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController implements ScheduleControllerSwagger {

    private final ScheduleService scheduleService;

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto> getAllSchedules() {
        return ResponseUtil.createSuccessResponse(scheduleService.getAllSchedules());
    }

    @Override
    @GetMapping("/{category}")
    public ResponseEntity<ResponseDto> getSchedulesByCategory(@PathVariable String category) {
        return ResponseUtil.createSuccessResponse(scheduleService.getSchedulesByCategory(category));
    }

}
