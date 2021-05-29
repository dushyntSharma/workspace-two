package flight.services;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import flight.model.Flight;
import flight.model.Passenger;

public class AddFlight {
	static Scanner sc = new Scanner(System.in);

	public static List<Flight> addFlights(List<Flight> flight, List<Passenger> passenger) throws IOException {
		// TODO Auto-generated method stub
		List<Passenger> pass = new LinkedList<Passenger>();
		System.out.println("Enter the flight name");
		String flightName = sc.nextLine();
		try {
			isValidFlight(flightName);
		} catch (IOException e) {
			throw new IOException(flightName + " is not Valid, Flights names should be Uppercase!!");
		}

		System.out.println("Enter the source");
		String source = sc.nextLine();
		System.out.println("Enter the destination");
		String destination = sc.nextLine();
		System.out.println("Enter the no of passenger");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			boolean check = false;
			do {
				System.out.println("Enter the passenger first name");
				String pName = sc.nextLine();
				for (int j = 0; j < passenger.size(); j++) {
					if (passenger.get(j).getFirstName().equals(pName)) {
						pass.add(passenger.get(j));
						check = true;
					}

				}
				if (!check)
					System.out.println("Passenger not found, May be in an other Flight!!");

			} while (!check);

		}
		flight.add(new Flight(flightName, source, destination, pass));

		return flight;
	}

	public static boolean isValidFlight(String flightName) throws IOException {
		boolean flag = false;

		for (int i = 0; i < flightName.length(); i++) {
			char ch = flightName.charAt(i);
			if (ch >= 65 && ch <= 90) {
				flag = true;
			} else {
				flag = false;
				throw new IOException("Not a valid flight");
			}
		}
		if (flag == true)
			return true;
		else
			return false;

	}
	

}
