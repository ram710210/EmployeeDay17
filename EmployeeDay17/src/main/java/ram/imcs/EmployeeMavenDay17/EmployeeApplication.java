package ram.imcs.EmployeeMavenDay17;
import ram.imcs.EmployeeMavenOperations.*;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeApplication {

	public static void main(String args[]) throws IOException {
		File inFile = new File("C:\\Users\\Ram\\Desktop\\EmpData.csv");
		if (inFile.exists()) {
			System.out.println("File already exists");
		} else {
			inFile.createNewFile();
		}
		EmployeeServiceInterface empservice = new EmployeeService(inFile);

		try {
			empservice.readEmployees();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		while (true) {
			int operation = EmployeeUtil.displayMenu();
			switch (operation) {
			case 1:
				Employee e1 = EmployeeUtil.getEmployeeData();
				try {
					empservice.createEmployees(e1);
				} catch (InvalidSalaryException ex) {
					System.out.println(ex.getMessage());
				}
				break;
			case 2:
				Employee e2 = EmployeeUtil.displayEmployee();
				System.out.println(e2.getEmpid());
				if (!empservice.isEmployeeExist(e2.getEmpid())) {
					System.out.println("No Employee found with the given number:" + e2.getEmpid());
				}
				System.out.println(empservice.displayEmployee(e2));

				break;
			case 3:
				System.out.println("Employees in the system are:");
				List<Employee> emp = empservice.displayallEmployees();
				for (int i = 0; i < emp.size(); i++)
					System.out.println(emp.get(i));
				break;
			case 4:
				Employee e = EmployeeUtil.updateEmployeeData();
				try {
					empservice.updateEmployee(e);
				} catch (EmployeeNotFoundException ex) {
					System.out.println(ex.getMessage());
				} catch (InvalidSalaryException ex) {
					System.out.println(ex.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter Employee id to delete:");
				long empid3 = EmployeeUtil.s1.nextLong();
				try {
					empservice.deleteEmployee(empid3);
					System.out.println("Deleted successfully");
				} catch (EmployeeNotFoundException ex) {
					System.out.println(ex.getMessage());

				}
				break;
			case 6:
				System.out.println("Enter Employee id to calculate hra of employee");
				long empid4 = EmployeeUtil.s1.nextLong();
				System.out.println(
						"HRA of the Employee id" + " " + empid4 + " " + "is:" + empservice.calculateHRA(empid4));
				break;
			case 7:
				System.out.println("Enter Employee id to calculate gross salary of employee");
				long empid5 = EmployeeUtil.s1.nextLong();
				System.out.println("Gross salary of the Employee id is " + empservice.grossSalary(empid5));
				break;
			case 8:
				try {
					empservice.saveEmployee(inFile);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				EmployeeUtil.s1.close();
				System.exit(0);
				break;
			}
		}
	}
}
