package com.example.bhatt.Photo.repository;

import com.example.bhatt.Photo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}