package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Patient;
import peaksoft.repo.PatientRepo;

import java.util.List;
@Repository // <--- Добавлена аннотация
@Transactional // Желательно добавить транзакционность здесь или в сервисе
@RequiredArgsConstructor
public class PatientRepoImpl implements PatientRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient getById(Long id) {
        return null;
    }

    @Override
    public void updatePatient(Long id, Patient newPatient) {

    }

    @Override
    public void deletePatient(Long id) {

    }
}
