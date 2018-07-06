package ram.imcs.EmployeeMavenOperations;

import java.util.List;

public interface EmployeeOperationsInterface {
	void createEmployees(Employee e1);

	Employee displayEmployee(Employee e);

	List<Employee> displayallEmployees();

	boolean updateEmployee(Employee e);

	boolean deleteEmployee(long empid);

	boolean isEmployeeExist(long empid);

	int getCurrentIndex();

	void setCurrentIndex(int currentIndex);

	List<Employee> getEmployee();

	void setEmployee(List<Employee> employee);
}
