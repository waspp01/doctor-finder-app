package doctor.finder.app.dto.visit;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class CreateVisitRequestDto {
    @NotBlank
    private UUID doctorId;
    @NotBlank
    private Long hospitalId;
    @NotBlank
    private LocalDateTime dateTime;
}
