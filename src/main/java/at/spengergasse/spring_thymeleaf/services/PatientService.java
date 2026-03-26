package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.PatientRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.mappers.PatientMapper;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public ResponseEntity<?> addPatient(Patient patient) {
        try {
            patientRepository.save(patient);
            return ResponseEntity.ok().body("Patient added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add patient: " + e.getMessage());
        }
    }

    public List<PatientRequest> getPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::PatientToPatientDTO) .toList();
    }
}
