package doctor.finder.app.repository;

import doctor.finder.app.model.Hospital;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @EntityGraph(attributePaths = "doctors")
    List<Hospital> findAll();
}
