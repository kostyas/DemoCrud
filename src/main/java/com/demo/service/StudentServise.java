package com.demo.service;

import com.demo.model.Student;

import java.util.List;

public interface StudentServise {
    Student findById(int id);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String student);
    List<Student> findAllStudents();
    Student findStudentByCode(String code);
    boolean isStudentCodeUnique(Integer id, String code);
}
