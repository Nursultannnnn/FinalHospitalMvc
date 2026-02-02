package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.entity.Patient;
import peaksoft.exceptions.MyException; // <-- Импорт
import peaksoft.repo.HospitalRepo;
import peaksoft.repo.PatientRepo;
import peaksoft.service.PatientService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public void savePatient(Long hospitalId, Patient patient) {
        // УСЛОВИЕ 3-III: Проверка номера +996
        if (!patient.getPhoneNumber().startsWith("+996")) {
            // Кидаем НАШУ ошибку
            throw new MyException("Phone number must start with +996 (e.g., +996700123456)");
        }
        // Длина номера (опционально, но полезно)
        if (patient.getPhoneNumber().length() != 13) {
            throw new MyException("Phone number length must be 13 symbols!");
        }

        Hospital hospital = hospitalRepo.getById(hospitalId);
        patient.setHospital(hospital);
        patientRepo.savePatient(patient);
    }

    // ... остальные методы без изменений, кроме updatePatient

    @Override
    public void updatePatient(Long id, Patient newPatient) {
        if (!newPatient.getPhoneNumber().startsWith("+996")) {
            throw new MyException("Phone number must start with +996");
        }
        patientRepo.updatePatient(id, newPatient);
    }

    @Override
    public List<Patient> getAllPatientsByHospitalId(Long hospitalId) {
        return patientRepo.getAllPatientsByHospitalId(hospitalId);
    }

    @Override
    public Patient getById(Long id) {
        return patientRepo.getById(id);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepo.deletePatient(id);
    }
}