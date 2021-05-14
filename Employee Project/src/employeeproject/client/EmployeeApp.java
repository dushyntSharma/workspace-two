package employeeproject.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employeeproject.model.Employee;
import employeeproject.service.EmployeeService;
import employeeproject.service.EmployeeServiceImpl;

public class EmployeeApp {
	static Scanner sc = new Scanner(System.in);
	static EmployeeService service = new EmployeeServiceImpl();

	public static void main(String[] args) {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				String s = addEmployeeDetails();
				System.out.println(s);
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);
	}

	private static String addEmployeeDetails() {
		// TODO Auto-generated method stub
		String s = null;
		List<Employee> emp = new ArrayList<Employee>();
		System.out.println("Enter the id");
		int id = sc.nextInt();
		System.out.println("ENter the name");
		String name = sc.next();
		System.out.println("Enter the designation");
		sc.nextLine();
		String designation = sc.next();
		System.out.println("Enter the salary");
		double salary = sc.nextDouble();
		Employee e = new Employee(id, name, designation, salary);
		emp.add(e);
		s = service.addEmployeeDetails(emp);
		return s;
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add Shop Details");
		System.out.println("2.Display Shop details");
		System.out.println("3.Search the Shop By its Name");
		System.out.println("4.Delete Shop");
		System.out.println();

	}

}
