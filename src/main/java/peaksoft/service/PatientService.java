package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Patient;

import java.util.List;
@Repository
@Transactional
public interface PatientService {
    void savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getById(Long id);
    void updatePatient(Long id,Patient newPatient);
    void deletePatient(Long id);
}
