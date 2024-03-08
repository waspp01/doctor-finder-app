package doctor.finder.app.model.user;

import doctor.finder.app.model.Visit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends User {
    @ManyToOne
    @JoinColumn
    private Doctor familyDoctor;
    @Column(nullable = false)
    private String address;

    @OneToMany
    private Set<Visit> visits = new HashSet<>();
}
