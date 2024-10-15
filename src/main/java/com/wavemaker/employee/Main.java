package com.wavemaker.employee;

import com.wavemaker.employee.controller.EmployeeController;
import com.wavemaker.employee.pojo.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Add Employee
                    Employee employee = new Employee();
                    System.out.print("Enter Employee ID: ");
                    employee.setEmpId(scanner.nextInt());
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Employee Name: ");
                    employee.setName(scanner.nextLine());
                    System.out.print("Enter Employee Age: ");
                    employee.setAge(scanner.nextInt());
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Employee Gender: ");
                    employee.setGender(scanner.nextLine());
                    employeeController.addEmployee(employee);
                    System.out.println("Employee added successfully!\n");
                    break;

                case 2:
                    // Get Employee by ID
                    System.out.print("Enter Employee ID: ");
                    int empIdToGet = scanner.nextInt();
                    Employee retrievedEmployee = employeeController.getEmployeeById(empIdToGet);
                    if (retrievedEmployee != null) {
                        System.out.println("Employee Found: " + retrievedEmployee);
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 3:
                    // Get All Employees
                    List<Employee> allEmployees = employeeController.getAllEmployees();
                    System.out.println("All Employees:");
                    for (Employee emp : allEmployees) {
                        System.out.println(emp);
                    }
                    System.out.println();
                    break;

                case 4:
                    // Delete Employee by ID
                    System.out.print("Enter Employee ID to delete: ");
                    int empIdToDelete = scanner.nextInt();
                    Employee deletedEmployee = employeeController.deleteEmployeeById(empIdToDelete);
                    if (deletedEmployee != null) {
                        System.out.println("Deleted Employee: " + deletedEmployee);
                    } else {
                        System.out.println("Employee not found.\n");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.\n");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
