package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Hospital;
import peaksoft.repo.HospitalRepo;

import java.util.List;
@Repository // <--- Добавлена аннотация
@Transactional // Желательно добавить транзакционность здесь или в сервисе
@RequiredArgsConstructor
public class HospitalRepoImpl implements HospitalRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void saveHospital(Hospital hospital) {

    }

    @Override
    public List<Hospital> getAllHospitals() {
        return null;
    }

    @Override
    public Hospital getById(Long id) {
        return null;
    }

    @Override
    public void updateHospital(Long id, Hospital newHospital) {

    }

    @Override
    public void deleteHospital(Long id) {

    }
}
