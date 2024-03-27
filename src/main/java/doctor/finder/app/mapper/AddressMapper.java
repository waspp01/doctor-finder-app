package doctor.finder.app.mapper;

import doctor.finder.app.config.MapperConfig;
import doctor.finder.app.dto.address.AddressResponseDto;
import doctor.finder.app.dto.address.CreateAddressRequestDto;
import doctor.finder.app.model.Address;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AddressMapper {
    AddressResponseDto toDto(Address address);

    Address toModel(CreateAddressRequestDto requestDto);
}
