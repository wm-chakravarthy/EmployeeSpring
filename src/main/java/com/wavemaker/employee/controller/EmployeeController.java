package com.wavemaker.employee.controller;

import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        System.out.println("Employee added: " + employee);
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable(value = "empId") int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{empId}")
    public Employee deleteEmployeeById(@PathVariable(value = "empId") int empId) {
        return employeeService.deleteEmployeeById(empId);
    }
}
