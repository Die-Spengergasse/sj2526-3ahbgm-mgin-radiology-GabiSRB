package at.spengergasse.spring_thymeleaf.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record ModalityRequest (
       Integer id,
         String type,
         String description,
         String location
) {

}
