package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Hospital;

import java.util.List;
@Repository
@Transactional
public interface HospitalService {
    void saveHospital (Hospital hospital);
    List<Hospital> getAllHospitals();
    Hospital getById(Long id);
    void updateHospital(Long id,Hospital newHospital);
    void deleteHospital(Long id);
}
