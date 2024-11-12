package kr.ac.gwnu.gwnu_newbie.club.presentation.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

@Tag(name = "ClubJoin", description = "**동아리 가입 정보 API**")
public interface ClubJoinControllerSwagger {

    @Operation(summary = "동아리 가입 정보 전체 조회", description = "모든 동아리의 가입 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "가입 정보 조회 성공",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class))
            )
    })
    ResponseEntity<ResponseDto> getAllClubJoinInfo();
}
