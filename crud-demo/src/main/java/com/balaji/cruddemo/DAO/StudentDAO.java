package com.balaji.cruddemo.DAO;

import com.balaji.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student readById(int id);

    List<Student> findAll();

    void updateStudent(Student student);

    void deleteStudent(int id);

    int deleteAll();
}
