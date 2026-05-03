package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.PatientAddRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.exceptionHandler.SomeValidationException;
import at.spengergasse.spring_thymeleaf.mappers.PatientMapper;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
    @Mock
    private PatientMapper patientMapper;

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    void addPatient_shouldSavePatient_whenSvnrDoesNotExist() {
        PatientAddRequest request = new PatientAddRequest(
                "123456789",
                "Mustermann",
                "Max",
                LocalDate.of(1990, 1, 1),
                "M"
        );
        Patient patient = new Patient();
        when(patientRepository.existsBySvnr(request.svnr())).thenReturn(false);
        when(patientMapper.toEntity(request)).thenReturn(patient);

        patientService.addPatient(request);
        then(patientRepository).should().save(patient);
    }

    @Test
    void addPatient_shouldThrowException_whenSvnrAlreadyExists() {
        PatientAddRequest request = new PatientAddRequest(
                "123456789",
                "Mustermann",
                "Max",
                LocalDate.of(1990, 1, 1),
                "M"
        );
        when(patientRepository.existsBySvnr(request.svnr())).thenReturn(true);

        assertThrows(SomeValidationException.class, () -> patientService.addPatient(request));
        then(patientRepository).should(never()).save(any());
    }
}