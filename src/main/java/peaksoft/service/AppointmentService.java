package peaksoft.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Appointment;

import java.util.List;
@Repository
@Transactional
public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getById(Long id);
    void updateAppointment(Long id,Appointment newAppointment);
    void deleteAppointment(Long id);
}
