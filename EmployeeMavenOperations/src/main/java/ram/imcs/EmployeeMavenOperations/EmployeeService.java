package ram.imcs.EmployeeMavenOperations;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class EmployeeService implements EmployeeServiceInterface {
	private EmployeeOperationsInterface empoperation;
	private File inFile;

	public EmployeeService(File infile) {
		empoperation = new EmployeeOperations();
		this.inFile = infile;
	}

	public void readEmployees() throws Exception {

		Reader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);

			String line = null;
			boolean keepReading = true;

			while (keepReading) {
				line = br.readLine();

				if (line == null || line.equals("")) {
					break;
				}

				Employee emp = parseLine(line);
				empoperation.createEmployees(emp);

			}
		} finally {
			br.close();
			fr.close();
		}

	}

	private Employee parseLine(String line) {
		String[] tokens = line.split(",");
		Employee emp = new Employee(Long.parseLong(tokens[0]), tokens[1], tokens[2], Double.parseDouble(tokens[3]),
				tokens[4]);
		return emp;
	}

	public void saveEmployee(File inFile) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream(inFile);
			bos = new BufferedOutputStream(fos);
			List<Employee> employee = empoperation.getEmployee();
			String temp = "";
			for (int i = 0; i < empoperation.getCurrentIndex(); i++) {
				temp = employee.get(i).getEmpid() + "," + employee.get(i).getFname() + "," + employee.get(i).getLname()
						+ "," + employee.get(i).getEmpsalary() + "," + employee.get(i).getGender() + "\n";
				bos.write(temp.getBytes());
			}
		} finally {

			bos.flush();
			bos.close();

		}
	}

	public double calculateHRA(long empid) {

		List<Employee> employee = empoperation.getEmployee();
		double hra = 0;
		for (int i = 0; i < empoperation.getCurrentIndex(); i++) {
			if (employee.get(i).getEmpid() == empid) {
				if (employee.get(i).getEmpsalary() < 10000) {
					employee.get(i).setHra(0.15 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 20000) {
					employee.get(i).setHra(0.20 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 30000 && employee.get(i).getAge() >= 40) {
					employee.get(i).setHra(0.27 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 30000 && employee.get(i).getAge() < 40) {
					employee.get(i).setHra(0.25 * employee.get(i).getEmpsalary());
				} else {
					employee.get(i).setHra(0.30 * employee.get(i).getEmpsalary());
				}
				hra = employee.get(i).getHra();
				break;
			}
		}

		return hra;
	}

	public double calculateDA(long empid) {
		List<Employee> employee = empoperation.getEmployee();
		double da = 0;
		for (int i = 0; i < empoperation.getCurrentIndex(); i++) {
			if (employee.get(i).getEmpid() == empid) {
				if (employee.get(i).getEmpsalary() < 10000) {
					employee.get(i).setDa(0.08 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 20000) {
					employee.get(i).setDa(0.10 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 30000 && employee.get(i).getAge() >= 40) {
					employee.get(i).setDa(0.15 * employee.get(i).getEmpsalary());
				} else if (employee.get(i).getEmpsalary() < 30000 && employee.get(i).getAge() < 40) {
					employee.get(i).setDa(0.13 * employee.get(i).getEmpsalary());
				} else {
					employee.get(i).setDa(0.17 * employee.get(i).getEmpsalary());
				}
				da = employee.get(i).getDa();
				break;

			}
		}

		return da;
	}

	public double grossSalary(long empid) {
		List<Employee> employee = empoperation.getEmployee();
		double gross = 0;
		for (int i = 0; i < empoperation.getCurrentIndex(); i++) {
			if (employee.get(i).getEmpid() == empid) {
				gross = employee.get(i).getEmpsalary() + calculateDA(empid) + calculateHRA(empid);
				break;
			}
		}
		return gross;
	}

	@Override
	public void createEmployees(Employee e1) throws InvalidSalaryException {
		if (e1.getEmpsalary() <= 5000)
			throw new InvalidSalaryException("Salary should greater than 5000");
		empoperation.createEmployees(e1);

	}

	@Override
	public Employee displayEmployee(Employee e2) {
		return empoperation.displayEmployee(e2);

	}

	@Override
	public List<Employee> displayallEmployees() {
		return empoperation.displayallEmployees();
	}

	@Override
	public void updateEmployee(Employee e) throws InvalidSalaryException, EmployeeNotFoundException {
		boolean updated = empoperation.updateEmployee(e);
		if (!updated)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		else if (e.getEmpsalary() <= 5000)
			throw new InvalidSalaryException("Salary should be greater than 5000");
	}

	@Override
	public void deleteEmployee(long empid) throws EmployeeNotFoundException {
		boolean deleted = false;
		deleted = empoperation.deleteEmployee(empid);
		if (!deleted)
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
	}

	@Override
	public boolean isEmployeeExist(long empid) {
		return empoperation.isEmployeeExist(empid);
	}

	@Override
	public int getCurrentIndex() {
		return empoperation.getCurrentIndex();
	}

	@Override
	public void setCurrentIndex(int currentIndex) {
		empoperation.getCurrentIndex();

	}

	public List<Employee> getEmployee() {
		return empoperation.getEmployee();
	}

	public void setEmployee(List<Employee> employee) {
		empoperation.setEmployee(employee);
	}

}
