package at.spengergasse.spring_thymeleaf.dto;

import at.spengergasse.spring_thymeleaf.customAnnotations.ValidSVNR;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record PatientAddRequest(
         @ValidSVNR
         String svnr,
         @NotBlank
         String surname,
         @NotBlank
         String firstname,
         @NotNull
         @PastOrPresent(message = "Birth date must be in the past or present")
         LocalDate birth,
         @NotBlank
         @Pattern(regexp = "^([mfd])$", message = "Gender must be Male, Female or Divers")
         String gender
) {
}
