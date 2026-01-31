package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Department;
import peaksoft.repo.DepartmentRepo;

import java.util.List;
@Repository // <--- Добавлена аннотация
@Transactional // Желательно добавить транзакционность здесь или в сервисе
@RequiredArgsConstructor
public class DepartmentRepoImpl implements DepartmentRepo {
    @PersistenceContext
    private final EntityManager entityManager;

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
