package AngajatiApp.model;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.validator.EmployeeException;
import AngajatiApp.validator.EmployeeValidator;

public class Employee {
	private static final int LAST_NAME_INDEX = 1;
	private static final int FIRST_NAME_INDEX = 0;
	private static final int CNP_INDEX = 2;
	private static final int DIDACTIC_FUNCTION_INDEX = 3;
	private static final int SALARY_INDEX = 4;
	private static final int ID_INDEX = 5;
	private int id;
	private String lastName;
	/**
	 * The last name of the employee
	 */
	private String firstName;
	/**
	 * The first name of the employee
	 */
	private String cnp;
	/**
	 * The unique id of the employee
	 */
	private DidacticFunction function;
	/**
	 * The didactic function of the employee inside the university
	 */
	private double salary; /** The salary of the employee */

	/**
	 * Default constructor for employee
	 */
	public Employee() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.cnp = "";
		this.function = DidacticFunction.ASISTENT;
		this.salary = 0.0D;
	}

	/**
	 * Constructor with fields for employee
	 */
	public Employee(int id, String firstName, String lastName, String cnp, DidacticFunction function, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnp = cnp;
		this.function = function;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public DidacticFunction getFunction() {
		return function;
	}

	public void setFunction(DidacticFunction function) {
		this.function = function;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		String employee = "";
		employee += firstName + ";";
		employee += lastName + ";";
		employee += cnp + ";";
		employee += function.toString() + ";";
		employee += salary + ";";
		employee += id;
		return employee;
	}

	@Override
	public boolean equals(Object otherEmployee) {
		if (this == otherEmployee) {
			return true;
		}
		if (!(otherEmployee instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) otherEmployee;

		return this.firstName.equals(employee.getFirstName())
				&& this.lastName.equals(employee.getLastName())
				&& this.cnp.equals(employee.getCnp())
				&& this.function == employee.getFunction()
				&& this.salary == employee.getSalary();
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

	/**
	 * Returns the Employee after parsing the given line
	 *
	 * @param employeeString the employee given as String from the input file
	 * @param line           the current line in the file
	 * @return if the given line is valid returns the corresponding Employee
	 * @throws EmployeeException
	 */
	public static Employee getEmployeeFromString(String employeeString, int line) throws EmployeeException {
		Employee employee = new Employee();

		String[] attributes = employeeString.split("[;]");

		if (attributes.length != 6) {
			throw new EmployeeException("Invalid line at: " + line);
		} else {
			EmployeeValidator validator = new EmployeeValidator();
			employee.setFirstName(attributes[FIRST_NAME_INDEX]);
			employee.setLastName(attributes[LAST_NAME_INDEX]);
			employee.setCnp(attributes[CNP_INDEX]);

			switch (attributes[DIDACTIC_FUNCTION_INDEX]) {
				case "ASISTENT":
					employee.setFunction(DidacticFunction.ASISTENT);
					break;
				case "LECTURER":
					employee.setFunction(DidacticFunction.LECTURER);
					break;
				case "TEACHER":
					employee.setFunction(DidacticFunction.TEACHER);
					break;
				case "CONFERENTIAR":
					employee.setFunction(DidacticFunction.CONFERENTIAR);
					break;
				default:
					throw new EmployeeException("Invalid didactic function at line: " + line);
			}

			try {
				employee.setSalary(Double.parseDouble(attributes[SALARY_INDEX]));
				employee.setId(Integer.parseInt(attributes[ID_INDEX]));
			} catch (NumberFormatException e) {
				throw new EmployeeException("Invalid salary or ID at line: " + line);
			}
			if (!validator.isValid(employee)) {
				throw new EmployeeException("Invalid line at: " + line);
			}
			return employee;
		}

	}
}
