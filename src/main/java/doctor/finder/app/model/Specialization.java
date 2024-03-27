package doctor.finder.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "specializations")
@SQLDelete(sql = "UPDATE roles SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private SpecializationName name;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public enum SpecializationName {
        FAMILY_DOCTOR,
        CARDIOLOGIST,
        DERMATOLOGIST,
        GASTROENTEROLOGIST,
        NEUROLOGIST,
        ONCOLOGIST,
        ORTHOPEDIC_SURGEON,
        PEDIATRICIAN,
        PSYCHIATRIST,
        RADIOLOGIST,
        UROLOGIST
    }
}
