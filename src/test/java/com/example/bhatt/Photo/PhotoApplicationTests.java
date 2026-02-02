package com.example.bhatt.Photo;

import com.example.bhatt.Photo.dto.StudentDto;
import com.example.bhatt.Photo.entity.Appointment;
import com.example.bhatt.Photo.entity.Doctor;
import com.example.bhatt.Photo.entity.Patient;
import com.example.bhatt.Photo.entity.Student;
import com.example.bhatt.Photo.repository.AppointmentRepository;
import com.example.bhatt.Photo.repository.DoctorRepository;
import com.example.bhatt.Photo.repository.PatientRepository;
import com.example.bhatt.Photo.repository.StudentRepository;
import com.example.bhatt.Photo.service.impl.StudentServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;


import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class PhotoApplicationTests {

    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;


    @PersistenceContext
    private EntityManager entityManager;


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

    @Test
    public void getAll() {
        List<StudentDto> students =
                studentServiceImpl.getAllStudentsWithPage(3,10);
                for(StudentDto student : students) System.out.println(student);
    }

    @Transactional
    @Test
    @Rollback(value = false)
    public void addPatients(){
//        Patient patient = Patient.builder()
//                        .name("User1").build();
//        patientRepository.save(patient);

        Patient patient = patientRepository.findById(2L).orElseThrow();
        Appointment appointment = Appointment.builder().build();
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
    }


    @Test
    public void deletePatient(){
        patientRepository.deleteById(2L);
    }



    @Test
    @Transactional
    @Rollback(value = false)
    public void createDoctorAndPatient(){

//        Doctor doctor1 = new Doctor();
//        doctor1.setName("doctor1");
//        entityManager.persist(doctor1);
//
//        Doctor doctor2 = new Doctor();
//        doctor2.setName("doctor2");
//        entityManager.persist(doctor2);


        Patient patient1 = new Patient();
        patient1.setName("patient1");


        patientRepository.save(patient1);

        patient1 = new Patient();
        patient1.setName("patient2");

        patientRepository.save(patient1);

    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void createAppointment(){

        Doctor doctor = doctorRepository.findById(7L).orElseThrow();
        Patient patient = patientRepository.findById(4L).orElseThrow();

        Appointment appointment = new Appointment();
        appointment.setProblem("back pain");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        entityManager.persist(appointment);
    }


    @Test
    @Transactional
    public void getAllAppointment(){

        Doctor doctor = doctorRepository.findById(6L).orElseThrow();
        List<Appointment> list = doctor.getAppointmentList();
        for(Appointment appointment : list) System.out.println(appointment);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void removeOrphanAppointment(){

        Doctor doctor = doctorRepository.findById(7L).orElseThrow();
        Patient patient = patientRepository.findById(4L).orElseThrow();

        Appointment appointment = doctor.getAppointmentList().stream()
                .filter((item)-> item.getId().equals(2L)).findFirst().orElseThrow();

        doctor.getAppointmentList().remove(appointment);

    }



}
