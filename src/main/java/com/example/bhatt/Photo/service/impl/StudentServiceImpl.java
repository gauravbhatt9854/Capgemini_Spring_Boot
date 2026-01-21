package com.example.bhatt.Photo.service.impl;

import com.example.bhatt.Photo.dto.NewUser;
import com.example.bhatt.Photo.dto.StudentDto;
import com.example.bhatt.Photo.entity.Student;
import com.example.bhatt.Photo.repository.StudentRepository;
import com.example.bhatt.Photo.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Student getByName(String name) {
        Student student = studentRepository.findByName(name);
        return  student;
    }
    @Override
    public Student getByEmail(String email) {
        Student student = studentRepository.findByEmailAddress(email);
        return  student;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> ans = studentRepository.findAll()
                .stream()
                .map(student -> new StudentDto(student.getId(),
                        student.getName(), student.getAge(), student.getEmail()))
                .toList();
        return ans;
    }

    @Override
    public StudentDto getOneStudent(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("user not found"));
        StudentDto studentDto = new StudentDto(student.getId() , student.getName() , student.getAge()
        ,student.getEmail());


//        return  studentDto;

        StudentDto std = modelMapper.map(student , StudentDto.class);

        return  std;
//        return new StudentDto(1L , "abc" , (byte)21 , "@mail.com");
    }

    @Override
    public StudentDto createNewStudent(NewUser newuser) {
        Student newStudent = modelMapper.map(newuser , Student.class);
        Student dbUser = studentRepository.save(newStudent);
        return modelMapper.map(dbUser , StudentDto.class);

    }

    @Override
    public StudentDto deleteUser(Long id) {
        StudentDto student = modelMapper.map(studentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("user not exist")), StudentDto.class);

        studentRepository.deleteById(id);
        return student;

    }

    @Override
    public StudentDto updateUser(Long id, NewUser newUser) {

        System.out.println(newUser);
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("user not exist"));
        modelMapper.map(newUser , student);
        student = studentRepository.save(student);
        return  modelMapper.map(student , StudentDto.class);

    }

    @Override
    @Transactional
    public StudentDto partialUpdate(Long id , Map<String , Object> map) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("user not exist"));

        map.forEach((field , value)->{
            switch (field){
                case "name":
                    student.setName((String)value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                case "age":
                    student.setAge((Byte)value);
                    break;
                default:
                    throw new IllegalArgumentException("No such field exists");

            }
        });

//        Student temp  = studentRepository.save(student);
//        return  modelMapper.map(temp , StudentDto.class);
        return  modelMapper.map(student , StudentDto.class);
    }

    @Override
    @Transactional
    public Student getStudent(Long id){
        Student student1 = studentRepository.findById(id).orElseThrow();
        Student student2 = studentRepository.findById(id).orElseThrow();
        return student2;
    }


    @Override
    public List<StudentDto> getByAge(byte age){
        List<StudentDto> list = studentRepository.findByAgeLessThan(age)
                .stream().map((student -> modelMapper.map(student , StudentDto.class))).toList();
        return list;
    }
}
