package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    boolean existsBySvnr(String svnr);

    @Query("""
        SELECT CASE WHEN COUNT(rt) > 0 THEN true ELSE false END
        FROM ReservationTime rt
        WHERE rt.modality = :patient
          AND rt.reservationDate < :newEnd
          AND rt.reservationDate > :newStartMinusOneHour
    """)
    boolean existsByPatientAndReservationDate(Patient patient, @FutureOrPresent LocalDateTime newEnd,  @FutureOrPresent LocalDateTime newStartMinusOneHour);
}
