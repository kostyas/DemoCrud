package com.demo.dao;

import com.demo.model.Student;

import java.util.List;

public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDAO {


    protected StudentDaoImpl(Class<Student> persistentClass) {
        super(persistentClass);
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(String student) {

    }

    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public Student findStudentByCode(String code) {
        return null;
    }
}
