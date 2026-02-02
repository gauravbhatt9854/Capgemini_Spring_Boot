package com.example.bhatt.Photo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Data
@Table(
        name = "student_table",
        indexes = {
                @Index(name = "email_indxex", columnList = "email")
        },
        uniqueConstraints = @UniqueConstraint(
            name ="email constraint",columnNames ={"email"}
        )
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private byte age;

    @OneToOne
    @JoinColumn(name = "students_admission_id")
    private Admission admission;
}
