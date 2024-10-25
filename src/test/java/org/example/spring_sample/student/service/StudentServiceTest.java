package org.example.spring_sample.student.service;

import org.assertj.core.api.Assertions;
import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.respository.StudentRepository;
import org.example.spring_sample.student.respository.StudentRepositoryMapImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentRepository sr = new StudentRepositoryMapImpl();
    StudentService service = new StudentService(sr);

    @Test
    void getAllStudents() {
        //given
        //when
        List<Student> allStudents = service.getAllStudents();
        //then
        Assertions.assertThat(allStudents.size()).isEqualTo(1);
    }
}