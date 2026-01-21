package com.example.bhatt.Photo.repository;

import com.example.bhatt.Photo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    Student findByName(String name);
    List<Student> findByAgeLessThan(byte age);

    @Query("select s from Student s where s.email= ?1")
    Student findByEmailAddress(@Param("email") String email);

}
