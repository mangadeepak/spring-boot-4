package com.luv2.springboot.demo.mycoolapp.restcrud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2.springboot.demo.mycoolapp.restcrud.dao.EmployeeDAO;
import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;
import com.luv2.springboot.demo.mycoolapp.restcrud.service.EmployeeService;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional 
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional 
    public int deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
