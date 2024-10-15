package com.wavemaker.employee.controller;

import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeController {

    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-servlet.xml");

    private final EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");

    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        System.out.println("Employee added: " + employee);
    }

    public Employee getEmployeeById(int empId) {
        return employeeService.getEmployeeById(empId);
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public Employee deleteEmployeeById(int empId) {
        return employeeService.deleteEmployeeById(empId);
    }
}
