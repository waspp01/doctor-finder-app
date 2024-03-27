package doctor.finder.app.dto.hospital;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Data
public class HospitalResponseDto {
    private Long id;
    private String name;
    private Long addressId;
    private Set<UUID> doctorIds = new HashSet<>();
    private Set<Long> emailsIds = new HashSet<>();
    private Set<Long> phoneNumberIds = new HashSet<>();
    private String information;
}
