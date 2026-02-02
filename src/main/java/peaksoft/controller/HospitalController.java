package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Hospital;
import peaksoft.service.HospitalService;

@Controller
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    // Показать все больницы
    @GetMapping
    public String getAllHospitals(Model model) {
        model.addAttribute("hospitals", hospitalService.getAllHospitals());
        return "hospitals";
    }

    // Форма создания
    @GetMapping("/new")
    public String createHospital(Model model) {
        model.addAttribute("newHospital", new Hospital());
        return "newHospital";
    }

    // Сохранение
    @PostMapping("/save")
    public String saveHospital(@ModelAttribute("newHospital") Hospital hospital) {
        hospitalService.saveHospital(hospital);
        return "redirect:/hospitals";
    }

    // Удаление
    @GetMapping("/delete/{id}")
    public String deleteHospital(@PathVariable("id") Long id) {
        hospitalService.deleteHospital(id);
        return "redirect:/hospitals";
    }

    // Форма редактирования
    @GetMapping("/edit/{id}")
    public String editHospital(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hospital", hospitalService.getById(id));
        return "editHospital";
    }

    // Обновление
    @PostMapping("/update/{id}")
    public String updateHospital(@PathVariable("id") Long id, @ModelAttribute("hospital") Hospital hospital) {
        hospitalService.updateHospital(id, hospital);
        return "redirect:/hospitals";
    }

    // Страница конкретной больницы (Дашборд)
    @GetMapping("/{id}")
    public String getHospitalById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hospital", hospitalService.getById(id));
        return "hospitalById"; // Мы сейчас создадим этот файл
    }

    // Страница деталей больницы (Дашборд) - сделаем чуть позже
    // @GetMapping("/{id}") ...
}