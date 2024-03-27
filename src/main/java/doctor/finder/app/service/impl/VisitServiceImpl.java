package doctor.finder.app.service.impl;

import doctor.finder.app.dto.visit.CreateVisitRequestDto;
import doctor.finder.app.dto.visit.VisitResponseDto;
import doctor.finder.app.dto.visit.VisitResponseDtoWithoutPatient;
import doctor.finder.app.mapper.VisitMapper;
import doctor.finder.app.repository.VisitRepository;
import doctor.finder.app.service.VisitService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Override
    public VisitResponseDto save(CreateVisitRequestDto requestDto) {
        return visitMapper.toDto(
                visitRepository.save(
                        visitMapper.toModel(requestDto)));
    }

    @Override
    public VisitResponseDto saveByDoctor(CreateVisitRequestDto requestDto,
                                          UUID doctorId) throws IllegalAccessException {
        if (requestDto.getDoctorId().equals(doctorId)) {
            return visitMapper.toDto(
                    visitRepository.save(
                            visitMapper.toModel(requestDto)));
        }
        throw new IllegalAccessException(
                "You can create appointments only for your ID " + doctorId);
    }

    @Override
    public List<VisitResponseDto> getAll() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDto getById(Long id) {
        return visitMapper.toDto(visitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find the visit with ID " + id)));
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public List<VisitResponseDtoWithoutPatient> getAllVisitsWithoutPatients() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toDtoWithoutPatient)
                .collect(Collectors.toList());
    }

    @Override
    public List<VisitResponseDtoWithoutPatient> getAllVisitsByPatient(UUID patientId) {
        return visitRepository.findAllByPatientId(patientId).stream()
                .map(visitMapper::toDtoWithoutPatient)
                .collect(Collectors.toList());
    }
}
