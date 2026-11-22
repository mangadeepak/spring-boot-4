package com.luv2.springboot.demo.mycoolapp.hibernateExample.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.dao.StudentDao;
import com.luv2.springboot.demo.mycoolapp.hibernateExample.entity.Student;

@Component 
public class HibernateExampleRunner {

    private StudentDao studentDaoImpl;

    public HibernateExampleRunner(StudentDao studentDao) {
        this.studentDaoImpl = studentDao;
    }

    public void runStudentDaoImpl(String methodToCall, Student student, int studentId, String firstName, String lastName, String email) {
        List<Student> students = null;
        switch (methodToCall) {
            case "create":
                if(null == student) {
                    System.out.println("Student object is null");
                } else {
                    studentDaoImpl.save(student);
                    System.out.println("Student created with ID: " + student.getId());
                }
                break;
            case "read":
                if(studentId < 0) {
                    System.out.println("Invalid ID.");
                } else {
                    Student studentFetchedWithId = studentDaoImpl.findById(studentId);
                    if(null == studentFetchedWithId) {
                        System.out.println("No student with ID: #%d exists in DB".formatted(studentId));
                        return;
                    }
                    System.out.println("Student details is as follows : " + studentFetchedWithId);
                }
                break; 
            case "readAll":
                students = studentDaoImpl.findAll();
                if(null != students)
                    students.forEach(System.out::println);
                break;
            case "findByLastNameAndEmail": 
                students = studentDaoImpl.findByLastNameAndEmailAddress(lastName, email);
                if(null != students)
                    students.forEach(System.out::println);
                break;
            case "updateFirstNameUsingId": 
                System.out.println("Student with Id = #%d updated in DB".formatted(studentDaoImpl.updateStudentById(firstName, studentId)));
                break;
            case "deleteById": 
                System.out.println("Student with Id = #%d deleted from DB".formatted(studentDaoImpl.deleteById(studentId)));
                break;
            case "deleteAll": 
                System.out.println("Number of rows removed from DB : " + studentDaoImpl.deleteAll());
                break;        
            default:
                System.out.println("No method found corresponds to action requested.");
                break;
        }
    }

}
