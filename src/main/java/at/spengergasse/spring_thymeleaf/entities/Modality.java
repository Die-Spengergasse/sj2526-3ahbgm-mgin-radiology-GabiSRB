package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "m_modalities")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="m_description")
    private String description;

    @Column(name="m_type")
    private String type;

    @Column(name="m_location")
    private String location;

    @OneToMany(mappedBy = "modality")
    List<ReservationTime> reservationTimes;
}
