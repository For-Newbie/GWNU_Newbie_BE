package kr.ac.gwnu.gwnu_newbie.community.presentation;

import kr.ac.gwnu.gwnu_newbie.community.application.UserService;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.LoginRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.UserRequest;
import kr.ac.gwnu.gwnu_newbie.global.dto.ResponseDto;
import kr.ac.gwnu.gwnu_newbie.global.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserRequest request) {
        return ResponseUtil.createSuccessResponse(userService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequest request) {
        return ResponseUtil.createSuccessResponse(userService.login(request));
    }
}