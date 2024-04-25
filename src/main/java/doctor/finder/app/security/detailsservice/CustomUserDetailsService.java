package doctor.finder.app.security.detailsservice;

import doctor.finder.app.model.user.Admin;
import doctor.finder.app.model.user.Doctor;
import doctor.finder.app.model.user.HospitalAdmin;
import doctor.finder.app.model.user.Patient;
import doctor.finder.app.repository.user.AdminRepository;
import doctor.finder.app.repository.user.DoctorRepository;
import doctor.finder.app.repository.user.HospitalAdminRepository;
import doctor.finder.app.repository.user.PatientRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AdminRepository adminRepository;
    private final HospitalAdminRepository hospitalAdminRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<Patient> patientOptional= patientRepository.findByEmail(username);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        }

        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(username);
        if (doctorOptional.isPresent()) {
            return doctorOptional.get();
        }

        Optional<HospitalAdmin> hospitalAdminOptional =
                hospitalAdminRepository.findByEmail(username);
        if (hospitalAdminOptional.isPresent()) {
            return hospitalAdminOptional.get();
        }

        Optional<Admin> adminOptional = adminRepository.findByEmail(username);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        }

        throw new UsernameNotFoundException("Wrong password or username " + username);
    }
}
