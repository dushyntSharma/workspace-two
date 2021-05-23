package com.mindtree.com.FilesCapability.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.mindtree.com.FilesCapability.dao.EmployeeDaoImpl;

public class Application {

	static Scanner sc = new Scanner(System.in);
	static EmployeeDaoImpl empImpl;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, SQLException {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				empImpl.csvInsertion();
				break;
			case 2:
				empImpl.writeToCSV();
				break;

			case 3:
				System.out.println("Thank you");
				flag = false;
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("1.Read CSV and add to database");
		System.out.println("2.Write to CSV file from database");
		System.out.println("3.Exit");
		System.out.println();

	}
}
