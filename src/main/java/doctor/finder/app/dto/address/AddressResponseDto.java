package doctor.finder.app.dto.address;

import lombok.Data;

@Data
public class AddressResponseDto {
    private String country;
    private String city;
    private String street;
    private String houseNumber;
}
