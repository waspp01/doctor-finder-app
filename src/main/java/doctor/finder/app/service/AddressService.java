package doctor.finder.app.service;

import doctor.finder.app.dto.address.AddressResponseDto;
import doctor.finder.app.dto.address.CreateAddressRequestDto;

public interface AddressService {
    AddressResponseDto findById(Long id);

    AddressResponseDto save(CreateAddressRequestDto requestDto);

    void deleteById(Long id);
}
