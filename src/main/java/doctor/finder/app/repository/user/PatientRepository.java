package doctor.finder.app.repository.user;

import doctor.finder.app.model.user.Patient;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @EntityGraph(attributePaths = "roles")
    Optional<Patient> findByEmail(String email);
}
