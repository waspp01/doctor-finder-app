package doctor.finder.app;

import doctor.finder.app.model.Address;
import doctor.finder.app.model.Hospital;
import doctor.finder.app.model.Role;
import doctor.finder.app.model.user.Doctor;
import doctor.finder.app.model.user.Patient;
import doctor.finder.app.model.user.User;
import doctor.finder.app.repository.AddressRepository;
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
//
//        Address address = new Address();
//        address.setCity("Chemnitz");
//        address.setPostalCode("0000");
//        address.setCountry("Germany");
//        address.setStreet("Wolgograder Allee");
//        address.setHouseNumber("100");
//        addressRepository.save(address);
//
//        Hospital hospital = new Hospital();
//        hospital.setName("hospital");
//        hospital.setAddress(address);
//        hospitalRepository.save(hospital);
//
//        Set<Hospital> hospitals = Set.of(hospital);
//
//        Doctor doctorUser = new Doctor();
//        doctorUser.setEmail("doc@i.ua");
//        doctorUser.setFirstName("docName");
//        doctorUser.setLastName("docLastName");
//        doctorUser.setPassword("123456");
//        doctorUser.setRoles(Set.of(doctorRole));
//        doctorUser.setHospitals(hospitals);
//
//        Address address1 = new Address();
//        address1.setCountry("Ger");
//        address1.setCity("Chem");
//        address1.setPostalCode("1111");
//        address1.setStreet("Wolg");
//        address1.setHouseNumber("111");
//        address1 = addressRepository.save(address1);
//
//        Patient patientUser = new Patient();
//        patientUser.setEmail("pat@i.ua");
//        patientUser.setPassword("123456");
//        patientUser.setFirstName("firstname");
//        patientUser.setLastName("lastname");
//        patientUser.setRoles(Set.of(patientRole));
//        patientUser.setAddress(address1);
//
//        patientRepository.save(patientUser);
//        doctorRepository.save(doctorUser);

    }
}
