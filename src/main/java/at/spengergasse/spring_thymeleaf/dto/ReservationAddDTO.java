package at.spengergasse.spring_thymeleaf.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record ReservationAddDTO (
         @NotNull
         Integer patient,
         @NotNull
         Integer modality,
         @NotBlank
         String bodyRegion,
         String comment,
         @FutureOrPresent(message = "Birth date must be in the Future or present")
         LocalDateTime reservationDate
){

}
