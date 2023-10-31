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
    //Test cu date invalide
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
    //Test cu date valide
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

    @Test
    //Test cu date valide - se modifica functia unui angajat din Lecturer in Conferentiar
    void TC_01_modifyEmployeeFunction1() {

        Employee employee = new Employee(2,"Ion", "Dumitrescu", "1234567890876", DidacticFunction.LECTURER, 2500d);
        employeeMock.modifyEmployeeFunction(employee,DidacticFunction.CONFERENTIAR);
        assertEquals(DidacticFunction.CONFERENTIAR, employeeMock.findEmployeeById(employee.getId()).getFunction());
    }

    @Test
    //Test cu date invalide - angajat null - se arunca exceptie - NullPointerException
    void TC_02_modifyEmployeeFunction(){
        assertThrows(NullPointerException.class, () ->
                employeeMock.modifyEmployeeFunction(null, DidacticFunction.TEACHER));
    }
}