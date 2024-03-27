package doctor.finder.app.service.impl;

import doctor.finder.app.dto.hospital.CreateHospitalRequestDto;
import doctor.finder.app.dto.hospital.HospitalResponseDto;
import doctor.finder.app.mapper.AddressMapper;
import doctor.finder.app.mapper.HospitalMapper;
import doctor.finder.app.model.Address;
import doctor.finder.app.model.Hospital;
import doctor.finder.app.repository.AddressRepository;
import doctor.finder.app.repository.HospitalRepository;
import doctor.finder.app.service.HospitalService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public HospitalResponseDto findById(Long id) {
        return hospitalMapper.toDto(
                        hospitalRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException(
                                        "Wrong hospital id " + id)));
    }

    @Override
    public HospitalResponseDto save(CreateHospitalRequestDto createHospitalRequestDto) {
        Address address = new Address();
        address.setCountry(createHospitalRequestDto.getCountry());
        address.setCity(createHospitalRequestDto.getCity());
        address.setPostalCode(createHospitalRequestDto.getPostalCode());
        address.setStreet(createHospitalRequestDto.getStreet());
        address.setHouseNumber(createHospitalRequestDto.getHouseNumber());
        Long addressId = addressRepository.save(address).getId();
        createHospitalRequestDto.setAddressId(addressId);

        return hospitalMapper.toDto(
                hospitalRepository.save(
                hospitalMapper.toModel(createHospitalRequestDto)));
    }

    @Override
    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public List<HospitalResponseDto> findAll() {
        return hospitalRepository.findAll().stream()
                .map(hospitalMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HospitalResponseDto update(Long id, CreateHospitalRequestDto requestDto) {
        Hospital hospital = hospitalMapper.toModel(requestDto);
        hospital.setId(id);
        return hospitalMapper.toDto(hospitalRepository.save(hospital));
    }
}
