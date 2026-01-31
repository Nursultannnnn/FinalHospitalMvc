package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Patient;
import peaksoft.repo.PatientRepo;
import peaksoft.service.PatientService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient getById(Long id) {
        return null;
    }

    @Override
    public void updatePatient(Long id, Patient newPatient) {

    }

    @Override
    public void deletePatient(Long id) {

    }
}
