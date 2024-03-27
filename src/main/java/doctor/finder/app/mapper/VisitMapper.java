package doctor.finder.app.mapper;

import doctor.finder.app.config.MapperConfig;
import doctor.finder.app.dto.visit.CreateVisitRequestDto;
import doctor.finder.app.dto.visit.VisitResponseDto;
import doctor.finder.app.dto.visit.VisitResponseDtoWithoutPatient;
import doctor.finder.app.model.Hospital;
import doctor.finder.app.model.Visit;
import doctor.finder.app.model.user.Doctor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface VisitMapper {
    VisitResponseDto toDto(Visit visit);

    @Mapping(target = "id", ignore = true)
    Visit toModel(CreateVisitRequestDto requestDto);

    VisitResponseDtoWithoutPatient toDtoWithoutPatient(Visit visit);

    @AfterMapping
    default void setHospitalDoctorPatientIds(@MappingTarget VisitResponseDto responseDto,
                                             Visit visit) {
        responseDto.setHospitalId(visit.getHospital().getId());
        responseDto.setDoctorId(visit.getDoctor().getId());
        responseDto.setPatientId(visit.getPatient().getId());
    }

    @AfterMapping
    default void setHospitalAndDoctor(@MappingTarget Visit visit,
                                          CreateVisitRequestDto requestDto) {
        Hospital hospital = new Hospital();
        hospital.setId(requestDto.getHospitalId());

        Doctor doctor = new Doctor();
        doctor.setId(requestDto.getDoctorId());
    }

    @AfterMapping
    default void setHospitalAndDoctorIds(@MappingTarget VisitResponseDtoWithoutPatient dto,
                                         Visit visit) {
        dto.setHospitalId(visit.getHospital().getId());
        dto.setDoctorId(visit.getDoctor().getId());
    }
}
