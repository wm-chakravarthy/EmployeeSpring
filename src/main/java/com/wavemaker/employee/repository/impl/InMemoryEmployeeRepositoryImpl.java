package com.wavemaker.employee.repository.impl;

import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEmployeeRepositoryImpl implements EmployeeRepository {

    private static Map<Integer, Employee> employeeMap = new ConcurrentHashMap<>();

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeMap.put(employee.getEmpId(), employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeMap.get(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee deleteEmployeeById(int empId) {
        return employeeMap.remove(empId);
    }
}
