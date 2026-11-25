package com.luv2.springboot.demo.mycoolapp.restcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
