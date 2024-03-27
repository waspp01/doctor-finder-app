package doctor.finder.app.repository;

import doctor.finder.app.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
