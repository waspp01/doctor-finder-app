package doctor.finder.app.service;

import doctor.finder.app.dto.visit.CreateVisitRequestDto;
import doctor.finder.app.dto.visit.VisitResponseDto;
import doctor.finder.app.dto.visit.VisitResponseDtoWithoutPatient;
import java.util.List;
import java.util.UUID;

public interface VisitService {
    VisitResponseDto save(CreateVisitRequestDto requestDto);

    VisitResponseDto saveByDoctor(CreateVisitRequestDto requestDto,
                                   UUID doctorId) throws IllegalAccessException;

    List<VisitResponseDto> getAll();

    VisitResponseDto getById(Long id);

    void deleteById(Long id);

    List<VisitResponseDtoWithoutPatient> getAllVisitsWithoutPatients();

    List<VisitResponseDtoWithoutPatient> getAllVisitsByPatient(UUID patientId);
}
