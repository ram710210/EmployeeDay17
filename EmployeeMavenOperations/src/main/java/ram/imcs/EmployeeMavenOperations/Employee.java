package ram.imcs.EmployeeMavenOperations;

public class Employee {

	private long empid;
	private String fname;
	private String lname;
	private double empsalary;
	private String gender;
	private int age;
	private double hra;
	private double da;
	private double gross_salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long empid, String fname, String lname, double empsalary, String gender) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.empsalary = empsalary;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", empsalary=" + empsalary
				+ ", gender=" + gender + "]";
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getGross_salary() {
		return gross_salary;
	}

	public void setGross_salary(double gross_salary) {
		this.gross_salary = gross_salary;
	}

}
