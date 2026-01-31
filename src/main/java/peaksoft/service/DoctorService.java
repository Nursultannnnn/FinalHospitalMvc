package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctor;

import java.util.List;
@Repository
@Transactional
public interface DoctorService {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getById(Long id);
    void updateDoctor(Long id,Doctor newDoctor);
    void deleteDoctor(Long id);
}
