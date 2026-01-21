package com.example.bhatt.Photo;

import com.example.bhatt.Photo.dto.StudentDto;
import com.example.bhatt.Photo.entity.Student;
import com.example.bhatt.Photo.repository.StudentRepository;
import com.example.bhatt.Photo.service.impl.StudentServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhotoApplicationTests {

    @Autowired
    StudentServiceImpl studentServiceImpl;
	@Test
	void contextLoads() {
	}

    @Test
    public void getByName(){
        Student student = studentServiceImpl.getByName("Gaurav Bhatt");
        System.out.println(student);
    }

    @Test
    public void getByEmail(){
        Student student = studentServiceImpl.getByEmail("gbhatt570@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getByAge(){
        List<StudentDto> students = studentServiceImpl.getByAge((byte)100);
        System.out.println(students);
    }
}
