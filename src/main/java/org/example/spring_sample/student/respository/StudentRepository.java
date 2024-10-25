package org.example.spring_sample.student.respository;

import org.example.spring_sample.student.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository {
    List<Student> findAll() ;
    Student findById(int id) ;
    void updateStudent(Student student) ;
    int addStudent(Student student) ;
    void deleteStudent(int id) ;
}
