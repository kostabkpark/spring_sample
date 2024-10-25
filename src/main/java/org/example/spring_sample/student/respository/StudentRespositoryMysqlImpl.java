package org.example.spring_sample.student.respository;

import org.example.spring_sample.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRespositoryMysqlImpl implements StudentRepository{
    final DataSource dataSource;

    @Autowired
    public StudentRespositoryMysqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Student> findAll() {
        Connection conn = getConnection();
        List<Student> students = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("univ"),
                        rs.getString("birth"),
                        rs.getString("email")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public void deleteStudent(int id) {

    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
}
