package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.dto.PatientAddDTO;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import at.spengergasse.spring_thymeleaf.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/list")
    public String patients(Model model) {

        return "patlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
        return  patientService.addPatient(patient);
    }
}
