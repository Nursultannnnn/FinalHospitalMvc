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
        entityManager.persist(hospital);

    }

    @Override
    public List<Hospital> getAllHospitals() {
        return entityManager.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }

    @Override
    public Hospital getById(Long id) {
        return entityManager.find(Hospital.class, id);    }

    @Override
    public void updateHospital(Long id, Hospital newHospital) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        //hospital.setImage(newHospital.getImage());
        entityManager.merge(hospital);

    }

    @Override
    public void deleteHospital(Long id) {
        entityManager.remove(entityManager.find(Hospital.class, id));
    }
}
