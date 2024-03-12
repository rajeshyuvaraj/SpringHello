package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Employee;

@Component
public interface EmployeeService {
	public List<Employee> getEmployees();
	public Employee createEmployee(Employee emp);
	Employee updateEmployee(Employee emp);

	Employee deleteEmployee(Long  empId);

	void deleteAllEmployees();

	Employee getEmployeeById(Long empId);
}
