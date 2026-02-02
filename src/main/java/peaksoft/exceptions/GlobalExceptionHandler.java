package peaksoft.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 1. Ловим наши ошибки (например, номер телефона)
    @ExceptionHandler(MyException.class)
    public String handleMyException(MyException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "errorPage"; // Открываем страницу errorPage.html
    }

    // 2. Ловим ошибки базы данных (дубликаты email или названий отделений)
    // Это закроет пункт 3-VI и 3-V
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDuplicate(DataIntegrityViolationException e, Model model) {
        // Проверяем текст ошибки, чтобы понять, что именно дублируется
        String msg = e.getMessage();

        if (msg != null && msg.contains("departments_name_key")) {
            model.addAttribute("errorMessage", "Department with this name already exists in database!");
        } else if (msg != null && msg.contains("doctors_email_key")) {
            model.addAttribute("errorMessage", "Doctor with this email already exists!");
        } else if (msg != null && msg.contains("patients_email_key")) {
            model.addAttribute("errorMessage", "Patient with this email already exists!");
        } else {
            model.addAttribute("errorMessage", "Database error: Duplicate value found.");
        }

        return "errorPage";
    }

    // 3. Ловим вообще все остальные ошибки (на всякий случай)
    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception e, Model model) {
        model.addAttribute("errorMessage", "Something went wrong: " + e.getMessage());
        return "errorPage";
    }
}