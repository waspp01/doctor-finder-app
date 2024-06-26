package doctor.finder.app.repository.user;

import doctor.finder.app.model.user.Doctor;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    @EntityGraph(attributePaths = "roles")
    Optional<Doctor> findByEmail(String email);
}
