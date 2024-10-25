package org.example.spring_sample.student.respository;

import org.assertj.core.api.Assertions;
import org.example.spring_sample.student.domain.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StudentRepositoryMapImplTest {
    StudentRepositoryMapImpl map = new StudentRepositoryMapImpl();

    @Test
    void findAll() {
        // given
        Student s = new Student(0, "김연아", "BBB", "2000-01-01", "b@naver.com");
        map.addStudent(s);
        // when
        List<Student> all = map.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        //given
        Student s = new Student(0, "손흥민", "CCC", "2000-01-01", "c@naver.com");
        //when
        int id = map.addStudent(s);
        //then
        assertThat(map.findById(id).getName()).isEqualTo(s.getName());
    }

    @Test
    void updateStudent() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void deleteStudent() {
    }
}