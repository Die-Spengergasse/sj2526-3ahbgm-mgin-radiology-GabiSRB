package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "r_reservation_times")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="r_id")
    private Integer id;

    @Column(name="r_reservation_date")
    private LocalDateTime reservationDate;

    @ManyToOne
    @JoinColumn(name="r_p_id")
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name="p_m_description")
    private Modality modality;

}
