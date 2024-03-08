package doctor.finder.app.repository.user;

import doctor.finder.app.model.user.Doctor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
