package com.luv2.springboot.demo.mycoolapp.restcrud.dao;

import java.util.List;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAllEmployees();
    public Employee getEmployee(int id);
    public Employee saveEmployee(Employee employee);
    public int deleteEmployee(int id);
    
}
