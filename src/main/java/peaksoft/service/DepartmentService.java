package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;

import java.util.List;
@Repository
@Transactional
public interface DepartmentService {
    void saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getById(Long id);
    void updateDepartment(Long id,Department newDepartment);
    void deleteDepartment(Long id);
}
