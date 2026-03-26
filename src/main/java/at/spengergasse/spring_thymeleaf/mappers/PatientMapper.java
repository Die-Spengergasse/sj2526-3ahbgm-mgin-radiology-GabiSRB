package at.spengergasse.spring_thymeleaf.mappers;

import at.spengergasse.spring_thymeleaf.dto.PatientRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient PatientDtoToPatient(PatientRequest patient);
    PatientRequest PatientToPatientDTO(Patient patient);
}
