package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository; // Можно убрать, это лишнее в сервисе, но не критично
import peaksoft.entity.Doctor;

import java.util.List;

public interface DoctorService {
    // ВАЖНО: Мы передаем ID больницы и список ID отделений
    void saveDoctor(Long hospitalId, List<Long> departmentIds, Doctor doctor);

    List<Doctor> getAllDoctorsByHospitalId(Long hospitalId);

    List<Doctor> getAllDoctors();
    Doctor getById(Long id);

    // update тоже можно расширить, если нужно менять отделения
    void updateDoctor(Long id, Doctor newDoctor, List<Long> departmentIds);

    void deleteDoctor(Long id);
}