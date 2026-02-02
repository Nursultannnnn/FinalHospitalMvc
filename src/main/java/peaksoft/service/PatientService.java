package peaksoft.service;

import peaksoft.entity.Patient;
import java.util.List;

public interface PatientService {
    // Изменили сигнатуру, чтобы принимать ID больницы
    void savePatient(Long hospitalId, Patient patient);

    List<Patient> getAllPatientsByHospitalId(Long hospitalId);
    Patient getById(Long id);
    void updatePatient(Long id, Patient newPatient);
    void deletePatient(Long id);
}