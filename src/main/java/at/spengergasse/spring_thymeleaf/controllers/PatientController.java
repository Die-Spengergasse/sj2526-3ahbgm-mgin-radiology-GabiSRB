package at.spengergasse.spring_thymeleaf.controllers;
import at.spengergasse.spring_thymeleaf.dto.PatientAddRequest;
import at.spengergasse.spring_thymeleaf.dto.PatientRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/getAll")
    public List<PatientRequest> patients() {
        return  patientService.getPatients();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@Valid @RequestBody PatientAddRequest patient) {
        return  patientService.addPatient(patient);
    }
}
