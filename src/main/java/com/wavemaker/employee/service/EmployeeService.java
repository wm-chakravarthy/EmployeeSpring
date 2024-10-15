package com.wavemaker.employee.service;

import com.wavemaker.employee.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public Employee getEmployeeById(int empId);

    public List<Employee> getAllEmployees();

    public Employee deleteEmployeeById(int empId);
}
