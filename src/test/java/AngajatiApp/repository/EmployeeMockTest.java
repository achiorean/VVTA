package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @Test
    void TC01_addEmployee() {

        Employee newEmployee = new Employee();
        newEmployee.setId(1); // Set ID
        newEmployee.setLastName("Chiorean"); // Set Last Name
        newEmployee.setFirstName("A"); // Set First Name
        newEmployee.setCnp("1830517823459"); // Set Cnp
        newEmployee.setFunction(DidacticFunction.ASISTENT); // Set Didactic Function
        newEmployee.setSalary(1000d); // Set Salary


        // Attempt to add the employee
        boolean result = employeeMock.addEmployee(newEmployee);


        // Check if the new employee is in the list
        assertFalse(employeeMock.getEmployeeList().contains(newEmployee));
    }

    @Test
    void TC02_addEmployee() {

        Employee newEmployee = new Employee();
        newEmployee.setId(1); // Set ID
        newEmployee.setLastName("Chiorean"); // Set Last Name
        newEmployee.setFirstName("Adi"); // Set First Name
        newEmployee.setCnp("1830517823459"); // Set Cnp
        newEmployee.setFunction(DidacticFunction.ASISTENT); // Set Didactic Function
        newEmployee.setSalary(1000d); // Set Salary


        // Attempt to add the employee
        boolean result = employeeMock.addEmployee(newEmployee);


        // Check if the new employee is in the list
        assertTrue(employeeMock.getEmployeeList().contains(newEmployee));

    }
}