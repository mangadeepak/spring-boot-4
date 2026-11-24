package com.luv2.springboot.demo.mycoolapp.restcrud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;
import com.luv2.springboot.demo.mycoolapp.restcrud.service.EmployeeService;


@RestController 
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/api/employees/{employeeId}")
    public Employee getEmployees(@PathVariable int employeeId) {
         Employee employee = employeeService.getEmployee(employeeId);
         if(null == employee) {
            throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(employeeId));
         }
         return employee;
    }

    @PostMapping("/api/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee employeeFromDB = employeeService.saveEmployee(employee);
        return employeeFromDB;
    }

    @PutMapping("/api/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employeeFromDB = employeeService.saveEmployee(employee);
        return employeeFromDB;
    }

}
