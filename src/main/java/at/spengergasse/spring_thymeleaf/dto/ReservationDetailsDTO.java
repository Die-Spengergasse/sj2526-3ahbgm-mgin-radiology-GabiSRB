package at.spengergasse.spring_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record ReservationDetailsDTO (
         String patientname,
         String patientsvnr,
         String bodyregion,
         String comment,
         String date

){
}
