package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.repo.DepartmentRepo;
import peaksoft.service.DepartmentService;

import java.util.List;
@Service//add this annotation
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    @Override
    public void saveDepartment(Department department) {

    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    @Override
    public Department getById(Long id) {
        return null;
    }

    @Override
    public void updateDepartment(Long id, Department newDepartment) {

    }

    @Override
    public void deleteDepartment(Long id) {

    }
}
