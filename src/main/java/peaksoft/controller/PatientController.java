package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Patient;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // ДОБАВИЛ ("hospitalId") везде в @PathVariable

    @GetMapping("/{hospitalId}")
    public String getAllPatients(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("patients", patientService.getAllPatientsByHospitalId(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "patients";
    }

    @GetMapping("/{hospitalId}/new")
    public String newPatient(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("hospitalId", hospitalId);
        return "newPatient";
    }

    @PostMapping("/{hospitalId}/save")
    public String savePatient(@PathVariable("hospitalId") Long hospitalId, @ModelAttribute("newPatient") Patient patient) {
            patientService.savePatient(hospitalId, patient);
        return "redirect:/patients/" + hospitalId;
    }

    @GetMapping("/edit/{hospitalId}/{id}")
    public String editPatient(@PathVariable("hospitalId") Long hospitalId,
                              @PathVariable("id") Long id,
                              Model model) {
        model.addAttribute("patient", patientService.getById(id));
        model.addAttribute("hospitalId", hospitalId);
        return "editPatient";
    }

    @PostMapping("/update/{hospitalId}/{id}")
    public String updatePatient(@PathVariable("hospitalId") Long hospitalId,
                                @PathVariable("id") Long id,
                                @ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(id, patient);
        return "redirect:/patients/" + hospitalId;
    }

    @GetMapping("/delete/{hospitalId}/{id}")
    public String deletePatient(@PathVariable("hospitalId") Long hospitalId,
                                @PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients/" + hospitalId;
    }
}