package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Appointment;
import peaksoft.service.AppointmentService;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorService;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final DepartmentService departmentService;

    @GetMapping("/{hospitalId}")
    public String getAllAppointments(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointmentsByHospitalId(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "appointments";
    }

    @GetMapping("/{hospitalId}/new")
    public String newAppointment(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("newAppointment", new Appointment());
        model.addAttribute("hospitalId", hospitalId);

        // Передаем списки для выбора в <select>
        model.addAttribute("doctors", doctorService.getAllDoctorsByHospitalId(hospitalId));
        model.addAttribute("patients", patientService.getAllPatientsByHospitalId(hospitalId));
        model.addAttribute("departments", departmentService.getAllDepartmentByHospitalId(hospitalId));

        return "newAppointment";
    }

    @PostMapping("/{hospitalId}/save")
    public String saveAppointment(@PathVariable("hospitalId") Long hospitalId,
                                  @ModelAttribute("newAppointment") Appointment appointment,
                                  @RequestParam("patientId") Long patientId,
                                  @RequestParam("doctorId") Long doctorId,
                                  @RequestParam("departmentId") Long departmentId) {

        appointmentService.saveAppointment(hospitalId, patientId, doctorId, departmentId, appointment);
        return "redirect:/appointments/" + hospitalId;
    }

    @GetMapping("/delete/{hospitalId}/{id}")
    public String deleteAppointment(@PathVariable("hospitalId") Long hospitalId, @PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments/" + hospitalId;
    }
}