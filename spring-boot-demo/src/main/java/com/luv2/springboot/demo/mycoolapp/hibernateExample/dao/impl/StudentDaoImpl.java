package com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.StudentDao;
import com.luv2.springboot.demo.mycoolapp.hibernateExample.entity.Student;

import jakarta.persistence.EntityManager;

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

}
