package org.example.spring_sample.student.service;

import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public Student createNewStudent(Student student) {
        int id = repository.addStudent(student);
        student.setId(id);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        Student oldStudent = repository.findById(id);
        if (student.getUniv() != null) {
            oldStudent.setUniv(student.getUniv());
        }
        if (student.getEmail() != null) {
            oldStudent.setEmail(student.getEmail());
        }
        repository.updateStudent(oldStudent);
        return oldStudent;
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}
