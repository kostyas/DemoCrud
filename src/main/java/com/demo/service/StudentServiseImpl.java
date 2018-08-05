package com.demo.service;

import com.demo.dao.StudentDAO;
import com.demo.model.Student;

import java.util.List;

public class StudentServiseImpl implements StudentServise {


    private StudentDAO studentDAO;

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student entity = studentDAO.findById(student.getId());
        if (entity!=null){
            entity.setName(student.getName());
            entity.setNationality(student.getNationality());
            entity.setCode(student.getCode());
        }
    }

    @Override
    public void deleteStudent(String code) {
        studentDAO.deleteStudent(code);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDAO.findAllStudents();
    }

    @Override
    public Student findStudentByCode(String code) {
        return studentDAO.findStudentByCode(code);
    }

    @Override
    public boolean isStudentCodeUnique(Integer id, String code) {
        Student student = findStudentByCode(code);
        return (student == null || ((id !=null) && (student.getId() == id)));
    }
}
