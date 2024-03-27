package doctor.finder.app.dto.visit;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class VisitResponseDtoWithoutPatient {
    private Long id;
    private UUID doctorId;
    private Long hospitalId;
    private LocalDateTime dateTime;
}
