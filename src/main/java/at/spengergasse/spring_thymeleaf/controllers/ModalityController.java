package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.dto.ModalityRequest;
import at.spengergasse.spring_thymeleaf.entities.Modality;
import at.spengergasse.spring_thymeleaf.services.ModalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/modalities")
@RequiredArgsConstructor
public class ModalityController {
    private final ModalityService modalityService;

    @GetMapping("/getAll")
    public List<ModalityRequest> getModalities() {
        return modalityService.getModalities();
    }
}
