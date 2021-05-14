package com.bank.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.services.BankService;
import com.bank.services.BankServiceImpl;

public class BankApp {
	static Scanner sc = new Scanner(System.in);
	static BankService service = new BankServiceImpl();

	public static void main(String[] args) {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				String s = addBankDetails();
				
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag == false);
	}

	private static String addBankDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Bank Id");
		long bankId = sc.nextLong();
		System.out.println("Enter the Bank Name");
		String bName = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the Customer account id");
		long accId = sc.nextLong();
		System.out.println("Enter the no of customers you need to insert");
		int n = sc.nextInt();
		Customer[] customer = new Customer[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Customer name");
			String cName = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter the branch of the bank");
			String branch = sc.nextLine();
			Customer c = new Customer(accId, cName, branch);
			customer[i] = c;
		}
		Bank b = new Bank(bankId, bName, accId, customer);
		String s = service.addBankDetails(b);

		return s;
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add Bank Details");
		System.out.println("2.Add Customer Details");
		System.out.println("3.Display Shops");
		System.out.println("4.Delete the shop");
		System.out.println();

	}

}
