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
        hospitalRepo.saveHospital(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.getAllHospitals();
    }

    @Override
    public Hospital getById(Long id) {
        return hospitalRepo.getById(id);    }

    @Override
    public void updateHospital(Long id, Hospital newHospital) {
        hospitalRepo.updateHospital(id, newHospital);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepo.deleteHospital(id);
    }
}
