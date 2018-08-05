package com.demo.dao;

import com.demo.model.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDAO {


    protected StudentDaoImpl(Class<Student> persistentClass) {
        super(persistentClass);
    }

    @Override
    public Student findById(int id) {
        return getKey(id);
    }

    @Override
    public void saveStudent(Student student) {
        persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        super.saveOrUpdate(student);
    }

    @Override
    public void deleteStudent(String code) {
        Query query = getSession().createQuery("delete from Student where code =: code");
        query.setString("code", code);
        query.executeUpdate();
    }

    @Override
    public List<Student> findAllStudents() {
        Criteria criteria = createEntityCriteria();
        return (List<Student>) criteria.list();
    }

    @Override
    public Student findStudentByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (Student) criteria.uniqueResult();
    }
}
