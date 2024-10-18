package com.wavemaker.employee.repository.impl;

import com.wavemaker.employee.exception.EmployeeNotFoundException;
import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryEmployeeRepositoryImpl implements EmployeeRepository {

    private static final Map<Integer, Employee> employeeMap = new ConcurrentHashMap<>();

    private static int maxEmployeeId = 0;

    @Override
    public Employee addEmployee(Employee employee) {
        if (maxEmployeeId == 0) {
            maxEmployeeId = generateEmpId();
        } else {
            maxEmployeeId += 1;
        }
        employee.setEmpId(maxEmployeeId);
        employeeMap.put(employee.getEmpId(), employee);
        return employee;

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
    public Employee deleteEmployeeById(int empId) throws EmployeeNotFoundException {
        Employee removedEmployee = employeeMap.remove(empId);
        if (removedEmployee == null) {
            throw new EmployeeNotFoundException("Employee with Id: " + empId + " Not Found To Delete", 404);
        }
        return removedEmployee;
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        if (employeeMap.containsKey(employee.getEmpId())) {
            employeeMap.put(employee.getEmpId(), employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Employee with Id : " + employee.getEmpId() + " Not Found To Update", 404); //404 = not found
        }
    }

    private int generateEmpId() {
        for (Integer id : employeeMap.keySet()) {
            maxEmployeeId = Math.max(id,maxEmployeeId);
        }
        return maxEmployeeId + 1;
    }
}
