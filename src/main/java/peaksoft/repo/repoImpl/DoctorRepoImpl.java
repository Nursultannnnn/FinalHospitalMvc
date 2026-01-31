package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctor;
import peaksoft.repo.DoctorRepo;

import java.util.List;
@Repository // <--- Добавлена аннотация
@Transactional // Желательно добавить транзакционность здесь или в сервисе
@RequiredArgsConstructor
public class DoctorRepoImpl implements DoctorRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void saveDoctor(Doctor doctor) {

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Doctor getById(Long id) {
        return null;
    }

    @Override
    public void updateDoctor(Long id, Doctor newDoctor) {

    }

    @Override
    public void deleteDoctor(Long id) {

    }
}
