package com.demo.dao;

import com.demo.model.Student;

import java.util.List;

public interface StudentDAO {
    Student findById(int id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String student);
    List<Student> findAllStudents();
    Student findStudentByCode(String code);
}
