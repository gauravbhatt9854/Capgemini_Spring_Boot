package com.example.bhatt.Photo.repository;

import com.example.bhatt.Photo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}