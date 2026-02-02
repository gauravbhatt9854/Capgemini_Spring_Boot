package com.example.bhatt.Photo.entity;


import com.example.bhatt.Photo.utils.Course;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private Course courseName;
    private Long fees;

    @OneToOne(mappedBy = "admission")
    private  Student student;
}
