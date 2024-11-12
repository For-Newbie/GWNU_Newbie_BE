package kr.ac.gwnu.gwnu_newbie.club.presentation.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.club.domain.Club;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

@Tag(name = "Club", description = "**동아리 정보 API**")
public interface ClubControllerSwagger {

    @Operation(summary = "동아리 전체", description = "동아리 전체 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = Club.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getAllClubs();

    @Operation(summary = "카테고리별 동아리", description = "카테고리별 동아리 정보 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = Club.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getClubsByCategory(
            @Parameter(description = "동아리 카테고리", required = true) String category
    );
}
