package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Hospital;
import peaksoft.repo.DepartmentRepo;
import peaksoft.repo.HospitalRepo;
import peaksoft.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo; // Нужно, чтобы найти больницу

    @Override
    public List<Department> getAllDepartmentByHospitalId(Long hospitalId) {
        return departmentRepo.getAllDepartmentByHospitalId(hospitalId);
    }

    // ВАЖНО: Мы сохраняем отделение ДЛЯ конкретной больницы
    public void saveDepartment(Long hospitalId, Department department) {
        Hospital hospital = hospitalRepo.getById(hospitalId);
        department.setHospital(hospital);

        // Валидация на уникальность имени (простая версия)
        // Можно добавить try-catch, если база данных выбросит ошибку
        departmentRepo.saveDepartment(department);
    }

    // Перегрузка метода из интерфейса (если он требует один аргумент)
    @Override
    public void saveDepartment(Department department) {
        // Этот метод лучше не использовать напрямую без ID больницы
        departmentRepo.saveDepartment(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.getAllDepartments();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepo.getById(id);
    }

    @Override
    public void updateDepartment(Long id, Department newDepartment) {
        departmentRepo.updateDepartment(id, newDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.deleteDepartment(id);
    }
}