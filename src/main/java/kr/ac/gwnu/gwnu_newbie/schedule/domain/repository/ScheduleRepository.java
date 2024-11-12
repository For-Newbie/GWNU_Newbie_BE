package kr.ac.gwnu.gwnu_newbie.schedule.domain.repository;

import kr.ac.gwnu.gwnu_newbie.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByCategory(String category);
}
