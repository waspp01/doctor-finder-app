package doctor.finder.app.repository.user;

import doctor.finder.app.model.user.HospitalAdmin;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalAdminRepository extends JpaRepository<HospitalAdmin, UUID> {
    @EntityGraph(attributePaths = "roles")
    Optional<HospitalAdmin> findByEmail(String email);
}
