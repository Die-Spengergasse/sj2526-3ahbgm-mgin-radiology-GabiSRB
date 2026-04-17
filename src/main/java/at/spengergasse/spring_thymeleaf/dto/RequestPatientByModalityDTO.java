package at.spengergasse.spring_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public record RequestPatientByModalityDTO (
        String type,
        String location

) {

}
