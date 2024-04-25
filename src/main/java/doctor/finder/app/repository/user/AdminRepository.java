package doctor.finder.app.repository.user;

import doctor.finder.app.model.user.Admin;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    @EntityGraph(attributePaths = "roles")
    Optional<Admin> findByEmail(String email);
}
