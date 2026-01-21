package com.example.bhatt.Photo.service;
import com.example.bhatt.Photo.dto.NewUser;
import com.example.bhatt.Photo.dto.StudentDto;
import com.example.bhatt.Photo.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getOneStudent(Long id);
    StudentDto createNewStudent(NewUser newUser);
    StudentDto deleteUser(Long id);
    StudentDto updateUser(Long id , NewUser newUser);
    StudentDto partialUpdate(Long id , Map<String , Object> map);
    Student getStudent(Long id);
    Student getByName(String name);
    Student getByEmail(String name);
    List<StudentDto> getByAge(byte age);

}
