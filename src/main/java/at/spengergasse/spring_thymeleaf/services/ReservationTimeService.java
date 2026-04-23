package at.spengergasse.spring_thymeleaf.services;

import at.spengergasse.spring_thymeleaf.dto.RequestPatientByModalityDTO;
import at.spengergasse.spring_thymeleaf.dto.ReservationAddDTO;
import at.spengergasse.spring_thymeleaf.dto.ReservationDetailsDTO;
import at.spengergasse.spring_thymeleaf.entities.Modality;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import at.spengergasse.spring_thymeleaf.exceptionHandler.SomeValidationException;
import at.spengergasse.spring_thymeleaf.repositories.ModalityRepository;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import at.spengergasse.spring_thymeleaf.repositories.ReservationTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {
    private final ReservationTimeRepository reservationTimeRepository;
    private final ModalityRepository modalityRepository;
    private final PatientRepository patientRepository;

    public ResponseEntity<?> addReservationTime(ReservationAddDTO dto)
    {
        Map<String, String> errors = new HashMap<>();
            Patient patient = patientRepository.findById(dto.patient()).orElseThrow();
            Modality modality = modalityRepository.findById(dto.modality()).orElseThrow();

            if(reservationTimeRepository.existsByModalityAndReservationDate(modality, dto.reservationDate().plusHours(2), dto.reservationDate().minusHours(2))) {
              errors.put("modality","This modality is already reserved at the given time. Please choose a different time or modality.");
            }

            if(reservationTimeRepository.existsByPatientAndReservationDate(patient, dto.reservationDate().plusHours(2), dto.reservationDate().minusHours(2))){
              errors.put("patient","This patient already has a reservation at the given time. Please choose a different time.");
            }

            if(!errors.isEmpty())
            {
                throw new SomeValidationException(errors);
            }
            ReservationTime reservationTime = new ReservationTime();
            reservationTime.setReservationDate(dto.reservationDate());
            reservationTime.setComment(dto.comment());
            reservationTime.setModality(modality);
            reservationTime.setPatient(patient);
            reservationTime.setBodyRegion(dto.bodyRegion());


            reservationTimeRepository.save(reservationTime);
            return ResponseEntity.ok().build();

    }

    public ResponseEntity<List<ReservationDetailsDTO>> getModalityReservation(RequestPatientByModalityDTO modality) {
        try {
            List<ReservationDetailsDTO> reservationDetails = reservationTimeRepository.findByModalityWithLocation(modality.type(),modality.location())
                    .stream()
                    .map(reservationTime -> new ReservationDetailsDTO(reservationTime.getPatient().getFirstname() + " " + reservationTime.getPatient().getSurname(),
                            reservationTime.getPatient().getSvnr(),
                            reservationTime.getBodyRegion(),
                            reservationTime.getComment(),
                         reservationTime.getReservationDate().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                    ))
                    .sorted((java.util.Comparator.comparing(ReservationDetailsDTO::date)))
                    .toList();
            return ResponseEntity.ok(reservationDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
