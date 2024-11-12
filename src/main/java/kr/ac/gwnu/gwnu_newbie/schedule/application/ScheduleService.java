package kr.ac.gwnu.gwnu_newbie.schedule.application;

import kr.ac.gwnu.gwnu_newbie.schedule.domain.dto.ScheduleResponseDto;
import kr.ac.gwnu.gwnu_newbie.schedule.domain.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::from)
                .toList();
    }

    public List<ScheduleResponseDto> getSchedulesByCategory(String category) {
        return scheduleRepository.findByCategory(category).stream()
                .map(ScheduleResponseDto::from)
                .toList();
    }
}
