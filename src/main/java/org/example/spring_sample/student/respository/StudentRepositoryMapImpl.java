package org.example.spring_sample.student.respository;

import org.example.spring_sample.student.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class StudentRepositoryMapImpl implements StudentRepository {
    private Map<Integer, Student> students;
    private int seq = 1;

    public StudentRepositoryMapImpl() {
        students = new HashMap<Integer, Student>();
        Student s = new Student(seq++, "홍길동", "AAA", "2000-01-01", "a@naver.com");
        students.put(s.getId(), s);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void updateStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public int addStudent(Student student) {
        student.setId(seq++);
        students.put(student.getId(), student);
        return student.getId();
    }

    @Override
    public void deleteStudent(int id) {
        students.remove(id);
    }
}
