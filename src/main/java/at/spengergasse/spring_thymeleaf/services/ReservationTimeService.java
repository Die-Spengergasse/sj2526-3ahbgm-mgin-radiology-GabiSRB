package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.ReservationAddDTO;
import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import at.spengergasse.spring_thymeleaf.repositories.ModalityRepository;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import at.spengergasse.spring_thymeleaf.repositories.ReservationTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {
    private final ReservationTimeRepository reservationTimeRepository;
    private final ModalityRepository modalityRepository;
    private final PatientRepository patientRepository;

    public ResponseEntity<?> addReservationTime(ReservationAddDTO dto)
    {
        try {
            ReservationTime reservationTime = new ReservationTime();
            reservationTime.setReservationDate(dto.getReservationDate());
            reservationTime.setComment(dto.getComment());
            reservationTime.setModality(modalityRepository.findById(dto.getModality()).orElseThrow());
            reservationTime.setPatient(patientRepository.findById(dto.getPatient()).orElseThrow());
            reservationTime.setBodyRegion(dto.getBodyRegion());


            reservationTimeRepository.save(reservationTime);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
           return ResponseEntity.badRequest().body("Failed to save reservationTime: " + e.getMessage());
        }
    }
}
