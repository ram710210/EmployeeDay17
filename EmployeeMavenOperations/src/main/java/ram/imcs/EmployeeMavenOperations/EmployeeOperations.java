package ram.imcs.EmployeeMavenOperations;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOperations implements EmployeeOperationsInterface {
	private List<Employee> employee;
	private int currentIndex = 0;

	EmployeeOperations() {
		employee = new ArrayList<>();
	}

	public void createEmployees(Employee e1) {
		employee.add(e1);
		currentIndex++;
	}

	public Employee displayEmployee(Employee e2) {
		Employee emp = null;
		for (int i = 0; i < currentIndex; i++) {
			if (employee.get(i).getEmpid() == e2.getEmpid()) {
				emp = employee.get(i);
				break;
			}
		}
		return emp;
	}

	public List<Employee> displayallEmployees() {

		return employee;

	}

	public boolean updateEmployee(Employee e) {
		boolean updated = false;
		for (int i = 0; i < currentIndex; i++) {
			if (employee.get(i).getEmpid() == e.getEmpid()) {
				updated = true;
				if (e.getEmpsalary() <= 5000)
					break;
				employee.remove(i);
				employee.add(i, e);
				break;

			}
		}
		return updated;
	}

	public boolean deleteEmployee(long empid) {
		boolean deleted = false;
		for (int i = 0; i < currentIndex; i++) {
			if (employee.get(i).getEmpid() == empid) {
				deleted = true;
				employee.remove(i);
				currentIndex--;
			}
		}
		return deleted;
	}

	public boolean isEmployeeExist(long empid) {
		boolean b = false;
		for (int i = 0; i < currentIndex; i++) {
			if (employee.get(i).getEmpid() == empid) {
				b = true;
				break;
			} else
				b = false;
		}
		return b;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

}
