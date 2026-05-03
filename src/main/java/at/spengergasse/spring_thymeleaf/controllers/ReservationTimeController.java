package at.spengergasse.spring_thymeleaf.controllers;
import at.spengergasse.spring_thymeleaf.dto.RequestPatientByModalityDTO;
import at.spengergasse.spring_thymeleaf.dto.ReservationAddDTO;
import at.spengergasse.spring_thymeleaf.dto.ReservationDetailsDTO;
import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import at.spengergasse.spring_thymeleaf.services.ReservationTimeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> addReservation(@Valid @RequestBody ReservationAddDTO dto) {
        reservationTimeService.addReservationTime(dto);
        return ResponseEntity.ok().body("Reservation has been added");
    }

    @PostMapping("/getPatients")
    public ResponseEntity<List<ReservationDetailsDTO>> getReservationTime(@RequestBody RequestPatientByModalityDTO modality) {
        return ResponseEntity.ok().body(reservationTimeService.getModalityReservation(modality));
    }

}
