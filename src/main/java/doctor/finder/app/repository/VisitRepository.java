package doctor.finder.app.repository;

import doctor.finder.app.model.Visit;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByPatientId(UUID patientId);
}
