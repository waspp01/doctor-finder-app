package doctor.finder.app.service;

import doctor.finder.app.dto.user.UserRegistrationRequestDto;
import doctor.finder.app.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto registerPatient(UserRegistrationRequestDto requestDto);
}
