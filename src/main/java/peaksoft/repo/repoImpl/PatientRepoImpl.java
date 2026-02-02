package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Patient;
import peaksoft.repo.PatientRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PatientRepoImpl implements PatientRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void savePatient(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public List<Patient> getAllPatientsByHospitalId(Long hospitalId) {
        return entityManager.createQuery("select p from Patient p where p.hospital.id = :id", Patient.class)
                .setParameter("id", hospitalId)
                .getResultList();
    }

    @Override
    public List<Patient> getAllPatients() {
        return entityManager.createQuery("select p from Patient p", Patient.class).getResultList();
    }

    @Override
    public Patient getById(Long id) {
        return entityManager.find(Patient.class, id);
    }

    @Override
    public void updatePatient(Long id, Patient newPatient) {
        Patient patient = entityManager.find(Patient.class, id);
        patient.setFirstName(newPatient.getFirstName());
        patient.setLastName(newPatient.getLastName());
        patient.setPhoneNumber(newPatient.getPhoneNumber());
        patient.setGender(newPatient.getGender());
        patient.setEmail(newPatient.getEmail());
        entityManager.merge(patient);
    }

    @Override
    public void deletePatient(Long id) {
        entityManager.remove(entityManager.find(Patient.class, id));
    }
}