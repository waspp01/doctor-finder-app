package doctor.finder.app;

import doctor.finder.app.model.Hospital;
import doctor.finder.app.model.Role;
import doctor.finder.app.model.user.Doctor;
import doctor.finder.app.model.user.Patient;
import doctor.finder.app.repository.HospitalRepository;
import doctor.finder.app.repository.RoleRepository;
import doctor.finder.app.repository.user.DoctorRepository;
import doctor.finder.app.repository.user.PatientRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    @Autowired
    private final RoleRepository repository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final HospitalRepository hospitalRepository;

    public AppApplication(RoleRepository repository, DoctorRepository doctorRepository, PatientRepository patientRepository, HospitalRepository hospitalRepository) {
        this.repository = repository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Your code to use RoleRepository can be placed here
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);

        Role patientRole = new Role();
        patientRole.setName(Role.RoleName.PATIENT);

        Role doctorRole = new Role();
        doctorRole.setName(Role.RoleName.DOCTOR);

        // Save roles to the database using the repository
        repository.save(adminRole);
        repository.save(patientRole);
        repository.save(doctorRole);

        Hospital hospital = new Hospital();
        hospital.setName("hospital");
        hospitalRepository.save(hospital);

        Doctor doctorUser = new Doctor();
        doctorUser.setEmail("doc@i.ua");
        doctorUser.setFirstName("docName");
        doctorUser.setLastName("docLastName");
        doctorUser.setPassword("123456");
        doctorUser.setRoles(Set.of(doctorRole));
        doctorUser.setHospital(hospital);


        Patient patientUser = new Patient();
        patientUser.setEmail("pat@i.ua");
        patientUser.setPassword("123456");
        patientUser.setFirstName("firstname");
        patientUser.setLastName("lastname");
        patientUser.setAddress("pat address");
        patientUser.setRoles(Set.of(patientRole));

        patientRepository.save(patientUser);
        doctorRepository.save(doctorUser);
    }
}
