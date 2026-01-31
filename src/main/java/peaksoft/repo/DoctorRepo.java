package peaksoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;

import java.util.List;
@Repository
@Transactional
public interface DoctorRepo {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getById(Long id);
    void updateDoctor(Long id,Doctor newDoctor);
    void deleteDoctor(Long id);
}
