package flight.services;

import java.util.List;
import java.util.Scanner;

import flight.model.Passenger;

public class AddPassenger {
	static Scanner sc = new Scanner(System.in);

	public static List<Passenger> addPassenger(List<Passenger> passenger) {
		// TODO Auto-generated method stub
		System.out.println("Enter the firstname");
		String firstName = sc.nextLine();
		System.out.println("Enter the lastname");
		String lastname = sc.nextLine();
		System.out.println("Enter the age");
		byte age = sc.nextByte();
		System.out.println("Enter the gender");
		String gender = sc.next();
		sc.nextLine();
		passenger.add(new Passenger(firstName, lastname, age, gender));
		return passenger;
	}

}
