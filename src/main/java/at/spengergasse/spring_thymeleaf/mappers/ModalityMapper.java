package at.spengergasse.spring_thymeleaf.mappers;

import at.spengergasse.spring_thymeleaf.dto.ModalityRequest;
import at.spengergasse.spring_thymeleaf.entities.Modality;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModalityMapper {
    ModalityRequest toModalityRequest(Modality modality);
}
