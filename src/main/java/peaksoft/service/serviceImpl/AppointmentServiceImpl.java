package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;
import peaksoft.repo.AppointmentRepo;
import peaksoft.service.AppointmentService;

import java.util.List;
@Service//add this annotation
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private  final AppointmentRepo appointmentRepo;
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
