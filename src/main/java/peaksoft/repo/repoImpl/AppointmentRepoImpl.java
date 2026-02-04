package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Appointment;
import peaksoft.repo.AppointmentRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class AppointmentRepoImpl implements AppointmentRepo {

    @PersistenceContext
    private final EntityManager entityManager;

//    @Override
//    public void saveAppointment(Appointment appointment) {
//        entityManager.persist(appointment);
//    }
@Override
public void saveAppointment(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment) {



}
    @Override
    public List<Appointment> getAllAppointmentsByHospitalId(Long hospitalId) {
        // УСЛОВИЕ 3-II: Сортировка (новые сверху) - "order by a.id desc"
        return entityManager.createQuery(
                        "select a from Appointment a where a.hospital.id = :id order by a.id desc", Appointment.class)
                .setParameter("id", hospitalId)
                .getResultList();
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return entityManager.createQuery("select a from Appointment a", Appointment.class).getResultList();
    }

    @Override
    public Appointment getById(Long id) {
        return entityManager.find(Appointment.class, id);
    }

    @Override
    public void updateAppointment(Long id, Appointment newAppointment) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        appointment.setDate(newAppointment.getDate());
        appointment.setPatient(newAppointment.getPatient());
        appointment.setDoctor(newAppointment.getDoctor());
        appointment.setDepartment(newAppointment.getDepartment());
        entityManager.merge(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        entityManager.remove(entityManager.find(Appointment.class, id));
    }
}