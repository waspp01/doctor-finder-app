package doctor.finder.app.model;

import doctor.finder.app.model.user.Doctor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "hospitals")
@SQLDelete(sql = "UPDATE categories SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();

    @OneToMany
    private Set<Email> emails = new HashSet<>();

    @OneToMany
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    private String information;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
}
