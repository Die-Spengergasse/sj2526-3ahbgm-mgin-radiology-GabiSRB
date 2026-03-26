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
public class ReservationAddDTO {
    private Integer patient;
    private Integer modality;
    private String bodyRegion;
    private String comment;
    private LocalDateTime reservationDate;
}
