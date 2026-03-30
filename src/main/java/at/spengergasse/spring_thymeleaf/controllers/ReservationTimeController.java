package at.spengergasse.spring_thymeleaf.controllers;
import at.spengergasse.spring_thymeleaf.dto.ReservationAddDTO;
import at.spengergasse.spring_thymeleaf.dto.ReservationDetailsDTO;
import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import at.spengergasse.spring_thymeleaf.services.ReservationTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationTimeController {
    private final ReservationTimeService reservationTimeService;

    @PostMapping("/add")
    public ResponseEntity<?> addReservation(@RequestBody ReservationAddDTO dto) {
        return reservationTimeService.addReservationTime(dto);
    }

    @GetMapping("/{modality}")
    public ResponseEntity<List<ReservationDetailsDTO>> getReservationTime(@PathVariable String modality) {
        return reservationTimeService.getModalityReservation(modality);
    }

}
