package com.luv2.springboot.demo.mycoolapp.restcrud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2.springboot.demo.mycoolapp.restcrud.dao.EmployeeRepository;
import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;
import com.luv2.springboot.demo.mycoolapp.restcrud.service.EmployeeService;

@Service 
public class EmployeeServiceWithSpringJpaImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceWithSpringJpaImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employeeFromDB = employeeRepository.findById(id).orElse(null);
        if(employeeFromDB == null) {
            throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(id));
        }
        return employeeFromDB;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getId() == 0) {
            return employeeRepository.save(employee);    
        } else {
            Employee employeeFromDB = employeeRepository.findById(employee.getId()).orElse(null);
            if(employeeFromDB == null) {
                throw new RuntimeException("Employee with ID: #%d is not found in database".formatted(employee.getId()));
            }
            employeeFromDB.setFirstName(employee.getFirstName());
            employeeFromDB.setLastName(employee.getLastName());
            employeeFromDB.setEmail(employee.getEmail());
            return employeeRepository.save(employeeFromDB);    
        }
    }

    @Override
    public int deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return id;
    }

}
