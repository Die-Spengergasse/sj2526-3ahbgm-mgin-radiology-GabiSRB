package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.ModalityRequest;
import at.spengergasse.spring_thymeleaf.entities.Modality;
import at.spengergasse.spring_thymeleaf.mappers.ModalityMapper;
import at.spengergasse.spring_thymeleaf.repositories.ModalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModalityService {
    private final ModalityRepository modalityRepository;
    private final ModalityMapper modalityMapper;

    public List<ModalityRequest> getModalities() {
        return modalityRepository.findAll().stream().map(modalityMapper::toModalityRequest).toList();
    }
}
