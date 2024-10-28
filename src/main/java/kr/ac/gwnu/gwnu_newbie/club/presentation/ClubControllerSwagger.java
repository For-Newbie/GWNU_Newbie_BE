package kr.ac.gwnu.gwnu_newbie.club.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.club.domain.Club;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

@Tag(name = "Product", description = "**동아리 정보 API**")
public interface ClubControllerSwagger {

    @Operation(summary = "카테고리", description = "카테고리 API")
    @ApiResponses({
            @ApiResponse(responseCode = "body", description = "응답 메시지 예시",
                    content = @Content(schema = @Schema(implementation = Club.class))),
            @ApiResponse(responseCode = "200", description = "Success")
    })
    ResponseEntity<ResponseDto> getAllClubs();
}
