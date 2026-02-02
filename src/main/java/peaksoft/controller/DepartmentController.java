package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Department;
import peaksoft.service.DepartmentService;
import peaksoft.service.HospitalService;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final HospitalService hospitalService; // Чтобы передать ID больницы в модель

    // Показать отделения конкретной больницы
    @GetMapping("/{hospitalId}")
    public String getDepartments(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("departments", departmentService.getAllDepartmentByHospitalId(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "departments";
    }

    // Форма добавления
    @GetMapping("/{hospitalId}/new")
    public String createDepartment(@PathVariable("hospitalId") Long hospitalId, Model model) {
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("hospitalId", hospitalId);
        return "newDepartment";
    }

    // Сохранение (Сюда мы добавим логику привязки к больнице)
    @PostMapping("/{hospitalId}/save")
    public String saveDepartment(@PathVariable("hospitalId") Long hospitalId,
                                 @ModelAttribute("newDepartment") Department department) {
        // Нам нужно вызвать метод, который привяжет больницу.
        // Но в интерфейсе у нас только saveDepartment(Department).
        // Давай сделаем хитро: найдем больницу тут или расширим сервис.
        // Лучший вариант - использовать сервис:
        // ((DepartmentServiceImpl) departmentService).saveDepartment(hospitalId, department);
        // Но правильнее найти больницу здесь:

        department.setHospital(hospitalService.getById(hospitalId));
        departmentService.saveDepartment(department);

        return "redirect:/departments/" + hospitalId;
    }

    @GetMapping("/delete/{hospitalId}/{id}")
    public String deleteDepartment(@PathVariable("hospitalId") Long hospitalId, @PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/departments/" + hospitalId;
    }

    @GetMapping("/edit/{hospitalId}/{id}")
    public String editDepartment(@PathVariable("hospitalId") Long hospitalId, @PathVariable("id") Long id, Model model) {
        model.addAttribute("department", departmentService.getById(id));
        model.addAttribute("hospitalId", hospitalId);
        return "editDepartment";
    }

    @PostMapping("/update/{hospitalId}/{id}")
    public String updateDepartment(@PathVariable("hospitalId") Long hospitalId,
                                   @PathVariable("id") Long id,
                                   @ModelAttribute("department") Department department) {
        departmentService.updateDepartment(id, department);
        return "redirect:/departments/" + hospitalId;
    }
}