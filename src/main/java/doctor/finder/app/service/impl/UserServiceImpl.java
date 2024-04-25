package doctor.finder.app.service.impl;

import doctor.finder.app.dto.user.UserRegistrationRequestDto;
import doctor.finder.app.dto.user.UserResponseDto;
import doctor.finder.app.mapper.PatientMapper;
import doctor.finder.app.model.Role;
import doctor.finder.app.model.user.Patient;
import doctor.finder.app.repository.RoleRepository;
import doctor.finder.app.repository.user.PatientRepository;
import doctor.finder.app.service.UserService;
import jakarta.transaction.Transactional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserResponseDto registerPatient(UserRegistrationRequestDto requestDto) {
        Patient patient = new Patient();
        patient.setEmail(requestDto.getEmail());
        patient.setFirstName(requestDto.getFirstName());
        patient.setLastName(requestDto.getLastName());
        patient.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        patient.setRoles(Set.of(roleRepository.findRoleByName(Role.RoleName.PATIENT)));
        return patientMapper.toDto(patientRepository.save(patient));
    }
}
