package com.luv2.springboot.demo.mycoolapp.restcrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;
import com.luv2.springboot.demo.mycoolapp.restcrud.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;

@RestController 
public class EmployeeRestControllerV2 {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired 
    public EmployeeRestControllerV2(@Qualifier(value="employeeServiceWithSpringJpaImpl") EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/api/v2/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/api/v2/employees/{employeeId}")
    public Employee getEmployees(@PathVariable int employeeId) {
         Employee employee = employeeService.getEmployee(employeeId);
         if(null == employee) {
            throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(employeeId));
         }
         return employee;
    }

    @PostMapping("/api/v2/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee employeeFromDB = employeeService.saveEmployee(employee);
        return employeeFromDB;
    }

    @PutMapping("/api/v2/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employeeFromDB = employeeService.saveEmployee(employee);
        return employeeFromDB;
    }

    @DeleteMapping ("/api/v2/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        int deletedEmployeeId = employeeService.deleteEmployee(employeeId);
        if(deletedEmployeeId == -1) {
            throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(employeeId));
        }
        return "Employee with ID: #%d is deleted from database".formatted(deletedEmployeeId);
    }

    @PatchMapping ("/api/v2/employees/{employeeId}")
    public Employee updateEmployeeFirstName(@PathVariable int employeeId, @RequestBody Map<String, Object> payload) {
        if(payload.containsKey("id")) {
            throw new RuntimeException("Employee ID #%d is not allowed in request body.".formatted(payload.get("id")));
        }
        Employee employeeFromDB = employeeService.getEmployee(employeeId);
        if(null == employeeFromDB) {
            throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(employeeId));
        }
        Employee updatedEmployee = jsonMapper.updateValue(employeeFromDB, payload);
        return employeeService.saveEmployee(updatedEmployee);
    }

}
