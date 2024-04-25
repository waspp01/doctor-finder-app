package doctor.finder.app;

import doctor.finder.app.model.Role;
import doctor.finder.app.repository.AddressRepository;
import doctor.finder.app.repository.HospitalRepository;
import doctor.finder.app.repository.RoleRepository;
import doctor.finder.app.repository.user.DoctorRepository;
import doctor.finder.app.repository.user.PatientRepository;
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
    @Autowired
    private final AddressRepository addressRepository;

    public AppApplication(RoleRepository repository,
                          DoctorRepository doctorRepository,
                          PatientRepository patientRepository,
                          HospitalRepository hospitalRepository,
                          AddressRepository addressRepository) {
        this.repository = repository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.hospitalRepository = hospitalRepository;
        this.addressRepository = addressRepository;
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

    }
}
