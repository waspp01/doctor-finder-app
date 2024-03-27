package doctor.finder.app.dto.hospital;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateHospitalRequestDto {
    @NotBlank
    private String name;
    private Long addressId;
    private String information;

    @NotBlank
    private String country;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
}
