package org.example.spring_sample.student.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_sample.student.domain.Student;
import org.example.spring_sample.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService service;

    public StudentController(StudentService studentService) {
        this.service = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id,
                                 @RequestBody Student student) {
        log.info("student : {}, {}" , id, student);
        Student student1 = service.updateStudent(id, student);
        return student1;
    }

    @PatchMapping("/{id}")
    public Student updateStudent2(@PathVariable("id") int id,
                                 @RequestBody Student student) {
        log.info("student : {}, {}" , id, student);
        Student student1 = service.updateStudent(id, student);
        return student1;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student newStudent = service.createNewStudent(student);
        return newStudent;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        service.deleteStudent(id);
    }
}
