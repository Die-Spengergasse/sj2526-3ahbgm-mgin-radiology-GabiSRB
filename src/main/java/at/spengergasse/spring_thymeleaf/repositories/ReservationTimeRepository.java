package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.Modality;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface ReservationTimeRepository extends JpaRepository<ReservationTime, Integer> {
    Collection<ReservationTime> findByModality_Type(String modality);

    @Query("""
        SELECT rt FROM ReservationTime rt
        JOIN FETCH rt.patient
        JOIN FETCH rt.modality
        WHERE rt.modality.type = :modality and rt.modality.location = :location
        """)
    List<ReservationTime> findByModalityWithLocation(@Param("modality") String modality, @Param("location") String location);

    @Query("""
        SELECT CASE WHEN COUNT(rt) > 0 THEN true ELSE false END
        FROM ReservationTime rt
        WHERE rt.modality = :modality
          AND rt.reservationDate < :newEnd
          AND rt.reservationDate > :newStartMinusOneHour
    """)
    boolean existsByModalityAndReservationDate(Modality modality, @FutureOrPresent LocalDateTime newEnd, @FutureOrPresent LocalDateTime newStartMinusOneHour);

    @Query("""
        SELECT CASE WHEN COUNT(rt) > 0 THEN true ELSE false END
        FROM ReservationTime rt
        WHERE rt.patient = :patient
          AND rt.reservationDate < :newEnd
          AND rt.reservationDate > :newStartMinusOneHour
    """)
    boolean existsByPatientAndReservationDate(Patient patient, @FutureOrPresent LocalDateTime newEnd, @FutureOrPresent LocalDateTime newStartMinusOneHour);

}
