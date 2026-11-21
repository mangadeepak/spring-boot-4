package com.luv2.springboot.demo.mycoolapp.hibernateExample.service;

import org.springframework.stereotype.Component;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.StudentDao;
import com.luv2.springboot.demo.mycoolapp.hibernateExample.entity.Student;

@Component 
public class HibernateExampleRunner {

    private StudentDao studentDaoImpl;

    public HibernateExampleRunner(StudentDao studentDao) {
        this.studentDaoImpl = studentDao;
    }

    public void runStudentDaoImpl(String methodToCall, Student student) {
        switch (methodToCall) {
            case "create":
                if(null == student) {
                    System.out.println("Student object is null");
                } else {
                    studentDaoImpl.save(student);
                    System.out.println("Student created with ID: " + student.getId());
                }
                break;
            default:
                System.out.println("No method found corresponds to action requested.");
                break;
        }
    }

}
