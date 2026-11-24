package com.luv2.springboot.demo.mycoolapp.restcrud.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2.springboot.demo.mycoolapp.restcrud.dao.EmployeeDAO;
import com.luv2.springboot.demo.mycoolapp.restcrud.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository 
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    //@Autowired - Not required as there is only one bean in constructor
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return entityManager.createQuery("FROM Employee ORDER BY id ASC", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getId() == 0) {
            entityManager.persist(employee);
            return employee;
        }
        else {
            Employee empFromDB = entityManager.find(Employee.class, employee.getId());
            if(null != empFromDB) {
                empFromDB.setEmail(employee.getEmail());
                entityManager.merge(empFromDB);
                return employee;
            }
            return null;
        }
    }

    @Override
    public int deleteEmployee(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        if(null != emp) {
            entityManager.remove(emp);
            return id;
        }
        return -1;
    }
}
