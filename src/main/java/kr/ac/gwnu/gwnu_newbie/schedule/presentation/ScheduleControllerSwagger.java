package kr.ac.gwnu.gwnu_newbie.schedule.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.schedule.domain.Schedule;
import org.springframework.http.ResponseEntity;

@Tag(name = "Schedule", description = "**학사 일정 정보 API**")
public interface ScheduleControllerSwagger {

    @Operation(summary = "학사 일정 전체", description = "학사 일정 전체 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = Schedule.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getAllSchedules();

    @Operation(summary = "카테고리별 학사 일정", description = "카테고리별 학사 일정 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = Schedule.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getSchedulesByCategory(
            @Parameter(description = "학사 일정 카테고리", required = true) String category
    );
}
