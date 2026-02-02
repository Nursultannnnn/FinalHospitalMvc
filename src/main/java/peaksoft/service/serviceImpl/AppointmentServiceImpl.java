package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;
import peaksoft.repo.*;
import peaksoft.service.AppointmentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final HospitalRepo hospitalRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final DepartmentRepo departmentRepo;

    @Override
    public void saveAppointment(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment) {
        appointment.setHospital(hospitalRepo.getById(hospitalId));
        appointment.setPatient(patientRepo.getById(patientId));
        appointment.setDoctor(doctorRepo.getById(doctorId));
        appointment.setDepartment(departmentRepo.getById(departmentId));

        appointmentRepo.saveAppointment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointmentsByHospitalId(Long hospitalId) {
        return appointmentRepo.getAllAppointmentsByHospitalId(hospitalId);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepo.getById(id);
    }

    @Override
    public void updateAppointment(Long id, Appointment newAppointment) {
        appointmentRepo.updateAppointment(id, newAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepo.deleteAppointment(id);
    }
}