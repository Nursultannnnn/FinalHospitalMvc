package peaksoft.service;

import peaksoft.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    // Метод save принимает ID всех участников
    void saveAppointment(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment);

    List<Appointment> getAllAppointmentsByHospitalId(Long hospitalId);
    Appointment getById(Long id);
    void updateAppointment(Long id, Appointment newAppointment); // Можно упростить
    void deleteAppointment(Long id);
}