package kr.ac.gwnu.gwnu_newbie.community.presentation.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.LoginRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.UserRequest;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "**유저 정보 API**")
public interface UserControllerSwagger {

    @Operation(summary = "회원가입", description = "회원가입 API")
    ResponseEntity<ResponseDto> register(@RequestBody UserRequest request);

    @Operation(summary = "로그인", description = "로그인 API")
    ResponseEntity<Void> login(@RequestBody LoginRequest request);
}
