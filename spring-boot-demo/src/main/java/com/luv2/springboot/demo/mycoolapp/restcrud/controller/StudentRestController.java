package com.luv2.springboot.demo.mycoolapp.restcrud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Student;
import com.luv2.springboot.demo.mycoolapp.restcrud.exceptions.StudentNotFoundException;

import jakarta.annotation.PostConstruct;



@RestController 
@RequestMapping ("/api")
public class StudentRestController {

    private List<Student> students = null;

    @PostConstruct 
    public void loadData() {
        students = List.of(
            new Student("Deepak", "Kumar"),
            new Student("Poornima", "Patel"),
            new Student("Mario", "Rossi"),
            new Student("Mary", "Smith")
        );
    }    

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student with ID #%d not found in database".formatted(studentId));
        }
        return students.get(studentId);
    }


    /* @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe) {
        return new ResponseEntity<StudentErrorResponse>(
            new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), 
            new Date().getTime()), HttpStatus.NOT_FOUND); 
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exp) {
        return new ResponseEntity<StudentErrorResponse>(
            new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exp.getMessage(), 
            new Date().getTime()), HttpStatus.BAD_REQUEST); 
    } */
    
}
