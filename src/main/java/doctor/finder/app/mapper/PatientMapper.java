package doctor.finder.app.mapper;

import doctor.finder.app.config.MapperConfig;
import doctor.finder.app.dto.user.UserRegistrationRequestDto;
import doctor.finder.app.dto.user.UserResponseDto;
import doctor.finder.app.model.user.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface PatientMapper {
    UserResponseDto toDto(Patient patient);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "familyDoctor", ignore = true)
    Patient toModel(UserRegistrationRequestDto requestDto);

}
