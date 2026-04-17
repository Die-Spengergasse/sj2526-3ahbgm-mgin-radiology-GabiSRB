package at.spengergasse.spring_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public record PatientRequest (
         Integer id,
         String firstname,
         String surname,
         String gender,
         LocalDate birth,
         String svnr
) {


}
