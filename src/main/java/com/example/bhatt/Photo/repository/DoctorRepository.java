package com.example.bhatt.Photo.repository;

import com.example.bhatt.Photo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}