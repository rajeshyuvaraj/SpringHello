package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody

    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee emp,@PathVariable Long empId) {
        return employeeService.updateEmployee(emp);
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable Long empId) {
        return employeeService.deleteEmployee(empId);
    }
    @RequestMapping(value = "/emp", method = RequestMethod.DELETE)
    public void deleteAllEmployees() {
         employeeService.deleteAllEmployees();
    }
}
