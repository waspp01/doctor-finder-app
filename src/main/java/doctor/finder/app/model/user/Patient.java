package doctor.finder.app.model.user;

import doctor.finder.app.model.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "patients")
public class Patient extends User {
    @ManyToOne
    @JoinColumn
    private Doctor familyDoctor;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
