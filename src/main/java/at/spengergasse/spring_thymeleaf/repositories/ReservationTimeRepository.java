package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.ReservationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReservationTimeRepository extends JpaRepository<ReservationTime, Integer> {
    Collection<ReservationTime> findByModality_Type(String modality);

    @Query("""
        SELECT rt FROM ReservationTime rt
        JOIN FETCH rt.patient
        JOIN FETCH rt.modality
        WHERE rt.modality.type = :modality
        """)
    List<ReservationTime> findByModalityWithPatient(@Param("modality") String modality);
}
