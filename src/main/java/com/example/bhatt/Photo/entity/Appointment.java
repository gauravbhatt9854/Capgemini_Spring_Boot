package com.example.bhatt.Photo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problem;

    @ManyToOne()
    @JoinColumn(name = "patients_id")
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name = "doctors_id")
    private Doctor doctor;
}
