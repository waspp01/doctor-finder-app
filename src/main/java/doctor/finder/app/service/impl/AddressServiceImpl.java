package doctor.finder.app.service.impl;

import doctor.finder.app.dto.address.AddressResponseDto;
import doctor.finder.app.dto.address.CreateAddressRequestDto;
import doctor.finder.app.mapper.AddressMapper;
import doctor.finder.app.repository.AddressRepository;
import doctor.finder.app.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponseDto findById(Long id) {
        return addressMapper.toDto(addressRepository.findById(id).orElseThrow());
    }

    @Override
    public AddressResponseDto save(CreateAddressRequestDto requestDto) {
        return addressMapper.toDto(
                addressRepository.save(
                        addressMapper.toModel(requestDto)));
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
