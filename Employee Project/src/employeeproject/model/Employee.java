package employeeproject.model;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	private int id;
	private String name;
	private String designation;
	private double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String designation, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		if (e1.getSalary() < e2.getSalary()) {
			return -1;
		} else if (e1.getSalary() > e2.getSalary()) {
			return 1;
		} else {
			return 0;
		}
	}

}
