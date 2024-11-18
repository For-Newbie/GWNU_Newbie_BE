package kr.ac.gwnu.gwnu_newbie.graduate.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.GraduateListResponseDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.GraduateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Graduate", description = "**졸업 이수 정보 API**")
public interface GraduateControllerSwagger {

    @Operation(summary = "학사 일정 전체", description = "학사 일정 전체 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = GraduateListResponseDto.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getAllGraduateRequirements();

    @Operation(summary = "졸업 이수 상세", description = "졸업 이수 상세 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = GraduateResponseDto.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getGraduateRequirements(@RequestParam String major,
                                                        @RequestParam Integer classOf);
}
