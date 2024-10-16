package com.wavemaker.employee.repository;

import com.wavemaker.employee.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public Employee addEmployee(Employee employee);

    public Employee getEmployeeById(int empId);

    public List<Employee> getAllEmployees();

    public Employee deleteEmployeeById(int empId);

    public Employee updateEmployeeById(Employee employee);
}
