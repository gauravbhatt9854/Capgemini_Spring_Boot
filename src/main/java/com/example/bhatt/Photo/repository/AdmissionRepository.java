package com.example.bhatt.Photo.repository;

import com.example.bhatt.Photo.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
}