package ram.imcs.EmployeeMavenOperations;

import java.io.File;
import java.util.List;

public interface EmployeeServiceInterface {
	double calculateHRA(long empid);

	double calculateDA(long empid);

	double grossSalary(long empid);

	public void createEmployees(Employee e1);

	public Employee displayEmployee(Employee e);

	public List<Employee> displayallEmployees();

	public void updateEmployee(Employee e);

	public void deleteEmployee(long empid);

	public boolean isEmployeeExist(long empid);

	public int getCurrentIndex();

	public void readEmployees() throws Exception;

	public void saveEmployee(File inFile) throws Exception;

	public void setCurrentIndex(int currentIndex);

	List<Employee> getEmployee();

	void setEmployee(List<Employee> employee);
}
