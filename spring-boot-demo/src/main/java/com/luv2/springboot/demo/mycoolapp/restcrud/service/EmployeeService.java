package com.luv2.springboot.demo.mycoolapp.restcrud.service;

import java.util.List;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAllEmployees();
    public Employee getEmployee(int id);
    public Employee saveEmployee(Employee employee);
    public int deleteEmployee(int id);

}
