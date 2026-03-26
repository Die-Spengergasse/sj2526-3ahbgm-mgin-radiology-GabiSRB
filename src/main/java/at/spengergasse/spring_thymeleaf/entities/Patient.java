package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "p_patients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private Integer id;

    @Column(name="p_svnr", unique = true)
    private String svnr;

    @Column(name="p_surname")
    private String surname;

    @Column(name="p_firstname")
    private String firstname;

    @Column(name="p_birth")
    private LocalDate birth;

    @Column(name="p_gender")
    private Character gender;

    @OneToMany(mappedBy = "patient")
    private List<ReservationTime> reservationTimes = new ArrayList<>();



}
