package com.luv2.springboot.demo.mycoolapp.hibernateExample.dao;

import java.util.List;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.entity.Student;

public interface StudentDao {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastNameAndEmailAddress(String lastName, String email);
    int updateStudentById(String firstName, int id);
    int deleteById(int id);
    int deleteAll();

}
