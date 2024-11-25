package kr.ac.gwnu.gwnu_newbie.community.application;

import kr.ac.gwnu.gwnu_newbie.community.domain.User;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.LoginRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.UserRequest;
import kr.ac.gwnu.gwnu_newbie.community.domain.dto.UserResponse;
import kr.ac.gwnu.gwnu_newbie.community.domain.repository.UserRepository;
import kr.ac.gwnu.gwnu_newbie.global.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserResponse register(UserRequest request) {
        if (userRepository.existsByUserName(request.userName())) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
        if (userRepository.existsByNickname(request.nickname())) {
            throw new RuntimeException("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .userName(request.userName())
                .name(request.name())
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .role("ROLE_USER")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return UserResponse.from(userRepository.save(user));
    }

    @Transactional
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.userName(), request.password())
        );

        return jwtTokenProvider.generateToken(authentication);
    }
}