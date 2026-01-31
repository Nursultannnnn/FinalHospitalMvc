package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Appointment;
import peaksoft.repo.AppointmentRepo;

import java.util.List;
@Repository // <--- Добавлена аннотация
@Transactional // Желательно добавить транзакционность здесь или в сервисе
@RequiredArgsConstructor
public class AppointmentRepoImpl implements AppointmentRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void saveAppointment(Appointment appointment) {

    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public Appointment getById(Long id) {
        return null;
    }

    @Override
    public void updateAppointment(Long id, Appointment newAppointment) {

    }

    @Override
    public void deleteAppointment(Long id) {

    }
}
