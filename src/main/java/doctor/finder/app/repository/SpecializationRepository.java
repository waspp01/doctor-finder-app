package doctor.finder.app.repository;

import doctor.finder.app.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
