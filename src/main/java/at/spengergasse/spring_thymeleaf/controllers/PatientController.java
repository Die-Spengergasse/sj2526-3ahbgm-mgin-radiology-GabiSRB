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
    public ResponseEntity<List<PatientRequest>> patients() {
        return  ResponseEntity.ok().body(patientService.getPatients());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientAddRequest patient) {
        patientService.addPatient(patient);
        return ResponseEntity.ok().body("Patient added successfully");
    }
}
