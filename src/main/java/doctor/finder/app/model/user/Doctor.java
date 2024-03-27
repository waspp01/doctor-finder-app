package doctor.finder.app.model.user;

import doctor.finder.app.model.Hospital;
import doctor.finder.app.model.Specialization;
import doctor.finder.app.model.Visit;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "doctors")
@Data
public class Doctor extends User {

    @ManyToMany
    private Set<Specialization> specializations;

    @ManyToMany
    private Set<Hospital> hospitals;

    @ManyToMany
    @JoinTable(name = "doctors_patients",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients = new HashSet<>();

    @ManyToMany
    private List<Visit> visits;

}
