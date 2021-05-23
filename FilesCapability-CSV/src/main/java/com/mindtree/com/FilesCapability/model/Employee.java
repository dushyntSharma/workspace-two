package com.mindtree.com.FilesCapability.model;

public class Employee {
	private String name;
	private String company;
	private String place;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String company, String place) {
		super();
		this.name = name;
		this.company = company;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", company=" + company + ", place=" + place + "]";
	}

}
