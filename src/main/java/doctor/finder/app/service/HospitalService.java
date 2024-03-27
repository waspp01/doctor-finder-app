package doctor.finder.app.service;

import doctor.finder.app.dto.hospital.CreateHospitalRequestDto;
import doctor.finder.app.dto.hospital.HospitalResponseDto;
import java.util.List;

public interface HospitalService {
    HospitalResponseDto findById(Long id);

    HospitalResponseDto save(CreateHospitalRequestDto createHospitalRequestDto);

    void deleteById(Long id);

    List<HospitalResponseDto> findAll();

    HospitalResponseDto update(Long id, CreateHospitalRequestDto requestDto);

    //   todo: change all to DTOs
    //   List<Doctor> getAllDoctorsByHospital(Long hospitalId);
    //
    //   List<Visit> getAllFreeVisitsByDoctor(Long doctorId);
    //
    //  List<Visit> getAllFreeVisitsByDoctorByDate(Long doctorId, LocalDate date);
}
