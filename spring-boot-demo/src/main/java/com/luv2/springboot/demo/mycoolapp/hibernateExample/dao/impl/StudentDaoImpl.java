package com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.StudentDao;
import com.luv2.springboot.demo.mycoolapp.hibernateExample.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository 
public class StudentDaoImpl implements StudentDao{

    private EntityManager myEntityManager;


    public StudentDaoImpl(EntityManager theEntityManager) {
        myEntityManager = theEntityManager;
    }


    @Override
    @Transactional 
    public void save(Student student) {
        myEntityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return myEntityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return myEntityManager.createQuery("FROM Student ORDER BY firstName ASC").getResultList();
    }


    @Override
    public List<Student> findByLastNameAndEmailAddress(String lastName, String email) {
        Query query = myEntityManager.createQuery("FROM Student WHERE lastName=:lastname AND email=:emailAddress ORDER BY firstName ASC");
        query.setParameter("lastname", lastName);
        query.setParameter("emailAddress", email);
        return query.getResultList();
    }


    @Override
    @Transactional 
    public int updateStudentById(String firstName, int id) {
        Student student = findById(1);
        student.setFirstName(firstName);
        student = myEntityManager.merge(student);
        return student.getId();
    }


    @Override
    @Transactional 
    public int deleteById(int id) {
        Student student = findById(id);
        if(null != student) {
            myEntityManager.remove(student);
            return id;
        }
        return -1;
    }


    @Override
    @Transactional 
    public int deleteAll() {
        return myEntityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
