package doctor.finder.app.mapper;

import doctor.finder.app.config.MapperConfig;
import doctor.finder.app.dto.hospital.CreateHospitalRequestDto;
import doctor.finder.app.dto.hospital.HospitalResponseDto;
import doctor.finder.app.model.Address;
import doctor.finder.app.model.Hospital;
import doctor.finder.app.model.user.Doctor;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface HospitalMapper {
    HospitalResponseDto toDto(Hospital hospital);

    @Mapping(target = "id", ignore = true)
    Hospital toModel(CreateHospitalRequestDto requestDto);

    @AfterMapping
    default void setDoctorsAndAddressIds(@MappingTarget HospitalResponseDto responseDto,
                                         Hospital hospital) {
        responseDto.setDoctorIds(hospital.getDoctors().stream()
                .map(Doctor::getId)
                .collect(Collectors.toSet()));
        responseDto.setAddressId(hospital.getAddress().getId());
    }

    @AfterMapping
    default void setAddress(@MappingTarget Hospital hospital, CreateHospitalRequestDto dto) {
        Address address = new Address();
        address.setId(dto.getAddressId());
        hospital.setAddress(address);
    }
}
