package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;
import peaksoft.entity.Hospital;
import peaksoft.repo.DepartmentRepo;
import peaksoft.repo.DoctorRepo;
import peaksoft.repo.HospitalRepo;
import peaksoft.service.DoctorService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;
    private final DepartmentRepo departmentRepo;

    @Override
    public void saveDoctor(Long hospitalId, List<Long> departmentIds, Doctor doctor) {
        // 1. Находим больницу и назначаем доктору
        Hospital hospital = hospitalRepo.getById(hospitalId);
        doctor.setHospital(hospital);

        // 2. Находим все выбранные отделения по их ID
        List<Department> departments = new ArrayList<>();
        if (departmentIds != null) {
            for (Long deptId : departmentIds) {
                departments.add(departmentRepo.getById(deptId));
            }
        }
        // 3. Назначаем отделения доктору
        doctor.setDepartments(departments);

        // 4. Сохраняем (валидацию email можно добавить тут)
        doctorRepo.saveDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long hospitalId) {
        return doctorRepo.getAllDoctorsByHospitalId(hospitalId);
    }

    @Override
    public void updateDoctor(Long id, Doctor newDoctor, List<Long> departmentIds) {
        Doctor doctor = doctorRepo.getById(id);

        // Обновляем простые поля через репо (или вручную тут)
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setEmail(newDoctor.getEmail());

        // Обновляем список отделений
        List<Department> departments = new ArrayList<>();
        if (departmentIds != null) {
            for (Long deptId : departmentIds) {
                departments.add(departmentRepo.getById(deptId));
            }
        }
        doctor.setDepartments(departments);

        doctorRepo.saveDoctor(doctor); // merge сработает так же
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepo.deleteDoctor(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.getAllDoctors();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepo.getById(id);
    }

    // Заглушка для старого метода saveDoctor, если он где-то используется
    public void saveDoctor(Doctor doctor) {
        doctorRepo.saveDoctor(doctor);
    }
}