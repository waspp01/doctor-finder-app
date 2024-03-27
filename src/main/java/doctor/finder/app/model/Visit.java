package doctor.finder.app.model;

import doctor.finder.app.model.user.Doctor;
import doctor.finder.app.model.user.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "visits")
@Data
@SQLDelete(sql = "UPDATE categories SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    private String comments;

    private boolean isBooked = false;

    private boolean isDeleted = false;
}
