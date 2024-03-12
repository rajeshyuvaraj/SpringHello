package com.example.demo.service;

import com.example.demo.entities.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployees() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Employee createEmployee(Employee emp) {
        logger.info("creating Employee-->{}", emp);
        return repository.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        if (repository.existsById(Math.toIntExact(emp.getId()))) {
            logger.info("updating Employee-->{}", emp);
            repository.save(emp);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found");
        }
        return null;
    }

    @Override
    public Employee deleteEmployee(Long empId) {
        if (repository.existsById(Math.toIntExact(empId))) {
            logger.info("Deleting Employee Id-->{}", empId);

            repository.deleteById(Math.toIntExact(empId));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Employee Not Found");
        }
        return null;
    }

    @Override
    public void deleteAllEmployees() {
        logger.warn("Deleting All the employees");
        repository.deleteAll();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        logger.warn("getting the employee details for the empId-->{}", empId);
        return repository.findById(Math.toIntExact(empId)).get();
    }
}
