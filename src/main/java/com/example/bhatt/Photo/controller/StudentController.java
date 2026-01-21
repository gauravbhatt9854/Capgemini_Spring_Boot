package com.example.bhatt.Photo.controller;
import com.example.bhatt.Photo.dto.StudentDto;
import com.example.bhatt.Photo.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bhatt.Photo.dto.NewUser;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentServiceImpl studentServiceimpl;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok(studentServiceimpl.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentServiceimpl.getOneStudent(id));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> registerUser(@RequestBody @Valid NewUser newUser) {
        System.out.println("inside the controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(studentServiceimpl.createNewStudent(newUser));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<StudentDto> deleteUser(@PathVariable Long id) {
        System.out.println("path variable " + id);
        return ResponseEntity.status(HttpStatus.OK).body(studentServiceimpl.deleteUser(id));
    }


//    put used to update entire oject but patch used to chagne only some attribute

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateUser(@PathVariable Long id, @RequestBody NewUser newUser) {
        System.out.println(newUser);

        return ResponseEntity.status(HttpStatus.OK).body(studentServiceimpl.updateUser(id, newUser));
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<StudentDto> partialUpdates(@PathVariable Long id, @RequestBody Map<String, Object> map) {
        return ResponseEntity.status(HttpStatus.OK).body(studentServiceimpl.partialUpdate(id, map));
    }
}
