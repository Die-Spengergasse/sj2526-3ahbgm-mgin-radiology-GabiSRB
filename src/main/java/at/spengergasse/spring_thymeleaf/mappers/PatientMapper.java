package at.spengergasse.spring_thymeleaf.mappers;

import at.spengergasse.spring_thymeleaf.dto.PatientAddRequest;
import at.spengergasse.spring_thymeleaf.dto.PatientRequest;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientRequest PatientToPatientDTO(Patient patient);

    Patient toEntity(PatientAddRequest patient);
}
