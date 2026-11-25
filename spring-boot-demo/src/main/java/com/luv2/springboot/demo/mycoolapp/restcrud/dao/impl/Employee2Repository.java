package com.luv2.springboot.demo.mycoolapp.restcrud.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee2;

@RepositoryRestResource(path = "members")
public interface Employee2Repository extends JpaRepository<Employee2, Integer> {

}
