package doctor.finder.app.controller;

import doctor.finder.app.dto.user.UserLoginRequestDto;
import doctor.finder.app.dto.user.UserLoginResponseDto;
import doctor.finder.app.dto.user.UserRegistrationRequestDto;
import doctor.finder.app.dto.user.UserResponseDto;
import doctor.finder.app.security.AuthenticationService;
import doctor.finder.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        return userService.registerPatient(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
