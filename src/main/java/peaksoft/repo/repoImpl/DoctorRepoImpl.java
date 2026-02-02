package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Doctor;
import peaksoft.repo.DoctorRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class DoctorRepoImpl implements DoctorRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveDoctor( Doctor doctor) {
        entityManager.persist(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return entityManager.createQuery("select d from Doctor d", Doctor.class).getResultList();
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long hospitalId) {
        return entityManager.createQuery(
                        "select d from Doctor d where d.hospital.id = :hospitalId", Doctor.class)
                .setParameter("hospitalId", hospitalId)
                .getResultList();
    }

    @Override
    public Doctor getById(Long id) {
        return entityManager.find(Doctor.class, id);
    }

    @Override
    public void updateDoctor(Long id, Doctor newDoctor) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setEmail(newDoctor.getEmail());
        // Отделения обновляются отдельно в сервисе
        entityManager.merge(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        entityManager.remove(entityManager.find(Doctor.class, id));
    }
}