package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.repo.HospitalRepo;
import peaksoft.service.HospitalService;

import java.util.List;
@Service//add this annotation
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepo hospitalRepo;
    @Override
    public void saveHospital(Hospital hospital) {

    }

    @Override
    public List<Hospital> getAllHospitals() {
        return null;
    }

    @Override
    public Hospital getById(Long id) {
        return null;
    }

    @Override
    public void updateHospital(Long id, Hospital newHospital) {

    }

    @Override
    public void deleteHospital(Long id) {

    }
}
