package ram.imcs.EmployeeMavenOperations;

import java.util.Scanner;

public class EmployeeUtil {
	public static Scanner s1 = new Scanner(System.in);
	public static int displayMenu() {
		System.out.println("|||MENU|||" + "\n" + "1.Create Employee" + "\n" + "2.Read(View) Employee" + "\n"
				+ "3.View all Employees" + "\n" + "4.Update Employee" + "\n" + "5.Delete Employee" + "\n"
				+ "6.Calculate HRA" + "\n" + "7.Calculate Gross Salary" + "\n" + "8.Exit" + "\n" + "Select a choice:");
		int operation = s1.nextInt();
		return operation;

	}

	public static Employee getEmployeeData() {
		Employee e = new Employee();
		System.out.println("Enter Employee id");
		e.setEmpid(s1.nextLong());
		System.out.println("Enter Employee First Name");
		e.setFname(s1.next());
		System.out.println("Enter Employee Last Name");
		e.setLname(s1.next());
		System.out.println("Enter Employee Salary");
		e.setEmpsalary(s1.nextDouble());
		System.out.println("Select the gender" + "\n" + "1.Male" + "\n" + "2.Female");
		int choice = s1.nextInt();
		if (choice == 1)
			e.setGender("Male");
		else
			e.setGender("Female");

		return e;

	}

	public static Employee updateEmployeeData() {
		Employee e = new Employee();
		System.out.println("Enter Employee data for update");
		System.out.println("Enter Employee id");
		e.setEmpid(s1.nextLong());
		System.out.println("Enter Employee First Name");
		e.setFname(s1.next());
		System.out.println("Enter Employee Last Name");
		e.setLname(s1.next());
		System.out.println("Enter Employee Salary");
		e.setEmpsalary(s1.nextDouble());
		System.out.println("Select the gender" + "\n" + "1.Male" + "\n" + "2.Female");
		int choice1 = s1.nextInt();
		if (choice1 == 1)
			e.setGender("Male");
		else
			e.setGender("Female");
		return e;

	}

	public static Employee displayEmployee() {
		Employee e = new Employee();
		System.out.println("Enter the employee Id:");
		e.setEmpid(s1.nextLong());
		return e;
	}

}
