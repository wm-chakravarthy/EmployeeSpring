package com.wavemaker.employee.service.impl;

import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import com.wavemaker.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private  EmployeeRepository employeeRepository;


//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        logger.info("Creating the EmployeeRepository Bean");
//        this.employeeRepository = employeeRepository;
//        logger.info("Bean EmployeeRepository injected");
//    }

    @Override
    public Employee addEmployee(Employee employee) {
        logger.info("Adding employee with ID: {}", employee.getEmpId());
        Employee addedEmployee = employeeRepository.addEmployee(employee);
        logger.info("Employee added: {}", addedEmployee);
        return addedEmployee;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        logger.info("Fetching employee with ID: {}", empId);
        Employee employee = employeeRepository.getEmployeeById(empId);
        if (employee != null) {
            logger.info("Employee found: {}", employee);
        } else {
            logger.warn("No employee found with ID: {}", empId);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        List<Employee> employees = employeeRepository.getAllEmployees();
        logger.info("Total employees retrieved: {}", employees.size());
        return employees;
    }

    @Override
    public Employee deleteEmployeeById(int empId) {
        logger.info("Deleting employee with ID: {}", empId);
        Employee deletedEmployee = employeeRepository.deleteEmployeeById(empId);
        if (deletedEmployee != null) {
            logger.info("Employee deleted: {}", deletedEmployee);
        } else {
            logger.warn("No employee found to delete with ID: {}", empId);
        }
        return deletedEmployee;
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        return employeeRepository.updateEmployeeById(employee);
    }
}
