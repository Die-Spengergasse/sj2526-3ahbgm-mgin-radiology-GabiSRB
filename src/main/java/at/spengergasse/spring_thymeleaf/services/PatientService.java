package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.PatientAddRequest;
import at.spengergasse.spring_thymeleaf.dto.PatientRequest;
import at.spengergasse.spring_thymeleaf.exceptionHandler.SomeValidationException;
import at.spengergasse.spring_thymeleaf.mappers.PatientMapper;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public ResponseEntity<?> addPatient(PatientAddRequest patient) {
            if(patientRepository.existsBySvnr(patient.svnr())) {
                throw new SomeValidationException(Map.of("svnr","Patient with SVNR " + patient.svnr() + " already exists"));
            }
            patientRepository.save(patientMapper.toEntity(patient));
            return ResponseEntity.ok().body("Patient added successfully");

    }

    public List<PatientRequest> getPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::PatientToPatientDTO) .toList();
    }
}
