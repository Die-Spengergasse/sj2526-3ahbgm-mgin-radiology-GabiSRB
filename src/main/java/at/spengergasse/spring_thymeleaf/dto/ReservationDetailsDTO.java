package at.spengergasse.spring_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetailsDTO {
    private String patientname;
    private String patientsvnr;
    private String bodyregion;
    private String comment;
    private String date;

}
