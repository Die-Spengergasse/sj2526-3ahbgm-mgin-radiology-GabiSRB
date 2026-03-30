package at.spengergasse.spring_thymeleaf.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModalityRequest {
    private Integer id;
    private String type;
    private String description;
    private String location;
}
