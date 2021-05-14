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
				System.out.println(s);
				break;
			case 2:
				List<Bank> bk = service.displayBankDetails();
				for(Bank b : bk) {
					System.out.println(b.toString());
				}
				List<Customer> cus = service.displayCustomerDetails();
				for(Customer c : cus) {
					System.out.println(c.toString());
				}
				break;
			case 3:
				System.out.println("Enter the bankId to be deleted");
				int bankId = sc.nextInt();
				String s1 = service.deleteBankId(bankId);
				System.out.println(s1);
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);
	}

	private static String addBankDetails() {
		// TODO Auto-generated method stub
		List<Bank> bank = new ArrayList<Bank>();
		System.out.println("Enter the Bank ID");
		int bankId = sc.nextInt();
		System.out.println("Enter the address");
		sc.nextLine();
		String address = sc.nextLine(); 
		System.out.println("Enter the bank Name");
		String bName = sc.nextLine();
		System.out.println("Enter the no of customers you want?");
		int n = sc.nextInt();
		List<Customer> customer = new ArrayList<Customer>(n);
		for (int i = 0; i < n; i++) {
			System.out.println("ENter the account number");
			int accNo = sc.nextInt();
			System.out.println("Enter the account Type (Savings or Salary)");
			String accType = sc.next();
			Customer c = new Customer(accNo, accType, bName);
			customer.add(c);

		}
		Bank b = new Bank(bankId, address, bName, customer);
		bank.add(b);

		String s = service.addBankDetails(bank);
		return s;
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add Bank Details");
		System.out.println("2.Display Bank details");
		System.out.println("Delete the BankId");
		System.out.println();

	}

	public void returnDetails(List<String> ls) {
		// TODO Auto-generated method stubs
		System.out.println(ls);
	}

}
