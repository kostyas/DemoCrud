package com.demo.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;


    @SuppressWarnings("unchecked")
    protected AbstractDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getKey(PK key){
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity){
        getSession().persist(entity);
    }

    public void saveOrUpdate(T entity){
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
