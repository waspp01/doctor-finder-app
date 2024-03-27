package doctor.finder.app.controller;

import doctor.finder.app.dto.hospital.CreateHospitalRequestDto;
import doctor.finder.app.dto.hospital.HospitalResponseDto;
import doctor.finder.app.service.HospitalService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HospitalResponseDto createHospital(@RequestBody CreateHospitalRequestDto requestDto) {
        return hospitalService.save(requestDto);
    }

    @GetMapping("/{id}")
    public HospitalResponseDto getHospitalById(@PathVariable Long id) {
        return hospitalService.findById(id);
    }

    @GetMapping
    public List<HospitalResponseDto> getAllHospitals() {
        return hospitalService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalById(@PathVariable Long id) {
        hospitalService.deleteById(id);
    }

    @PutMapping("/{id}")
    public HospitalResponseDto updateHospitalById(
            @PathVariable Long id,
            @RequestBody CreateHospitalRequestDto requestDto) {
        return hospitalService.update(id, requestDto);
    }
}
